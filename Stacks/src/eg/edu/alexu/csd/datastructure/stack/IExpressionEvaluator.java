package eg.edu.alexu.csd.datastructure.stack;

public interface IExpressionEvaluator {
    /**
     * @param expression to be transformed to postfix
     * @return transformed String
     */
    public String infixToPostfix(String expression);

    /**
     * @param expression to be evaluated
     * @return evaluated number
     */
    public int evaluate(String expression);
}