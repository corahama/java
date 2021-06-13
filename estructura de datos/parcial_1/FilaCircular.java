package parcial_1;
public class FilaCircular {
    public static void main(String[] args) {    
        Fila miFila = new Fila();

        miFila.datos = new int[5];
        miFila.frente = -1;
        miFila.fin = -1;

        System.out.println("¿La fila esta vacia?: " + isEmpty(miFila));
        System.out.println("Agregando el 2 " + add(miFila, 2));
        System.out.println("Agregando el 4 " + add(miFila, 4));
        System.out.println("Agregando el 8 " + add(miFila, 8));
        System.out.println("Agregando el 6 " + add(miFila, 6));
        System.out.println("Agregando el 10 " + add(miFila, 10));
        System.out.println("Agregando el 9 " + add(miFila, 9));
        System.out.printf("Fila: %s\n\n", imprimirFila(miFila));

        System.out.println("Sale el: " + remove(miFila));
        System.out.println("Sigue el: " + peek(miFila));
        System.out.println("Agregando el 9 otra vez: " + add(miFila, 9));
        System.out.println("Sale el: " + remove(miFila));
        System.out.println("Agregando el 9 tercera vez: " + add(miFila, 9));
        System.out.println("Sale el: " + remove(miFila));
        System.out.println("Sale el: " + remove(miFila));
        System.out.println("¿La fila esta vacia?: " + isEmpty(miFila));
        System.out.printf("Fila: %s\n\n", imprimirFila(miFila));

        System.out.println("Agregando el 11 " + add(miFila, 11));
        System.out.println("Agregando el 88 " + add(miFila, 88));
        System.out.println("Agregando el 92 " + add(miFila, 92));
        System.out.printf("Fila: %s\n", imprimirFila(miFila));
        System.out.println("Sale el: " + remove(miFila));
        System.out.println("Sale el: " + remove(miFila));
        System.out.printf("Fila: %s\n", imprimirFila(miFila));
        System.out.println("Sale el: " + remove(miFila));
        System.out.println("¿La fila esta vacia?: " + isEmpty(miFila));
        System.out.println("Sigue el: " + peek(miFila));
        System.out.println("Sale el: " + remove(miFila));
        System.out.printf("Fila: %s\n", imprimirFila(miFila));
    }

    static class Fila{
        private int[] datos;
        private int frente;
        private int fin;
    }

    public static boolean add(Fila f, int elemento) {
        if ((f.fin + 1) != f.frente) {
            if ((f.fin + 1) < f.datos.length)
                f.fin++;
            else {
                if (f.frente > 0)
                    f.fin = 0;
                else 
                    return false;
            }
            f.datos[f.fin] = elemento;
            return true;
        }
        return false;
    }

    public static int remove(Fila f) {
        if (f.frente > f.fin) {
            if (f.frente + 1 < f.datos.length) {
                return f.datos[++f.frente];
            } else {
                f.frente = 0;
                return f.datos[f.frente];
            }
        } else if (f.frente < f.fin) {
            return f.datos[++f.frente];
        } else {
            return -1;
        }
    }

    public static int peek(Fila f) {
        return (f.fin != f.frente) ? f.datos[f.frente + 1] : -1;
    }

    public static boolean isEmpty(Fila f) {
        return f.fin == f.frente;
    }

    public static String imprimirFila(Fila f) {
        String output = "";
        if (f.frente == f.fin)
            output = "Fila vacia";
        else {
            for (int i = f.frente + 1; i <= ((f.fin > f.frente) ? f.fin : f.datos.length + f.fin ); i++)
                output += String.format("%d ", f.datos[i%f.datos.length], i);
        }
        return output;
    }
}