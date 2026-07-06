package com.kk.tree;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

public class MaximumDepthBinaryTree {
    Node root;

    public static void main(String[] args) {

        MaximumDepthBinaryTree tree = new MaximumDepthBinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Height of tree is " + tree.maxDepth(tree.root));
    }

    private int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return lDepth > rDepth ? ++lDepth : ++rDepth;
    }
}
