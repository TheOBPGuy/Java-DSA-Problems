import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

public class MergeKSortedLists {

    /**
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     *
     * Merge all the linked-lists into one sorted linked-list and return it.
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        // Iterate over all the lists in this array
        // Push the elements onto a min heap array
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++) {
            ListNode current = lists[i];
            while (current != null) {
                queue.add(current.val);
                current = current.next;
            }
        }

        ListNode newNode = new ListNode(-1);
        ListNode current = newNode;
        while (!queue.isEmpty()) {
            ListNode temp = new ListNode(queue.poll());
            current.next = temp;
            current = current.next;
        }

        return newNode.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,0,1};
        // System.out.println(missingNumber(nums));
    }
}
