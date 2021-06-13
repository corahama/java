package proyecto1;

public class RutaAlimentadora implements Runnable {
    private int ciclos, ciclosTotales;
    private Aereopuerto aereopuerto;

    public RutaAlimentadora(Aereopuerto aereopuerto, int ciclosTotales) {
        ciclos = 0;
        this.aereopuerto = aereopuerto;
        this.ciclosTotales = ciclosTotales;
    }

    @Override
    public void run() {
        while (ciclos < ciclosTotales) {
            aereopuerto.depositarPersonas();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("Error en la interrupción");
            }
            ciclos += 5;
            if (ciclos % 5000 == 0)
                System.out.println("ciclo: " + ciclos);
        }
    }   
}
