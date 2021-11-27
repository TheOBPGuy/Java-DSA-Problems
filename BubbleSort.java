import java.util.Arrays;

/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class BubbleSort {

	public static void bubbleSort(int[] arr) {
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < arr.length-1; i++) {
				if  (arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					sorted = false;
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
		bubbleSort(arr);
	}

}
