package section11.ex27;

import java.util.LinkedList;
import java.util.Queue;

class Command1 {
	String s;
	Command1(String s) { this.s = s; }
	void operation() { System.out.print(s); }
}

class Build {	
	Queue<Command1> makeQ() {
		Queue<Command1> q = new LinkedList<Command1>();
		for(int i = 0; i < 10; i++)
			q.offer(new Command1(i + " "));
		return q;
	}
}

public class Queue27 {
	public static void commandEater(Queue<Command1> qc) {
		while(qc.peek() != null)
			qc.poll().operation();
	}
	public static void main(String[] args) {
		Build b = new Build();
		commandEater(b.makeQ());	
	}
}