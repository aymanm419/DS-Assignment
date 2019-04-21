package eg.edu.alexu.csd.datastructure.stack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void printHead()
    {
        System.out.println("1-to push");
        System.out.println("2-to pop");
        System.out.println("3-to peek");
        System.out.println("4-get size");
        System.out.println("5-check if empty");
        System.out.println("6-infinix to postfix");
        System.out.println("7-evaluate expression");
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        ExpressionEvaluator expEvaulator = new ExpressionEvaluator();
        Scanner Sc = new Scanner(System.in);
        while(true)
        {
            printHead();
            int state;
            try
            {
                state = Sc.nextInt();
            } catch (InputMismatchException e)
            {
                System.out.println("Insert A Number");
                Sc.next();
                continue;
            }
            if(state == 1)
            {
                Sc.nextLine();
                Object state2 = Sc.nextLine();
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
            } else if(state == 5){
                System.out.println(stack.isEmpty());
            } else if(state == 6)
            {
                Sc.nextLine();
                String state2 = Sc.nextLine();
                String tmp;
                try {
                     tmp = expEvaulator.infixToPostfix(state2);
                   // expEvaulator.evaluate(tmp);
                } catch (RuntimeException e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
                System.out.println(tmp);
            } else if(state == 7)
            {
                Sc.nextLine();
                String state2 = Sc.nextLine();
                int val;
                try
                {
                    val = expEvaulator.evaluate(expEvaulator.infixToPostfix(state2));
                } catch(RuntimeException e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
                System.out.println(val);
            }
        }
    }
}
