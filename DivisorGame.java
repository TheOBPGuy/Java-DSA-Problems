/**
 * 
 */

/**
 * @author farhanibrahim
 *
 */
public class DivisorGame {

	public boolean divisorGame(int N, boolean[] dp) {
		if (N == 1) {
			return false;
		}
		
		else {
			for (int i = 1; i < N; i++) {
				if (N % i == 0) {
					if (!divisorGame(N-i, dp) {
						return true;
					}
				}
			}
		}
		dp[N] = false;
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
