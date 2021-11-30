public class WaveArray {

    /**
     * Given an array of integers A, sort the array into a wave like array 
     * and return it, In other words, arrange the elements into a sequence such that 
     * a1 >= a2 <= a3 >= a4 <= a5.....
     */
    public int[] wave(int[] A) {

        boolean flip = true;
        for (int i = 0; i < A.length-1; i++) {
            // Swap elements if conditions match
            if (flip) {
                // a1 >= a2
                if (A[i] < A[i+1]) {
                    // Swap the elements
                    int temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                }
                flip = false;
            } else {
                if (A[i] > A[i+1]) {
                    // Swap the elements
                    int temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                }
                flip = true;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        
    }
}