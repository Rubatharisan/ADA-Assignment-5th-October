/**
 * Created by rubatharisan on 18/10/2016.
 */
import java.util.*;

public class Tree {
    // Define property root.
    Node root;

    // Construct with a root - and set instance root.
    Tree(Node root){
        this.root = root;
    }

    // Get instance root.
    public Node getRoot(){
        return this.root;
    }

    // BST insertion.
    public static Node insertBST(Node root, int value)
    {
        // If node is null, set a new node with value.
        if(root == null){
            root = new Node(value);
        }
        else {
            // If value is lesser than the current nodes data, then go left child -- else go right child.
            if(root.data > value){
                root.left = insertBST(root.left, value);
            } else {
                root.right = insertBST(root.right, value);
            }
        }

        // Return our node.
        return root;

    }

    // BT insertion
    public Node insertBT(int value)
    {
        // Create a queue.
        Queue<Node> queue = new LinkedList<Node>();

        // Add our root to the queue.
        queue.add(getRoot());

        // Until the queue is empty.
        while(!queue.isEmpty()){

            // Get a node out and check it.
            Node tmpNode = queue.poll();

            // Check if left child is null - if it is, insert a new node with the value.
            if(tmpNode.left == null){

                // Print out current node's data.
                System.out.println("Parent: " + tmpNode.getData());

                // Create a new node with the value.
                tmpNode.left = new Node(value);

                // Print out our data.
                System.out.println("L: " + value);

                // Return our root - with the newly added left child.
                return getRoot();

            }
            // Check if right child is null - if it is, insert a new node with the value.
            else if(tmpNode.right == null){

                // Print out current node's data.
                System.out.println("Parent: " + tmpNode.getData());

                // Create a new node with the value.
                tmpNode.right = new Node(value);

                // Print out our data.
                System.out.println("R: " + value);

                // Return our root - with the newly added right child.
                return getRoot();

            } else {

                // If left child exists, add it to our queue.
                queue.add(tmpNode.left);

                // If right child exists, add it to our queue.
                queue.add(tmpNode.right);
            }
        }

        // Return our root - with our newly added data
        return getRoot();

    }

    public static void postOrder(Node root) {

        // Check if node is empty.
        if(root != null){

            // If left child is not null, recursively call postOrder with current nodes left child.
            if(root.left != null){
                postOrder(root.left);
            }

            // If right child is not null, recursively call postOrder with current nodes right child.
            if(root.right != null){
                postOrder(root.right);
            }

            // Print out our node data.
            System.out.print(root.data + " ");
        }
    }

    public static void preOrder(Node root) {

        // Check if node is empty.
        if(root != null){

            // Print out our node data.
            System.out.print(root.data + " ");

            // If left child is not null, recursively call preOrder with current nodes left child.
            if(root.left != null){
                preOrder(root.left);
            }

            // If right child is not null, recursively call preOrder with current nodes right child.
            if(root.right != null){
                preOrder(root.right);
            }
        }
    }

    public static void inOrder(Node root) {

        // Check if node is null
        if(root != null){

            // Recursively call inOrder again with the nodes left child.
            inOrder(root.left);

            // Print out our node data.
            System.out.print(root.data + " ");

            // Recursively call inOrder again with the nodes right child.
            inOrder(root.right);
        }

    }

    public static void levelOrder(Node root)
    {
        // Create our queue.
        Queue<Node> queue = new LinkedList<Node>();

        // Add our node to the queue.
        queue.add(root);

        // Run while loop until no more nodes is in the queue.
        while(!queue.isEmpty()){

            // Poll our node out of the queue.
            Node tmpNode = queue.poll();

            // Print out our node data.
            System.out.print(tmpNode.data + " ");

            // If our nodes left child is not null, add it to the queue.
            if(tmpNode.left != null){
                queue.add(tmpNode.left);
            }

            // If our nodes right child is not null, add it to the queue.
            if(tmpNode.right != null){
                queue.add(tmpNode.right);
            }
        }
    }

    public static void countNodes(Node root)
    {
        // Create our queue.
        Queue<Node> queue = new LinkedList<Node>();

        // Initiate our counter variable.
        int i = 0;

        // Add our root node to the queue.
        queue.add(root);

        // Run while loop until no more nodes in the queue.
        while(!queue.isEmpty()){

            // Increment our counter variable.
            i++;

            // Poll out a node from the queue.
            Node tmpNode = queue.poll();

            // Check if left child of our node is null, if not - add it to our queue.
            if(tmpNode.left != null){
                queue.add(tmpNode.left);
            }

            // Check if right child of our node is null, if not - add it to our queue.
            if(tmpNode.right != null){
                queue.add(tmpNode.right);
            }
        }

        // When we out of the while loop, lets print out our amount of nodes.
        System.out.print(i);
    }

    public static void countLeaves(Node root)
    {
        // Create our queue.
        Queue<Node> queue = new LinkedList<Node>();

        // Initiate our counter variable.
        int i = 0;

        // Add our root to the queue.
        queue.add(root);

        // Run while loop until no more nodes in the queue.
        while(!queue.isEmpty()){

            // Poll a node out of the queue.
            Node tmpNode = queue.poll();

            // If our polled out node have no children, increment our counter.
            if(tmpNode.left == null && tmpNode.right == null) {
                i++;
            }

            // If left child of the current node exists, add it to the queue.
            if(tmpNode.left != null){
                queue.add(tmpNode.left);
            }

            // If right child of the current node exists, add it to the queue.
            if(tmpNode.right != null){
                queue.add(tmpNode.right);
            }


        }

        // Print out the amount of leaves in our tree.
        System.out.print(i);
    }

    public static void countFullNodes(Node root)
    {
        // Create our queue.
        Queue<Node> queue = new LinkedList<Node>();

        // Initiate our counter variable.
        int i = 0;

        // Add our root to the queue.
        queue.add(root);

        // Run while loop until no more nodes in the queue.
        while(!queue.isEmpty()){

            // Poll out a node from the queue.
            Node tmpNode = queue.poll();

            // Increment our counter if the current node have both children.
            if(tmpNode.left != null && tmpNode.right != null) {
                i++;
            }

            // If we have a left child - add left child to the queue.
            if(tmpNode.left != null){
                queue.add(tmpNode.left);
            }

            // If we have a right child - add right child to the queue.
            if(tmpNode.right != null){
                queue.add(tmpNode.right);
            }


        }

        // Print out our amount of full nodes.
        System.out.print(i);
    }
}
