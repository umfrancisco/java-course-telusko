package sorting;

import java.util.Arrays;

// bubble, selection and insertion sort -> O(n^2)
public class Telusko1 {
	
	public static void insertionSort() {
		int[] arr = {6,5,2,8,9,4};
		int size = arr.length;
		System.out.println("Before sorting: "+Arrays.toString(arr));
		
		for (int i = 1; i < size; i++) {
			int key = arr[i];
			int j = i - 1;
			
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
				
			}
			arr[j + 1] = key;
		}
		
		System.out.println("After sorting: "+Arrays.toString(arr));
	}
	
	public static void selectionSort() {
		int[] nums = {6,5,2,8,9,4};
		int size = nums.length;
		int temp = 0;
		int minIndex = 0;
		int start = 1;
		
		System.out.println("Before sorting: "+Arrays.toString(nums));
		
		for (int i = 0; i < size - 1; i++) {
			minIndex = i;
			for (int j = start; j < size; j++) {
				if (nums[minIndex] > nums[j]) {
					minIndex = j;
				}
			}
			temp = nums[minIndex];
			nums[minIndex] = nums[i];
			nums[i] = temp;
			start++;
			System.out.println("--> "+Arrays.toString(nums));
		}
		
		System.out.println("After sorting: "+Arrays.toString(nums));
	}
	
	public static void bubbleSort() {
		int[] nums = {6,5,2,8,9,4};
		int size = nums.length;
		int temp = 0;
		
		System.out.println("Before sorting: "+Arrays.toString(nums));
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
				System.out.println("i="+i+", j="+j+" --> "+Arrays.toString(nums));
			}
		}
		
		System.out.println("After sorting: "+Arrays.toString(nums));
	}
	
}
