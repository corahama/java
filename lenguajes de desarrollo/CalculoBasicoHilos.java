// TAREA 1
import java.util.Random;
import java.util.ArrayList;

public class CalculoBasicoHilos {
    public static void main(String[] args) {
        Random random = new Random();

        // Generamos el array con valores aleatorios
        ArrayList<Punto2d> arrayPuntos = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            arrayPuntos.add(new Punto2d(random));

        // Generamos una instancia para cada Clase Adder
        Adder adder1 = new Adder(arrayPuntos, 0, 25);
        Adder adder2 = new Adder(arrayPuntos, 25, 50);
        Adder adder3 = new Adder(arrayPuntos, 50, 75);
        Adder adder4 = new Adder(arrayPuntos, 75, 100);

        // Generamos un hilo para cada Adder
        Thread hilo1 = new Thread(adder1);
        Thread hilo2 = new Thread(adder2);
        Thread hilo3 = new Thread(adder3);
        Thread hilo4 = new Thread(adder4);

        // Iniciamos la ejecución de los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        // Bucle para frenar la ejecucion del resto del codigo hasta que todos los hilos hayan terminado
        // de ejecutarse
        while (hilo1.isAlive() || hilo2.isAlive() || hilo3.isAlive() || hilo4.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex){
                System.out.println("Error en la interrupción");
            }
        }
        
        // Imprimimos los resultados de cada hilo
        System.out.printf("Resultados hilo 1: %.2f\n", adder1.result);
        System.out.printf("Resultados hilo 2: %.2f\n", adder2.result);
        System.out.printf("Resultados hilo 3: %.2f\n", adder3.result);
        System.out.printf("Resultados hilo 4: %.2f\n", adder4.result);

        // Imprimimos el total de la suma de cada hilo
        System.out.println("*****Total*****");
        System.out.printf("total=%.2f\n", (adder1.result+adder2.result+adder3.result+adder4.result));

    }
}

class Adder implements Runnable {
    ArrayList<Punto2d> pointsArray;
    int initialValue, finalValue;
    float result = 0;

    public Adder(ArrayList<Punto2d> pointsArray, int initialValue, int finalValue) {
        this.pointsArray = pointsArray;
        this.initialValue = initialValue;
        this.finalValue = finalValue;
    }

    @Override
    public void run() {
        for (int i = this.initialValue; i < this.finalValue; i++)
            result += Math.pow(pointsArray.get(i).x,2) + 2*pointsArray.get(i).y - pointsArray.get(i).x;            
    }
}

class Punto2d {
    float x;
    float y;

    public Punto2d(Random random) {
        this.x = random.nextFloat() * 10;
        this.y = random.nextFloat() * 10 - 5;
    }

    public String toString() {
        return String.format("x: %.2f, y: %.2f", this.x, this.y);
    }
}