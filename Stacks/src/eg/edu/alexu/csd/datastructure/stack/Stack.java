package eg.edu.alexu.csd.datastructure.stack;

public class Stack implements IStack {
    private int Sz = 0;
    private int curPointer = 0;
    Object Stk[];
    public Object pop()
    {
        if(curPointer == 0)
            throw new RuntimeException("Trying to pop from empty stack!");
        curPointer--;
        return Stk[curPointer];
    }
    public Object peek()
    {
        if(curPointer == 0)
            throw new RuntimeException("Trying to peek from empty stack!");
        return Stk[curPointer - 1];
    }
    public void push(Object element)
    {
        if(curPointer == Sz)
        {
            Object Tmp[] = new Object[Sz * 2 + 1];
            for(int i = 0;i < Sz;i++)
                Tmp[i] = Stk[i];
            Stk = Tmp;
            Sz = Tmp.length;
        }
        Stk[curPointer] = element;
        curPointer++;
        return;
    }
    public boolean isEmpty()
    {
        return curPointer == 0;
    }
    public int size()
    {
        return curPointer;
    }
}
