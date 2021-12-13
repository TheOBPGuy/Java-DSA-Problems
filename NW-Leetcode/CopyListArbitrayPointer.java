import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode arbitraryPointer;
    ListNode(int x) {
        this.val = x;
        this.next = null;
        this.arbitraryPointer = null;
    }
}

public class CopyListArbitraryPointer {

    /**
     * You are given a linked list where the node has two pointers. The first is the regular next pointer.
     * The second pointer is called arbitrary_pointer and it can point to any node in the linked list.
     * Your job is to write code to make a deep copy of the given linked list.
     * Here, deep copy means that any operations on the original list should not affect the copied list.
     * @param head
     * @return
     */
    public static ListNode deepCopyArbitraryPointer(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        ListNode new_head = null;
        ListNode new_prev = null;
        Hashtable<ListNode, ListNode> map = new Hashtable<ListNode, ListNode>();

        // Create copy of the linked List
        while (current != null) {
            ListNode new_node = new ListNode(current.val);

            new_node.arbitraryPointer = current.arbitraryPointer;
            if (new_prev != null) {
                new_prev.next = new_node;
            } else {
                new_head = new_node;
            }

            map.put(current, new_node);
            new_prev = new_node;
            current = current.next;
        }

        ListNode new_current = new_head;
        while (new_current != null) {
            if (new_current.arbitraryPointer != null) {
                ListNode node = map.get(new_current.arbitraryPointer);
                new_current.arbitraryPointer = node;
            }

            new_current = new_current.next;
        }

        return new_head;
    }

    public static void main(String[] args) {

    }
}
