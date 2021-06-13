public class EmployeeStatic{
  private static int count = 0;
  private String firstName, lastName;

  public EmployeeStatic(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;

    ++count;
    System.out.printf("EmployeeStatic Constructor: %s %s; count = %d%n", firstName, lastName, count);

  }

  public EmployeeStatic(){
    this.firstName = "empleado";
    this.lastName = "default";

    ++count;
    System.out.printf("EmployeeStatic Constructor: %s %s; count = %d%n", firstName, lastName, count);

  }


  public String getFirstName(){
    return firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public static int getCount(){
    return count;
  }
}
