package dataStructure;

public class selectionSortEx {
	private static void selectSort(int[] arr) {
		selectSort(arr, 0);
	}

	private static void selectSort(int[] arr, int s) {
		if (s < arr.length - 1) {
			int min = s;
			int temp;
			for (int i = s; i < arr.length; i++) {
				if (arr[min] > arr[i]) {
					min = i;
				}
			}
			temp = arr[s];
			arr[s] = arr[min];
			arr[min] = temp;

			selectSort(arr, s + 1);
		}
	}

	private static void print(int[] arr) {
		for (int data : arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 5, 2 };
		print(arr);
		selectSort(arr);
		print(arr);
	}
}
