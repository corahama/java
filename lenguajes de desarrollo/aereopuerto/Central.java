package proyecto1;

import java.util.Random;

public class Central {
    private int ocupacion, capacidad;
    private Random rand;

    public Central(int capacidad) {
        ocupacion = 0;
        this.capacidad = capacidad ;
        rand = new Random();
    }

    public synchronized void depositarPersonas(int cantidad) {
        if (ocupacion + cantidad < capacidad)
            ocupacion += cantidad;
    }

    public synchronized int salidaPersonas() {
        float probabilidad = rand.nextFloat();
        if (probabilidad >= .60) {
            ocupacion -= 3;
            return 3;
        } else if (probabilidad >= .30 && probabilidad < .60) {
            ocupacion -= 2;
            return 2;
        } else if (probabilidad < .30) {
            ocupacion -= 1;
            return 1;
        } else {
            return 0;
        }
    }

    public synchronized int obtenerOcupacion() {
        return ocupacion;
    }

    @Override
    public String toString() {
        return String.format("ocupacion: %d", ocupacion);
    }

}
