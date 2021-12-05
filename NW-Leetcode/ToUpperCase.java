public class ToUpperCase {

    /**
     * Given a string s, return the string after replacing every lowercase letter with the same uppercase letter.
     * @param str
     * @return
     *
     * Example 1:
     * Input: s = "hello"
     * Output: "Hello"
     *
     */
    public static String toUpperCase(String str) {
        String result = "";
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                // Convert to lower case
                result = result + (char)(c-32);
            } else {
                result = result + c;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
