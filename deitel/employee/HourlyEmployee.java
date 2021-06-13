public class HourlyEmployee extends Employee{
  private double wage, hours;

  public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours){
    super(firstName, lastName, socialSecurityNumber);

    if (wage < 0.0)
      throw new IllegalArgumentException("El salario debe ser mayor que 0.0");
    if ((hours < 0.0) || (hours > 168.0))
      throw new IllegalArgumentException("Las horas deben ser mayor que 0.0 y menor que 168");

    this.wage = wage;
    this.hours = hours;
  }

  public void setWage(double wage){
    if (wage < 0.0)
      throw new IllegalArgumentException("El salario debe ser mayor que 0.0");

    this.wage = wage;
  }

  public double getWage(){
    return wage;
  }

  public void setHours(double hours){
    if ((hours < 0.0) || (hours > 168.0))
      throw new IllegalArgumentException("Las horas deben ser mayor que 0.0 y menor que 168");

    this.hours = hours;
  }

  public double getHours(){
    return hours;
  }

  @Override
  public double earnings(){
    if (getHours() <= 40)
      return getWage() * getHours();
    else
      return 40 * getHours() + (getHours() - 40 ) * 1.5;
  }

  @Override
  public String toString(){
    return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", getWage(), "hours worked", getHours());
  }
}
