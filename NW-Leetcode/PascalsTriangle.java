import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    /**
     * Given an integer numRows, return the first numRows of Pascal's triangle.
     *
     * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
     * @param numRows
     * @return
     *
     * Example
     * Input: numRows = 5
     * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        // Base Condition
        if (numRows <= 0) {
            return res;
        }

        // Number of Rows is atleast going to be 1
        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        res.add(first_row);

        for (int i = 1; i < numRows; i++) {
            List<Integer> previous = res.get(i-1);
            List<Integer> current = new ArrayList<>;

            current.add(1);

            // Fill in all the middle elements
            for (int j = 1; j < i; j++) {
                current.add(previous.get(j-1) + previous.get(j));
            }

            // Fill in the last value with 1 as well
            current.add(1);
            res.add(current);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
