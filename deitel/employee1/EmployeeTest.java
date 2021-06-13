public class EmployeeTest{
  public static void main(String[] args){
    Date birth = new Date(7, 24, 1949);
    Date hire = new Date(3, 12, 1988);
    Employee empleado1 = new Employee("Fernando", "Contreras", birth, hire);

    System.out.println(empleado1);
  }
}
