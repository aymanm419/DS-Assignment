package eg.edu.alexu.csd.datastructure.queue.cs69_cs12_cs21;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedBasedTest {

    @Test
    public void enqueue() {
        LinkedBased queue = new LinkedBased();
        queue.enqueue(15);
        queue.enqueue(16);
        assertEquals(queue.dequeue(),15);
        assertEquals(queue.dequeue(),16);
        for(int i = 0;i <= 1000000;i++)
            queue.enqueue(i);
        assertEquals(queue.dequeue(),0);
    }
    @Test(expected = RuntimeException.class)
    public void dequeueException()
    {
        LinkedBased queue = new LinkedBased();
        for(int i = 0;i <= 1000000;i++)
            queue.enqueue(i);
        for(int i = 0;i <= 1000001;i++)
            queue.dequeue();

    }
    @Test
    public void dequeue() {
        LinkedBased queue = new LinkedBased();
        for(int i = 0;i <= 1000000;i++)
            queue.enqueue(i);
        for(int i = 0;i <= 1000000;i++)
            queue.dequeue();
    }

    @Test
    public void isEmpty() {
        LinkedBased queue = new LinkedBased();
        for(int i = 0;i <= 1000000;i++)
            queue.enqueue(i);
        for(int i = 0;i <= 1000000;i++)
            queue.dequeue();
        assertEquals(queue.isEmpty(),true);
        for(int i = 0;i <= 1000000;i++)
            queue.enqueue(i);
        for(int i = 0;i < 1000000;i++)
            queue.dequeue();
        assertEquals(queue.isEmpty(),false);
    }

    @Test
    public void size() {
        LinkedBased queue = new LinkedBased();
        for(int i = 0;i <= 1000000;i++)
            queue.enqueue(i);
        for(int i = 0;i <= 500000;i++)
            queue.dequeue();
        assertEquals(queue.size(),500000);
        for(int i = 0;i < 1000000;i++)
            queue.enqueue(i);
        assertEquals(queue.size(),1500000);
        while(!queue.isEmpty())
            queue.dequeue();
        assertEquals(queue.size(),0);
    }
}