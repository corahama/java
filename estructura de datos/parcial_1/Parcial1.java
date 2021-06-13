package parcial_1;
public class Parcial1 {
    public static void main(String[] args) {
        // PRIMERO CREAMOS LA PILA INICIAL CON LOS DATOS PROVISTOS
        Pila pilaInicial = new Pila();
        pilaInicial.datos = new int[20];
        pilaInicial.puntero = -1;

        push(pilaInicial, 10);
        push(pilaInicial, 80);
        push(pilaInicial, 78);
        push(pilaInicial, 90);
        push(pilaInicial, 100);
        push(pilaInicial, 89);


        // INVERTIMOS LOS DATOS DE LA PILA INICIAL
        Pila pilaInvertida = new Pila();
        pilaInvertida.datos = new int[20];
        pilaInvertida.puntero = -1;
        while (!isEmpty(pilaInicial))
            push(pilaInvertida, pop(pilaInicial));

        
        // FILTRAMOS LOS DATOS MAYORES A 90
        Pila pilaFiltrada = new Pila();
        pilaFiltrada.datos = new int[20];
        pilaFiltrada.puntero = -1;
        while (!isEmpty(pilaInvertida)) {
            if (peek(pilaInvertida) < 90)
                push(pilaFiltrada, pop(pilaInvertida));
            else 
                pop(pilaInvertida);
        }


        // FINALMENTE IMPRIMIMOS LOS DATOS DE LA PILA FILTRADA
        while (!isEmpty(pilaFiltrada))
            System.out.println(pop(pilaFiltrada));

    }


    public static void push (Pila PilaTemp , int dato){
        PilaTemp.puntero = PilaTemp.puntero + 1;
        if (PilaTemp.datos.length > PilaTemp.puntero)
            PilaTemp.datos[PilaTemp.puntero] = dato;
        else
            PilaTemp.puntero = PilaTemp.puntero - 1;
    }
    
    public static int pop (Pila PilaTemp){
        int aux = 0;
        if (PilaTemp.puntero >= 0){
            aux = PilaTemp.datos[PilaTemp.puntero]; //Controlar, que mi puntero no sea < 0
            PilaTemp.puntero--;
        }
        return aux;
    }
    
    public static int peek(Pila PilaTemp){
        if (PilaTemp.puntero >= 0){
            return PilaTemp.datos[PilaTemp.puntero];
        }
        else{
            return 0;
        }   
    }
    
    public static boolean isEmpty(Pila PilaTemp){
        if (PilaTemp.puntero < 0){
            return true;
        }
        else{
            return false;
        }
    }
}

class Pila {
    public int[] datos;
    public int puntero;
}

