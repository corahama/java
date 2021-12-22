package HierarchicalClustering;

public class Node {
    Cluster parent = null;
    
    public Node getLastParent() {
        if (parent == null)
            return this;
        else
            return parent.getLastParent();

        // TODO: check this.
        // return (parent.getLastParent() == null) ? this : parent.getLastParent();
    }

    public Node getLChild() {
        return this;
    }

    public Node getRChild() {
        return this;
    }

    public double[] getChs() {
        return null;
    }

    public double[][] getElements() {
        return new double[][] {this.getChs()};
    }
}
