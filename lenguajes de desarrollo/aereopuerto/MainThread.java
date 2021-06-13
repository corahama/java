package proyecto1;

public class MainThread {
    public static void main(String[] args) {
        Aereopuerto aereopuerto = new Aereopuerto();
        Central centralNorte = new Central(500);
        Central centralSur = new Central(200);

        RutaAlimentadora rutaAlimentadora = new RutaAlimentadora(aereopuerto, 50000);
        Avion avion = new Avion(aereopuerto, centralNorte);
        Camion camion = new Camion(aereopuerto, centralSur);
        Carro carro1 = new Carro(centralNorte);
        Carro carro2 = new Carro(centralSur);

        Thread thread_rutaAlimentadora = new Thread(rutaAlimentadora);
        Thread thread_avion = new Thread(avion);
        Thread thread_camion = new Thread(camion);
        Thread thread_carro1 = new Thread(carro1);
        Thread thread_carro2 = new Thread(carro2);

        thread_rutaAlimentadora.start();
        thread_avion.start();
        thread_camion.start();
        thread_carro1.start();
        thread_carro2.start();
        
        while (thread_rutaAlimentadora.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Error en la interrupción 1");
            }
            imprimirEstadoGeneral(aereopuerto, centralNorte, centralSur);
        }

        System.out.println("Matando hilo avion y camion");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Error en la interrupción 2");
        }
        avion.stop();
        camion.stop();

        System.out.println("Matando hilos carro");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Error en la interrupción 3");
        }
        carro1.stop();
        carro2.stop();

        System.out.printf("\n******* Total de viajes *******\nAvion - Central norte: %d\t\tCamion - Central sur: %d\n\n******* Total de personas transportadas *******\nTaxi - Central Norte: %d\tTaxi - Central Sur: %d\n\n", avion.obtenerViajesTotales(), camion.obtenerViajesTotales(), carro1.obtenerTotalPersonasTransportadas(), carro2.obtenerTotalPersonasTransportadas());
        System.out.println("Sistema terminado");
    }

    public static void imprimirEstadoGeneral(Aereopuerto aereopuerto, Central centralNorte, Central centralSur) {
        System.out.printf("aereopuerto <%s>\tcentral norte %s\tcentral sur %s\n", aereopuerto, centralNorte, centralSur);
    }
}
