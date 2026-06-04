package sorting;

import java.util.Arrays;
import java.util.Random;

// Quick Sort -> O(n log n)
public class Telusko2 {
	
	public static void main(String[] args) {
		int[] arr = getRandomArray(10);
		System.out.println("Before sorting: "+Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("After sorting: "+Arrays.toString(arr));
	}
	
	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}
	}
	
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start - 1;
		
		for (int j = start; j < end; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = temp;
		
		return i + 1;
	}
	
	public static int[] getRandomArray(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(100);
		}
		return arr;
	}
}
