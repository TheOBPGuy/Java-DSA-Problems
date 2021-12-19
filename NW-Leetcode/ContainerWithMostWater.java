import java.util.*;


public class ContainerWithMostWater {

    /**
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     *
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     *
     * Return the maximum amount of water a container can store.
     *
     * Notice that you may not slant the container.
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0; int right = height.length-1;
        int result = Integer.MIN_VALUE;

        while (left < right) {
            int area = (right - left) * Math.min(height[right], height[left]);
            result = Math.max(area, result);
            if (height[right] < height[left]) {
                right = right -1;
            } else {
                left = left + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}
