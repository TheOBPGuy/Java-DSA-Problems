import java.util.*;

public class KClosestPointstoOrigin {

    /**
     * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
     *
     * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
     *
     * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is 
     * @param points
     * @param k
     * @return
     */
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        for (int i = 0 ; i < points.length; i++) {
            int[] entry = {square(points[i]),i};
            // Continue inputting into the array until k elements
            if (pq.size() < k) {
                pq.add(entry);
            } else {
                if (entry[0] < pq.peek()[0]) {
                    // We found a point closer to origin than the head of queue
                    pq.poll();
                    pq.add(entry);
                }
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int index = pq.poll()[1];
            result[i] = points[index];
        }

        return result;
    }

    private static int square(int[] points) {
        return points[0]*points[0] + points[1]*points[1];
    }

    public static void main(String[] args) {

    }
}
