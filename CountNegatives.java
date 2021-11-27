/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class CountNegatives {

	public static int countNegatives(int[][] grid) {
		int count = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = grid[i].length - 1; j >= 0; j--) {
				if (grid[i][j] < 0) {
					count++;
				} else {
					break;
				}
			}
		}
		
		return count;
	}
	
	public static int binarySearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length;
		int middle;
		
		// Iterate until low > high
		while (low <= high) {
			middle = (int) Math.floor((low + high)/2);
			if (arr[middle] == key) {
				return middle;
			} else if (key >= arr[middle]) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
		
		// int[] arr1 = new int[] {3,6,8,12,14,17,25,29,31,36,42,47,53,55,62};
		// System.out.println(binarySearch(arr1,3));
		
		int[][] grid = new int[][] {{-1}};
		System.out.println(countNegatives(grid));
	}

}
