public class Employee{
  private final String firstName, lastName;
  private final Date birth, hire;

  public Employee(String firstName, String lastName, Date birth, Date hire){
    this.firstName = firstName;
    this.lastName = lastName;
    this.birth = birth;
    this.hire = hire;
  }

  public String getFirstName(){
    return firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public Date getBirth(){
    return birth;
  }

  public Date getHire(){
    return hire;
  }


  public String toString(){
    return String.format("Empleado: %s %s%nCumpleaños: %s\nFecha de contrataion: %s", getFirstName(), getLastName(), getBirth(), getHire());
  }

}
