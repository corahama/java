package agricultura;

import java.util.ArrayList;

public class AreaConsumo{
  private ArrayList<String> consumo = null;
  private Parcela parcela = null;


  public AreaConsumo(int size, Parcela parcela){
    this.consumo = new ArrayList<String>(size);
    this.parcela = parcela;
  }

  synchronized public void aumenta(){
    if (this.consumo.size() < 150){
      while (parcela.contains("fruto") || parcela.contains("hortaliza"))
        for (int count = 0; count < parcela.size(); count++){
          if (parcela.get(count) == "fruto" || parcela.get(count) == "hortaliza"){
            this.consumo.add(parcela.get(count));
            parcela.remove(count);
            break;
          }
      }
    }
  }

  public boolean contains(String value){
    return consumo.contains(value);
  }

  public String get(int value){
    return consumo.get(value);
  }

  public void remove(int value){
    consumo.remove(value);
  }

  public int size(){
    return consumo.size();
  }



}
