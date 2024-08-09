package datastructures.nonlinear;

import java.util.LinkedList;

class HashTable{
	private class HashNode{
		Product key;
		String value;
		HashNode next;
		
			public HashNode(Product key, String value) {
				super();
				this.key = key;
				this.value = value;
			}
		}
		private LinkedList<HashNode>[] buckets;
		private int capacity;
		private int size;
		
		public HashTable() {
			this.capacity = 10;
			this.buckets = new LinkedList[capacity];
			this.size = 0;
		}
		
		private int getBucketIndex(Product key){
			int hashCode = key.hashCode();
			int index = hashCode % capacity;
			return Math.abs(index);
		}
		
		//Add key value pair to hash table
		public void put(Product key,String value) {
			int bucketIndex = getBucketIndex(key);
			LinkedList<HashNode> bucket = buckets[bucketIndex];
			if(bucket == null) {
				bucket = new LinkedList<>();
				buckets[bucketIndex] = bucket;
			}
			for( HashNode node : bucket) {
				if(node.key.equals(key)) {
					node.value = value;
					return;
				}
			}
			HashNode newNode = new HashNode(key, value);
			bucket.add(newNode);
			size++;
			//resize the hash table if the load factor exceeds 0.7
			if((1.0 * size)/capacity >= 0.7) {
				resize();
			}
		}

		public String get(Product key) {
			int bucketIndex = getBucketIndex(key);
			LinkedList<HashNode> bucket = buckets[bucketIndex];
			if(bucket == null) 
				return null;
			
			for(HashNode node : bucket) {
				if(node.key.equals(key)) {
					return node.value;
				}
			}
			return null;
		}
		
		private void resize() {
			// TODO Auto-generated method stub
			LinkedList<HashNode>[] oldBuckets = buckets;
			capacity *= 2;
			buckets = new LinkedList[capacity];
			size = 0;
			
			for(LinkedList<HashNode> bucket : oldBuckets) {
				if(bucket != null) {
					for( HashNode node : bucket) {
						put(node.key,node.value);
					}
				}
			}
		}		
		//get the size of hash table
		public int size() {
			return size;
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
	}



public class Test16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable hashTable = new HashTable();
		Product p1 = new Product("Laptop", 100000);
		Product p2 = new Product("Desktop", 50000);
		Product p3 = new Product("Tab", 25000);
		
		hashTable.put(p1,"Product1 details");
		hashTable.put(p2,"Product2 details");
		hashTable.put(p3,"Product3 details");
		
		System.out.println("Size: " + hashTable.size());
		System.out.println("Product1 Details: " + hashTable.get(p1));
		System.out.println("Product2 Details: " + hashTable.get(p2));
		System.out.println("Product3 Details: " + hashTable.get(p3));
	}

}