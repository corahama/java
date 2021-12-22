package umda;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Random;

public class umdaAlgorithm {
    final int N; // total population
    final int a; // active population
    final int n; // dimensions number
    final int iterations; // iterations quantity
    final double min = -5.12, max = 5.12; // bounds
    final objectiveFunction objectiveFunction; // objective function

    public umdaAlgorithm(int N, int a, int n, int iterations, objectiveFunction objectiveFunction) {
        this.N = N;
        this.a = a;
        this.n = n;
        this.iterations = iterations;
        this.objectiveFunction = objectiveFunction;
    }

    // comparator class
    class CompareI implements Comparator<i> {
        @Override
        public int compare(i a, i b) {
            return  ((a.getFitness() > b.getFitness()) ? 1 : 0) - ((a.getFitness() < b.getFitness()) ? 1 : 0);
        }
    }

    // mean calculation
    public double mean(i[] population, int j) {
        double mean = 0;
        for (i ind : population)
            mean += ind.values[j];
        return mean/population.length;
    }

    // standard deviation calculation
    public double stanDev(i[] population, int j) {
        double mean = mean(population, j);
        double standDev = 0;
        for (i ind : population)
            standDev += Math.pow((ind.values[j]-mean), 2);
        return Math.sqrt(standDev/population.length);
    }

    // ********* Algorithm method *********
    public ArrayList<i> execute() {
        ArrayList<i> history = new ArrayList<>();
        Random random = new Random();
        i[] population = new i[N];

        // initial population generation
        double[] values;
        for (int i = 0; i < population.length; i++) {
            values = new double[n];
            for (int j = 0; j < values.length; j++)
                values[j] = min + random.nextDouble()*(max-min);

            population[i] = new i(values, objectiveFunction);
        }
        // population sorting
        Arrays.sort(population, new CompareI());

        // loop
        double[] bestValues;
        for (int e = 0; e < iterations; e++) {
            bestValues = new double[n];
            System.arraycopy(population[0].values, 0, bestValues, 0, n);
            history.add(new i(bestValues, objectiveFunction));

            for (int j = 0; j < n; j++) {
                double m = mean(population, j), sd = stanDev(population, j);
                for (int i = a; i < N; i++)
                    population[i].values[j] = random.nextGaussian()*sd+m;
            }
            
            for (i ind : population)
                ind.calculateFitness();
            
            Arrays.sort(population, new CompareI());
        }

        return history;
    }
}