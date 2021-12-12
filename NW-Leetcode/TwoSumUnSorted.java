import java.util.HashMap;
import java.util.HashSet;

public class TwoSumUnSorted {

    public static boolean twoSumUnSorted(int[] numbers, int target) {
        // Second two Sum approach when the array is not sorted
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!set.contains(numbers[i])) {
                set.add(numbers[i]);
            }
        }

        for (int e : numbers) {
            int tempTarget = target - e;
            if (set.contains(tempTarget) && tempTarget != e) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
