package project;

import java.util.Arrays;

public class Application {
	
	public static void main(String[] args) {
		int[] arr = Data.array(32);
		System.out.println(Arrays.toString(arr));
		
		int index = Data.binarySearch(arr, 50);
		System.out.println(index != -1 ? "Index="+index+", Value="+arr[index] : "Not found");
	}
}
