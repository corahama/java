public class Student{

  private String name;
  private double average;

  public Student(String name, double average){
    this.name = name;
    if (average > 0 && average <= 100)
      this.average = average;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public void setAverage(double average){
    if (average > 0 && average <= 100)
      this.average = average;
  }

  public String getAverage(){
    String note = "";
    if (average >= 90.0)
      note = "A";
    else if (average >= 80.0)
      note = "B";
    else if (average >= 70.0)
      note = "C";
    else if(average >= 60.0)
      note = "D";
    else
      note = "Reprobado";
    return note;
  }
}
