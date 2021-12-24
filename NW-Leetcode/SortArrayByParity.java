import java.util.*;

public class SortArrayByParity {

    /**
     * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
     *
     * Return any array that satisfies this condition.
     *
     * Input: nums = [3,1,2,4]
     * Output: [2,4,3,1]
     * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
     * 
     * @param nums
     * @return
     */
    public static int[] sortArrayByParity(int[] nums) {
        int evenIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                // Current number is even
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

    public static int[] sortArrayByParityUsingStacks(int[] nums) {
        Stack<Integer> even = new Stack<>();
        Stack<Integer> odd = new Stack<>();
        // Populate both the stacks using either odd or even
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                // Even Number
                even.push(nums[i]);
            } else {
                // Odd Number
                odd.push(nums[i]);
            }
        }

        // Iterate through all arrays and populate the Array.
        // In this second step we can either create a new array or simply
        // overwrite onto the existing array
        int idx = 0;
        while (!even.empty()) {
            nums[idx++] = even.pop();
        }

        while (!odd.empty()) {
            nums[idx++] = odd.pop();
        }
        return nums;
    }

    public static void main(String[] args) {
    }
}
