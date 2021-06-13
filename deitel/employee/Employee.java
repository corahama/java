public abstract class Employee{
  private final String firstName, lastName, socialSecurityNumber;

  public Employee(String firstName, String lastName, String socialSecurityNumber){
    this.firstName = firstName;
    this.lastName = lastName;
    this.socialSecurityNumber = socialSecurityNumber;
  }

  public String getFirstName(){
    return firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public String getSocialSecurityName(){
    return socialSecurityNumber;
  }

  @Override
  public String toString(){
    return String.format("%s %s%nsocial security number: %s", getFirstName(), getLastName(), getSocialSecurityName());
  }

  public abstract double earnings();
}
