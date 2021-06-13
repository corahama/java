import java.util.Scanner;

public class StaticTest{

  public static void main(String[] args){
    int num;

    if (args.length == 0 || args.length > 1){
      Scanner input = new Scanner(System.in);
      do{
        System.out.printf("Tienes que introducir un valor: ");
        num = input.nextInt();
      }while(num == 0);

    }else{
      num = Integer.parseInt(args[0]);
    }

    Static.printNumber(num);

  }
}
