public class Invoice implements Payable{
  private final String partNumber, partDescription;
  private int quantity;
  private double pricePerItem;

  public Invoice(String partNumber, String  partDescription, int quantity, double pricePerItem){
    if (quantity < 0)
      throw new IllegalArgumentException("Cantidad debe ser mayor a 0");
    if (pricePerItem < 0.0)
      throw new IllegalArgumentException("Precio por item debe ser mayor a 0");

    this.quantity = quantity;
    this.partNumber = partNumber;
    this.partDescription = partDescription;
    this.pricePerItem = pricePerItem;
  }

  public String getPartNumber(){
    return partNumber;
  }

  public String getPartDescription(){
    return partDescription;
  }

  public void setQuantity(int quantity){
    if (quantity < 0)
      throw new IllegalArgumentException("Cantidad debe ser mayor a 0");

    this.quantity = quantity;
  }

  public int getQuantity(){
    return quantity;
  }

  public void setPricePerItem(double pricePerItem){
    if (pricePerItem < 0.0)
      throw new IllegalArgumentException("Precio por item debe ser mayor a 0");

    this.pricePerItem = pricePerItem;
  }

  public double getPricePerItem(){
    return pricePerItem;
  }

  @Override
  public String toString(){
    return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f", "invoice", "part number", getPartNumber(), getPartDescription(), "quantity", getQuantity(), "price per item", getPricePerItem());
  }

  @Override
  public double getPaymentAmount(){
    return getQuantity() * getPricePerItem();
  }
}
