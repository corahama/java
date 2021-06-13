import java.util.Scanner;

public class StudentTest{
  public static void main(String[] arg){
    int pass = 0, fail = 0, counter = 0;
    Scanner input = new Scanner(System.in);

    while (counter < 3){
      System.out.print("Introduce 1 si paso o 2 si no paso: ");
      int num = input.nextInt();

      if (num == 1 )
        pass = pass + 1;
      else if (num == 2)
        fail = fail + 1;

      counter = counter + 1;
    }

    System.out.printf("El total de alumnos que pasaron fue: %d%n", pass);
    System.out.printf("El total de alumnos que no pasaron fue: %d%n", fail);
    System.out.printf("El total de alumnos fue: %d%n", counter);

    if (pass > fail)
      System.out.print("Bonus!");
  }

}
