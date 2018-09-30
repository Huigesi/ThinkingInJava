package Exercise.atunit;

import Exercise.BinaryFile;
import Exercise.ProcessFiles;
import com.sun.beans.finder.ClassFinder;
import org.junit.internal.runners.TestMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class AtUnit implements ProcessFiles.Strategy {
    static Class<?> testClass;
    static List<String> failedTests = new ArrayList<>();
    static long testRun = 0;
    static long failures = 0;

    public static void main(String[] args) {
        ClassLoader.getSystemClassLoader()
                .setDefaultAssertionStatus(true);
        new ProcessFiles(new AtUnit(), "class").start(args);
        if (failures == 0) {
            System.out.println("OK (" + testRun + " tests");
        } else {
            System.out.println("(" + testRun + " tests");
            System.out.println("\n>>> " + failures + " FAILURE" +
                    (failures > 1 ? "S" : "") + " <<<");
            for (String failed : failedTests) {
                System.out.println(" " + failed);
            }
        }
    }

    @Override
    public void process(File file) {
        try {
            String cName = ClassNameFinder.thisClass(BinaryFile.read(file));
            if (!cName.contains(".")) {
                return;
            }
            testClass = Class.forName(cName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TestMethods testMethods = new TestMethods();
        Method creator = null;
        Method cleanup = null;
        for (Method m : testClass.getDeclaredMethods()) {
            testMethods.addIfTestMethod(m);
            if (creator == null) {
                creator = checkForCreatorMethod(m);
                if (creator == null) {
                    creator = checkForCreatorMethod(m);
                }
                if (cleanup == null) {
                    cleanup = checkForCleanupMethod(m);
                }
                if (testMethods.size() > 0) {
                    if (creator == null) {
                        try {
                            if (!Modifier.isPublic(testClass
                                    .getDeclaredConstructor().getModifiers())) {
                                System.out.print("Error: "+testClass+
                                        "default constructor must be public");
                                System.exit(1);
                            }
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                        System.out.print(testClass.getName());
                    }
                    for (Method method : testMethods) {
                        System.out.println(" ."+m.getName()+" ");
                    }
                    Object testObject = createTestObject(creator);
                    boolean success = false;

                        try {
                            if (m.getReturnType().equals(boolean.class)) {
                            success = (Boolean) m.invoke(testObject);
                            }else {
                                m.invoke(testObject);
                                success=true;
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    System.out.println(success ? "":"(failed)");
                    testRun++;
                    if (!success) {
                        failures++;
                        failedTests.add(testClass.getName() + ": "
                                + m.getName());
                    }
                    if (cleanup != null) {
                        try {
                            cleanup.invoke(testObject, testObject);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class TestMethods extends ArrayList<Method> {
        void addIfTestMethod(Method m) {
            if (m.getAnnotation(Test.class) == null) {
                return;
            }
            if (!(m.getReturnType().equals(boolean.class) ||
                    m.getReturnType().equals(void.class))) {
                throw new RuntimeException("@Test method"
                        + " must return boolean or void");
            }
            m.setAccessible(true);
            add(m);
        }
    }
    private static Method checkForCreatorMethod(Method m){
        if (m.getAnnotation(TestObjectCreate.class) == null) {
            return null;
        }
        if (!m.getReturnType().equals(testClass)) {
            throw new RuntimeException("@TestObjectCreate " +
                    "must return instance of Class to be tested");
        }
        if ((m.getModifiers()& Modifier.STATIC)<1){
            throw new RuntimeException("@TestObjectCreate "+
                    "must be static");
        }
        m.setAccessible(true);
        return m;
    }
    private static Method checkForCleanupMethod(Method m){
        if (m.getAnnotation(TestObjectCleanup.class) == null) {
            return null;
        }
        if (!m.getReturnType().equals(void.class)) {
            throw new RuntimeException("@TestObjectCleanup " +
                    "must return void");
        }
        if ((m.getModifiers() & Modifier.STATIC)<1) {
            throw new RuntimeException("@TestObjectCleanup " +
                    "must be static");
        }
        if (m.getParameterTypes().length == 0 ||
                m.getParameterTypes()[0] != testClass) {
            throw new RuntimeException("@TestObjectCleanup " +
                    "must take an argument of the tested type");
        }
        m.setAccessible(true);
        return m;
    }

    private static Object createTestObject(Method creator) {
        if (creator != null) {
            try {
                return creator.invoke(testClass);
            } catch (Exception e) {
                throw new RuntimeException("Couldn`t run " +
                        "@TestObject (creator) method.");
            }
        }else {
            try {
                return testClass.newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Couldn`t create a " +
                        "test object. Try using a @TestObject method.");
            }
        }
    }
}