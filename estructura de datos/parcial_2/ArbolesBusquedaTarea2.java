package parcial_2;

public class ArbolesBusquedaTarea2 {
    public static void main(String[] args){
        NodoArbol numeros = new NodoArbol();
        numeros.dato = 43;

        insertar(numeros, 77);
        insertar(numeros, 23);
        insertar(numeros, 92);
        insertar(numeros, 55);
        insertar(numeros, 10);
        insertar(numeros, 24);
        insertar(numeros, 86);
        insertar(numeros, 15);
        insertar(numeros, 48);

        // Arbol de busqueda lleno
        NodoArbol eliminadoMayor = eliminarMayor(numeros);
        System.out.println(eliminadoMayor.dato);

        NodoArbol eliminadoMenor = eliminarMenor(numeros);
        System.out.println(eliminadoMenor.dato);

    }

    public static void insertar(NodoArbol n, int num){
        if (num == n.dato) {
            return;
        }
        else {
            if (num < n.dato) {
                //Si num es menor
                if (n.i != null) {
                    //Si tiene arbol izquierdo
                    insertar(n.i, num);
                }
                else {
                    //Si no tiene arbol izquierdo
                    //Crear un nuevo nodo (nuevo arbol), con el dato recibido
                    n.i = new NodoArbol();
                    n.i.dato = num;
                    return;
                }
            }
            else {
                //Si num es mayor
                //Completar en caso en el que el numero es mayor
                if (n.d != null) {
                    insertar(n.d, num);
                } else {
                    n.d = new NodoArbol();
                    n.d.dato = num;
                    return;
                }
            }
        }
    }

    public static NodoArbol eliminarMayor(NodoArbol n) {
        NodoArbol actual = n;
        NodoArbol anterior = null;
        while (actual.d != null) {
            anterior = actual;
            actual = actual.d;
        }
        // Actual apuntaria al anterior
        anterior.d = null;
        return actual;
    }

    public static NodoArbol eliminarMenor(NodoArbol n) {
        // Completar metodo eliminarMenor
        NodoArbol actual = n;
        NodoArbol anterior = null;
        while (actual.i != null) {
            anterior = actual;
            actual = actual.i;
        }
        anterior.i = null;
        return actual;
    }


    static class NodoArbol{
        public int dato;
        public NodoArbol i;
        public NodoArbol d;
    }
}
