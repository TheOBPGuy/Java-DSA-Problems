import java.util.*;


public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        // Basic input checks
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[size++] = nums[i];
            }
        }
        return size;
    }


    public static void main(String[] args) {
    }
}
