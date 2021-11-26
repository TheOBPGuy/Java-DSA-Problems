import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author farhanibrahim
 *
 */
public class CountSubstrings {

	@SuppressWarnings("unlikely-arg-type")
	public static int countSubstrings(String s, String t) {
		// 1. Generate all substrings of s
		ArrayList<String> arrayS = prefix(s);
		
		System.out.println(Arrays.toString(arrayS.toArray()));
		
		// 2. Generate all substrings of t
		ArrayList<String> arrayT = prefix(t);
		
		// 3. Create a Map which stores all the prefixes of t
		// The Map will contain Key as length of prefix.
		// The value will be an arraylist of the prefix itself
		// We will count duplicates
		HashMap<Integer, ArrayList<String>> mapS = createMapOfPrefixes(arrayS);
		HashMap<Integer, ArrayList<String>> mapT = createMapOfPrefixes(arrayT);
		
		// For printing out elements of a HashMap
		mapS.entrySet().forEach(entry->{
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });
		
		mapT.entrySet().forEach(entry->{
			System.out.println(entry.getKey() + " " + entry.getValue());
		});
		
		
		// 4. Loop through all elements(prefixes) of String s
		// Match length of prefix with map
		// For similar length:
		// 		if prefixes don't match -> increment count
		int count = 0;
		for (int i = 0; i < arrayS.size(); i++) {
			if (mapT.containsKey(arrayS.get(i).length())) {
				//ArrayList<String> temp = mapT.get(arrayS.get(i));
				String target = arrayS.get(i);
				for (int j = 0; j < mapT.get(arrayS.get(i).length()).size(); j++) {
					String current = mapT.get(arrayS.get(i).length()).get(j);
					
					int foundOnes = 0;
					for (int k = 0; k < current.length(); k++) {
						if (current.charAt(k) != target.charAt(k)) {
							foundOnes++;
						}
						
						if (foundOnes > 1) {
							break;
						}
					}
					
					if (foundOnes == 1) {
						count++;
					}
				}
			}
		}
		
		System.out.println(count);
		return count;
	}
	
	
	private static HashMap<Integer, ArrayList<String>> createMapOfPrefixes(ArrayList<String> array) {
		HashMap<Integer, ArrayList<String>> map = new HashMap<>();
		for (int i = 0; i < array.size(); i++) {
			// If the map does not contain the array.length; then insert it is a new  one
			if (!map.containsKey(array.get(i).length())) {
				ArrayList<String> newArray = new ArrayList<>();
				newArray.add(array.get(i));
				int key = array.get(i).length();
				map.put(key, newArray);
			} else {
				ArrayList<String> oldArray = map.get(array.get(i).length());
				oldArray.add(array.get(i));
				map.put(array.get(i).length(), oldArray);
			}
		}
		
		return map;
	}
	
	
	private static ArrayList<String> prefix(String str) {
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) 
			for (int j = i; j< str.length(); j++) {
				if (i == j) {
					result.add(Character.toString(str.charAt(j)));
				} else {
					result.add(str.substring(i, j+1));
				}
			}
		return result;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abe";
		String t = "bbc";
	
//		char[] tempS = s.toCharArray();
//		Arrays.sort(tempS);
//		String sA = new String(tempS);
//		System.out.println(sA);
		
		countSubstrings(s,t);
	}

}
