import java.util.Stack;


public class LinkListPalindrome {
	boolean isPalindrome(LinkedListNode head){
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		while(fast != null && fast.next !=null){
			stack.push(slow.data);
			slow= slow.next;
			fast= fast.next.next;
		}
		if(fast.next == null){
			slow=slow.next;
			//stack.pop();
		}
		while(slow != null){
			if(slow.data != stack.pop())
				return false;
			slow = slow.next;
		}
		return true;
	}
}
