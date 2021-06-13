package parcial_1;
public class Filas {    
    public static void main(String[] args) {
        Fila miFila = new Fila();

        miFila.datos = new int[5];
        miFila.frente = -1;
        miFila.fin = -1;

        add(miFila, 10);
        add(miFila, 20);
        add(miFila, 30);
        add(miFila, 40);
        add(miFila, 50);
        add(miFila, 60);
        System.out.print("Arreglo despues de agregar elementos: ");
        imprimirFila(miFila);

        System.out.println(peek(miFila));
        remove(miFila);
        System.out.println(peek(miFila));
        remove(miFila);
        System.out.println(peek(miFila));
        remove(miFila);
        System.out.println(peek(miFila));
        remove(miFila);
        System.out.println(peek(miFila));
        remove(miFila);
        System.out.println(peek(miFila));

        imprimirFila(miFila);
    }

    static class Fila {
        public int[] datos;
        public int frente;
        public int fin;
    }

    public static void add(Fila f, int elemento) {
        if (f.fin + 1 < f.datos.length)
            f.datos[++f.fin] = elemento;
        else
            System.out.println("Elemento no insertado: " + elemento);
    }

    public static int remove(Fila f) {
        return (f.frente < f.fin) ? f.datos[++f.frente] : -1;
    }

    public static int peek(Fila f) {
        return (!isEmpty(f)) ? f.datos[f.frente + 1] : -1;
    }

    public static boolean isEmpty(Fila f) {
        return (f.frente == f.fin) ? true : false;
    }

    public static void imprimirFila(Fila f) {
        if (f.frente == f.fin)
            System.out.println("Fila vacia");
        else {
            for (int i = f.frente + 1; i <= f.fin; i++)
                System.out.printf("%d ", f.datos[i]);
        }
        System.out.println("");
    }
}