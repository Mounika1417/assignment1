package patternsearch;

public class RabinKarpAlgorithm {
	private final int d = 256;	
	private final int q = 101;
	
	 void search(String pattern,String text) {
		int m = pattern.length();
		int n = text.length();
		int p =0; //hash value for pattern
		int t = 0;//hash value for text
		int h = 1;
		
		//value of h would be "pow(d,m-1)%q"
		for(int i =0; i < m - 1; i++) {
			h = ( h * d) % q;
		}
		
		//calculate the hash value of pattern and first window of text
		for(int i = 0; i < m; i++) {
			p = ( d * p + pattern.charAt(i)) % q;
			t = (d * t + text.charAt(i)) % q;
		}
		
		//slide the pattern over text one by one
		for(int i = 0; i <=n-m; i++) {
			//check the hash values of current window of text and pattern.
			if ( p == t) {
				boolean match = true;
				for(int j= 0; j < m; j++) {
				if( text.charAt(i + j) != pattern.charAt(j)) {
					match = false;
					break;
				}
				}
				
				if(match) {
					System.out.println("Pattern found at index " + i);
				}
			}
			//calculate hash value for next window of text
			if(i < n-m) {
				t = ( d * (t - text.charAt(i) * h ) + text.charAt(i + m)) % q; 
				//we may get negative value of t, converting it to positive
				if(t < 0) {
					t = ( t + q);
				}
			}
		}		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "ABBCCDDAEFG";
		String pattern = "CDD";
		RabinKarpAlgorithm obj = new RabinKarpAlgorithm();
		obj.search(pattern,text);		
	}
}