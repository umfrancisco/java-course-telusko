package sorting;

import java.util.Arrays;

public class Application {
	
	public static void main(String[] args) {
		int[] arr = {2,5,3,7,1,9};
		Algorithms.selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}

class Algorithms {
	
	public static void selectionSort(int[] arr) {
		int size = arr.length;
		
		for (int i = 0; i < size - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < size; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
