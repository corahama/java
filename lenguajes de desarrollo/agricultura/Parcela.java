package agricultura;

import java.util.ArrayList;

public class Parcela{
  private ArrayList<String> parcela = null;

  public Parcela(int size){
    this.parcela = new ArrayList<String>(size);
  }

  synchronized public void aumenta(String cosecha){
    if (this.parcela.size() < 100)
      this.parcela.add(cosecha);
  }

  synchronized public void evalua(){
    if (parcela.size() > 0){
      for (int count = 0; count < parcela.size(); count++){
        if (parcela.get(count) == "lsemilla")
        parcela.set(count, "lbrote");
        else if (parcela.get(count) == "lbrote")
        parcela.set(count, "hortaliza");
        else if (parcela.get(count) == "fsemilla")
        parcela.set(count, "fbrote");
        else if (parcela.get(count) == "fbrote")
        parcela.set(count, "fplanta");
        else if (parcela.get(count) == "fplanta")
        parcela.set(count, "fruto");
      }
    }

  }

  public boolean contains(String value){
    return parcela.contains(value);
  }

  public String get(int value){
    return parcela.get(value);
  }

  public void remove(int value){
    parcela.remove(value);
  }

  public int size(){
    return parcela.size();
  }

}
