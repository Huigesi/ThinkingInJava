package section11.ex17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Gerbil {
	private int gerbilNumber;
	public Gerbil(int i) {
		gerbilNumber = i;
	}
	public void hop() {
		System.out.println("gerbil " + gerbilNumber + " hops");
	}
}

public class Gerbils17 {
	public static void main(String[] args) {
		Map<String, Gerbil> gerbils = new HashMap<String, Gerbil>();
		gerbils.put("Fuzzy", new Gerbil(0));
		gerbils.put("Spot", new Gerbil(1));
		gerbils.put("Speedy", new Gerbil(2));
		gerbils.put("Dopey", new Gerbil(3));
		gerbils.put("Sleepy", new Gerbil(4));
		gerbils.put("Happy", new Gerbil(5));
		Iterator<String> it = gerbils.keySet().iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.print(s + ": ");
			gerbils.get(s).hop();
		}	
	}
}
