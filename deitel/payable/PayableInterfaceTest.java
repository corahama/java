public class PayableInterfaceTest{
  public static void main(String[] args){
    Payable[] payableObjects = new Payable[4];

    payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
    payableObjects[1] = new Invoice("56789", "tire", 4, 79.99);
    payableObjects[2] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
    payableObjects[3] = new SalariedEmployee("Lisa", "Barnes", "222-22-2222", 1200.00);

    System.out.println("Invoice and Employees processed polymorphically: ");

    for (Payable currentPayable : payableObjects)
      System.out.printf("%n%s %n%s: $%,.2f%n", currentPayable.toString(), "payment due", currentPayable.getPaymentAmount());
  }
}
