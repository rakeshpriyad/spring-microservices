package com.test.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;

class SumofAllNodeAtKthlevel {


    // Function to return the sum of all
// the nodes at Kth level using 
// level order traversal 
    static int sumOfNodesAtNthLevel(Node root,
                                    int k) {

        // If the current node is null
        if (root == null)
            return 0;

        // Create Queue
        Queue<Node> que = new LinkedList<>();

        // Enqueue the root node
        que.add(root);

        // Level is used to track
        // the current level
        int level = 0;

        // To store the sum of nodes
        // at the Kth level
        int sum = 0;

        // flag is used to break out of
        // the loop after the sum of all
        // the nodes at Nth level is found
        int flag = 0;

        // Iterate the queue till its not empty
        while (!que.isEmpty()) {

            // Calculate the number of nodes
            // in the current level
            int size = que.size();

            // Process each node of the current
            // level and enqueue their left
            // and right child to the queue
            while (size-- > 0) {
                Node ptr = que.peek();
                que.remove();

                // If the current level matches the
                // required level then calculate the
                // sum of all the nodes at that level
                if (level == k) {

                    // Flag initialized to 1
                    // indicates that sum of the
                    // required level is calculated
                    flag = 1;

                    // Calculating the sum of the nodes
                    sum += ptr.data;
                } else {

                    // Traverse to the left child
                    if (ptr.left != null)
                        que.add(ptr.left);

                    // Traverse to the right child
                    if (ptr.right != null)
                        que.add(ptr.right);
                }
            }

            // Increment the variable level
            // by 1 for each level
            level++;

            // Break out from the loop after the sum
            // of nodes at K level is found
            if (flag == 1)
                break;
        }
        return sum;
    }

    // Driver code
    public static void main(String[] args) {
        Node root = null;

        // Tree Construction
        root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        int level = 2;
        int result = sumOfNodesAtNthLevel(root, level);

        // Printing the result
        System.out.print(result);
    }
}

// This code is contributed by 29AjayKumar 