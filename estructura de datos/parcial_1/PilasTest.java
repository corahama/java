package parcial_1;
public class PilasTest {

    public static void main(String[] args) {

        Pila nuevaPila = new Pila();

        nuevaPila.datos = new int[20];
        nuevaPila.puntero = -1;

        push(nuevaPila, 88);
        push(nuevaPila, 102);
        push(nuevaPila, 44);

        int valor;

        valor = pop(nuevaPila); //44
        valor = pop(nuevaPila); //102

        push(nuevaPila, 78);
        push(nuevaPila, 99);


        valor = pop(nuevaPila); //88
        System.out.println(valor);
    }

    static class Pila {
        public int datos[];
        public int puntero;
    }

    public static void push (Pila PilaTemp , int dato){
        if (PilaTemp.datos.length > ++PilaTemp.puntero)
            PilaTemp.datos[PilaTemp.puntero] = dato;
        else
            --PilaTemp.puntero;
    }
    
    public static int pop (Pila PilaTemp){
        int elemento = 0;
        if (PilaTemp.puntero >= 0) {
            elemento = PilaTemp.datos[PilaTemp.puntero];
            PilaTemp.puntero -= 1;
        }
        return elemento;
    }
    
    public static int peek(Pila PilaTemp){
        int elemento = 0;
        if (PilaTemp.puntero >= 0)
            elemento = PilaTemp.datos[PilaTemp.puntero];
        return elemento;
    }
    
    public static boolean isEmpty(Pila PilaTemp){
        if (PilaTemp.puntero == -1)
            return true;
        return false;
    }
    
    
}
