package eg.edu.alexu.csd.datastructure.stack;

public class ExpressionEvaluator implements IExpressionEvaluator {
    char operator[] = {'^','*','+','-','/'};
    int priority[] = {3,2, 1, 1, 2};
    boolean isNumericalOrVariable(Character c)
    {
        return Character.isLetterOrDigit(c);
    }
    int getCharacterPriority(char c)
    {
        for(int i = 0;i < operator.length;i++)
        {
            if(operator[i] == c)
                return priority[i];
        }
        return 0;
    }
    Float evaluateOperation(Float f1,Float f2,char operation)
    {
        if(operation == '+')
            return f1+f2;
        else if(operation == '-')
            return f1-f2;
        else if(operation == '*')
            return f1*f2;
        else
            return f1/f2;
    }
    public String infixToPostfix(String expression)
    {
        Stack stack = new Stack();
        String ret = new String();
        for(int i = 0;i < expression.length();i++)
        {
            if(isNumericalOrVariable(expression.charAt(i)))
            {
                ret += expression.charAt(i);
                continue;
            }
            if(expression.charAt(i) == '(')
            {
                stack.push(expression.charAt(i));
                continue;
            }
            if(expression.charAt(i) == ')')
            {
                while(!stack.isEmpty() && !((Character)stack.peek() == '('))
                {
                    ret += (Character)stack.peek();
                    stack.pop();
                }
                if(stack.isEmpty())
                    throw new RuntimeException("String is unbalanced");
                stack.pop();
                continue;
            }
            int curPriorioty = getCharacterPriority(expression.charAt(i));
            if(curPriorioty == 0)
                continue;
            while(!stack.isEmpty() && getCharacterPriority((Character)stack.peek()) >= curPriorioty)
            {
                ret += (Character)stack.peek();
                stack.pop();
            }
            stack.push(expression.charAt(i));
        }
        while(!stack.isEmpty())
        {
            ret += (Character)stack.peek();
            if((Character)stack.peek() == '(')
                throw new RuntimeException("String is unbalanced");
            stack.pop();
        }
        return ret;
    }
    public int evaluate(String expression)
    {
        Stack stack = new Stack();
        for(int i = 0;i < expression.length();i++)
        {
            if(isNumericalOrVariable(expression.charAt(i)))
            {
                stack.push(Float.valueOf(expression.substring(i,i+1)));
                continue;
            }
            if(stack.size() < 2)
                throw new RuntimeException("Invalid Expression");
            Float secondOperand = (Float)stack.pop();
            Float firstOperand = (Float)stack.pop();
            if(secondOperand == 0)
                throw new RuntimeException("Divided by zero :( Bad Boy!");
            stack.push(evaluateOperation(firstOperand,secondOperand,expression.charAt(i)));
        }
        if(stack.size() != 1)
            throw new RuntimeException("Bad Expression");
        return Integer.valueOf(Math.round((Float)stack.peek()));
    }
}
