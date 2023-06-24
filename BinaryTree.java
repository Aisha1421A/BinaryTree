

package tree_template;


public class BinaryTree {

    private class Node {

        private int element;
        private Node left;
        private Node right;

        public Node(int e) {
            element = e;
            right = null;
            left = null;
        }
    }//----------- end of nested Node class -----------

    private Node root = null;

    public BinaryTree() {
    } // constructor constructs an initially empty tree

    public boolean isEmpty() {
        return root == null;
    }

    // return the number of nodes/elements in the tree
    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node n) {
        if (n == null) {
            return 0;
        }
        return 1 + getSizeRecursive(n.left) + getSizeRecursive(n.right);
    }

    // insert a node
    public void addNode(int e) {
        root = addNodeRecursive(root, e);

    }

    private Node addNodeRecursive(Node n, int e) {

        // if the root is null, create a new node and return it
        if (n == null) {
            return new Node(e);
        }

        // if the given key is less than the root node,
        // recur for the left subtree
        if (e < n.element) {
            n.left = addNodeRecursive(n.left, e);
        } // otherwise, recur for the right subtree
        else {
            // key >= root.data
            n.right = addNodeRecursive(n.right, e);
        }

        return n;
    }

    // search for a given node, return true if it is found, false otherwise 
    public boolean searchNode(int e) {
        return searchNodeRecursive(root, e);
    }

    private boolean searchNodeRecursive(Node n, int e) {
        if (n == null) {
            return false;
        }
        if (n.element > e) {
            return searchNodeRecursive(n.left, e);
        } else if (n.element < e) {
            return searchNodeRecursive(n.right, e);
        } else {
            return true;
        }
    }

    //delete a node
    public void deleteNode(int e) {
        root = deleteNodeRecursive(root, e);
    }

    private Node deleteNodeRecursive(Node current, int e) {
        if (current == null) {
            return current;
        }
        if (current.element > e) {
            current.left = deleteNodeRecursive(current.left, e);
        } else if (current.element < e) {
            current.right = deleteNodeRecursive(current.right, e);
        } else {
            // node with only one child or no child
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            current.element = minvalue(current.right);

            // Delete the inorder successor
            current.right = deleteNodeRecursive(current.right, current.element);
        }

        return current;
    }

    //finds the smallest value starting from the subtree rooted at Node n.
    private int minvalue(Node n) {
        if (n.left == null) {
            return n.element;
        } else {
            return minvalue(n.left);
        }
    }

    // in-order traversal
    public void print() {
        print(root);
    }

    private void print(Node n) {
        if (n.left != null) {
            print(n.left);
        }
        System.out.println(" " + n.element);
        if (n.right != null) {
            print(n.right);
        }

    }


 

    // our visit is printing the nodes stored values
    private void visit(int value) {
        System.out.print(" " + value);
    }

}
