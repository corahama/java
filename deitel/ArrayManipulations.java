import java.util.Arrays;

public class ArrayManipulations{
  public static void main(String[] args){
    double[] doubleArray = { 8.4, 9.3, 0.2, 7.9, 3.4 };

    Arrays.sort(doubleArray);
    System.out.printf("%ndoubleArray: ");
    for(double value : doubleArray)
      System.out.printf(" %.1f", value);

    int[] filledIntArray = new int[10];
    Arrays.fill(filledIntArray, 7);
    displayArray(filledIntArray, "filledIntArray");

    int[] intArray = { 1, 2, 3, 4, 5, 6 };
    int[] intArrayCopy = new int[intArray.length];
    System.arraycopy(intArray, 0, intArrayCopy, 0, intArray.length);
    displayArray(intArray, "intArray");
    displayArray(intArrayCopy, "intArrayCopy");

    boolean b = Arrays.equals(intArray, intArrayCopy);
    System.out.printf("%n%ninitArray %s initArrayCopy%n", (b ? "==" : "!="));

    b = Arrays.equals(intArray, filledIntArray);
    System.out.printf("initArray %s filledArray%n%n", (b ? "==" : "!="));

    int location = Arrays.binarySearch(intArray, 5);
    if(location >= 0)
      System.out.printf("Se encotro 5 en el indice %d en intArray%n", location);
    else
      System.out.printf("No se encontro el elemento 5");

    location = Arrays.binarySearch(intArray, 400);
    if(location >= 0)
      System.out.printf("Se encotro 400 en el elemento %d en intArray%n", location);
    else
      System.out.printf("No se encontro 400");
  }

  public static void displayArray(int[] array, String description){
    System.out.printf("%n%s: ", description);

    for(int value : array)
      System.out.printf(" %d", value);
  }
}
