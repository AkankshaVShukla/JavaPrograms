
public class LinkedListIntersection {

	public LinkedListNode findIntersection(LinkedListNode l1, LinkedListNode l2){
		if(l1 == null || l2 == null)return null;
		LinkedListTailSize result1 = getTailAndSize(l1);
		LinkedListTailSize result2 = getTailAndSize(l2);
		if(result1.tail != result2.tail) return null;
		LinkedListNode longer = (result1.size - result2.size) >0 ? l1:l2;
		LinkedListNode shorter = (result1.size - result2.size)>0 ? l2:l1;
		longer = chopLongerList(longer,Math.abs(result1.size - result2.size));
		while(longer != shorter){
			longer =longer.next;
			shorter = shorter.next;
		}
		return longer;
	}
	
	private LinkedListNode chopLongerList(LinkedListNode longer, int k) {
		// TODO Auto-generated method stub
		LinkedListNode current = longer;
		while(k>0 && current!= null){
			current = current.next;
			k--;
		}
		return current;
	}

	LinkedListTailSize getTailAndSize(LinkedListNode list){
		if(list == null) return null;
		int size =1;
		LinkedListNode current = list;
		while(current.next !=null){
			size++;
			current = current.next;
		}
		return (new LinkedListTailSize(current, size));
	}
	
}

class LinkedListNode{
	int data;
	LinkedListNode next;
	public LinkedListNode(int data){
		this.data = data;
		next = null;
	}
}

class LinkedListTailSize{
	LinkedListNode tail;
	int size;
	public LinkedListTailSize(LinkedListNode tail, int size){
		this.tail = tail;
		this.size = size;
	}
}