import java.util.Arrays;

/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class InsertionSort {

	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int j = i;
			while (arr[j] < arr[j-1] && j >= 0) {
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				
				j--;
				
				if (j == 0) {
					break;
				}
			}
		}
		
		System.out.print(Arrays.toString(arr));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {4,2,1,5,3};
		// 2,4,1,5,3
		insertionSort(arr);
		
	}

}
