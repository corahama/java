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
public class ArbolesBusqueda {
 
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
        
        
        //Arbol de busqueda lleno
        //NodoArbol eliminado = eliminarMayor(numeros);
        
        //NodoArbol[] buscado = buscarPadre(numeros, 5);
        
        eliminar(numeros, 77);
        
        System.out.println("");
        //System.out.println(buscado[1].dato);
        
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
        //Completar metodo eliminarMenor
        
        return null;
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
        //Programar
        
        return null;
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
                    NodoArbol mayorIzquierdo = eliminarMayorDeHijoIzquierdo(eliminar);
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
    
    
    static class NodoArbol{
        public int dato;
        public NodoArbol i;
        public NodoArbol d;
    }
    
}
