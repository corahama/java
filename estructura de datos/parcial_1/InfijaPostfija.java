package parcial_1;
public class InfijaPostfija {
    public static void main(String[] args){
        String cadenaSalida = "";
        String cadenaEntrada;
        if (args.length != 0)
            cadenaEntrada = args[0];
        else
            cadenaEntrada = "(A+B)*(C+D)";

        PilaCaracteres pila = new PilaCaracteres(new char[cadenaEntrada.length()]);

        char c;
        for(int i = 0; i < cadenaEntrada.length(); i++){
            c = cadenaEntrada.charAt(i);
            switch(c) {
                case '(':
                    pila.push(c);
                    break;
                case ')':
                    while (pila.peek() != '(')
                        cadenaSalida += pila.pop();
                    pila.pop();
                    break;
                default:
                    if (esOperando(c))
                        cadenaSalida += c;
                    else if (esOperador(c)){
                        if (pila.isEmpty())
                            pila.push(c);
                        else {
                            while(mayorOIgualPrioridad(pila.peek(), c ))
                                cadenaSalida += pila.pop();
                            pila.push(c);
                        }
                    }
                    break;
            }
        }

        while (!pila.isEmpty())
            cadenaSalida += pila.pop();

        System.out.println(cadenaSalida);
    }

    public static boolean esOperando(char c) {
        int valorAscii = (int)c;
        return (valorAscii >= 65 && valorAscii <= 90);
    }

    public static boolean esOperador(char c) {
        return (c == '^' || c == '*' || c == '/' || c == '+' || c == '-');
    }

    public static boolean mayorOIgualPrioridad(char x, char y){
        return (obtenerPrioridad (x) >= obtenerPrioridad(y));
    }

    public static int obtenerPrioridad(char x) {
        if (x == '^')
            return 3;
        if (x == '/' || x == '*')
            return 2;
        if (x == '+' || x == '-')
            return 1;
        return -1;
    }
}


class PilaCaracteres {
    private char datos[];
    private int puntero;

    public PilaCaracteres(char datos[]) {
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