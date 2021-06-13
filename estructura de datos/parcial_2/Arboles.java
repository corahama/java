/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_2;

/**
 *
 * @author juan
 */
public class Arboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear su propio árbol binario
        
        
        //Probar los 3 recorridos
        


        //Probar las tres búsquedas
        
        
        
        
        
    }
    
    
    
    public static void recorridoPreOrden(NodoArbol n){
        System.out.print(n.Dato);
        if (n.arbolIzq != null)
            recorridoPreOrden(n.arbolIzq);
        if (n.arbolDer != null)
            recorridoPreOrden(n.arbolDer);
    }
    
    public static void recorridoEnOrden(NodoArbol n){
        
    }
    
    public static void recorridoPostOrden(NodoArbol n){
        
    }
    
    public static NodoArbol buscarPreOrden(NodoArbol n, String busqueda){
        if (n.Dato.equals((busqueda))){
            return n;
        }
        if (n.arbolIzq != null){
            NodoArbol encontrado = buscarPreOrden(n.arbolIzq, busqueda);
            if (encontrado != null){
                return encontrado;
            }
        }   
        if (n.arbolDer != null){
            NodoArbol encontrado = buscarPreOrden(n.arbolDer, busqueda);
            if (encontrado != null){
                return encontrado;
            }
        }
        return null;
    }
    
    public static NodoArbol buscarEnOrden(NodoArbol n, String busqueda){
        return null;
    }
    
    public static NodoArbol buscarPostOrden(NodoArbol n, String busqueda){
        return null;
    }
    
    
    static class NodoArbol{
        String Dato;
        NodoArbol arbolIzq;
        NodoArbol arbolDer;
    }
 
    
    
    
    
}
