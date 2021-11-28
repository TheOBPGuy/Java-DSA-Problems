public class IntersectionBetweenTwoArrays {

    public static ArrayList<Integer> solve(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        
        // Pull out all the Unique values
        for (int i : A) {
            set.add(A[i]);
        }

        HashSet<Integer> intersection = new HashSet<>();
        // Extract only the intersection values
        for (int j : B) {
            if (set.contains(B[j])) {
                intersection.add(B[j]);
            }
        }

        // Put all values onto an ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for (int k : intersection) {
            result.add(k);
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}