/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class MajorityElement {

	public static int majorityElement(int[] nums) {
		int majorityElement = -1;
		int count = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != majorityElement) {
				// 1. Decrement the Count
				// 2. If Count == 0; then update the ME to nums[i]
				// 3. Increment count by 1
				if (count != 0) {
					count--;
				}
				if (count == 0) {
					majorityElement = nums[i];
					count = 1;
				}
			} else {
				count++;
			}
		}
		return majorityElement;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// [8,8,7,7,7]
		int[] nums = new int[] {8,8,7,7,7};
		System.out.println(majorityElement(nums));
	}

}
