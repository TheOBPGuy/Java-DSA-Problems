import java.util.*;
import java.util.LinkedList;


public class ReverseInteger {

    /**
     * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     *
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int reverse = 0;
        int curr;
        while (x != 0) {
            curr = x % 10;
            reverse = (reverse * 10) + curr;
            x = x / 10;
        }

        // Following code needed to account for extremely large numbers
        if (reverse > Integer.MAX_VALUE/10 || reverse == Integer.MAX_VALUE && curr > 7) return 0;
        if (reverse < Integer.MIN_VALUE/10 || reverse == Integer.MIN_VALUE/10 && curr < -8) return 0;

        return reverse;
    }

    public static void main(String[] args) {
        int x = 123;
        reverse(x);
        System.out.println(x);
    }
}
