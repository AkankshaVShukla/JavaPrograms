/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class AdditionLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cary =0;
        ListNode sentinel = new ListNode(0);
        ListNode resultNode =sentinel;
        while(l1 !=null || l2!=null){
            int sum = cary;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 !=null){
                sum+=l2.val;
                l2 = l2.next;
            }
             if(sum > 9){
                cary = sum/10;
               sum = sum%10;
            }else{
                cary =0;
            }
            resultNode.next = new ListNode(sum);
            resultNode = resultNode.next;
        }
        if(cary>0) resultNode.next = new ListNode(cary);
        return sentinel.next;
    }
}