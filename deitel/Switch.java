import java.util.Scanner;

public class Switch{
  public static void main(String[] args){
    int total = 0, totalGrade = 0, gradeA = 0, gradeB = 0, gradeC = 0, gradeD = 0, gradeF = 0;
    Scanner input = new Scanner(System.in);

    System.out.print("Introduce un nuevo valor: ");
    while (input.hasNext()){
      int grade = input.nextInt();
      total += grade;
      totalGrade++;

      System.out.print("Introduce un nuevo valor: ");
      switch (grade/10){
        case 9:
        case 10:
          gradeA++;
          break;
        case 8:
          gradeB++;
          break;
        case 7:
          gradeC++;
          break;
        case 6:
          gradeD++;
          break;
        default:
          gradeF++;
          break;
      }

    }

    double average = total/(totalGrade*10);

    if (totalGrade != 0){
      System.out.println();
      System.out.println("*****RESULTADOS******");
      System.out.printf("El total de datos ingresados fue: %d%n", totalGrade);
      System.out.printf("La sumatoria de los datos ingresados fue: %d%n", total);
      System.out.printf("El promeido de los alumnos fue: %.2f%n", average);
      System.out.printf("Cuenta de datos por calificacion: %nA:%d  B:%d  C:%d  D:%d  F:%d", gradeA, gradeB, gradeC, gradeD, gradeF);
    }
    else
      System.out.println("No ingresaste ningun dato.");

  }
}
