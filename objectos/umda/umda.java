package umda;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Random;

public class umda implements objetviceFunction {
    private int N = 100; // total population
    private int a = 5; // active population
    private int n = 2; // dimensions number
    private int iterations = 100; // iterations quantity
    private double min = -5.12, max = 5.12; // bounds

    public umda(int N, int a, int n, int iterations) {
        this.N = N;
        this.a = a;
        this.n = n;
        this.iterations = iterations;
    }

    // objective function
    @Override
    public double function(double[] x) {
        double total = 0.0;
        for (double xi : x) {
            total += Math.pow(xi, 2.0);
        }
        return total;
    }

    // comparator class
    class CompareI implements Comparator<i> {
        public int compare(i a, i b) {
            double ap = function(a.values);
            double bp = function(b.values);
            return  ((ap > bp) ? 1 : 0) - ((ap < bp) ? 1 : 0);
        }
    }

    // mean calculation
    public double mean(i[] population, int j) {
        double mean = 0;
        for (int i = 0; i < population.length; i++)
            mean += population[i].values[j];
        return mean/population.length;
    }

    // standard deviation calculation
    public double stanDev(i[] population, int j) {
        double mean = mean(population, j);
        double standDev = 0;
        for (int i = 0; i < population.length; i++)
            standDev += Math.pow((population[i].values[j]-mean), 2);
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

            population[i] = new i(values);
        }
        // population sorting
        Arrays.sort(population, new CompareI());

        // loop
        double[] bestValues;
        for (int e = 0; e < iterations-1; e++) {
            bestValues = new double[n];
            System.arraycopy(population[0].values, 0, bestValues, 0, n);
            history.add(new i(bestValues));

            for (int j = 0; j < n; j++) {
                double m = mean(population, j), sd = stanDev(population, j);
                for (int i = a; i < N; i++)
                    population[i].values[j] = random.nextGaussian()*sd+m;
            }
            
            Arrays.sort(population, new CompareI());
        }

        for (i ind : history)
            ind.fitness = function(ind.values);

        return history;
    }
}