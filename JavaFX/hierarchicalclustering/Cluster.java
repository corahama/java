package hierarchicalclustering;

import java.util.ArrayList;


public class Cluster extends Node {
    private Node lChild;
    private Node rChild;
    private double distance;

    public Cluster(Node lChild, Node rChild, double distance) {
        this.lChild = lChild;
        this.rChild = rChild;
        this.distance = distance;
    }

    @Override
    public Node getLChild() {
        return lChild;
    }

    @Override
    public Node getRChild() {
        return rChild;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public double[][] getElements() {
        ArrayList<double[]> elms = new ArrayList<>();
        getElements(getLChild(), elms);
        getElements(getRChild(), elms);
        return elms.toArray(double[][]::new);
    }

    public void getElements(Node node, ArrayList<double[]> arr) {
        if (node.getClass().getSimpleName().equals("Leaf")) {
            arr.add(node.getChs());
        } else {
            getElements(node.getLChild(), arr);
            getElements(node.getRChild(), arr);
        }
    }
}
