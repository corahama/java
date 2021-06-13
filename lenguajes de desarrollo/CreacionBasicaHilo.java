public class CreacionBasicaHilo {
    public static void main(String[] args) {
        // A fin de ejecutar un hilo primero debemos instanciar su objeto base
        Saluda base = new Saluda(5000);

        // Luego debemos crear el hilo a partir del objecto base
        Thread hilo1 = new Thread(base);

        // A fin de ejecutar el Hilo debemos llamar su metodo start
        hilo1.start();

        // El metodo run se ejecutará en forma paralela
        // Importante: Si ejecutamos el metodo run, se ejecutará de forma secuencial
    }
}

class Saluda implements Runnable{
    private  int veces = 0;

    public Saluda(int veces) {
        this.veces = veces;
    }

    @Override
    public void run() {
        // Metodo que se llamará en paralelo cuando el objeto sea transformado en hilo
        for (int i = 0; i < this.veces; i++)
            System.out.println("Hola numero " + i);
        
    }
}