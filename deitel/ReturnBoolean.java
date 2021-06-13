public class ReturnBoolean{
  public static void main(String[] args){
    boolean variable;
    System.out.printf("el valor es %s", call() ? "verdadedo" : "falso");
  }

  public static boolean call(){
    return true;
  }
}
