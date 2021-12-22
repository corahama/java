package umda;

public class i { // individuals class
    public double[] values;
    private double fitness;
    final objectiveFunction objectiveFunction;

    public i(double[] values, objectiveFunction objectiveFunction) {
        this.values = values;
        this.objectiveFunction = objectiveFunction;
        this.fitness = objectiveFunction.function(values);
    }

    public double getFitness() {
        return fitness;
    }

    public void calculateFitness() {
        fitness = objectiveFunction.function(values);
    }
}