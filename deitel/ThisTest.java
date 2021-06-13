class ThisTest{
  public static void main(String[] args){
    SimpleTime time = new SimpleTime(15, 30, 19);
    System.out.println(time.buildString());

  }
}

class SimpleTime{
  private int hour, minute, second;

  public SimpleTime(int hour, int minute, int second){
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public String buildString(){
    return String.format("%22s %s%n%22s %s%n", "this.toUniversalString", this.toUniversalString(), "toUniversalString", toUniversalString());
  }

  public String toUniversalString(){
    return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
  }
}
