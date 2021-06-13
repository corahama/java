import java.util.Scanner;

public class AverageTest{
  private static int total = 0;
  private static int counter = 0;

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Introduce una calificacion o -1 para terminar: ");
    int number = input.nextInt();

    while (number != -1){
      total = total + number;
      counter = counter + 1;
      System.out.print("Introduce una calificacion o -1 para terminar: ");
      number = input.nextInt();
    }

    double average = (double) total/counter;
    System.out.printf("La suma de todos los valores es %d, y los valores introducidos fueron: %d%n", total, counter);
    System.out.printf("El promedio fue %.2f", average);

  }

}
