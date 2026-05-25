package sorting;

import java.util.Arrays;

public class TeluskoResolution {
	
	public static void main(String[] args) {
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
