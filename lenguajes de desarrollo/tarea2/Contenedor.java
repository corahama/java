package tarea2;

public class Contenedor {
    int litros = 0;
    float carga = 0;
    int cambios = 0;
    int noRealizado = 0;

    public Contenedor(int litros) {
        this.litros = litros;
        this.carga = litros/2;
    }

    public synchronized void cargar(int cantidad) {
        carga += cantidad;
    }

    public synchronized boolean consumir(int cantidad) {
        if (carga >= cantidad) {
            carga -= cantidad;
            return true;
        } else {
            return false;
        }

    }
}