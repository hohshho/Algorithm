package dataStructure;

public class quickSortEx {
	private static void quickSort(int[] arr) {
		quickSort(arr,0,arr.length-1);
	}
	private static void quickSort(int arr[], int start, int end) {
		int pivot = partition(arr,start,end);
		if(start < pivot-1) {
			quickSort(arr,start,pivot-1);
		}//���ʿ� �ϳ��̻� ���� ��츸 ȣ���Ѵ�.
		if(end>pivot) {
			quickSort(arr,pivot,end);
		}//������ ��Ƽ���� �ϳ� �̻��� ��츸 ȣ���Ѵ�.
	}
	
	private static int partition(int[] arr,int start,int end) {
		int pivot = arr[(start+end)/2];
		while(start<=end) {
			while(arr[start] < pivot) start++;
			while(arr[end] > pivot) end--;
			if(start<=end) {
				swap(arr,start,end);
				start++;
				end--;
			}
		}	
		return start;
	}
	
	private static void swap(int[] arr,int start,int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}
	
	private static void printArray(int[] arr) {
		for(int data:arr) {
			System.out.print(data + ", ");
		}System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		printArray(arr);
		quickSort(arr);
		printArray(arr);
	}
}
