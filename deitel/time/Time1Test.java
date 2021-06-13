public class Time1Test{
  public static void main(String[] args){
    Time1 time = new Time1(2);

    displayTime("Despues de que el objeto time fue creado: ", time);
    System.out.println();

    time.setTime(13, 02, 54);

    displayTime("Despues de haber llamado el metodo setTime: ", time);
    System.out.println();

    try{
      time.setTime(24, 01, 01);
    }catch(IllegalArgumentException e){
      System.out.printf("Exception: %s%n%n", e.getMessage() );
    }

    displayTime("Despues de haber llamado el metodo setTime con valores fuera de rango: ", time);
    System.out.println();

  }

  public static void displayTime(String mensaje, Time1 time){
    System.out.printf("%s%n%s%n%s%n", mensaje, time.toUniversalString(), time.toString());
  }
}
