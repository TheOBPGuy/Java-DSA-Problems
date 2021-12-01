import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoSumTwo {

    /**
     * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
     *
     * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
     *
     * The tests are generated such that there is exactly one solution. You may not use the same element twice.
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        // Check if the array is sorted. If not then preferably sort the array first
        int pointer1 = 0;
        int pointer2 = numbers.length-1;

        while (pointer1 <= pointer2) {
            int sum = numbers[pointer1] + numbers[pointer2];
            if (sum == target) {
                return new int[] {pointer1+1, pointer2+1};
            } else if (sum < target) {
                pointer1 = pointer1+1;
            } else {
                pointer2 = pointer2-1;
            }
        }
        return new int[] {pointer1+1, pointer2+1};
    }

    public static void main(String[] args) {

    }
}
