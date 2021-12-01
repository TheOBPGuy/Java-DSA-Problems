import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

}

public class IsPalindromeLinkedList {

    /**
     * Given the head of a singly linked list, return true if it is a palindrome.
     * Input: head = [1,2,2,1]
     * Output: true
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // We have reached the middle of the list at this point
        // Reverse the slow pointer
        slow = reverse(slow);

        // Reassign Fast back to being the head of the list
        fast = head;

        // Finally compare both slow and fast pointer values one by one
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
