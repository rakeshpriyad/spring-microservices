package com.test.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;

class LevelOrderBinaryTree {
  
    Node root; 
  
    /* Given a binary tree. Print its nodes in level order 
     using array for implementing queue  */
    void printLevelOrder()  
    { 
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root); 
        while (!queue.isEmpty())  
        { 
  
            /* poll() removes the present head. 
            For more information on poll()
             */
            Node tempNode = queue.poll(); 
            System.out.print(tempNode.data + " "); 
  
            /*Enqueue left child */
            if (tempNode.left != null) { 
                queue.add(tempNode.left); 
            } 
  
            /*Enqueue right child */
            if (tempNode.right != null) { 
                queue.add(tempNode.right); 
            } 
        } 
    } 
  
    public static void main(String args[])  
    { 
        /* creating a binary tree and entering  
         the nodes */
        LevelOrderBinaryTree treeLevel = new LevelOrderBinaryTree();
        treeLevel.root = new Node(1);
        treeLevel.root.left = new Node(2);
        treeLevel.root.right = new Node(3);
        treeLevel.root.left.left = new Node(4);
        treeLevel.root.left.right = new Node(5);
  
        System.out.println("Level order traversal of binary tree is - "); 
        treeLevel.printLevelOrder();
    } 
} 