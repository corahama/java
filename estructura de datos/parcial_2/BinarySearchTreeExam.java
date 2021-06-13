package parcial_2;

public class BinarySearchTreeExam {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTreeExam() {
        root = null;
    }

    void insert(int data) {
        root = insertElmn(root, data);
    }

    // Inserta un nuevo nodo en el arbol
    Node insertElmn(Node root, int data) {
        // Regresa el nodo nuevo si la raíz ingresada esta vacia
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Encontramos el lugar correspondiente para insertar el nuevo nodo
        if (data < root.data)
            root.left = insertElmn(root.left, data);
        else if (data > root.data)
            root.right = insertElmn(root.right, data);

        return root;
    }

    void travHigLow() {
        travHigLowRec(root);
    }

    // Recorrido de mayor a menor
    public void travHigLowRec(Node node) {
        if (node != null) {
            travHigLowRec(node.right);
            System.out.print(" " + node.data);
            travHigLowRec(node.left);
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeExam tree = new BinarySearchTreeExam();

        tree.insert(7);
        tree.insert(6);
        tree.insert(10);
        tree.insert(65);
        tree.insert(43);
        tree.insert(12);
        tree.insert(78);
        tree.insert(5);
        tree.insert(2);

        System.out.print("Recorrido de mayor a menor: ");
        tree.travHigLow();
    }
}
