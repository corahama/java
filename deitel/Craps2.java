import java.security.SecureRandom;

public class Craps2{
  private static final SecureRandom randomNumber = new SecureRandom();

  private enum Status { CONTINUE, WIN, LOST };

  private static final int SNAKE_EYES = 2;
  private static final int TREY = 3;
  private static final int SEVEN = 7;
  private static final int YO_LEVEN = 11;
  private static final int BOX_CARS = 12;

  static int number1, number2, sum, num, countRoll = 1, numR;


  public static void main(String[] argas){
    num = rollDice();

    switch(num){
      case 7: case 11:
        System.out.println(Status.CONTINUE);
        break;
      case 2: case 3: case 12:
        System.out.println(Status.LOST);
        break;
      default:
        for (int counter = 1; counter <= 7; counter++){
          numR = rollDice();
          if (numR == num ){
            System.out.println(Status.WIN);
            break;
          }else if ( numR == 7 ){
            System.out.println(Status.LOST);
            break;
          }
          if (counter == 7){
            System.out.println(Status.LOST);
            break;
          }
        }
    }

  }

  public static int rollDice(){
    System.out.printf("%nRonda: %s%n", countRoll++);
    System.out.printf("Primer dado: %d%n", number1 = 1 + randomNumber.nextInt(6));
    System.out.printf("Segundo dado: %d%n", number2 = 1 + randomNumber.nextInt(6));
    sum = number1 + number2;
    return sum;
  }

}
