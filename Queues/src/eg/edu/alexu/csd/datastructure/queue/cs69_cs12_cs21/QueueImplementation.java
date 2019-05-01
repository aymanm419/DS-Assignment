/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eg.edu.alexu.csd.datastructure.queue.cs69_cs12_cs21;

/**
 *
 * @author Momen
 */
public class QueueImplementation implements IQueue {
        LinkedList q=new LinkedList();
    public void enqueue(Object c){
        q.add(c);
    }

    public Object dequeue(){
        if(q.isEmpty()==false){
            Object c=q.get(0);
            q.remove(0);
            return c;
        }else{
            System.out.println("The Queues is Empty");
            return -1;
        }
        
    }
    public boolean isEmpty(){
       if(q.isEmpty()){
           return true;
       }else{
           return false;
       }
    }
    public int size(){
        return q.getlength();
    }
}
