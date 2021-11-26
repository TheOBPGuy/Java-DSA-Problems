/**
 * 
 */

/**
 * @author farhanibrahim
 *
 */
public class MiddleofLinkedList {

	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void insert(ListNode head, int data) {
		if (head == null) {
			head = new ListNode(data);
		}
		if (head.next == null) {
			head.next = new ListNode(data);
		} else {
			ListNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(data);
		}
	}
	
	public static ListNode middleNode(ListNode head) {
		// 1. If node is null -> return null
		if (head == null) return null;
		if (head.next == null) return head;
		
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next!= null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public static ListNode reverse(ListNode head) {
		// 1->2->3->4
		ListNode prev = null;

		while (head != null) {
			ListNode next_node = head.next;
			head.next = prev;
			prev = head;
			head = next_node;
		}
		
		return prev;
	}
	
	public static void printNodes(ListNode head) {
		if (head == null) {
			System.out.println(" ");
		} else {
			ListNode current = head;
			while (current != null) {
				System.out.println(current.val);
				current = current.next;
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		insert(head,2);
		insert(head,3);
		insert(head,4);
		insert(head,5);
		
		// printNodes(head);
		// System.out.println(middleNode(head).val);
		
		// System.out.println("=====================");
		ListNode newTemp = reverse(head);
		printNodes(newTemp);
		
	}

}
