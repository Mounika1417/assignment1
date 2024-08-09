package datastructures.nonlinear;

import java.util.ArrayList;
import java.util.List;

//Tree DataStructure Implementation
class TreeNode{
	private Product product;
	private List<TreeNode> chidren;
	
	public TreeNode(Product product) {
		super();
		this.product = product;
		this.chidren = new ArrayList<>();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<TreeNode> getChidren() {
		return chidren;
	}

	public void setChidren(List<TreeNode> chidren) {
		this.chidren = chidren;
	}
	
	public void addChild(TreeNode child){
		this.chidren.add(child);
	}

	@Override
	public String toString() {
		return "TreeNode [product=" + product + ", chidren=" + chidren + "]";
	}
}
public class Test13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p1 = new Product("Laptop", 75000);
		Product p2 = new Product("Desktop", 50000);
		Product p3 = new Product("Tab", 15000);
		
		TreeNode root = new TreeNode(p1);
		TreeNode node1 = new TreeNode(p2);
		TreeNode node2 = new TreeNode(p3);
		
		root.addChild(node1);
		root.addChild(node2);
		
		System.out.print(root);
	}
}
