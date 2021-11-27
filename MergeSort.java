/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class MergeSort {

	public static void mergeSort(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int middle = (left + right)/2;
		
		if (left >= right) {
			return;
		} else {
			int[] leftArr = new int[middle];
			int[] rightArr = new int[arr.length - middle];
			
			// Fill all values inside the left and right arrays
			for (int i = 0; i < leftArr.length; i++) {
				leftArr[i] = arr[i];
			}
			
			for (int i = 0; i < rightArr.length; i++) {
				rightArr[i] = arr[i];
			}
			
			mergeSort(leftArr);
			mergeSort(rightArr);
			merge(arr,leftArr,rightArr);
		}
	}
	
	private static void merge(int[] arr,int[] left, int[] right) {
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {2,1};
	}

}
