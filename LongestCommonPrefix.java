/**
 * 
 */

/**
 * @author farhanibrahim
 *
 */
public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		
		// Base case:
		if (strs.length == 0 || strs == null) {
			return "";
		}
		
		String prefix = strs[0];
		//System.out.println(strs[1].indexOf("fl"));
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}
		
		return prefix;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ["flow","flight"]
		// "flower"
		
		String[] strs = new String[] {"dog","racecar","car"};
		System.out.println(longestCommonPrefix(strs));
	}

}
