/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class BinarySearch {

	public static int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length;
		int middle = -1;
		while (low < high) {
			middle = (high+low)/2;
			
			// Check for last position
			if (middle == nums.length) {
				return -1;
			}
			
			if (nums[middle] == target) {
				return middle;
			} else if (nums[middle] < target) {
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
		int[] nums = new int[] {-1,0,3,5,9,12};
		System.out.println(search(nums,13));
	}

}
