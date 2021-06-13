package agricultura;

public class ProductorLechuga implements Runnable{
  private int ciclos;
  private Parcela parcela = null;

  public ProductorLechuga(int ciclos, Parcela parcela){
    this.ciclos = ciclos;
    this.parcela = parcela;
  }

  @Override
  public void run(){
      for (int count = 0; count < ciclos; count++){
        if(count % 75 == 0)
          parcela.aumenta("lsemilla");
      }
  }
}
