package proyecto1;

import java.util.concurrent.atomic.AtomicBoolean;

public class Avion implements Runnable {
    private final AtomicBoolean running = new AtomicBoolean(false);
    private Aereopuerto aereopuerto;
    private Central central;
    private int personasEnAvion;
    private int viajesTotales;
    
    public Avion(Aereopuerto aereopuerto, Central central) {
        this.aereopuerto = aereopuerto;
        this.central = central;
        viajesTotales = 0;
    }

    public int obtenerViajesTotales() {
        return viajesTotales;
    }

    public void stop() {
        running.set(false);
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            if (aereopuerto.viajeNecesario("Norte")) {
                personasEnAvion = aereopuerto.trasladarPersonas("Norte");
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    System.out.println("Error en la interrupción");
                }
                central.depositarPersonas(personasEnAvion);
                viajesTotales++;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Error en la interrupción");
            }
        }
    }
}
