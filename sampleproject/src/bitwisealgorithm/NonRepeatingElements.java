package bitwisealgorithm;

public class NonRepeatingElements {
	
	public static void findNonRepeating(int[] arr) {
		int xor = 0;
		//step1: XOR all elements 
		for(int num: arr) {
			xor ^= num;
		}
		//step2: find  setbit in xor
		int setBit = xor & -xor;
		int x = 0, y = 0;
		
		// divide elements into two group and XOR each group
		for(int num: arr) {
			if((num & setBit) == 0) {
				x ^= num;
			}else {
				y ^= num;
			}
		}
		System.out.println("The non repeating elements are: " + x + " and " + y);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,1,2,1,2,3,4,5};
		findNonRepeating(arr);
	}

}