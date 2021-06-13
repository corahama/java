package parcial_1;

public class Ejercicio10 {
    public static void main(String[] args) {
        String cadenaEntrada = "(a+b)*{[2-X]/[Z]^(324)}+2";
        System.out.println(evaluar(cadenaEntrada) ? "La expesión matematica esta balanceada": "La expresipon matematica NO esta balanceada");
    }

    private static boolean evaluar(String cadenaEntrada) {
        PilaCaracteresOrd pilaCaracteres = new PilaCaracteresOrd(new char[cadenaEntrada.length()]);

        char c;
        for(int i = 0; i < cadenaEntrada.length(); i++){
            c = cadenaEntrada.charAt(i);
            switch(c) {
                case '(':
                    pilaCaracteres.push('(');
                    break;
                case ')':
                    if (pilaCaracteres.peek() == '(')
                        pilaCaracteres.pop();
                    else
                        return false;
                    break;
                case '[':
                    pilaCaracteres.push('[');
                    break;
                case ']':
                    if (pilaCaracteres.peek() == '[')
                        pilaCaracteres.pop();
                    else
                        return false;
                    break;
                case '{':
                    pilaCaracteres.push('{');
                    break;
                case '}':
                    if (pilaCaracteres.peek() == '{')
                        pilaCaracteres.pop();
                    else
                        return false;
                    break;
                default:
                    break;
            }
        }

        if (!pilaCaracteres.isEmpty())
            return false;
        else
            return true;
    }
}


class PilaCaracteresOrd {
    private char datos[];
    private int puntero;

    public PilaCaracteresOrd(char datos[]) {
        this.datos = datos;
        this.puntero = -1;
    }

    public void push(char dato) {
        if (datos.length > puntero + 1)
            datos[++puntero] = dato;
    }

    public char pop (){
        return (puntero >= 0) ? datos[puntero--] : 0;
    }

    public char peek() {
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