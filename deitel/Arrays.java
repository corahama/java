import java.security.SecureRandom;

public class Arrays{
  // DECLARAR E INICIALIZAR UN ARRAY
  // public static void main(String[] args){
  //   int[] array = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37 };
  //
  //   System.out.printf("%8s %8s%n", "index", "value");
  //
  //   for(int counter = 0; counter < array.length; counter++){
  //     System.out.printf("%8s %8s%n", counter, array[counter]);
  //   }
  //
  //   System.out.print(array.length);
  // }

  // ARRAY DE LOS NUMEROS PARES
  // public static void main(String[] args){
  //   int[] array = new int[10];
  //
  //   System.out.printf("%8s %8s%n", "index", "value");
  //
  //   for(int counter = 0; counter < array.length; counter++){
  //     array[counter] = 2 + 2 * counter;
  //     System.out.printf("%8s %8s%n", counter, array[counter]);
  //   }
  // }

  // SACA EL LA SUMATORIA DE UN ARRAY
  // public static void main(String[] args){
  //   int[] array = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 };
  //   int sum = 0;
  //
  //   for(int counter = 0; counter < array.length; counter++){
  //     sum += array[counter];
  //   }
  //   System.out.printf("La sumatoria fue: %d", sum);
  // }

  // GRAFICA LOS RESULTADOS DE EXAMENES
  // public static void main(String[] args){
  //   int[] array = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87, 90, 69};
  //
  //   for(int counter = 1; counter <= 10; counter++){
  //
  //     if (counter == 10){
  //       System.out.printf("El total de   100   fueron: ");
  //       for(int sum = 0; sum < array.length; sum++){
  //         if(array[sum]==100){
  //           System.out.printf("*");
  //         }
  //       }
  //       System.out.println();
  //     }else{
  //       System.out.printf("El total de %d - %d fueron: ", counter*10, (counter*10)+9);
  //       for(int sum = 0; sum < array.length; sum++){
  //         if(array[sum] >= counter*10 && array[sum] <= (counter*10) + 9){
  //           System.out.printf("*");
  //         }
  //       }
  //       System.out.println();
  //     }
  //
  //   }
  // }

  // GRAFICA LA FRECUENCUA DE UN LANZAMIENTO DE DADO
  // public static void main(String[] args){
  //   SecureRandom number = new SecureRandom();
  //   int[] frecuency = new int[7];
  //   int sum = 0;
  //
  //   for(int counter = 0; counter < 60000; counter++)
  //     frecuency[1 + number.nextInt(6)]++;
  //
  //   System.out.printf("%s %s%n", "Cara", "Frecuencia");
  //   for(int counter = 1; counter < frecuency.length; counter++){
  //     System.out.printf("%4d %10d%n", counter, frecuency[counter]);
  //     sum += frecuency[counter];
  //   }
  //   System.out.print(sum);
  //
  // }

  // MUESTRA LA FRECUENCIA DE UNA ENCUESTA
  public static void main(String[] args){
    int[] responses = { 1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 1, 4, 3, 3, 3, 2, 3, 3, 2, 14 };
    int[] answer = new int[6];

    for(int counter = 0; counter < responses.length; counter++){
      try{
        ++answer[responses[counter]];
      }
      catch(ArrayIndexOutOfBoundsException e){
        System.out.println(e);
        System.out.printf("responses[%d] = %d%n%n", counter, responses[counter]);
      }

    }
    System.out.printf("%s %s%n", "Puntuacion", "Frecuencia");
    for(int counter = 1; counter < answer.length ; counter++)
      System.out.printf("%10d %10d%n", counter, answer[counter]);

  }


  // public static void main(String[] args){
  //   int array[] = {1, 2, 3, 4};
  //
  //   for (int elm:array)
  //     System.out.print(elm);
  //
  //   System.out.println();
  // }
}
