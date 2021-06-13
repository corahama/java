package proyecto1;

import java.util.Random;

public class Aereopuerto {
    private int destinoNorte, destinoSur, capacidad;
    private Random rand;

    public Aereopuerto() {
        destinoNorte = 0;
        destinoSur = 0;
        capacidad = 700;
        rand = new Random();
    }

    public synchronized void depositarPersonas() {
        if (destinoNorte + destinoSur + 1 < capacidad) {
            if (rand.nextFloat() > .35)
                destinoNorte++;
            else
                destinoSur++;
        }
    }

    public synchronized int trasladarPersonas(String nombreCentral) {
        switch (nombreCentral) {
            case "Norte":
                destinoNorte -= 100;
                return 100;
            case "Sur":
                destinoSur -= 70;
                return 70;
            default:
                return 0;
        }
    }

    public synchronized boolean viajeNecesario(String nombreCentral) {
        switch (nombreCentral) {
            case "Norte":
                return (destinoNorte > capacidad*0.65*0.85) ? true : false;
            case "Sur":
                return (destinoSur > capacidad*0.35*0.85) ? true : false;
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return String.format("norte: %d, sur: %d", destinoNorte, destinoSur);
    }
}