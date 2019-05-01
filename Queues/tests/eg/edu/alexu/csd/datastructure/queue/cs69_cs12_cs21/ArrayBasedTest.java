package eg.edu.alexu.csd.datastructure.queue.cs69_cs12_cs21;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayBasedTest {
    @Test
    public void enqueue() {
        ArrayBased queue = new ArrayBased(100000);
        for(int i = 0;i < 100000;i++)
            queue.enqueue(i);
        for(int i = 0;i < 50000;i++)
            queue.dequeue();
        for(int i = 1;i <= 20000;i++)
            queue.enqueue(i);
        assertEquals(queue.dequeue(),50000);
    }
    @Test(expected = RuntimeException.class)
    public void enqueueException()
    {
        ArrayBased queue = new ArrayBased(1000000);
        for(int i = 0;i < 1000000;i++)
            queue.enqueue(i);
        queue.enqueue(1);
    }
    @Test
    public void dequeue() {
        ArrayBased queue = new ArrayBased(1000000);
        for(int i = 0;i < 1000000;i++)
            queue.enqueue(i);
        for(int i = 0;i < 500000;i++)
            queue.dequeue();
        assertEquals(queue.dequeue(),500000);
    }
    @Test(expected = RuntimeException.class)
    public void dequeueException()
    {
        ArrayBased queue = new ArrayBased(1000000);
        for(int i = 0;i < 1000000;i++)
            queue.enqueue(i);
        for(int i = 0;i < 5000000;i++)
            queue.dequeue();
        assertEquals(queue.dequeue(),500000);
    }

    @Test
    public void isEmpty() {
        ArrayBased queue = new ArrayBased(1000000);
        for(int i = 0;i < 1000000;i++)
            queue.enqueue(i);
        assertEquals(queue.isEmpty(),false);
        for(int i = 0;i < 1000000;i++)
            queue.dequeue();
        assertEquals(queue.isEmpty(),true);
    }

    @Test
    public void size() {
        ArrayBased queue = new ArrayBased(1000000);
        for(int i = 0;i < 1000000;i++)
            queue.enqueue(i);
        assertEquals(queue.size(),1000000);
        for(int i = 0;i < 1000000;i++)
            queue.dequeue();
        assertEquals(queue.size(),0);
    }
}