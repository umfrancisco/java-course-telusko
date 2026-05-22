package sorting;

import java.util.Arrays;

public class Application {
	public static void main(String[] args) {
		int[] arr = {8,6,9,2,4,5};
		int[] sorted = BubbleSort.sort(arr);
		System.out.println(Arrays.toString(sorted));
	}
}

class BubbleSort {
	
	public static int[] sort(int[] arr) {
		int size = arr.length;
		return arr;
	}
}
