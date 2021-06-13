package parcial_1;
/**
 *
 * @author juan
 */
public class EjercicioLista {
    
    public static void main(String[] args){
    
    
        Nodo miListaPeliculas = new Nodo();
        
        miListaPeliculas.dato = "La amenaza fantasma";
        
        
        InsertarAlFinal(miListaPeliculas, "El ataque de los clones");
        InsertarAlFinal(miListaPeliculas, "La venganza del Sith");
        
        
        /*
        Procedimiento para insertar al inicio
        */
        
        Nodo precuela = new Nodo();
        precuela.dato = "Las aventuras de Obi-Wan, el adolescente";
        Nodo aux = null;
        
        aux = miListaPeliculas;
        miListaPeliculas = precuela;
        miListaPeliculas.referencia = aux;
       
        //Método para insertar al inicio
        miListaPeliculas = InsertarAlInicio(miListaPeliculas, "Las aventuras de baby Yoda");
        
        
        InsertarAlFinal(miListaPeliculas, "Una nueva esperanza");
        InsertarDespuesDe(miListaPeliculas, "La venganza del Sith", "Rogue One");
        
        
        //InsertarAntesDe(miListaPeliculas, "El ataque de los clones", "Han Solo");
        
        
        EliminarAlFinal(miListaPeliculas);
        
        System.out.println("Impresión inicial: ");
        ImprimirLista(miListaPeliculas);
        
        
        
        Nodo encontrado = buscar(miListaPeliculas, "El ataque de los clones");
        
        System.out.println("El nodo encontrado es: " + encontrado.dato);
        
        encontrado.dato = "El ataque de las malas actuaciones";
        
        System.out.println("Despues de la modificación: ");
        ImprimirLista(miListaPeliculas);
        
        
        miListaPeliculas = EliminarAlInicio(miListaPeliculas);
        
        
        System.out.println("Despues de eliminar al inicio: ");
        ImprimirLista(miListaPeliculas);
    }
    
    /*
    public static void InsertarAlInicio(Nodo n, String dato){
        Nodo anterior = new Nodo();
        anterior.dato = dato;
        
        Nodo aux = null;
        aux = n;
        n = anterior;
        n.referencia = aux;
    }
    */
    
    
    
    
    public static void EliminarDespuesDe(Nodo n, String despues){
        //Tarea
        
    }
    
    public static void EliminarAlFinal(Nodo n){
        Nodo anterior = null;
        Nodo actual = n;
        
        while(actual.referencia != null){
            anterior = actual;
            actual = actual.referencia;
        }
        
        if (anterior != null){
            anterior.referencia = null;
        }
        
    }
    
    public static Nodo EliminarAlInicio(Nodo n){
        return n.referencia;
    }
    
    public static void ImprimirLista(Nodo n){
        //Tarea
        Nodo actual = n;
        while(actual.referencia != null){
            System.out.println(actual.dato);
            actual = actual.referencia;
        }
        //actual estaría en el último elemento
        System.out.println(actual.dato);
    }
    
    
    public static Nodo InsertarAlInicio(Nodo n, String dato){
        Nodo anterior = new Nodo();
        anterior.dato = dato;
        anterior.referencia = n;
        
        return anterior;
    }
    
    public static void InsertarAntesDe(Nodo n, String antes, String dato){
        //Tarea
        
    }
    
    public static void InsertarDespuesDe(Nodo n, String despues, String dato){
        Nodo actual = n;
        
        while (actual.referencia != null && actual.dato.equals(despues) == false){
            actual = actual.referencia;
        }
        
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        
        Nodo aux = actual.referencia;
        
        actual.referencia = nuevo;
        nuevo.referencia = aux;
    
    }
    
    public static void InsertarAlFinal(Nodo n, String dato){
        //Variable para ir recorriendo la lista
        Nodo actual = n;
        
        
        //Mientras el nodo a revisar no tenga un nodo siguiente
        while(actual.referencia != null){
            //Moverse al siguiente nodo
            actual = actual.referencia;
        }
        
        //Una vez que llegamos al final de la lista
        //Creamos un nuevo nodo, con el dato que recibimos
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        
        //Agregamos el nodo nuevo, al último nodo
        actual.referencia = nuevo;
    }
    
    
    
    public static Nodo buscar(Nodo n, String aBuscar){
        Nodo actual = n;
        Nodo encontrado = null;
        while(actual != null){
            if (actual.dato.equals(aBuscar) ){
                encontrado = actual;
                break;
            }
            actual = actual.referencia;
        }
        return encontrado;
    }
    
    
}


class Nodo{
    public String dato;
    public Nodo referencia;
}