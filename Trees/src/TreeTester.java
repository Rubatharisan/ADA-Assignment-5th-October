/**
 * Created by rubatharisan on 27/10/2016.
 */
public class TreeTester {
    public static void main(String[] args){

        // Create a new node - with a data value.
        Node nodeRoot = new Node(100);

        // Create a tree - with our defined node above.
        Tree myTree = new Tree(nodeRoot);

        // Insert random values into the tree.
        System.out.println("Inserting values into the binary tree...");
        myTree.insertBT(10);
        myTree.insertBT(20);
        myTree.insertBT(30);
        myTree.insertBT(40);
        myTree.insertBT(50);
        myTree.insertBT(60);
        myTree.insertBT(70);

        System.out.println();
        System.out.println();

        // Do our recursive postOrder method.
        System.out.print("Post Order: ");
        myTree.postOrder(myTree.getRoot());

        System.out.println();

        // Do our recursive preOrder method.
        System.out.print("Pre Order: ");
        myTree.preOrder(myTree.getRoot());

        System.out.println();

        // Do our recursive inOrder method.
        System.out.print("In Order: ");
        myTree.inOrder(myTree.getRoot());

        System.out.println();

        // Do our while-looped levelOrder method.
        System.out.print("Level Order: ");
        myTree.levelOrder(myTree.getRoot());

        System.out.println();
        System.out.println();

        // Print out our number of nodes in the tree.
        System.out.print("Number of nodes: ");
        myTree.countNodes(myTree.getRoot());

        System.out.println();

        // Print out our number of leaves in the tree.
        System.out.print("Number of leaves: ");
        myTree.countLeaves(myTree.getRoot());

        System.out.println();

        // Print out our number of full nodes in the tree.
        System.out.print("Number of full nodes: ");
        myTree.countFullNodes(myTree.getRoot());
        System.out.println();


    }

}
