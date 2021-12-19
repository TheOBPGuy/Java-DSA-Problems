import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

public class ReverseLinkedListStackMethod {

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        // Input all the elements of the list onto the stack
        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        // Iterate over the stack and create a new list and dump those new elements
        // onto the list.
        ListNode newNode = new ListNode(-1);
        ListNode newCurrent = newNode;
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            newCurrent.next = new ListNode(temp.val);
            newCurrent = newCurrent.next;
        }

        return newNode.next;
    }

    public static void main(String[] args) {

    }
}
