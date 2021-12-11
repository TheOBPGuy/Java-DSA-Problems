public class VersionControl {

    // This is some blackbox function
    private static boolean isBadVersion(int num) {
        return true;
    }

    public static int firstBadVersion(int n) {
        int lo = 0;
        int hi = n;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi-lo)/2;
            if (isBadVersion(mid)) {
                hi = mid -1;
            } else {
                lo = mid + 1;
            }
        }

        if (lo == hi && isBadVersion(lo)) {
            return lo;
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
