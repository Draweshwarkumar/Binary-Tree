package BinaryTree;

public class queueusingLL<T> {
	
	node<T> front;
	node<T> rear;
	int size;
	
	queueusingLL(){
		front = null;
		rear = null;
		size = 0;
	}
	
	int size() {
		return size;
	}
	
	boolean isEmpty() {
		return size==0;
	}
	T front() throws queueemptyexception{
		if(isEmpty()) {
			throw new queueemptyexception();
		}
		return front.data;
	}
	
	void enqueue(T value) {
		node<T> newnode = new node<T>(value);
		
		if(isEmpty()) {
			front = newnode;
			rear = newnode;
		}
		rear.next = newnode;
		rear = newnode;
		size++;
	}
	
	T dequeue() throws queueemptyexception {
		if(isEmpty()) {
			throw new queueemptyexception();
		}
		T temp = front.data;
		front = front.next;
		if(size == 1) {
			rear = null;
		}
		size--;
		return temp;
	}

}
