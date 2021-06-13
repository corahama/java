import java.security.SecureRandom;

public class Sumador implements Runnable{
  SecureRandom random = new SecureRandom();
  private int[] arr;
  private int tamano;
  private Integer resultado = null;

  public Sumador(int tam){
    this.tamano = tam;
    this.arr = new int[tam];

    for (int count = 0; count < tam; count++)
      arr[count] = random.nextInt(2);
  }

  @Override
  public void run(){
    this.resultado = 0;
    for (int count = 0; count < tamano; count++)
      resultado += arr[count];
    System.out.printf("Resultado obtenido por el hilo %d", resultado);
  }

  public Integer getResultado(){
    return this.resultado;
  }
}
