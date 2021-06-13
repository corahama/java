package parcial_2;

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }
    public Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data >= root.data)
            root.right = insertRec(root.right, data);
        else
            root.left = insertRec(root.left, data);

        return root;
    }

    public Node search(int data) {
        return searchRec(root, data);
    }
    public Node searchRec(Node root, int data) {
        if (root == null)
            return root;

        if (data > root.data)
            return searchRec(root.right, data);
        else if (data < root.data)
            return searchRec(root.left, data);
        
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }
    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);

        tree.inorder();

        System.out.println();
        Node result = tree.search(14);
        System.out.println((result != null) ? result.data : "No se encontro el nodo");
    }
}
