package fig_geom;

// import fig_geom.Circulo;
// import fig_geom.Cuadrado;
// import fig_geom.Figura;
// import fig_geom.OrdenamientoArea;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class PrincipalFigura {
    public static void main(String[] args) {
        // Estructuras de Datos: son elementos que nos permiten manejar 
        // la memoria de manerá dinámica, lo que implica que se pueden 
        // agregar, modificar o eliminar el tamaño de dichas estructuras 
        // en tiempo ejecución.

        // Listas (List)
        // - Enlazadas (LinkedList)
        // - Doblemente Enlazadas
        // - Pilas
        // - Colas
        // Mapas
        // Arboles
        // - Binarios
        // -- AVL
        // - B+

        LinkedList<Figura> llfigura = new LinkedList<>();
        // Circulo elemento = new Circulo(5f);
        // llfigura.add(new Circulo(4f));
        llfigura.add(new Cuadrado(3f));
        // llfigura.add(elemento);

        for(Figura tfigura: llfigura) {
            tfigura.calArea();
            tfigura.calPerimetro();
            System.out.println(tfigura);
        }

        Collections.sort(llfigura, new OrdenamientoArea().reversed());
        System.out.println("--------------------");
        for(Figura tfigura: llfigura)
            System.out.println(tfigura);

        Collections.sort(llfigura);
        System.out.println("--------------------");
        for(Figura tfigura: llfigura)
            System.out.println(tfigura);

        Figura afigura[] = new Figura[3];
        // afigura[0] = new Circulo(5f);
        // afigura[1] = new Circulo(1f);
        afigura[2] = new Cuadrado(2f);

        System.out.println("--------------------");
        for (Figura tfigura: afigura) {
            tfigura.calArea();
            tfigura.calPerimetro();
        }

        Arrays.sort(afigura);
        for (Figura tfigura: afigura)
            System.out.println(tfigura);

    }
}