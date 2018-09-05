package section11.ex31;

import java.util.Iterator;
import java.util.Random;

public class Shape {
	public void draw() {}
	public void erase() {}
	public void amend() { System.out.println("Shape.amend()"); }
	@Override public String toString() { return "Shape"; }
 }

