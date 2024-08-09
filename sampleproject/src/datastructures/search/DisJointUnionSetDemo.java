package datastructures.search;


	public class DisJointUnionSetDemo {

		int parent[],rank[];
		int n;
		//constructor
		public DisJointUnionSetDemo(int n) {
			// TODO Auto-generated constructor stub
			rank = new int[n];
			parent = new int[n];
			this.n = n;
			makeSet();
		}
		
		//creates n sets with single item in each
		 void makeSet() {
			// TODO Auto-generated method stub
			for(int i = 0; i < n; i++) {
				//All elements are in their own set
				parent[i] = i;
			}
		 }

		//Return representative of x's set
		int find(int x) {
			//finds the representative of the set
			//that x ia an element of
			if(parent[x] != x) {
				//if x is not the parent of itself
				//then x is not the representative of own set
				parent[x] = find(parent[x]);
			}
			return parent[x];
			//we recursively call Find on its parent
			//and move i's node directly under the
			//representation of this set
		}
		
		//unites the set that includes x and the set that includes x
		void union(int x, int y) {
			//find representatives of two sets
			int xRoot = find(x),yRoot = find(y);
			//elements are in the same set, no need to unite
			if(xRoot == yRoot)
				return;
			//if x's rank is less than y's rank
			if(rank[xRoot] < rank[yRoot])
				//move x under y so that depth of tree remains less
				parent[xRoot] = yRoot;
			//else if y's rank is less than x's rank
			else if(rank[yRoot] < rank[xRoot])
				//move y under x 
				parent[yRoot] = xRoot;
			else {
				//move y under x 
				parent[yRoot] = xRoot;
				//increment result tree rank by 1
				rank[xRoot] = rank[xRoot] + 1;
			}
		}
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int n = 5;
			DisJointUnionSetDemo obj = new DisJointUnionSetDemo(n);
			obj.union(0, 2);
			obj.union(4, 2);
			obj.union(3, 1);
			
			if(obj.find(4) == obj.find(0)) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
			
			if(obj.find(1) == obj.find(0)) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}	
			
				
		}
	}