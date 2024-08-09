package datastructures;

public class Test5 {

	 public static void addition(int[] arr){
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		
		System.out.println("Sum of Array values:" + sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,20,30,40,50};
		addition(arr);
	}

}