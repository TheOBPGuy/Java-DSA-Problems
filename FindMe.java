/**
 * 
 */

/**
 * @author farhanibrahim
 *
 */
public class FindMe {

	public static int findMe(int[] n, int target) {
		for (int i = 0; i < n.length; i++) {
			if (n[i] == target) { return i; }
		}
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1, 2, 13, 4, 5, 9, 31};
		System.out.print(findMe(arr, 13));
	}

}
