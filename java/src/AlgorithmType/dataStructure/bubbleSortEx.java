package dataStructure;

public class bubbleSortEx {
	private static void bubbleSort(int[] arr) {
		bubbleSort(arr,0,arr.length-1);
	}
	private static void bubbleSort(int[] arr,int s,int e) {
		int temp=0;
		for(int i=s;i<e;i++) {
			if(arr[i]>arr[i+1]) {
				temp = arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;
			}
		}
		
		if(s<e) {
			bubbleSort(arr,s,e-1);
		}
	}
	private static void printArr(int[] arr) {
		for(int data: arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {1,3,4,5,2};
		printArr(arr);
		bubbleSort(arr);
		printArr(arr);
	}
}
