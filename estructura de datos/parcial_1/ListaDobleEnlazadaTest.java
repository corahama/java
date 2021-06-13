package parcial_1;
public class ListaDobleEnlazadaTest {
    public static void main(String[] args) {
        ListaDobleEnlazada equipos = new ListaDobleEnlazada("Monterrey");
                
        equipos.insertarAlFinal("León");
        equipos.insertarAlFinal("Cruz Azul");
        equipos.insertarAlFinal("América");
        
        equipos.eliminarElemento("León");
        
        equipos.insertarAlInicio("Pumas");
        equipos.insertarAlInicio("Tigres");
        equipos.insertarAlInicio("Chivas");
        equipos.insertarAlInicio("Puebla");
        System.out.println(equipos.imprimirHaciaAdelante());
        
        equipos.buscar("América");

        equipos.eliminarElementos("Tigres", "Monterrey");
        System.out.println(equipos.imprimirHaciaAdelante());

        equipos.eliminarAlFinal();
        System.out.println(equipos.imprimirHaciaAtras());
    }
}

class ListaDobleEnlazada {
    private String dato;
    private ListaDobleEnlazada anterior;
    private ListaDobleEnlazada siguiente;

    public ListaDobleEnlazada(String dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }

    public void insertarAlInicio(String dato) {
        if (this.dato == "")
            this.dato = dato;
        else {
            ListaDobleEnlazada auxiliar = new ListaDobleEnlazada(this.dato);
            auxiliar.siguiente = siguiente;
            auxiliar.anterior = this;
            siguiente.anterior = auxiliar;
            this.dato = dato;
            siguiente = auxiliar;
        }
    }

    public void insertarAlFinal(String dato) {
        if (this.dato == "")
            this.dato = dato;
        else {
            ListaDobleEnlazada actual = this;
            while (actual.siguiente != null)
                actual = actual.siguiente;
            ListaDobleEnlazada nuevo = new ListaDobleEnlazada(dato);
            nuevo.anterior = actual;
            actual.siguiente = nuevo;
        }
    }

    public void buscar(String dato) {
        ListaDobleEnlazada actual = this;
        int counter = 1;
        while (!actual.dato.equals(dato)) {
            actual = actual.siguiente;
            counter++;
        }
        System.out.printf("Elemento \'%s\' encontrado en la posición [%d]\n", dato, counter);
    }

    public void eliminarElemento(String dato) {
        ListaDobleEnlazada actual = this;
        while (!actual.dato.equals(dato))
            actual = actual.siguiente;
        if (actual.anterior == null) {
            actual.dato = actual.siguiente.dato;
            actual.siguiente = actual.siguiente.siguiente;
            if (actual.siguiente.siguiente != null)
                actual.siguiente.siguiente.anterior = actual;
        } else if (actual.siguiente == null) {
            actual.anterior.siguiente = null;
        } else {
            actual.siguiente.anterior = actual.anterior;
            actual.anterior.siguiente = actual.siguiente;
        }
    }

    public void eliminarElementos(String eInicial, String eFinal) {
        ListaDobleEnlazada actual = this;
        while (!actual.dato.equals(eInicial))
            actual = actual.siguiente;
        ListaDobleEnlazada cInicial = actual;

        while (!actual.dato.equals(eFinal))
            actual = actual.siguiente;
        ListaDobleEnlazada cFinal = actual;

        cInicial.anterior.siguiente = cFinal.siguiente;
        cFinal.siguiente.anterior = cInicial.anterior;
    }

    public void eliminarAlFinal() {
        if (siguiente == null)
            dato = "";
        else {
            ListaDobleEnlazada actual = this;
            while (actual.siguiente != null)
                actual = actual.siguiente;
            actual.anterior.siguiente = null;
        }
    }

    public String imprimirHaciaAdelante() {
        if (dato == "")
            return "La lista doble esta vacia";
        else {
            String elementos = "";
            ListaDobleEnlazada actual = this;
            while (actual.siguiente != null) {
                elementos += (actual.dato + " -> ");
                actual = actual.siguiente;
            }
            elementos += actual.dato;
            return elementos;            
        }
    }

    public String imprimirHaciaAtras() {
        if (dato == "")
            return "La lista doble esta vacia";
        else {
            ListaDobleEnlazada actual = this;
            
            while (actual.siguiente != null)
                actual = actual.siguiente;
            
            String elementos = "";
            while  (actual.anterior != null) {
                elementos += (actual.dato + " -> ");
                actual = actual.anterior;
            }
            elementos += actual.dato;

            return elementos;
        }
    }
}