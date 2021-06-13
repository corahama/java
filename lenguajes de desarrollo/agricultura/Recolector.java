package agricultura;

public class Recolector implements Runnable{
  int ciclos, frecuencia;
  AreaConsumo consumo;

  public Recolector(int ciclos, int frecuencia, AreaConsumo consumo){
      this.ciclos = ciclos;
      this.frecuencia = frecuencia;
      this.consumo = consumo;
  }

  @Override
  public void run(){
    for (int count = 0; count < ciclos; count++){
      if (count % frecuencia == 0)
        consumo.aumenta();

    }
  }
}
