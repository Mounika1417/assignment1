package datastructures.sort;

public class HeapSortDemo {

	static void heapSort(int arr[]) {
		int N = arr.length;
		
		//Build heap
		for(int i = N / 2 - 1; i >= 0 ; i--) {
			heapify(arr,N,i);
		}
		
		for (int i = N-1;i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr, i,0);
		}
		
	}
	private static void heapify(int[] arr, int N, int i) {
		// TODO Auto-generated method stub
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if( l < N && arr[l] > arr[largest])
			largest = l;
		
		if( r < N && arr[r] > arr[largest])
			largest = r;
		
		if( largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr,N,largest);
		}
		
	}
	public static void printArr(int[] arr){		 
		for(int i =0; i< arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {13,12,14,6,7,8};
		
		heapSort(arr);
		System.out.println("\n Sorted Array is:");
		printArr(arr);
	}

}