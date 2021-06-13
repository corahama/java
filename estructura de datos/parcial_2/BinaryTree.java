package parcial_2;

public class BinaryTree {
    NodeStr root;

    BinaryTree() {
        root = null;
    }

    public NodeStr search(String data) {
        return searchRec(root, data);
    }
    public NodeStr searchRec(NodeStr root, String data) {
        if (root == null)
            return root;

        if (data.equals(root.data))
            return root;

        NodeStr leftSearch = searchRec(root.left, data);
        if (leftSearch != null)
            return leftSearch;
        
        return searchRec(root.right, data);
    }

    public void inorder() {
        inorderRec(root);
    }
    public void inorderRec(NodeStr root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
 
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new NodeStr("uno");
        tree.root.left = new NodeStr("dos");
        tree.root.right = new NodeStr("tres");

        tree.root.left.left = new NodeStr("cuatro");
        tree.root.left.right = new NodeStr("cinco");

        tree.root.right.left = new NodeStr("seis");
        tree.root.right.right = new NodeStr("siete");

        // cuatro, dos, cinco, uno, seis, tres, siete
        tree.inorder();
        System.out.println();

        NodeStr result = tree.search("siete");
        System.out.println(result != null ? result.data : "No se encontro el nodo");
    }

}


class NodeStr {
    String data;
    NodeStr left, right;

    NodeStr(String data) {
        this.data = data;
    }
}
