package tarea2;

import java.util.Random;

public class Vuelo implements Runnable {
    Contenedor contenedor, reserva;
    int gasto, periodo;
    Random rand = null;

    public Vuelo(Contenedor contenedor, int gasto, int periodo, Contenedor reserva) {
        this.contenedor = contenedor;
        this.gasto = gasto;
        this.periodo = periodo;
        this.reserva = reserva;

        this.rand = new Random();
    }

    @Override
    public void run() {
        for (int tiempo = 0; tiempo < 43800; tiempo += this.periodo) {
            if (this.rand.nextFloat() > .05) {
                if (!contenedor.consumir(this.gasto)){
                    if (reserva.carga >= 1000) {
                        contenedor.cargar(1000);
                        reserva.consumir(1000);
                        contenedor.cambios += 1;
                    } else {
                        contenedor.noRealizado += 1;
                    }
                };
            }

            try {
                Thread.sleep(this.periodo);
            } catch (InterruptedException e) {
                System.out.println("Error de interrupción");
            }
        }

    }

}
