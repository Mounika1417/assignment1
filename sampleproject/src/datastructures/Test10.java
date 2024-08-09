package datastructures;
import java.util.Iterator;
import java.util.LinkedList;

public class Test10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("Robin");
		ll.add("Vincent");
		ll.add("Robert");
		ll.add("Alex");
		
		Iterator<String> itr = ll.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}

