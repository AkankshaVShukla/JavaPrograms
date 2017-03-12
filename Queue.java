package queue;

import java.util.EmptyStackException;

class QueueNode<T>{
	T data;
	QueueNode<T> next;
	QueueNode(T data){
		this.data = data;
	}
}
public class Queue<T> {
	private QueueNode<T> front;
	private QueueNode<T> rear;
	Queue(){
		front = rear = null;
	}
	public void add(T data){
		QueueNode<T> newNode = new QueueNode<T>(data);
		newNode.next = null;
		if(isEmpty()){
			front = newNode;
		}else{
			rear.next = newNode; 
		}
		rear = newNode;
	}
	public T remove(){
		if(isEmpty()) throw new EmptyStackException();
		T data = front.data;
		front = front.next;
		if(isEmpty()){
			rear = null;
		}
		return data;
	}
	public T peek(){
		if(isEmpty()) throw new EmptyStackException();
		return front.data;
	}
	public boolean isEmpty(){
		return front == null;
	}
}
