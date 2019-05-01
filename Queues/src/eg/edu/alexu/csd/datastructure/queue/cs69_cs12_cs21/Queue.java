
public class Queue implements IQueue,IArrayBased {
	private int first=-1;
	private int last=-1;
	private int arrlenght;
	private int size =0;
	private Object [] arr;
	public Queue(int n){
		arrlenght=n;
		arr=new Object [arrlenght];
	}
	
	
	
public void enqueue(Object item) {
		if(size==arrlenght) {
			System.out.println("the Queue is full");
		}else {
			last=(last+1)%arrlenght;
			arr[last]=item;
			size++;
		}
	}
	
public Object dequeue() {
		if(isEmpty()) {
			throw new RuntimeException();
		}else {
			first=(first+1)%arrlenght;
			size--;
			return arr[first];
		}
	}
	
	public boolean isEmpty() {
	return size==0;	
	}
	
	public int size() {
		return size;
	}
}
