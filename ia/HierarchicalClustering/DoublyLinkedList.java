package HierarchicalClustering;


public class DoublyLinkedList {
    private Node node;
    private DoublyLinkedList left;
    private DoublyLinkedList right;

    public DoublyLinkedList(Node node, Node node2) {
        this.node = node;
        right = new DoublyLinkedList(node2);
        right.left = this;
    }

    private DoublyLinkedList(Node node) {
        this.node = node;
    }

    public Node getValue() {
        return node;
    }

    public DoublyLinkedList getNode(int index) {
        DoublyLinkedList currentNode = this;
        for(int i = 0; i < index; i++)
            currentNode = currentNode.right;

        return currentNode;
    }

    public int size() {
        DoublyLinkedList currentNode = this;
        int size = 1;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
            size++;
        }
        return size;
    }

    public DoublyLinkedList getLastNode() {
        DoublyLinkedList currentNode = this;
        while(currentNode.right != null)
            currentNode = currentNode.right;

        return currentNode;
    }

    // method to insert a sub-list of lenght 2 into the list
    public void insertSubList(DoublyLinkedList subList) {
        if (left !=  null) {
            left.right = subList;
            subList.left = left;
            if (right != null) {
                subList.right.right = right;
                right.left = subList.right;
            }
        } else {
            subList.right.right = right;
            right.left = subList.right;

            node = subList.getValue();
            right = subList.right;
            subList.right.left = this;
        }
    }

    public Node[] toArray() {
        int size = size();
        DoublyLinkedList currentNode = this;

        Node[] nodesArr = new Node[size];
        for (int i = 0; i < size; i++) {
            nodesArr[i] = currentNode.node;
            currentNode = currentNode.right;
        }

        return nodesArr;
    }
}

    // public void add(Node node) {
    //     DoublyLinkedList currentNode = this;
    //     while (currentNode.right != null)
    //         currentNode = currentNode.right;

    //     currentNode.right = new DoublyLinkedList(node);
    //     currentNode.right.left = currentNode;
    // }

