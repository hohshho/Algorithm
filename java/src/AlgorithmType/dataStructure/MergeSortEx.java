package dataStructure;

public class MergeSortEx {
	private static void mergeSort(int arr[]) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length-1);
	}

	private static void mergeSort(int[] arr, int[] tmp, int s, int e) {
		if (s < e) {
			int pivot = (s + e) / 2;
			mergeSort(arr, tmp, s, pivot);
			mergeSort(arr, tmp, pivot+1, e);
			merge(arr, tmp, s, pivot, e);
		}
	}

	private static void merge(int[] arr, int[] tmp, int s, int p, int e) {
		for(int i=s; i<=e;i++) {
			tmp[i] = arr[i];
		}
		int part1 = s;
		int part2 = p+1;
		int index = s;
		while(part1 <= p && part2 <= e) {
			if(tmp[part1] < tmp[part2]) {
				arr[index] = tmp[part1];
				part1++;
			}else{
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		for(int i=part1;i<=p;i++) {
			arr[index] = tmp[i];
			index++;
		}
	}
	private static void printArr(int[] arr) {
		for(int data:arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {9,8,7,6,5,4,3,2,1,0};
		printArr(arr);
		mergeSort(arr);
		printArr(arr);
		
	}

}
