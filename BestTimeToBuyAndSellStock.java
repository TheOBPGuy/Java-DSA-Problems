/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class BestTimeToBuyAndSellStock {

	public static int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][prices.length];
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < prices.length; i++) {
			for (int j = i+1; j < prices.length; j++) {
				int val = prices[j] - prices[i];
				dp[i][j] = val;
				if (val > max) {
					max = val;
				}
			}
		}
		if (max <= 0) {
			return 0;
		} else return max;
		
	}s
	
	public static int maxProfitSmart(int[] prices) {
		int min  = Integer.MAX_VALUE;
		int max  = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				max = Math.max(max, prices[i] - min);
			}
		}
		
		return max;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = new int[] {7,1,5,3,6,4};
		System.out.print(maxProfit(prices));

	}

}
