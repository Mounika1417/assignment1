package bitwisealgorithm;

public class CountSetBits {

	public static int countSetBits(int n) {
		int count = 0;
		while(n > 0) {
			n &= (n -1);
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 29;
		System.out.println("Number of set bits in " + n + " is: " + countSetBits(n));
	}
}