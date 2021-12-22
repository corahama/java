package umda;

class Sphere implements objectiveFunction {
    // objective function
    @Override
    public double function(double[] x) {
        double total = 0.0;
        for (double xi : x)
            total += Math.pow(xi, 2.0);
        return total;
    }
}