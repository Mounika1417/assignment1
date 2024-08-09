package datastructuresassignments;

//Node class to represent each node in the binary tree
class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;

 public TreeNode(int val) {
     this.val = val;
     this.left = null;
     this.right = null;
 }
}

//Binary Tree class to manage the tree operations
public class BinaryTree {
 private TreeNode root;

 public BinaryTree() {
     this.root = null;
 }

 // Method to insert a value into the binary tree
 public void insert(int val) {
     root = insertRecursive(root, val);
 }

 // Recursive method to insert a value into the binary tree
 private TreeNode insertRecursive(TreeNode root, int val) {
     if (root == null) {
         root = new TreeNode(val);
         return root;
     }

     // Insert recursively into left subtree if val is less than current node's value
     if (val < root.val) {
         root.left = insertRecursive(root.left, val);
     }
     // Insert recursively into right subtree if val is greater than or equal to current node's value
     else {
         root.right = insertRecursive(root.right, val);
     }

     return root;
 }

 // Method to delete a value from the binary tree
 public void delete(int val) {
     root = deleteRecursive(root, val);
 }

 // Recursive method to delete a value from the binary tree
 private TreeNode deleteRecursive(TreeNode root, int val) {
     if (root == null) {
         return null;
     }

     // Traverse the tree to find the node with the given value
     if (val < root.val) {
         root.left = deleteRecursive(root.left, val);
     } else if (val > root.val) {
         root.right = deleteRecursive(root.right, val);
     } else {
         // Node to be deleted found

         // Case 1: Node with only one child or no child
         if (root.left == null) {
             return root.right;
         } else if (root.right == null) {
             return root.left;
         }

         // Case 2: Node with two children
         // Find the inorder successor (smallest node in the right subtree)
         root.val = minValue(root.right);

         // Delete the inorder successor
         root.right = deleteRecursive(root.right, root.val);
     }

     return root;
 }

 // Method to find the minimum value in a subtree (used for deleting node with two children)
 private int minValue(TreeNode root) {
     int minValue = root.val;
     while (root.left != null) {
         minValue = root.left.val;
         root = root.left;
     }
     return minValue;
 }

 // Method to perform inorder traversal of the binary tree
 public void inorder() {
     inorderRecursive(root);
     System.out.println();
 }

 // Recursive method to perform inorder traversal of the binary tree
 private void inorderRecursive(TreeNode root) {
     if (root != null) {
         inorderRecursive(root.left);
         System.out.print(root.val + " ");
         inorderRecursive(root.right);
     }
 }

 // Method to perform preorder traversal of the binary tree
 public void preorder() {
     preorderRecursive(root);
     System.out.println();
 }

 // Recursive method to perform preorder traversal of the binary tree
 private void preorderRecursive(TreeNode root) {
     if (root != null) {
         System.out.print(root.val + " ");
         preorderRecursive(root.left);
         preorderRecursive(root.right);
     }
 }

 // Method to perform postorder traversal of the binary tree
 public void postorder() {
     postorderRecursive(root);
     System.out.println();
 }

 // Recursive method to perform postorder traversal of the binary tree
 private void postorderRecursive(TreeNode root) {
     if (root != null) {
         postorderRecursive(root.left);
         postorderRecursive(root.right);
         System.out.print(root.val + " ");
     }
 }

 public static void main(String[] args) {
     BinaryTree tree = new BinaryTree();
     tree.insert(50);
     tree.insert(30);
     tree.insert(20);
     tree.insert(40);
     tree.insert(70);
     tree.insert(60);
     tree.insert(80);

     System.out.println("Inorder traversal:");
     tree.inorder(); // Output: 20 30 40 50 60 70 80

     System.out.println("Preorder traversal:");
     tree.preorder(); // Output: 50 30 20 40 70 60 80

     System.out.println("Postorder traversal:");
     tree.postorder(); // Output: 20 40 30 60 80 70 50

     tree.delete(30);
     System.out.println("Inorder traversal after deleting 30:");
     tree.inorder(); // Output: 20 40 50 60 70 80
 }
}
