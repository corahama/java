public class CommandLineArgument{
  public static void main(String[] args){
    if(args.length != 3){
      System.out.print("Error. Fin del programa");
    }else{
      int arraySize = Integer.parseInt(args[0]);
      int initialValue = Integer.parseInt(args[1]);
      int increment = Integer.parseInt(args[2]);
      int[] array = new int[arraySize];

      for(int count = 0; count < array.length; count++){
        array[count] = initialValue;
        initialValue += increment;
      }

      System.out.printf("Index Value%n");
      for(int count = 0; count < arraySize; count++){
        System.out.printf("%4d %4d", count, array[count]);
        System.out.println();
      }
    }
  }
}
