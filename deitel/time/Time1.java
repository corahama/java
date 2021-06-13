public class Time1{
  private int hour, minute, second;

  public Time1(){
    this(0, 0, 0);
  }

  public Time1(int hour){
    this(hour, 0, 0);
  }

  public Time1(int hour, int minute, int second){
    if (hour < 0 || hour >= 24)
    throw new IllegalArgumentException("hour must be 0-23");
    if (minute < 0 || minute >= 60)
    throw new IllegalArgumentException("minute must be 0-59");
    if (second < 0 || second >= 60)
    throw new IllegalArgumentException("second must be 0-59");
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public void setTime(int hour, int minute, int second){
    if (hour < 0 || hour >23 || minute < 0 || minute > 60 || second < 0 || second > 60)
      throw new IllegalArgumentException("Valores fuera de rango");

    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public String toUniversalString(){
    return String.format("%02d:%02d:%02d", hour, minute, second);
  }

  public String toString(){
    return String.format("%d:%02d:%02d %s", (hour == 0 || hour == 12) ? 12 : hour % 12, minute, second, (hour < 12) ? "AM" : "PM");
  }
}
