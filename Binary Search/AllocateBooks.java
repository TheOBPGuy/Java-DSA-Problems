public class AllocateBooks {

    public static int binarySearch(int[] A, int B) {
        // Find the lowest element
        int low = findSmallest(A);
        // Find the Summation of all elements
        int high = findSummation(A);
        int res = 0;

        while (low <= high) {
            int middle = low + (high-low)/2;
            if (isPossible(A, B, mid)) {
                // Decrement the high
                res = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    private static boolean isPossible(int[] A, int N, int mid) {
        int students = 1;
        int pages = 0;
        for (int i = 0 ; i < A.length; i++) {
            if (A[i] > mid) {
                return false;
            }
            if (pages + A[i] > mid) {
                students++;
            } else {
                pages += A[i];
            }
        }

        // Check if total students required for allocaiton surpasses
        // what is permissible
        if (students > N) {
            return false;
        } else {
            return true;
        }
    }

    private static int findSmallest(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    private static int findSummation(int[] arr) {
        int sum = 0;
        for (int i = ; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}