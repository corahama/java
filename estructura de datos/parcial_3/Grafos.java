/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_3;

/**
 *
 * @author juan
 */
public class Grafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Grafo letras = new Grafo();
        
        
        letras.m = new int[10][10];
        letras.v = new String[10];
        
        insertarVertice(letras, "a");
        insertarVertice(letras, "b");
        insertarVertice(letras, "c");
        insertarVertice(letras, "d");
        
        insertarArista(letras, "a", "b", 1);
        insertarArista(letras, "b", "c", 1);
        insertarArista(letras, "b", "d", 4);
        insertarArista(letras, "c", "d", 1);
        insertarArista(letras, "d", "c", 3);
        
        
        
    }
    
    
    public static void insertarVertice(Grafo g, String a){
    
        boolean encontrado = false;
        for (int i = 0; i < g.numeroVertices && !encontrado; i++){
            if (g.v[i].equals(a)){
                encontrado = true;
            }
        }
        
        if (!encontrado){
            //Insertar vertice en arreglo de vertices
            int indiceA = g.numeroVertices;
            
            g.v[indiceA] = a;
            
            g.numeroVertices++;
            
            //Inicializar la matriz para el nuevo vertice
            for(int i = 0; i < g.numeroVertices;i++){
                g.m[indiceA][i] = 99999999;
            }
            
            for(int i = 0; i < g.numeroVertices;i++){
                g.m[i][indiceA] = 99999999;
            }
            
            
            
        }
        
    }
    
    public static void insertarArista(Grafo g, String v, String w, int valor){
        int indiceV = encontrarVertice(g, v);
        int indiceW = encontrarVertice(g, w);
        g.m[indiceV][indiceW] = valor;
    }

    public static int encontrarVertice(Grafo g, String v){ 
        for (int i = 0; i < g.numeroVertices; i++){
            if (g.v[i].equals(v)){
                return i;
            }
        }
        return -1;
    }
    
    
    public static void eliminarVertice(Grafo g, String v){
        //Práctica1: Tarea programar eliminarVertice
    }
    
    public static void eliminarArista(Grafo g, String v, String w){
        //Práctica1: Tarea programa eliminarArista
    }
    
    public static int[] dijkstra(Grafo g, String a){
        //Práctica 2: programa algoritmo de dijkstra
        int[] D = new int[g.numeroVertices];
        
        return D;
    }
    
    public static String[] restaVertices(String[] V, String[] S){
        int tamanio = V.length - S.length;
        String[] VmS = new String[tamanio];
        int x = 0;
        for (int i = 0; i < V.length; i++){
            boolean encontrado = false;
            for (int j = 0; j < S.length && !encontrado;i++){
                if (V[i].equals(S[j])){
                    encontrado = true;
                }
            }
            if (!encontrado){
                VmS[x] = V[i];
                x++;
            }
        }
        return VmS;
    }
    
    static class Grafo{
        public int[][] m;
        public String[] v;
        public int numeroVertices;
        
        
    }
    
    
}
