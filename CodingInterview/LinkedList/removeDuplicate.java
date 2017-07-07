package LinkedList;

import java.util.HashSet;

import LinkedList.SingleLinkedList.Node;

public class removeDuplicate {
	public SingleLinkedList<Character> removeDupWithoutBuffer(SingleLinkedList<Character> target){
		SingleLinkedList<Character> ret = new SingleLinkedList<>();
		Node<Character> curNode = target.getHead();
		
		while(curNode != null){
			Node<Character> searchNode = target.getHead();
			boolean isExt = false;
			while(searchNode != curNode){
				if(searchNode.val == curNode.val){
					isExt = true;
					break;
				}
				searchNode = searchNode.next;
			}
			if(!isExt)
				ret.enqueue(curNode.val);
			curNode = curNode.next;
		}
		return ret;
	}
	public SingleLinkedList<Character> removeDupWithBuffer(SingleLinkedList<Character> target){
		HashSet<Character> memo = new HashSet<>();
		SingleLinkedList<Character> ret = new SingleLinkedList<>();
		return travel(memo, ret, target.getHead());
	}
	public SingleLinkedList<Character> travel(HashSet<Character> memo, SingleLinkedList<Character> ret, Node<Character> curNode){
		if(curNode == null)
			return ret;
		if(memo.contains(curNode.val))
			return travel(memo, ret, curNode.next);
		memo.add(curNode.val);
		ret.enqueue(curNode.val);
		return travel(memo, ret, curNode.next);
	}
}
