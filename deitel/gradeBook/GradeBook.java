public class GradeBook{
  String courseName;
  int[][] grades;

  public GradeBook(String courseName, int[][] grades){
    this.courseName = courseName;
    this.grades = grades;
  }

  public void setCourseName(String courseName){
    this.courseName = courseName;
  }

  public String getCourseName(){
    return courseName;
  }

  public void processGrades(){
    outputGrades();

    for (int count = 0; count < 3; count++){
      System.out.printf("%nDatos generales del Examen %d%n%nPromedio de la clase: %.2f%n%n", count + 1, classAverage(count));

      System.out.printf("Calificacion mas baja: %d%nCalificacion mas alta: %d%n%n", lowerGrade(count), highestGrade(count));

      outputBarChar(count);

    }
  }

  public double classAverage(int exam){
    int average = 0;

    for(int counter = 0; counter < grades.length; counter++)
      average += grades[counter][exam];

    return (double) average/grades.length;
  }

  public int lowerGrade(int exam){
    int lower = grades[0][exam];

    for(int counter = 0; counter < grades.length; counter++){
      if ( grades[counter][exam] < lower )
        lower = grades[counter][exam];
    }

    return lower;
  }

  public int highestGrade(int exam){
    int high = grades[0][exam];

    for(int counter = 0; counter < grades.length; counter++){
      if ( grades[counter][exam] > high )
        high = grades[counter][exam];
    }

    return high;
  }

  public void outputBarChar(int exam){
    int[] frecuency = new int[11];

    System.out.printf("Dispercion grafica de las calificaiones:%n");
    for(int count = 0; count < grades.length; count++)
        ++frecuency[grades[count][exam]/10];

    for (int counter = 0; counter < frecuency.length; counter++){
      if ( counter == 10 )
        System.out.printf("%4s :", "100");
      else
        System.out.printf("%02d-%02d:", counter*10, (counter*10) + 9);

      for (int start = 0; start < frecuency[counter]; start++)
        System.out.printf("*");
      System.out.println();
    }

  }

  public void outputGrades(){
    int average = 0;

    System.out.printf("Calificaciones semestrales del curso de '%s':", courseName);
    System.out.printf("%n%n");

    System.out.printf("%s %s %s %s %s%n", "Nombre del alumno", "Examen 1",  "Examen 2", "Examen 3", "Promedio");
    for (int counter = 0; counter < grades.length; counter++){
      System.out.printf("Alumno %-10d", counter + 1);
      for (int exam : grades[counter]){
        System.out.printf("%9d", exam);
        average += exam;
      }
      System.out.printf("%9.2f", (double)average/3);
      System.out.println();
      average = 0;
    }
    System.out.println();

  }

}
