package datastructures.search;

public class JumpSearchDemo {

	static int jumpSearch(int[] arr, int x) {
		int n = arr.length;
		int step = (int) Math.floor(Math.sqrt(n));
		int prev = 0;
		
		System.out.println("Array length is: " + n);
		System.out.println("Step value is: " + step);
		
		for(int minStep = Math.min(step, n)-1; 
				arr[minStep] < x; 
				minStep = Math.min(step, n)-1) {
			
			prev = step;
			System.out.println("Prev is: " + prev);
			step += (int)Math.floor(Math.sqrt(Math.sqrt(n)));
			System.out.println("Step is: " + step);
			
			if(prev >= n) {
				System.out.println("Prev is :" + prev + " and n is : " + n);
				return -1;
			}
			System.out.println("-------------------");
				
		}
		
		while(arr[prev] < x) {
			prev++;
			System.out.println("with in while prev is : " + prev);
			if(prev == Math.min(step, n))
				System.out.println("with in while - if : " + prev);
				return -1;
		}
		
		if(arr[prev] == x) {
			System.out.println("If equals :" + prev);
			return prev;
		}			
		
		
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610};
		int x = 55;
		int result = jumpSearch(arr, x);
		System.out.println("\n Number : " + x + " is at index : " + result);
	}

}
