import java.util.*;

public class LastStoneWeight {

    /**
     *
     * You are given an array of integers stones where stones[i] is the weight of the ith stone.
     *
     * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
     *
     * If x == y, both stones are destroyed, and
     * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
     * At the end of the game, there is at most one stone left.
     *
     * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
     *
     * O(NLogN) -> Time complexity
     * O(N) -> Space Complexity
     *
     * @param stones
     * @return
     */
    public static int lastStoneWeight(int[] stones) {
        // Create a Max Heap to store the elements of the stones array.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        // By default Java creates a Min Heap . So we would need to negate the values of the array
        // to insert them to the Max Heap
        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(-stones[i]);
        }

        // Keep looping and remove the "max"/top elements of the heap until
        // there is only 1 element left
        while (maxHeap.size() > 1) {
            int largest = -maxHeap.remove();
            int second = -maxHeap.remove();
            // Only insert into the Max Heap if there is any actual difference after 'smashing' the rocks
            if (largest != second) {
                maxHeap.add(-(largest-second));
            }
        }

        return maxHeap.isEmpty() ? 0 : -maxHeap.remove();
    }

    public static void main(String[] args) {
        
    }
}
