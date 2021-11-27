import java.util.Arrays;

/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class SelectionSort {

	public static void selectionSort(int[] arr) {
		//int current_item;
		int current_minimum;
		int min_index = 0;
		boolean found = false;
		
		
		int i = 0;
		while (i <= arr.length - 1) {
			current_minimum = arr[i];
			min_index = i;
			found = false;
			
			for (int j = i+1; j < arr.length; j++) {
				//current_item = arr[j];
				if (arr[j] < current_minimum) {
					current_minimum = arr[j];
					min_index = j;
					found = true;
				}
			}
			
			if (found) {
				int temp = arr[i];
				arr[i] = current_minimum;
				arr[min_index] = temp;
			}
			
			
			i++;
		}
		
		System.out.print(Arrays.toString(arr));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {4,2,1,5,3};
		// 1,2,4,5,3
		
		selectionSort(arr);
	}

}
