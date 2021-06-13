package agricultura;

public class ProductorFresa implements Runnable{
  private int ciclos;
  private Parcela parcela = null;

  public ProductorFresa(int ciclos, Parcela parcela){
    this.ciclos = ciclos;
    this.parcela = parcela;
  }

  @Override
  public void run(){
      for (int count = 0; count < ciclos; count++){
        if(count % 50 == 0)
          parcela.aumenta("fsemilla");
      }
  }
}
