import java.util.*;

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int[] nums2 = new int[nums.length+1]; // Store all elements in ascending order here

        // Fill the arrays so its easier to keep track which element(s) have not been updated
        Arrays.fill(nums2, -1);

        // Storing elements into the nums2 from nums
        for (int i = 0; i < nums.length; i++) {
            nums2[nums[i]] = nums[i];
        }

        int result = -1;

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == -1) {
                result = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,0,1};
        System.out.println(missingNumber(nums));
    }
}
