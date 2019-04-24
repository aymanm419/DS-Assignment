package eg.edu.alexu.csd.datastructure.stack;

public interface IStack {
    /**
     * @return remove and return the last element
     */
    public Object pop();

    /**
     * @return top element of stack
     */
    public Object peek();

    /**
     * @param element to be pushed into stack
     */
    public void push(Object element);

    /**
     * @return true if stack is empty
     */
    public boolean isEmpty();

    /**
     * @return size of stack
     */
    public int size();
}
