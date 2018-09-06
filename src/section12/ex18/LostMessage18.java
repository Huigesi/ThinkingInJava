package section12.ex18;

class VeryImportantException extends Exception {
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	public String toString() {
		return "A trivial exception";
	}
}

class MeaninglessException extends Exception {
	public String toString() {
		return "A meaningless exception";
	}
}	

public class LostMessage18 {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}
	void dispose() throws HoHumException {
		throw new HoHumException();
	}
	void eliminate() throws MeaninglessException {
		throw new MeaninglessException();
	}
	public static void main(String[] args) {
		try {
			LostMessage18 lm = new LostMessage18();
			try {
				try {
					lm.f();
					lm.dispose();
				} finally {
					lm.eliminate();
				}
			} catch(Exception e) {
				System.out.println(e);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}