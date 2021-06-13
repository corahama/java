package parcial_2;

public class BinarySearchTreeI {
    Node root;

    BinarySearchTreeI() {
        root = null;
    }

    void insert(int data) {
        root = insertElmn(root, data);
    }

    // Insert an element in the tree
    Node insertElmn(Node root, int data) {
        // Return a new node if the tree is empty
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Traverse to the right place and insert the node
        if (data < root.data)
            root.left = insertElmn(root.left, data);
        else if (data > root.data)
            root.right = insertElmn(root.right, data);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    // Inorder Traversal
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " -> ");
            inorderRec(root.right);
        }
    }

    void deleteElmn(int data) {
        root = deleteRec(root, data);
    }

    Node deleteRec(Node root, int data) {
        // Return if the tree is empty
        if (root == null)
            return root;

        // Find the node to be deleted
        if (data < root.data)
            root.left = deleteRec(root.left, data);
        else if (data > root.data)
            root.right = deleteRec(root.right, data);
        else {
            // If the node is eith only one child or no child 
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // If the node has two children
            // Place the inorder successor in position of the of the node to be delete
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Find the inorder successor
    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        BinarySearchTreeI tree = new BinarySearchTreeI();

        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);

        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.println("\n\nAfter deleting 10");
        tree.deleteElmn(10);
        System.out.print("Inorder traversal: ");
        tree.inorder();
    }
}
