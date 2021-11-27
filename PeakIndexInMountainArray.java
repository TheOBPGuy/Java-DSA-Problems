/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class PeakIndexInMountainArray {

	public static int peakIndexInMountainArray(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		int middle;
		
		while (low <= high) {
			middle = (int)Math.floor((low + high)/2);
			if (arr[middle] >= arr[middle + 1] && arr[middle] >= arr[middle -1]) {
				return middle;
			} else {
				if (middle == 0) {
					if (arr[middle] <= arr[middle + 1]) {
						low = middle + 1;
					} else {
						high = middle - 1;
					}
				} else {
					if (arr[middle] >= arr[middle -1] && arr[middle] <= arr[middle + 1]) {
						low = middle + 1;
					} else if (arr[middle] <= arr[middle -1]) {
						high = middle - 1;
					}
				}
			}
		}
		
		return -1;
	}
	
	public static int binarySearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;
		int middle;
		
		while(low <= high) {
			middle = (int)Math.floor((low + high)/2);
			if (arr[middle] == key) {
				return middle;
			} else if (key >= arr[middle]) {
				low = middle+1;
			}
			else {
				high = middle - 1;
			}
		}
		
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {3,5,3,2,0};
		
		System.out.println(peakIndexInMountainArray(arr));
	}

}
