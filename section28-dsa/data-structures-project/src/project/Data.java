package project;


public class Data {
	
	public static int[] array(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = i * 2;
		}
		return arr;
	}
	
	public static void timer(int seconds) {
		System.out.println("Searching for "+seconds+"s");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// returns index
	// time complexity -> O(log n)
	public static int binarySearch(int[] arr, int value) {
		int start = 0;
		int end = arr.length - 1;
		
		int seconds = 0;
		while (start <= end) {
			seconds++;
			timer(seconds);
			int mid = (start + end) / 2;
			if (arr[mid] == value) {
				return mid;
			} else if (arr[mid] < value) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
	
	// returns index
	// time complexity -> O(n)
	public static int linearSearch(int[] arr, int value) {
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
}

