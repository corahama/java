import javax.swing.JOptionPane;

public class Addition{
  public static void main(String[] args){
    String firstNumber = JOptionPane.showInputDialog("Introduce el primer numero: ");
    String secondNumber = JOptionPane.showInputDialog("Introduce el segundo numero: ");

    int number1 = Integer.parseInt(firstNumber);
    int number2 = Integer.parseInt(secondNumber);

    int sum = number1 + number2;

    JOptionPane.showMessageDialog(null, "La suma es "+ sum, "Suma de los enteros", JOptionPane.PLAIN_MESSAGE);

  }
}
