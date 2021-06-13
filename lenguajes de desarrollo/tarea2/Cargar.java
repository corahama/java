package tarea2;

public class Cargar implements Runnable {
    Contenedor contenedor1, contenedor2;

    public Cargar(Contenedor contenedor1, Contenedor contenedor2) {
        this.contenedor1 = contenedor1;
        this.contenedor2 = contenedor2;
    }

    @Override
    public void run() {
        for (int tiempo = 0; tiempo < 43800; tiempo += 24) {
            contenedor1.cargar(3600);
            contenedor2.cargar(3600);
            try {
                Thread.sleep(24);
            } catch (InterruptedException e) {
                System.out.println("Error de interrupción");
            }
        }
    }
}
