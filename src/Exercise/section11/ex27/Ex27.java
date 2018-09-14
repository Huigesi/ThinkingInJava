package Exercise.section11.ex27;

import java.util.LinkedList;
import java.util.Queue;

public class Ex27 {
    public static void getQueue(Queue<Command> queue) {
        while(queue.peek() != null)
            queue.poll().operation();
        //queue.element().operation();
    }
    public static void main(String[] args) {
        Command command;
        Command2 command2 = new Command2();
        for (int i = 0; i < 10; i++) {
            command = new Command();
            command.s = "hi"+i;
            Queue<Command> queue = command2.getCommand(command);
            Ex27.getQueue(queue);
        }
    }
}

class Command {
    String s;

    void operation() {
        System.out.println(s);
    }
}

class Command2 {
    Queue<Command> getCommand(Command command) {
        Queue<Command> commands = new LinkedList<>();
        commands.offer(command);
        return commands;
    }
}

class Command3 {

}
