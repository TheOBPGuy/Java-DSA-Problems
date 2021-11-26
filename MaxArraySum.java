/**
 * 
 */
import java.util.*;

/**
 * @author farhanibrahim
 *
 */
public class MaxArraySum {

	public static int maxSubsetSum(int[] arr) {
		// 1. Create a Dynamic Programming Array
		int[] dp = new int[arr.length];
		dp[0] = Math.max(0, arr[0]); dp[1] = Math.max(dp[0], arr[1]);
		for (int i = 2; i < arr.length; i++) {
			dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
		}
		return dp[arr.length - 1];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
