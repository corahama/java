package parcial_2;


public class CheckTreeBalanceI {
    Node root;

    // Check height balance
    boolean checkBalance(Node root, Height height) {
        // Check for emptiness
        if (root == null) {
            height.height = 0;
            return true;
        }

        Height leftHeighteight = new Height(), rightHeighteight = new Height();
        if (checkBalance(root.left, leftHeighteight) && checkBalance(root.right, rightHeighteight)) {
            int leftHeight = leftHeighteight.height, rightHeight = rightHeighteight.height;

            if ((leftHeight-rightHeight > 1) || (rightHeight-leftHeight > 1))
                return false;
            else
                height.height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
                return true;

        } else
            return false;
    }

    public static void main(String[] args) {
        Height height = new Height();

        CheckTreeBalanceI tree = new CheckTreeBalanceI();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(6);

        if (tree.checkBalance(tree.root, height))
            System.out.println("The tree is balanced");
        else
            System.out.println("The tree is not balanced");
    }

}


class Height {
    int height = 0;
}