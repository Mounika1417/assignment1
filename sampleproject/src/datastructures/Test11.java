package datastructures;

//Single Linked List
class LinkedList{
	//head of list
	Node head;
	
	//Linked List Node
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	//Method to insert new node
	public static LinkedList insert(LinkedList list,int data){
		//creating a new node with given data
		Node new_node = new Node(data);
		//if list is empty then we make new node as head
		if(list.head == null) {
			list.head = new_node;
		} else {
			//traverse till last node and insert new node
			Node last = list.head;
			while(last.next != null) {
				last = last.next;
			}
			//insert new_node at last node
			last.next = new_node;			
		}
		//return the list by head
		return list;
	}
	//print the LinkedList
	public static void printList(LinkedList list) {
		Node currNode = list.head;
		System.out.println("LinkedList: ");
		//traversing through out the list
		while( currNode != null) {
			//printing current node
			System.out.print(currNode.data + " ");
			//goto next node
			currNode = currNode.next;
		}
	}
}
public class Test11 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//starts with empty list
		LinkedList list = new LinkedList();
		//inserting values
		list = list.insert(list,10);
		list = list.insert(list,20);
		list = list.insert(list,30);
		list = list.insert(list,40);
		list = list.insert(list,50);
		list = list.insert(list,60);
		list = list.insert(list,70);
		list = list.insert(list,80);
		list = list.insert(list,90);
		list = list.insert(list,100);
		//printing the LinkList
		list.printList(list);		
	}
}