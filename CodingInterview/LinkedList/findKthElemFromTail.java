package LinkedList;

import LinkedList.SingleLinkedList.Node;

public class findKthElemFromTail <T>{
	public T getKthElemFromTail(SingleLinkedList<T> list, int k){
		if(list.size() < k)
			return null;
		Node<T> preNode = list.getHead();
		Node<T> curNode = list.getHead();
		for(int i = 0;i < k;i++){
			preNode = preNode.next;
		}
		while(preNode != null){
			preNode = preNode.next;
			curNode = curNode.next;
		}
		return curNode.val;
	}
}
