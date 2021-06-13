package parcial_2;

public class ArbolesEquilibradosTarea6 {
    public static void main(String[] args) {
        AVL arbolEquilibrado = new AVL();

        //Inserta los elementos del árbol a equilibrar
        arbolEquilibrado.insertar(50);
        arbolEquilibrado.insertar(70);
        arbolEquilibrado.insertar(40);
        arbolEquilibrado.insertar(45);
        arbolEquilibrado.insertar(80);
        arbolEquilibrado.insertar(65);
        arbolEquilibrado.insertar(67);
        arbolEquilibrado.insertar(30);
        arbolEquilibrado.insertar(37);
        arbolEquilibrado.insertar(20);
        arbolEquilibrado.insertar(35);
        arbolEquilibrado.insertar(69);
        arbolEquilibrado.insertar(60);
        arbolEquilibrado.insertar(66);
        arbolEquilibrado.insertar(62);
        arbolEquilibrado.inorder();
        System.out.println();
    }
}


class AVL {
    Nodo raiz;

    AVL() {
        raiz = null;
    }

    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }
    public Nodo insertarRec(Nodo nodo, int dato) {
        if (nodo == null) {
            return new Nodo(dato);
        }

        if (dato < nodo.dato) {
            nodo.i = insertarRec(nodo.i, dato);
        } else if (dato > nodo.dato) {
            nodo.d = insertarRec(nodo.d, dato);
        } else {
            return nodo;
        }

        // Actualizamos la altura del nodo actual y realizamos la 
        // rotación pertinente si el arbol se desequilibra
        nodo.altura = 1 + masGrande(altura(nodo.i), altura(nodo.d));

        int fe = altura(nodo.i) - altura(nodo.d);
        if (fe > 1) {
            if (dato < nodo.i.dato) {
                return rotacionII(nodo);
            } else if (dato > nodo.i.dato) {
                nodo.i = rotacionDD(nodo.i);
                return rotacionII(nodo);
            }
        }
        if (fe < -1) {
            if (dato > nodo.d.dato) {
                return rotacionDD(nodo);
            } else if (dato < nodo.d.dato) {
                nodo.d = rotacionII(nodo.d);
                return rotacionDD(nodo);
            }
        }
        return nodo;
    }

    public int altura(Nodo nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }

    public int masGrande(int i, int d) {
        return (i > d) ? i : d;
    }

    public Nodo rotacionDD(Nodo n) {
        Nodo n1 = n.d;
        Nodo aux = n1.i;
        n1.i = n;
        n.d = aux;
        n.altura = 1 + masGrande(altura(n.i), altura(n.d));
        n1.altura = 1 + masGrande(altura(n1.i), altura(n1.d));
        return n1;
    }
    
    public Nodo rotacionII(Nodo n) {
        Nodo n1 = n.i;
        Nodo aux = n1.d;
        n1.d = n;
        n.i = aux;
        n.altura = 1 + masGrande(altura(n.i), altura(n.d));
        n1.altura = 1 + masGrande(altura(n1.i), altura(n1.d));
        return n1;
    }

    // Recorrido inorder
    public void inorder() {
        inorderRec(raiz);
    }
    public void inorderRec(Nodo raiz) {
        if (raiz != null) {
            inorderRec(raiz.i);
            System.out.print(raiz.dato + " ");
            inorderRec(raiz.d);
        }
    }
}


class Nodo {
    public int dato;
    public Nodo i;
    public Nodo d;
    public int altura;

    Nodo(int dato) {
        this.dato = dato;
        this.altura = 1;
    }
}