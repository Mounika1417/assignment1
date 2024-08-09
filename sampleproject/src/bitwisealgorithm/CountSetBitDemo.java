package bitwisealgorithm;

public class CountSetBitDemo {
	
	
	static int countTotalSetBits(int n) {
		int count = 0;
		for(int i =0; i< 32; i++) {
			int blocksize =1 <<(i +1);
			int fullBlocks = (n+1)/blocksize;
			count +=fullBlocks *(blocksize/2);
			
			int remainder = (n+1)% blocksize;
			if(remainder > blocksize/2) {
				count+= remainder-(blocksize/2);
				
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=7;
		int totalSetBits = countTotalSetBits(n);
		System.out.println("Total set bits from 1 to"+ n +":"+ totalSetBits);
		

	}

}