import java.util.Scanner;

public class MaximumFinder{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int number1, number2, number3;

    System.out.print("Introduce el numero 1: ");
    number1 = input.nextInt();

    System.out.print("Introduce el numero 2: ");
    number2 = input.nextInt();

    System.out.print("Introduce el numero 3: ");
    number3 = input.nextInt();

    // for (int counter = 1; counter <=3; counter++){
    //   System.out.printf("Introduce el numero %d: ", counter);
    //   number1 = input.nextInt();
    // }

    int MaxValue = calculate(number1, number2, number3);
    System.out.printf("%nEl numero mas grande introducido es: " + MaxValue);
  }

  public static int calculate(int number1, int number2, int number3){
    // int numberMax = Math.max(number1, Math.max(number2, number3));

    return Math.max(number1, Math.max(number2, number3));
  }
}
