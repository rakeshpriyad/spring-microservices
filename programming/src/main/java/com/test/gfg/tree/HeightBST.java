package com.test.gfg.tree;

/*
Thanks to LJW489 for suggesting this method.
1) Do In-Order Traversal of the given tree and store the result in a temp array.
3) Check if the temp array is sorted in ascending order, if it is, then the tree is BST.

Time Complexity: O(n)

We can avoid the use of Auxiliary Array. While doing In-Order traversal, we can keep track of previously visited node. If the value of the currently visited node is less than the previous value, then tree is not BST. Thanks to ygos for this space optimization.
 */
public class HeightBST {
    // Root of the Binary Tree 
    Node root;

    // To keep tract of previous node in Inorder Traversal 
    Node prev;



    /* Returns true if given search tree is binary 
       search tree (efficient version) */
    int height(Node node) {

        if (node == null) {
            return 0;
        }

        int lheight = height(node.left);
        int rheight = height(node.right);

        return Math.max(lheight,rheight) +1;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        HeightBST tree = new HeightBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

            System.out.println("Tree height: " + tree.height(tree.root));
    }
} 
/*
Note of empty tree is zero
            4
        /       \
        2       5
      /  \
     1    3
 */