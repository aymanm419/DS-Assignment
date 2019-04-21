package eg.edu.alexu.csd.datastructure.stack;

import java.util.Scanner;

public class Main {
    public static void printHead()
    {
        System.out.println("1-to push");
        System.out.println("2-to pop");
        System.out.println("3-to peek");
        System.out.println("4-get size");
        System.out.println("5-check if empty");
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner Sc = new Scanner(System.in);
        while(true)
        {
            printHead();
            int state = Sc.nextInt();
            if(state == 1)
            {
                Object state2 = Sc.next();
                stack.push(state2);
            } else if(state == 2)
            {
                stack.pop();
            } else if(state == 3)
            {
                System.out.println(stack.peek());
            } else if(state == 4)
            {
                System.out.println(stack.size());
            } else {
                System.out.println(stack.isEmpty());
            }
        }
    }
}
