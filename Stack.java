package stack;

import java.util.EmptyStackException;

class StackNode<T>{
	T data;
	StackNode<T> next;
	StackNode(T data){
		this.data = data;
	}
}
public class Stack<T> {
	private StackNode<T> top;
	Stack(){
		top = null;
	}
	public void push(T data){
		StackNode<T> newNode = new StackNode<T>(data);
		if(isEmpty()){
			newNode.next = null;
		}else{
			newNode.next = top;
		}
		top = newNode;
	}
	public T pop(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		StackNode<T> topNode = top;
		top = top.next;
		return topNode.data;
	}
	public T peek(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return top.data;
	}
	public boolean isEmpty(){
		return top == null;
	}
}
