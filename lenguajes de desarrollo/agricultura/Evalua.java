package agricultura;

public class Evalua implements Runnable{
  private int ciclos;
  private Parcela parcela = null;

  public Evalua(int ciclos, Parcela parcela){
    this.ciclos = ciclos;
    this.parcela = parcela;
  }

  @Override
  public void run(){
      for (int count = 0; count < ciclos; count++){
        if(count % 100 == 0)
          parcela.evalua();
      }
  }
}
