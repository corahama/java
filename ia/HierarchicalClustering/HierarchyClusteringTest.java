package HierarchicalClustering;

import java.io.FileNotFoundException;
import java.io.IOException;


public class HierarchyClusteringTest {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        double[][] dataset = ReadDataset.ReadFile("datasets/iris.data", 1, 3);
        Cluster dendogram = HierarchyClustering.getDendogram(dataset);
        Node[] clusters = HierarchyClustering.getNClusters(dendogram, 4);
        System.out.println(clusters);
    }
}
