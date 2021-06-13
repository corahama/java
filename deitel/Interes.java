public class Interes{
  public static void main(String[] args){
    double a = 0, //Total de cada año
    p = 1000, //Inversion inicial
    r = .05; //Interes anual

    System.out.printf("%s%23s%n", "Año", "Cantidad en el banco");
    for(int counter = 1; counter <= 10; counter++){
      a = p*Math.pow(1+r,counter);
      System.out.printf("%4d%,23.2f%n", counter, a);
    }

  }
}
