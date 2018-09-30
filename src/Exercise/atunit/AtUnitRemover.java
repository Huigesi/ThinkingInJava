package Exercise.atunit;

import Exercise.BinaryFile;
import Exercise.ProcessFiles;
import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.annotation.Annotation;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtUnitRemover implements ProcessFiles.Strategy {
    private static boolean remove = false;

    public static void main(String[] args) {
        if (args.length > 0 & args[0].equals("-r")) {
            remove=true;
            String[] nargs = new String[args.length - 1];
            System.arraycopy(args, 1, nargs, 0, nargs.length);
            args=nargs;
        }
        new ProcessFiles(
                new AtUnitRemover(), "class").start(args);;
    }

    @Override
    public void process(File file) {
        boolean modified=false;
        try {
            String cName = ClassNameFinder.thisClass(
                    BinaryFile.read(file)
            );
            if (!cName.contains(".")) {
                return;
            }
            ClassPool classPool=ClassPool.getDefault();
            CtClass ctClass = classPool.get(cName);
            for (CtMethod method : ctClass.getDeclaredMethods()) {
                MethodInfo mi = method.getMethodInfo();
                AnnotationsAttribute attr = (AnnotationsAttribute)
                        mi.getAttribute(AnnotationsAttribute.visibleTag);
                if (attr==null) continue;
                for (Annotation ann : attr.getAnnotations()) {
                    if (ann.getTypeName().startsWith("net.mindview.atunit")) {
                        System.out.print(ctClass.getName() + " Method: "
                                + mi.getName() + " " + ann);
                        if (remove) {
                            ctClass.removeMethod(method);
                            modified = true;
                        }
                    }
                }
            }
            ctClass.toBytecode(new DataOutputStream(
                    new FileOutputStream(file)
            ));
            ctClass.detach();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }
}
