public class ToLowerCase {

    /**
     * Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
     * @param str
     * @return
     *
     * Example 1:
     * Input: s = "Hello"
     * Output: "hello"
     *
     */
    public static String toLowerCase(String str) {
        String result = "";
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                // Convert to lower case
                result = result + (char)(c+32);
            } else {
                result = result + c;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
