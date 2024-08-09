package datastructures.nonlinear.visualize;

import javax.swing.*;
import java.awt.*;

class Node {
    int value;
    Node left, right;

    public Node(int item) {
        value = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    // Method to insert values in the tree
    void insert(int value) {
        root = insertRec(root, value);
    }

    // A recursive function to insert a new value in the binary tree
    Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }
}

class BinaryTreePanel extends JPanel {
    private final BinaryTree tree;

    public BinaryTreePanel(BinaryTree tree) {
        this.tree = tree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (tree.root != null) {
            drawTree(g, tree.root, getWidth() / 2, 30, getWidth() / 4);
        }
    }

    private void drawTree(Graphics g, Node root, int x, int y, int xOffset) {
        g.setColor(Color.BLACK);
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(root.value), x - 5, y + 5);

        if (root.left != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x - 5, y + 5, x - xOffset + 5, y + 50 - 5);
            drawTree(g, root.left, x - xOffset, y + 50, xOffset / 2);
        }
        if (root.right != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x + 5, y + 5, x + xOffset - 5, y + 50 - 5);
            drawTree(g, root.right, x + xOffset, y + 50, xOffset / 2);
        }
    }
}

public class BinaryTreeVisualizer {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /* Example input sequence: 1, 2, 3, 4, 5 */
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        JFrame frame = new JFrame("Binary Tree Visualization");
        BinaryTreePanel treePanel = new BinaryTreePanel(tree);
        frame.add(treePanel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
