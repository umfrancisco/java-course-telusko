package searching;

import java.util.Arrays;

public class Application {
	
	public static void main(String[] args) {
		int[] arr = array(1000);
		System.out.println(Arrays.toString(arr));
		int target = 900;
		
		int index1 = linearSearch(arr, target);
		System.out.println(index1 != -1 ? "Using Linear Search: Element found at index "+index1+", value="+arr[index1] : "Element not found");
		
		int index2 = binarySearch(arr, target);
		System.out.println(index2 != -1 ? "Using Binary Search: Element found at index "+index2+", value="+arr[index2] : "Element not found");
	}
	
	public static int[] array(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = (i + 1) * 2;
		}
		return arr;
	}
	
	public static int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		
		while (start <= end) {
			System.out.print(".");
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static int linearSearch(int[] arr, int target) {
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			System.out.print(".");
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
}

