public class SortArrayWithSquares {
    
    /**
        The idea is to maintian two pointers - negative and postive
        Negative pointer will go over all the negative elements starting with the least negative
        and keep adding to answer. We need to decrement the negative simultanously
        Postive pointer will go over all the positive elements starting with the least positive 
        and keep adding to answer. We need to increment the positive simultaneously 
    */
    public static int[] solve(int[] A) {
        int negative = 0;
        int positive = 0;
        int[] ans = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                positive++;
            } else {
                break;
            }
        }
        negative = positive - 1;

        System.out.println(negative + "," + positive);

        // Maintain 2 pointers. if positive is greater - insert the postive to answer - increment postive
        // if negative is greater - insert the negative to answer - decrement negative
        int idx = 0;
        while (negative >= 0 && postive < A.length) {
            int negativeSq = A[negative]*A[negative];
            int postiveSq = A[postive]*A[positive];

            if (negativeSq > postiveSq) {
                ans[idx] = negativeSq;
                negative--;
            } else {
                ans[idx] = postiveSq;
                postive++;
            }
            idx++;
        }

        // If there are any pending elements left from either side of the arrays
        while (negative >= 0) {
            int negativeSq = A[negative]*A[negative];
            ans[idx] = negativeSq
            negative--;
            idx++;
        }

        while (postive < A.length) {
            int postiveSq = A[positive]*A[postive];
            ans[idx] = postiveSq;
            postive++;
            idx++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[] {-4,-1,0,3,10};
        solve(A);
    }
}