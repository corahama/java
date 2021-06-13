public class CommissionEmployee extends Employee{
  private double grossSales, commissionRate;

  public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate){
    super(firstName, lastName, socialSecurityNumber);

    if (commissionRate <= 0.0 || commissionRate >= 1.0)
    throw new IllegalArgumentException("Commision Rate fuera de rango");
    if (grossSales < 0)
    throw new IllegalArgumentException("Gross Sales fuera de rango");

    this.grossSales = grossSales;
    this.commissionRate = commissionRate;
  }

  public void setGrossSales(double grossSales){
    if (grossSales < 0)
      throw new IllegalArgumentException("Gross Sales fuera de rango");

    this.grossSales = grossSales;
  }

  public double getGrossSales(){
    return grossSales;
  }

  public void setCommissionRate(double commissionRate){
    if (commissionRate <= 0.0 || commissionRate >= 1.0)
      throw new IllegalArgumentException("Commision Rate fuera de rango");

    this.commissionRate = commissionRate;
  }

  public double getCommisionRate(){
    return commissionRate;
  }

  @Override
  public double earnings(){
    return getCommisionRate() * getGrossSales();
  }

  @Override
  public String toString(){
    return String.format("%s: %s%n%s: $%,.2f; %s: %.2f", "commision employee", super.toString(), "gross sales", getGrossSales(), "commission rate", getCommisionRate());
  }

}
