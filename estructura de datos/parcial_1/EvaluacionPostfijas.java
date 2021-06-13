package parcial_1;
import java.lang.Math;
import java.util.Scanner;

public class EvaluacionPostfijas {
    public static void main(String[] args) {
        String cadenaPostfija;
        if (args.length != 0)
            cadenaPostfija = args[0];
        else
            cadenaPostfija = "AB+CD+*";

        Scanner in = new Scanner(System.in);

        int valores[] = new int[10];
        for (int i = 0, count = 0; i < cadenaPostfija.length(); i++) {
            if (cadenaPostfija.charAt(i) >= 65 && cadenaPostfija.charAt(i) <= 90) {
                System.out.printf("Introduce el valor de la variable %c: ", cadenaPostfija.charAt(i));
                valores[count++] = in.nextInt();
            }
        }

        PilaOperandos pila = new PilaOperandos(valores);

        char c;
        for(int i = 0, count = 0; i < cadenaPostfija.length(); i++){
            c = cadenaPostfija.charAt(i);

            if (esOperando(c))
                pila.push(valores[count++]);
            else {
                int operando1 = pila.pop();
                int operando2 = pila.pop();
                int resultado = hacerOperacion(operando1, operando2, c);
                pila.push(resultado);
            }
        }

        System.out.println("Resultado de " + cadenaPostfija + " = " + pila.peek());
        in.close();
    }

    public static boolean esOperando(char c) {
        int valorAscii = (int)c;
        return (valorAscii >= 65 && valorAscii <= 90);
    }

    public static int hacerOperacion(int operando1, int operando2, char operador) {
        switch(operador) {
            case '+':
                return operando1 + operando2;
            case '-':
                    return operando1 - operando2;
            case '*':
                return operando1 * operando2;
            case '/':
                return operando1 / operando2;
            case '^':
                return (int)Math.pow(operando1, operando2);
            default:
                return 0;                
        }
    }
}


class PilaOperandos {
    private int datos[];
    private int puntero;

    public PilaOperandos(int datos[]) {
        this.datos = datos;
        this.puntero = -1;
    }

    public void push(int dato) {
        if (datos.length > puntero + 1)
            datos[++puntero] = dato;
    }

    public int pop (){
        return (puntero >= 0) ? datos[puntero--] : 0;
    }

    public int peek() {
        return (puntero >= 0) ? datos[puntero] : 0;
    }

    public boolean isEmpty(){
        return (puntero == -1) ? true : false;
    }

    public String toString() {
        String returnString = "";
        for (int i = 0; i < datos.length; i++)
            returnString += datos[i];
        return returnString;
    }
}