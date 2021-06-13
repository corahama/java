package parcial_1;
public class ListaTest {
    public static void main(String[] args){
        Lista lista = new Lista("La amenaza fantasma");
        lista.insetarAlFinal("La guerra de los clones");
        lista.insetarAlFinal("La venganza del sith");
        lista.insertarAlInicio("La alta republica");
        lista.insetarAlFinal("Una nueva esperanza");
        lista.insertarDespuesDe("La venganza del sith", "Rogue One");
        lista.eliminarAlFinal();
        lista.eliminarAlFinal();
        lista.eliminarAlFinal();
        lista.eliminarAlFinal();
        lista.eliminarAlFinal();
        lista.eliminarAlFinal();
        System.out.println(lista);

        lista.insetarAlFinal("La amenaza fantasma");
        lista.insetarAlFinal("La guerra de los clones");
        lista.insetarAlFinal("La venganza del sith");
        lista.insetarAlFinal("Rogue One");
        lista.insetarAlFinal("Una nueva esperanza");
        System.out.println(lista);

        lista.eliminarDespuesDe("La venganza del sith");
        lista.eliminarAlInicio();
        lista.insertarAntesDe("La guerra de los clones", "La amenaza fantasma");
        lista.insetarAlFinal("Una nueva esperanza");
        lista.insertarAntesDe("Una nueva esperanza", "Rogue One");
        System.out.println(lista);
    }
}

class Lista {
    private String dato;
    private Lista siguiente;

    public Lista(String dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public void insertarAlInicio(String dato){
        if (dato == "")
            this.dato = dato;
        else {
            Lista auxiliar = new Lista(this.dato);
            auxiliar.siguiente = this.siguiente;
            this.dato = dato;
            siguiente = auxiliar;
        }
    }

    public void insertarAntesDe(String antes, String dato) {
        Lista anterior = null;
        Lista actual = this;
        while (!actual.dato.equals(antes)) {
            anterior = actual;
            actual = actual.siguiente;
        }
        if (anterior == null) {
            Lista auxiliar = new Lista(this.dato);
            auxiliar.siguiente = this.siguiente;
            this.dato = dato;
            siguiente = auxiliar;
        } else {
            Lista nuevo = new Lista(dato);
            nuevo.siguiente = anterior.siguiente;
            anterior.siguiente = nuevo;
        }
    }

    public void insertarDespuesDe(String despues, String dato) {
        Lista actual = this;
        while (!actual.dato.equals(despues))
            actual = actual.siguiente;
        Lista nuevo = new Lista(dato);
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
    }

    public void insetarAlFinal(String dato) {
        if (this.dato == "")
            this.dato = dato;
        else {
            Lista actual = this;
            while (actual.siguiente != null)
                actual = actual.siguiente;
            Lista nuevo = new Lista(dato);
            actual.siguiente = nuevo;
        }
    }

    public void eliminarAlInicio() {
        if (siguiente == null)
            this.dato = "";
        else {
            dato = siguiente.dato;
            siguiente = siguiente.siguiente;
        }
    }

    public void eliminarDespuesDe(String dato) {
        Lista actual = this;
        while (!actual.dato.equals(dato))
            actual = actual.siguiente;
        actual.siguiente = null;
    }

    public void eliminarAlFinal() {
        Lista anterior = null;
        Lista actual = this;
        while (actual.siguiente != null) {
            anterior = actual;
            actual = actual.siguiente;
        }
        if (anterior == null)
            dato = "";
        else
            anterior.siguiente = null;
    }

    public String toString() {
        if (dato == "")
            return "La lista esta vacia";
        else {
            String elementos = "";
            Lista actual = this;
            while (actual.siguiente != null) {
                elementos += (actual.dato + "->");
                actual = actual.siguiente;
            }
            elementos += (actual.dato);
            return elementos;
        }
    }
}