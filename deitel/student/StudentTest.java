import java.util.Scanner;

public class StudentTest{
  public static void main(String[] args){
    Student student = new Student("Fernando", 90);

    System.out.printf("%s, tu promedio es %s%n%n", student.getName(), student.getAverage());

    Scanner input = new Scanner(System.in);

    System.out.print("Elige un nuevo nombre: ");
    String name = input.next();
    student.setName(name);

    System.out.print("Elige un nuevo promedio: ");
    double average = input.nextInt();
    student.setAverage(average);
    System.out.println();

    System.out.printf("Hola %s, tu promedio es %s", student.getName(), student.getAverage());
  }
}
