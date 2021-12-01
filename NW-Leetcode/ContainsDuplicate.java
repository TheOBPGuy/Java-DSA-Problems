import java.util.HashSet;

public class ContainsDuplicate {

    /**
     * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1]
     * Output: true
     * Example 2:
     *
     * Input: nums = [1,2,3,4]
     * Output: false
     * Example 3:
     *
     * Input: nums = [1,1,1,3,3,4,3,2,4,2]
     * Output: true
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        // A set will contain only unique keys . this is why we are leveraging a set
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
