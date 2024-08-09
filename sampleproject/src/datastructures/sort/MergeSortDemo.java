package datastructures.sort;

public class MergeSortDemo {

	static void merge(int arr[],int l,int m,int r) {
		//find size of two sub arrays
		int n1 = m - l + 1;
		int n2 = r - m;
		//create temp arrays
		int L[] = new int[n1];
		int R[] = new int[n2];
		//copy data to temp arrays
		for(int i = 0; i< n1; ++i)
			L[i] = arr[l + i];
		for(int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 +j];
		//merge temp arrays
		//initial indices for 1st and 2nd sub arrays
		int i = 0, j = 0;
		//initial index of merged sub array
		int k = l;
		while( i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		//copy remaining elements of L[] if any
		while( i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		//copy remaining elements of R[] if any
		while( j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		
	}
	//merge()
	static void sort(int arr[],int l,int r) {
		if(l < r){
			//find middle index
			int m = l + ( r - l) /2;
			sort(arr,l,m);
			sort(arr,m+1,r);
			merge(arr,l,m,r);
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
		int arr[] = {12,11,13,5,6,7};
		System.out.println("Array is: ");
		printArr(arr);
		
		sort(arr,0,arr.length - 1);
		System.out.println("\n Sorted Array is:");
		printArr(arr);
	}

}
