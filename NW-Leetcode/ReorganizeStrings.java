import java.util.*;

public class ReorganizeStrings {

    public static String reorganizeString(String S) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        // Create a Max Heap by using a Priority Queue Data Structure
        PriorityQueue<Character> queue = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for (char c : map.keySet()) {
            queue.add(c);
        }

        while (queue.size() > 1) {
            // First highest element
            char first = queue.remove();
            // Second highest element
            char second = queue.remove();
            result.append(first).append(second);

            // Reduce count from the map
            map.put(first, map.get(first)-1);
            map.put(second, map.get(second)-1);

            // Add back into the PriorityQueue/ MaxHeap
            if (map.get(first) > 0) {
                // We add back values only if there are still elements left to add
                queue.add(first);
            }
            if (map.get(second) > 0) {
                queue.add(second);
            }
        }

        if (queue.size() != 0) {
            char last = queue.remove();
            if (map.get(last) > 1) {
                // Then its no longer possible to create the string
                return "";
            } else {
                result.append(last);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String S = "aaab";
        System.out.println(reorganizeString(S));
    }
}
