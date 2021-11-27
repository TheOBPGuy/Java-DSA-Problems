/**
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * @author TheOBPGuy
 *
 */
public class Watermelon {

	private static final int max_solvers = 2;
	
	public static void watermelon(int w) {
		int remainder = w % 2;
		if (remainder % 2 == 0) { System.out.print("Yes"); }
		else { System.out.println("No"); }
	}
	
	public static void wayTooLongWords(String s) {
		if (s.length() <= 10) {
			System.out.println(s);
		} else {
			String first = Character.toString(s.charAt(0));
			String last = Character.toString(s.charAt(s.length()-1));
			String count = Integer.toString(s.length() - 2);
			String result = first + count + last;
			System.out.println(result);
		}
	}
	
	public static int team(int[][] matrix) {
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			int row_count = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					row_count = row_count + 1;
				}
				
				if (row_count >= max_solvers) {
					res = res + 1;
					break;
				}
			}
		}
		return res;
	}
	
	public static int nextRound(int pos, int[] arr) {
		int res = 0;
		int standard = arr[pos];
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= standard) {
				res = res + 1;
			}
		}
		
		return res;
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// watermelon(8);
		//wayTooLongWords("pneumonoultramicroscopicsilicovolcanoconiosis");
//		int[][] matrix = {
//				{1, 0, 0},
//				{0, 1, 1}
//		};
//		System.out.println(team(matrix));
		
		// Get data using Buffered Reader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// Get the First set of input parameters by user
		LinkedList<Integer> list = new LinkedList<Integer>();
		String line1 = reader.readLine();
		String[] strs1 = line1.trim().split("\\s+");
		for (int j = 0; j < strs1.length; j++) {
			list.add(Integer.parseInt(strs1[j]));
		}
		int length = list.get(0);
		
		// Get the Second set of input parameters by user
		
		int[] a2 = new int[length];
		String line2 = reader.readLine(); // To read multiple Integer lines
		String[] strs = line2.trim().split("\\s+");
		for (int i = 0; i< length; i++) {
			a2[i]  = Integer.parseInt(strs[i]);
		}
		
	}

}
