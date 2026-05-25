package sorting;

import java.util.Arrays;

public class Application {
	
	public static void main(String[] args) {
		int[] arr = {7,2,5,1,8,4,5};
		Algorithms.bubble_sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}

class Algorithms {
	
	public static void bubble_sort(int[] arr) {
		int steps = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					steps++;
				}
			}
		}
		System.out.println("# Number of steps = "+steps);
	}
}
