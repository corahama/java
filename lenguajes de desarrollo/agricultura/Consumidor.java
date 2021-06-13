package agricultura;

public class Consumidor implements Runnable{
  int ciclos, frecuencia;
  AreaConsumo consumo;

  public Consumidor(int ciclos, int frecuencia, AreaConsumo consumo){
    this.ciclos = ciclos;
    this.frecuencia = frecuencia;
    this.consumo = consumo;
  }

  @Override
  public void run(){
    if (frecuencia == 50){
      for (int i = 0; i < ciclos; i++){
        if (i % 50 == 0){
          for (int count = 0; count < consumo.size(); count++){
            if (consumo.get(count) == "fruto"){
              consumo.remove(count);
              break;
            }
          }
        }
      }
    }

    if (frecuencia == 60){
      for (int i = 0; i < ciclos; i++){
        if (i % 60 == 0){
          for (int count = 0; count < consumo.size(); count++){
            if (consumo.get(count) == "hortaliza"){
              consumo.remove(count);
              break;
            }
          }
        }
      }
    }

    if (frecuencia == 70){
      int count1 = 0, count2 = 0;
      for (int i = 0; i < ciclos; i++){
        if (i % 70 == 0){
          for (int count = 0; count < consumo.size(); count++){
            if (consumo.get(count) == "fruto"){
              count1++;
            }
            if (consumo.get(count) == "hortaliza"){
              count2++;
            }
          }
          if (count1 < count2){
            for (int count = 0; count < consumo.size(); count++){
              if (consumo.get(count) == "fruto"){
                consumo.remove(count);
                break;
              }
            }
          }else{
            for (int count = 0; count < consumo.size(); count++){
              if (consumo.get(count) == "hortaliza"){
                consumo.remove(count);
                break;
              }
            }

          }
        }
      }
    }


    if (frecuencia == 80){
      for (int i = 0; i < ciclos; i++){
        if (i % 80 == 0){
          for (int count = 0; count < consumo.size(); count++){
            if (consumo.get(count) == "hortaliza" || consumo.get(count) == "fruto"){
              consumo.remove(count);
              break;
            }
          }
        }
      }
    }


    if (frecuencia == 90){
      int count1 = 0, count2 = 0;
      for (int i = 0; i < ciclos; i++){
        if (i % 90 == 0){
          for (int count = 0; count < consumo.size(); count++){
            if (consumo.get(count) == "fruto"){
              count1++;
            }
            if (consumo.get(count) == "hortaliza"){
              count2++;
            }
          }
          if (count1 > count2){
            for (int count = 0; count < consumo.size(); count++){
              if (consumo.get(count) == "fruto"){
                consumo.remove(count);
                break;
              }
            }
          }else{
            for (int count = 0; count < consumo.size(); count++){
              if (consumo.get(count) == "hortaliza"){
                consumo.remove(count);
                break;
              }
            }

          }
        }
      }
    }

  }


}
