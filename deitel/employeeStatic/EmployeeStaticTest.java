public class EmployeeStaticTest{
  public static void main(String[] args){
    // String empleado;
    EmployeeStatic[] employeeList = new EmployeeStatic[10];

    for (EmployeeStatic employee : employeeList) {
      employee = new EmployeeStatic("Empleado", "Numero" + (EmployeeStatic.getCount()));
    }

    // EmployeeStatic empleado = new EmployeeStatic();
    // EmployeeStatic empleado1 = new EmployeeStatic("Fernando", "Contreras");


  }
}
