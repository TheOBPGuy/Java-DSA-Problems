public class FirstNonRepeatingCharacter {

    private static final int NO_OF_CHARS = 256;
    private static char count[] = new char[NO_OF_CHARS];

    public static void generateCharCountArr(String str) {
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
    }

    private static void printChars() {
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i]);
        }
    }

    public static int solution(String str) {
        generateCharCountArr(str);

        for (int i = 0; i < count.length; i++) {
            if (count[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "geekforgeeks";
        System.out.println(solution(str));
        // printChars();
    }
}
