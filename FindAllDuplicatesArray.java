
import java.util.*;

/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class FindAllDuplicatesArray {

	public List<Integer> findDuplicates(int[] nums) {
		// Create a set
		HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
		
		List<Integer> list = new LinkedList<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				list.add(nums[i]);
			} else {
				LinkedList<Integer> temp = new LinkedList<Integer>();
				temp.add(nums[i]);
				map.put(nums[i], temp);
			}
		}
		
		return list;
	}
	
	public static List<Integer> findDuplicatesSmart(int[] nums) {
		List<Integer> result = new LinkedList<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			int check = Math.abs(nums[i]) - 1;
			
			if (nums[check] < 0) {
				result.add(Math.abs(nums[i]));
			} else {
				nums[check] = -1 * nums[check];
			}
		}
		
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// [4,3,2,7,8,2,3,1]
		// [4,3,2,-7,8,2,3,1]
		// [4,3,-2,-7,8,2,3,1]
		// [4,-3,-2,-7,8,2,3,1]
		// [4,-3,-2,-7,8,2,3,1]
		// [4,-3,-2,-7,8,2,-3,1]
		// [4,-3,-2,-7,8,2,-3,-1]
		// [4,-3,-2,-7,8,2,-3,-1]
		int[] nums = new int[] {4,3,2,7,8,2,3,1};
		System.out.println(findDuplicatesSmart(nums));

	}

}
