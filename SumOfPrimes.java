/**
 * 
 */

/**
 * @author farhanibrahim
 *
 */
public class SumOfPrimes {

	private static boolean checkForPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) { return false; }
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 20000;
		
		System.out.println(checkForPrime(num));
		
	}

}
