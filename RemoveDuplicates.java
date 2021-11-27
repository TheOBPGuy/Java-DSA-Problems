/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class RemoveDuplicates {

	public static int removeDuplicates(int[] nums) {
		int index = 1;
		for (int i = 0; i < nums.length-1; i++) {
			if (nums[i] != nums[i + 1]) {
				nums[index++] = nums[i+1];
			}
		}
		return index;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[] {8,8,7,7,8};
		System.out.println(removeDuplicates(nums));
	}

}
