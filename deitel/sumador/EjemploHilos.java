public class EjemploHilos{
  public static void main(String[] args){
    Sumador sumador1 = new Sumador(5000);

    Thread hilo_sumador1 = new Thread(sumador1);

    hilo_sumador1.start();

    System.out.printf("Resultado obtenido por el main %s%n", sumador1.getResultado());

  }
}
