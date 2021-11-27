/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class FibonacciNumbers {

	public static int fibonacciRecursive(int n) {
		if (n ==1 || n == 2) return 1;
		else {
			return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
		}
	}
	
	public static int fibonacciDynamic(int n, int[] dp) {
		if (n ==1 || n == 2) {
			dp[n]dp.le  = 1;
			return 1;
		}
		else {
			int result = fibonacciDynamic(n-1, dp) + fibonacciDynamic(n-2,dp);
			dp[n] = result;
		}
		return dp[n];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(fibonacciRecursive(6));
		//
		int[] dp = new int[7];
		System.out.println(fibonacciDynamic(6, dp));
	}

}
