package HierarchicalClustering;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Leaf extends Node {
    private double[] chs;

    public Leaf(double[] chs) {
        this.chs = chs;
    }

    @Override
    public double[] getChs() {
        return chs;
    }

    @Override
    public String toString() {
        return Arrays.stream(chs).mapToObj(String::valueOf).collect(Collectors.joining(", "));
    }

}
