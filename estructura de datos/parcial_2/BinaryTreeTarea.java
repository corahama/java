package parcial_2;

public class BinaryTreeTarea {
    public static void main(String[] args) {
        BinaryTree1 tree = new BinaryTree1();

        //Crear su propio árbol binario
        tree.root = new NodeStr1("uno");
        tree.root.left = new NodeStr1("dos");
        tree.root.right = new NodeStr1("tres");

        tree.root.left.left = new NodeStr1("cuatro");
        tree.root.left.right = new NodeStr1("cinco");

        tree.root.right.left = new NodeStr1("seis");
        tree.root.right.right = new NodeStr1("siete");

        //Probar los 3 recorridos
        System.out.print("Recorrido inorder: ");
        tree.inorder();
        // cuatro, dos, cinco, uno, seis, tres, siente
        System.out.println();

        System.out.print("Recorrido preorder: ");
        tree.preorder();
        // uno, dos, cuatro, cinco, tres, seis, siete
        System.out.println();

        System.out.print("Recorrido postorder: ");
        tree.postorder();
        // cuatro, cinco, dos, seis, siete, tres, uno
        System.out.println();

        //Probar las tres búsquedas
        NodeStr1 result1 = tree.searchInorder("siete");
        System.out.println(result1 != null ? result1.data : "No se encontro el nodo");

        NodeStr1 result2 = tree.searchPreorder("seis");
        System.out.println(result2 != null ? result2.data : "No se encontro el nodo");

        NodeStr1 result3 = tree.searchPostorder("ocho");
        System.out.println(result3 != null ? result3.data : "No se encontro el nodo");
    }

}


class BinaryTree1 {
    NodeStr1 root;

    BinaryTree1() {
        root = null;
    }

    // Inorder Search
    public NodeStr1 searchInorder(String data) {
        return searchInorderRec(root, data);
    }
    public NodeStr1 searchInorderRec(NodeStr1 root, String data) {
        if (root == null)
            return root;

        NodeStr1 leftSearch = searchInorderRec(root.left, data);
        if (leftSearch != null)
            return leftSearch;

        if (data.equals(root.data))
            return root;

        return searchInorderRec(root.right, data);
    }

    // Preorder Search
    public NodeStr1 searchPreorder(String data) {
        return searchPreorderRec(root, data);
    }
    public NodeStr1 searchPreorderRec(NodeStr1 root, String data) {
        if (root == null)
            return root;

        if (data.equals(root.data))
            return root;

        NodeStr1 leftSearch = searchPreorderRec(root.left, data);
        if (leftSearch != null)
            return leftSearch;
        
        return searchPreorderRec(root.right, data);
    }

    // Postorder Search
    public NodeStr1 searchPostorder(String data) {
        return searchPostorderRec(root, data);
    }
    public NodeStr1 searchPostorderRec(NodeStr1 root, String data) {
        if (root == null)
            return root;

        NodeStr1 leftSearch = searchPostorderRec(root.left, data);
        if (leftSearch != null)
            return leftSearch;
            
        NodeStr1 rightSearch = searchPostorderRec(root.right, data);
        if (rightSearch != null)
            return rightSearch;

        if (data.equals(root.data))
            return root;
        else
            return null;
    }

    // Inorder traverse
    public void inorder() {
        inorderRec(root);
    }
    public void inorderRec(NodeStr1 root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traverse
    public void preorder() {
        preorderRec(root);
    }
    public void preorderRec(NodeStr1 root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traverse
    public void postorder() {
        postorderRec(root);
    }
    public void postorderRec(NodeStr1 root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

}


class NodeStr1 {
    String data;
    NodeStr1 left, right;

    NodeStr1(String data) {
        this.data = data;
    }
}