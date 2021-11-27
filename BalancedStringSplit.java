import java.util.LinkedList;

/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class BalancedStringSplit {

    public int balancedStringSplit(String s) {
        int res = 0;
        // Find out all the substrings of a string
        LinkedList<String> subStr = new LinkedList<String>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                subStr.add(s.substring(i, j));
            }
        }

        for (int k = 0; k < subStr.size(); k++) {

        }

        return res;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
