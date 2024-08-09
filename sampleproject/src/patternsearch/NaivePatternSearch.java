package patternsearch;

public class NaivePatternSearch {
	//ABAAABCD   ABC
		static void search(String text,String pattern) {
			int n = text.length();
			int m = pattern.length();
			
			for(int i = 0; i <= n - m; i++) {
				int j;
				
				for(j = 0; j < m; j++) {
					if(text.charAt(i + j) != pattern.charAt(j)) {
						break;
					}
				}
				if( j == m) {
					System.out.println("Pattern found at index " + i);
				}
			}
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String text = "ABAAABCD";
			String pattern = "ABC";
			search(text,pattern);
			
		}

	}