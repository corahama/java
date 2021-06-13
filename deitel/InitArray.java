public class InitArray{
  public static void main(String[] args){
    int[][] array1 = {{1, 2, 3}, {4, 5, 6}}, array2 = {{1, 2}, {3}, {4, 5, 6}};

    System.out.printf("Los valores de la primer matriz son:%n");
    outputArray(array1);

    System.out.printf("Los valores de la segunda matriz son:%n");
    outputArray(array2);
  }

  public static void outputArray(int[][] array){
    for(int[] value : array){
        for(int value2 : value)
          System.out.printf(" %d ", value2);
        System.out.println();
    }
    System.out.println();
  }
}
