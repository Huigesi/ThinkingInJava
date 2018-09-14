package Exercise.section14.ex2;
interface HasBatteries {}

interface Waterproof {}

interface Shoots {}

interface dow { }

class Toy {
	// With default constructor commented out will be
	// unable to instantiate this Toy, super of FancyToy:
	Toy() {}
	Toy(int i) {}
}

class FancyToy extends Toy 
	implements HasBatteries, Waterproof, Shoots,dow {
		FancyToy() { super(1); }
}

public class ToyTest2 {
	static void printInfo(Class cc) {
		System.out.println("Class name: " + cc.getName() +
			" is interface? [" + cc.isInterface() + "]");
		System.out.println("Simple name: " + cc.getSimpleName());
		System.out.println("Canonical name: " + cc.getCanonicalName());
	}
	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("Exercise.section14.ex2.FancyToy");
		} catch(ClassNotFoundException e) {
			System.out.println("Can't find FancyToy");
			System.exit(1);
		}
		printInfo(c);
		for(Class face : c.getInterfaces())
			printInfo(face);
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			// Requires default constructor in order to
			// create a super or Toy object:
			obj = up.newInstance();
		} catch(InstantiationException e) {
			System.out.println("Cannot instantiate");
			System.exit(1);
		} catch(IllegalAccessException i) {
			System.out.println("Cannot access");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
}