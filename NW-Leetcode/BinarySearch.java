public class BinarySearch {

    /**
     * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     * @param nums
     * @param target
     * @return
     *
     * Input: nums = [-1,0,3,5,9,12], target = 9
     * Output: 4
     * Explanation: 9 exists in nums and its index is 4
     *
     */
    public static int search(int[] nums, int target) {
        int lo = 0; int hi = nums.length-1;
        int middle;
        while (lo <= hi) {
            middle = lo + (hi-lo)/2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                lo = middle + 1;
            } else {
                hi = middle -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
