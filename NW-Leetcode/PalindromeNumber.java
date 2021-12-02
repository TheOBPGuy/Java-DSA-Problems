import java.util.*;
import java.util.LinkedList;


public class PalindromeNumber {

    /**
     * Given an integer x, return true if x is palindrome integer.
     *
     * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
     *
     * Example 1:
     * Input: x = 121
     * Output: true
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int reverse_half = 0;

        while (x > reverse_half) {
            int curr = x % 10; // Get the last number
            int temp_res = (reverse_half *10) + curr;
            x = x / 10;
        }

        // number = 1221
        // x = 12; reverse_half = 12
        if (x == reverse_half || x == reverse_half/10) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
