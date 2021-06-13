package parcial_2;

public class ArbolesBusquedaTarea3 { 
    public static void main(String[] args) {
        NodoArbol numeros = new NodoArbol();
        numeros.dato = 15;

        insertar(numeros, 7);
        insertar(numeros, 22);
        insertar(numeros, 3);
        insertar(numeros, 10);
        insertar(numeros, 1);
        insertar(numeros, 5);
        insertar(numeros, 8);
        insertar(numeros, 13);
        insertar(numeros, 9);
        insertar(numeros, 18);
        insertar(numeros, 17);
        insertar(numeros, 20);
        insertar(numeros, 23);
        insertar(numeros, 24);

        inorder(numeros);
        System.out.println();
        eliminar(numeros, 7);
        inorder(numeros);
        System.out.println();

    }

    public static void insertar(NodoArbol n, int num){
        if (num == n.dato){
            return;
        }
        else{
            if (num < n.dato){
                //Si num es menor
                if (n.i != null){
                    //Si tiene arbol izquierdo
                    insertar(n.i, num);
                }
                else{
                    //Si no tiene arbol izquierdo
                    //Crear un nuevo nodo (nuevo arbol), con el dato recibido
                    n.i = new NodoArbol();
                    n.i.dato = num;
                    return;
                }
            }
            else{
                //Si num es mayor
                //Completar en caso en el que el numero es mayor
                if (n.d != null){
                    //Si tiene arbol izquierdo
                    insertar(n.d, num);
                }
                else{
                    //Si no tiene arbol izquierdo
                    //Crear un nuevo nodo (nuevo arbol), con el dato recibido
                    n.d = new NodoArbol();
                    n.d.dato = num;
                    return;
                }
            }
            
        }
    } 

    public static NodoArbol buscar(NodoArbol n, int dato){
        if (n.dato == dato){
            return n;
        }
        else{
            if (dato < n.dato){
                if (n.i != null){
                    return buscar(n.i, dato);
                }
                else{
                    return null;
                }
            }
            else{
                if (n.d != null){
                    return buscar(n.d, dato);
                }
                else{
                    return null;
                }
            }
        }
    }

    public static NodoArbol[] buscarPadre(NodoArbol n, int dato){
        if (n.dato == dato){
            NodoArbol[] nodos = new NodoArbol[2];
            nodos[0] = null;
            nodos[1] = n;
            return nodos;
        }
        if (n.i != null && n.i.dato == dato){
            NodoArbol[] nodos = new NodoArbol[2];
            nodos[0] = n;
            nodos[1] = n.i;
            return nodos;
        }
        if (n.d != null && n.d.dato == dato){
            NodoArbol[] nodos = new NodoArbol[2];
            nodos[0] = n;
            nodos[1] = n.d;
            return nodos;
        }
        if (dato < n.dato){
            if (n.i != null){
                return buscarPadre(n.i, dato);
            }
            else{
                return null;
            }
        }
        else{
            if (n.d != null){
                return buscarPadre(n.d, dato);
            }
            else{
                return null;
            }
        }

    }
    
    public static NodoArbol eliminarMayor(NodoArbol n){
        NodoArbol actual = n;
        NodoArbol anterior = null;
        while(actual.d != null){
            anterior = actual;
            actual = actual.d;
        }
        //Actual apuntaria al anterior
        anterior.d = actual.i;
        return actual;
    }

    public static NodoArbol eliminarMenor(NodoArbol n){
        NodoArbol actual = n;
        NodoArbol anterior = null;
        while (actual.i != null) {
            anterior = actual;
            actual = actual.i;
        }
        anterior.i = null;
        return actual;
    }

    public static NodoArbol eliminarMayorDeHijoIzquierdo(NodoArbol n) {
        NodoArbol actual = null;
        NodoArbol anterior = null;

        NodoArbol hijoIzquierdo = n.i;

        if (hijoIzquierdo.d == null){
            n.i = hijoIzquierdo.i;
            return hijoIzquierdo;
        }
        else{
            actual = n.i;
            anterior = null;
            while(actual.d != null){
                anterior = actual;
                actual = actual.d;
            }
            //Actual apuntaria al anterior
            anterior.d = actual.i;
            return actual;
        }
    }
    
    public static NodoArbol eliminarMenorDeHijoDerecho(NodoArbol n){
        NodoArbol actual = null;
        NodoArbol anterior = null;

        NodoArbol hijoDerecho = n.d;

        if (hijoDerecho.i == null){
            n.d = hijoDerecho.d;
            return hijoDerecho;
        }
        else{
            actual = n.d;
            anterior = null;
            while(actual.i != null){
                anterior = actual;
                actual = actual.i;
            }
            //Actual apuntaria al anterior
            anterior.i = actual.d;
            return actual;
        }
    }


    public static void eliminar(NodoArbol n, int dato) {

        NodoArbol[] nodos = buscarPadre(n, dato);

        NodoArbol padre = nodos[0];
        NodoArbol eliminar = nodos[1];

        if (eliminar.i == null && eliminar.d == null){
            //Si no tiene hijos
            if (padre.i == eliminar){
                padre.i = null;
            }
            else{
                padre.d = null;
            }
        }
        else{
            if (eliminar.i != null && eliminar.d == null){
                //Solo tiene hijo ... izquierdo
                if (padre.i == eliminar){
                    padre.i = eliminar.i;
                }
                else{
                    padre.d = eliminar.i;
                }
            }
            else{
                if (eliminar.i == null && eliminar.d != null){
                    //Solo tiene hijo ... derecho
                    if (padre.i == eliminar){
                        padre.i = eliminar.d;
                    }
                    else{
                        padre.d = eliminar.d;
                    }
                }
                else{
                    //Tiene sus dos hijos
                    NodoArbol mayorIzquierdo = eliminarMenorDeHijoDerecho(eliminar);
                    mayorIzquierdo.i = eliminar.i;
                    mayorIzquierdo.d = eliminar.d;
                    if (padre.i == eliminar){
                        padre.i = mayorIzquierdo;
                    }
                    else{
                        padre.d = mayorIzquierdo;
                    }
                    
                }
            }
            
        }
    }

    // Recorrido inorder
    public static void inorder(NodoArbol root) {
        if (root != null) {
            inorder(root.i);
            System.out.print(root.dato + " - ");
            inorder(root.d);
        }
    }

    static class NodoArbol{
        public int dato;
        public NodoArbol i;
        public NodoArbol d;
    }

}
