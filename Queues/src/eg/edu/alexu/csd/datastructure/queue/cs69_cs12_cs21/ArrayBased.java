package eg.edu.alexu.csd.datastructure.queue.cs69_cs12_cs21;

public class ArrayBased implements IQueue, IArrayBased {
    private int first;
    private int last;
    private int arrLength;
    private int size;
    private Object[] arr;

    public ArrayBased(int n) {
        arrLength = n;
        arr = new Object[arrLength];
        first = last = -1;
        size = 0;
    }


    public void enqueue(Object item) {
        if (size == arrLength) {
            throw new RuntimeException("Queue Is Full");
        } else {
            last = (last + 1) % arrLength;
            arr[last] = item;
            size++;
        }
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Is Empty");
        } else {
            first = (first + 1) % arrLength;
            size--;
            return arr[first];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
