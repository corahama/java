public class Date{
  private int year, month, day;

  public static final int[] daysPerMonth = {0, 31, 29, 30, 31, 30, 31, 30, 31, 30, 31, 30, 31};

  public Date(int month, int day, int year){
    if (month <= 0 || month > 12)
      throw new IllegalArgumentException("Valor del mes(" + month + ")fuera de rango.");
    if (day <= 0 || day > daysPerMonth[month] && !(month == 2))
      throw new IllegalArgumentException("Valro del dia(" + day + ")fuera de rango");
    if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
      throw new IllegalArgumentException("Valro del dia(" + day + ")fuera de rango");

    this.year = year;
    this.month = month;
    this.day = day;

  }

  public String toString(){
    return String.format("%d/%d/%d", month, day, year);
  }

}
