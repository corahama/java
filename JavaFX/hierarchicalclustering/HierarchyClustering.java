package hierarchicalclustering;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class HierarchyClustering extends Application {

    @Override
    public void start(Stage stage) throws Exception, FileNotFoundException, IOException {
        stage.setTitle("Hierarchy Clustering");

        final NumberAxis xAxis = new NumberAxis(1, 6, 1);
        final NumberAxis yAxis = new NumberAxis(0, 8, 1);
        final ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("x");
        yAxis.setLabel("y");
        sc.setTitle("Scatter Chart");

        double[][] dataset = ReadDataset.ReadFile("datasets/iris.data", 1, 3);
        Cluster dendogram = HierarchyClusteringAlgorithm.getDendogram(dataset);
        Node[] clusters = HierarchyClusteringAlgorithm.getNClusters(dendogram, 4);

        ArrayList<XYChart.Series<Number, Number>> data = new ArrayList<>();
        for (int i = 0; i < clusters.length; i++) {
            double[][] clusterData = clusters[i].getElements();
            XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();

            for (double[] e : clusterData)
                series.getData().add(new XYChart.Data<Number, Number>(e[0], e[1]));

            series.setName(String.format("Cluster %d", i+1));
            data.add(series);
        }
        sc.getData().addAll(data);

        Scene scene  = new Scene(sc, 500, 400);
        scene.getStylesheets().add("hierarchicalclustering/chart-symbol.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
