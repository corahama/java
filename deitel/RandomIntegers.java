import java.security.SecureRandom;

public class RandomIntegers{
  public static void main(String[] args){
    SecureRandom numberRandom = new SecureRandom();
    int number, count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, counterDefault = 0;

    for (int counter = 1; counter <=600000; counter++){
      number = 1 + numberRandom.nextInt(6);
      // System.out.printf("%d ", number);

      // if (counter % 5 == 0){
      //   System.out.println();
      // }

      switch(number){
        case 1:
          count1++;
          break;
        case 2:
          count2++;
          break;
        case 3:
          count3++;
          break;
        case 4:
          count4++;
          break;
        case 5:
          count5++;
          break;
        case 6:
          count6++;
          break;
        default:
          counterDefault++;
      }
    }

    System.out.println();
    System.out.println("*****Tabla de resultados*****");
    System.out.printf("%6s %10s%n", "Numero", "Resultado");
    System.out.printf("%6s %10d%n", "1", count1);
    System.out.printf("%6s %10d%n", "2", count2);
    System.out.printf("%6s %10d%n", "3", count3);
    System.out.printf("%6s %10d%n", "4", count4);
    System.out.printf("%6s %10d%n", "5", count5);
    System.out.printf("%6s %10d%n", "6", count6);
    System.out.printf("El total de default fue: %d%n", counterDefault);
  }
}
