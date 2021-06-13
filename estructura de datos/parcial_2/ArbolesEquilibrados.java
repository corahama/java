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
public class ArbolesEquilibrados {
 
    public static void main(String[] args){
    
        
            
        NodoArbol arbolEquilibrado = new NodoArbol();

        arbolEquilibrado.dato = 0;
       
        
        //Inserta los elementos del árbol a equilibrar
        

    }
            
    
    
    public static String insertarEq(NodoArbol a, int dato){
        
        if (dato < a.dato){
            if (a.i == null){
                NodoArbol n = new NodoArbol();
                n.fe = 0;
                n.dato = dato;
                a.i = n;
                return "I";
            }
            else{
                
                String h =  insertarEq(a.i, dato);
                //Si el árbol fue equilibrado previamente, ya no hacer nada
                if (h.equals("e")){
                    return "e";
                }
                
                String r = "I" + h;
                //Recalcular el factor de equilibrio
                calcularFE(a.i);
                
                if (a.i.fe < -1 || a.i.fe > 1){
                    //Rotacion
                    String ruta = h.substring(0, 2);
                    switch(ruta){
                        case "II":
                            rotacionII(a, a.i, a.i.i);
                            break;
                        case "DD":
                            rotacionDD(a, a.i, a.i.d);
                            break;
                        case "ID":
                            rotacionID(a, a.i, a.i.i);
                            break;
                        case "DI":
                            rotacionDI(a, a.i, a.i.d);
                            break;
                    }
                    
                    return "e";
                }
                
                return r;
            }
            
        }
        else if (dato > a.dato){
            if (a.d == null){
                //Completa esta parte en donde se inserta el nodo en la rama derecha
                //Nota que al return le falta la letra que debe regresar.
                return "";
            }
            else{
                String h = insertarEq(a.d, dato);
                //Si el árbol fue equilibrado previamente, ya no hacer nada
                if (h.equals("e")){
                    return "e";
                }
                
                String r = "D" + h;
                calcularFE(a.d);
                
                
                if (a.d.fe < -1 || a.d.fe > 1){
                    String ruta = h.substring(0, 2);
                    switch(ruta){
                        case "II":
                            rotacionII(a, a.d, a.d.i);
                            break;
                        case "DD":
                            rotacionDD(a, a.d, a.d.d);
                            break;
                        case "ID":
                            rotacionID(a, a.d, a.d.i);
                            break;
                        case "DI":
                            rotacionDI(a, a.d, a.d.d);
                            break;
                    }
                    return "e";
                }
                
                return r;
            }
            
            
        }
        else{
            return "";
        }
        
    
    }
    
    
    public static void rotacionII(NodoArbol padre, NodoArbol n, NodoArbol n1){
        //Completar
    }
    
    public static void rotacionDD(NodoArbol padre, NodoArbol n, NodoArbol n1){
        n.d = n1.i;
        n1.i = n;
        if (padre.i == n){
            padre.i = n1;
        }
        else{
            padre.d = n1;
        }
        calcularFE(n);
        calcularFE(n1);
    }

    public static void rotacionID(NodoArbol padre, NodoArbol n, NodoArbol n1){
        //Completar
    }
    
    public static void rotacionDI(NodoArbol padre, NodoArbol n, NodoArbol n1){
        NodoArbol n2 = n1.i;
        
        n1.i = n2.d; 
        n2.d = n1; 
        n.d = n2.i; 
        n2.i = n; 
        
        if (padre.i == n){
            padre.i = n2;
        }
        else{
            padre.d = n2;
        }

        calcularFE(n);
        calcularFE(n1);
        calcularFE(n2);
    }
    
    
    
    public static void calcularFE(NodoArbol n){
        int alturaizq = 0;
        int alturader = 0;
        if (n.i != null)
            alturaizq = altura(n.i);
        if (n.d != null)
            alturader = altura(n.d);
        n.fe = alturaizq - alturader;
    }
    
    public static int altura(NodoArbol n){
        int alturaizq = 0;
        int alturader = 0;
        int altura;
        if (n.i != null){
            alturaizq = altura(n.i);
        }
        if (n.d != null){
            alturader = altura(n.d);
        }
        if (alturaizq > alturader){
            altura = alturaizq;
        }
        else{
            altura = alturader;
        }
        return altura + 1;
    }
    
    
    static class NodoArbol{
        public int dato;
        public NodoArbol i;
        public NodoArbol d;
        public int fe;
    }
}