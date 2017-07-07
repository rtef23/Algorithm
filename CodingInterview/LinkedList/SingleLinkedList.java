package LinkedList;

public class SingleLinkedList <T>{
	private int size;
	private Node<T> head;
	private Node<T> tail;
	
	public SingleLinkedList() {
		// TODO Auto-generated constructor stub
		size = 0;
		head = null;
		tail = null;
	}
	static class Node<T>{
		T val;
		Node<T> next;
	}
	public boolean isEmpty(){
		return head == null;
	}
	public int size(){
		return size;
	}
	public Node<T> getHead(){
		return head;
	}
	public Node<T> getTail(){
		return tail;
	}
	public void enqueue(T val){
		Node<T> newNode = new Node<>();
		newNode.val = val;
		size++;
		if(isEmpty()){
			newNode.next = null;
			head = tail = newNode;
			return;
		}
		tail.next = newNode;
		tail = newNode;
	}
	public T dequeue(){
		if(isEmpty())
			return null;
		
		Node<T> ret = head;
		head = ret.next;
		size--;
		return ret.val;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Node<T> curNode = getHead();
		
		while(curNode != null){
			sb.append(curNode.val);
			curNode = curNode.next;
		}
		return sb.toString();
	}
}
