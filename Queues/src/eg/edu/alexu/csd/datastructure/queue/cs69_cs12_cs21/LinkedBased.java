package eg.edu.alexu.csd.datastructure.queue.cs69_cs12_cs21;

public class LinkedBased implements IQueue, ILinkedBased {
    LinkedList q = new LinkedList();

    public void enqueue(Object c) {
        q.add(c);
    }

    public Object dequeue() {
        if (q.isEmpty() == false) {
            Object c = q.get(0);
            q.remove(0);
            return c;
        } else {
            throw new RuntimeException("Queue is Empty");
        }

    }

    public boolean isEmpty() {
        return q.getlength() == 0;
    }

    public int size() {
        return q.getlength();
    }
}
