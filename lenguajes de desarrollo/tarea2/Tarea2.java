package tarea2;

public class Tarea2 {
    public static void main(String[] args) {
        // int tiempoTotal = 43800;
        Contenedor contenedor1 = new Contenedor(24000);
        Contenedor contenedor2 = new Contenedor(32000);

        Cargar o_cargar = new Cargar(contenedor1, contenedor2);
        Vuelo o_vuelo1 = new Vuelo(contenedor1, 400, 3, contenedor2);
        Vuelo o_vuelo2 = new Vuelo(contenedor2, 800, 5, contenedor1);

        Thread h_cargar = new Thread(o_cargar);
        Thread h_vuelo1 = new Thread(o_vuelo1);
        Thread h_vuelo2 = new Thread(o_vuelo2);

        while(h_cargar.isAlive() || h_vuelo1.isAlive() || h_vuelo2.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex){
                System.out.println("Error de interrupción");
            }
        }

        System.out.printf("Veces que un tanque se quedó sin combustible y se tuvo que recurrir al otro: %d", (contenedor1.cambios + contenedor2.cambios));
        System.out.printf("Veces que no se pudo realizar el vuelo por no haber combustible: %d", (contenedor1.noRealizado + contenedor2.noRealizado));

    }
}
