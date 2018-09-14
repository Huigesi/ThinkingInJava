package Exercise.section14.ex19;

import java.lang.reflect.InvocationTargetException;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
	Toy() {
		System.out.println("Creating Toy() object");	
	}
	Toy(int i) {
		System.out.println("Creating Toy(" + i + ") object");
	}
}

class FancyToy extends Toy 
	implements HasBatteries, Waterproof, Shoots {
		FancyToy() { super(1); }
}

public class ToyTest19 {
	public static void main(String[] args) {
		// get appropriate constructor and create new instance:
		try {
			Toy.class.getDeclaredConstructor(int.class).newInstance(1);
		// catch four exceptions:
		} catch(NoSuchMethodException e) {
			System.out.println("No such method: " + e);
		} catch(InstantiationException e) {
			System.out.println("Unable make Toy: " + e);
		} catch(IllegalAccessException e) {
			System.out.println("Unable access: " + e);
		} catch(InvocationTargetException e) {
			System.out.println("Target invocation problem: " + e);
		}
	}
}