package parcial_3;

public class GrafosTarea2 {
    public static void main(String[] args) {        
        Grafo letras = new Grafo();

        letras.m = new int[10][10];
        letras.v = new String[10];

        insertarVertice(letras, "a");
        insertarVertice(letras, "b");
        insertarVertice(letras, "c");
        insertarVertice(letras, "d");

        insertarArista(letras, "a", "b", 3);
        insertarArista(letras, "b", "c", 1);
        insertarArista(letras, "b", "d", 4);
        insertarArista(letras, "c", "d", 1);
        insertarArista(letras, "d", "c", 3);
        insertarArista(letras, "d", "d", 7);
        insertarArista(letras, "a", "d", 5);

        eliminarVertice(letras, "c");
        eliminarArista(letras, "b", "d");
        eliminarArista(letras, "d", "d");

        System.out.println();

        int[] distancias = dijkstra(letras, "a");
        for (int i = 0; i < distancias.length; i++) {
            System.out.println(String.format("La distancia minima desde '%s' a '%s' es %s", 
                "a", letras.v[i], distancias[i]));
        }
    }


    public static void insertarVertice(Grafo g, String a) {
        boolean encontrado = false;
        for (int i = 0; i < g.numV && !encontrado; i++) {
            if (g.v[i].equals(a)){
                encontrado = true;
            }
        }
        
        if (!encontrado){
            //Insertar vertice en arreglo de vertices
            int indiceA = g.numV;
            g.v[indiceA] = a;
            g.numV++;

            //Inicializar la matriz para el nuevo vertice
            for(int i = 0; i < g.numV;i++) {
                g.m[indiceA][i] = 99999999;
            }

            for(int i = 0; i < g.numV;i++) {
                g.m[i][indiceA] = 99999999;
            }
        }
    }
    
    public static void insertarArista(Grafo g, String v, String w, int valor) {
        int indiceV = encontrarVertice(g, v);
        int indiceW = encontrarVertice(g, w);
        g.m[indiceV][indiceW] = valor;
    }

    public static int encontrarVertice(Grafo g, String v) { 
        for (int i = 0; i < g.numV; i++) {
            if (g.v[i].equals(v)){
                return i;
            }
        }
        return -1;
    }

    public static void eliminarVertice(Grafo g, String v) {
        //Práctica1: Tarea programar eliminarVertice
        int index = encontrarVertice(g, v) + 1;

        if (index == 0)
            return;

        // Eliminamos el vertice del arreglo de vertices
        for (int i = index; i < g.numV; i++) {
            g.v[i-1] = g.v[i];
        }
        g.v[g.numV-1] = null;

        // Eliminamos las aristas correspondientes al 
        // vertice eliminado de la matriz de aristas
        for (int i = index; i < g.numV; i++) {
            g.m[i-1] = g.m[i].clone();
        }
        for (int i = 0 ; i < g.numV; i++)
            g.m[g.numV-1][i] = 0;
        
        for (int i = 0; i < g.numV; i++) {
            for (int j = index; j < g.numV; j++) {
                g.m[i][j-1] = g.m[i][j];
            }
        }
        for (int i = 0; i < g.numV; i++) {
            g.m[i][g.numV-1] = 0;
        }

        g.numV--;
    }

    public static void eliminarArista(Grafo g, String v, String w) {
        //Práctica1: Tarea programa eliminarArista
        int indiceV = encontrarVertice(g, v);
        int indiceW = encontrarVertice(g, w);

        g.m[indiceV][indiceW] = 99999999;        
    }

    public static int[] dijkstra(Grafo g, String a) {
        //Práctica 2: programa algoritmo de dijkstra
        int longitud = g.numV;
        boolean[] nodosVisitados = new boolean[longitud];
        int[] distancias = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            nodosVisitados[i] = false;
            distancias[i] = 99999999;
        }
    
        // definimos como 0 la distancia a si mismo
        distancias[encontrarVertice(g, a)] = 0;
        for (int i = 0; i < longitud; i++) {
    
            // Actualizar la distancia entre el vértice vecino y el vértice de origen
            int u = minDistancia(distancias, nodosVisitados);
            nodosVisitados[u] = true;
        
            // actualizamos todas las distancias de los nodos vecinos
            for (int v = 0; v < longitud; v++) {
                if (!nodosVisitados[v] && g.m[u][v] != 0 && (distancias[u] + g.m[u][v] < distancias[v])) {
                    distancias[v] = distancias[u] + g.m[u][v];
                }
            }
        }

        return distancias;
    }

    // funcion para encontrar la minima distancia
    private static int minDistancia(int[] distancias, boolean[] nodosVisiados) {
        int minDist = 99999999;
        int minDistNodo = -1;
        for (int i = 0; i < distancias.length; i++) {
            if (!nodosVisiados[i] && distancias[i] < minDist) {
                minDist = distancias[i];
                minDistNodo = i;
            }
        }
        return minDistNodo;
    }
    

    public static String[] restaVertices(String[] V, String[] S) {
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

    static class Grafo {
        public int[][] m;
        public String[] v;
        public int numV;
    }

}
