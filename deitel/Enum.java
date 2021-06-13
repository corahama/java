public class Enum {
  public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY
  }

  Day day;

  public Enum(Day day) {
      this.day = day;
  }

  public void tellItLikeItIs() {
      switch (day) {
          case MONDAY:
              System.out.println("Mondays are bad.");
              break;

          case FRIDAY:
              System.out.println("Fridays are better.");
              break;

          case SATURDAY: case SUNDAY:
              System.out.println("Weekends are best.");
              break;

          default:
              System.out.println("Midweek days are so-so.");
              break;
      }
  }

  public static void main(String[] args) {
      Enum firstDay = new Enum(Day.MONDAY);
      firstDay.tellItLikeItIs();
      Enum thirdDay = new Enum(Day.WEDNESDAY);
      thirdDay.tellItLikeItIs();
      Enum fifthDay = new Enum(Day.FRIDAY);
      fifthDay.tellItLikeItIs();
      Enum sixthDay = new Enum(Day.SATURDAY);
      sixthDay.tellItLikeItIs();
      Enum seventhDay = new Enum(Day.SUNDAY);
      seventhDay.tellItLikeItIs();
}
}
