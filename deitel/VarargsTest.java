public class VarargsTest{
  public static double average(double... numbers){
    double total = 0.0;

    for(double number : numbers)
      total += number;

    return total/numbers.length;
  }

  public static void main(String[] args){
    double d1 = 10.0, d2 = 20.0, d3 = 30.0, d4 = 40.0;

    System.out.printf("El promedio de d1 y d2 es %.1f%n", average(d1, d2));
    System.out.printf("El promedio de d1, d2 y d3 es %.1f%n", average(d1, d2, d3));
    System.out.printf("El promedio de d1 , d2, d3 y d4 es %.1f%n", average(d1, d2, d3, d4));

  }
}
