import java.util.*;

public class AddStringAndBinary {

    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() -1;
        int j = num2.length() -1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum = sum + num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum = sum + num2.charAt(j--) - '0';
            }

            result.append(sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) {
            result.append(carry);
        }
        result = result.reverse();
        return result.toString();
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                // We still have numbers (binary digits) inside a to keep going forward
                sum = sum + a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            result.insert(0,sum % 2);
            carry = sum /2;
        }

        // Check if there was any left over carry values from the last calculation
        if (carry > 0) {
            result.insert(0,1);
        }
        return result.toString();
    }

    public static void main(String[] args) {

    }
}
