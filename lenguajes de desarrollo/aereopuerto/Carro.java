package proyecto1;

import java.util.concurrent.atomic.AtomicBoolean;

public class Carro implements Runnable {
    private final AtomicBoolean running = new AtomicBoolean(false);
    private Central central;
    private int totalPersonasTransportadas;

    public Carro(Central central) {
        this.central = central;
        totalPersonasTransportadas = 0;
    }

    public int obtenerTotalPersonasTransportadas() {
        return totalPersonasTransportadas;
    }

    public void stop() {
        running.set(false);
    }

    @Override
    public void run() {
        running.set(true);
        int personasTransportadas;
        while (running.get()) {
            if (central.obtenerOcupacion() >= 3) {
                personasTransportadas = central.salidaPersonas();
                totalPersonasTransportadas += personasTransportadas;
            }

            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                System.out.println("Error en la interrupción");
            }
        }
    }
    
}
