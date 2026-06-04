package sorting;

import java.util.Arrays;
import java.util.Random;

public class Telusko3 {
	public static void main(String[] args) {
		int[] arr = getRandomArray(10);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		
	}
	
	public static int[] getRandomArray(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(100);
		}
		return arr;
	}
}
