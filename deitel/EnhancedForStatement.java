public class EnhancedForStatement{
  public static void main(String[] args){
    int[] array = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 };
    int sum = 0;

    for ( int number : array )
      sum += number;

    System.out.printf("La suma de los numberos es %d", sum);
  }
}
