package prodCon;

public class ProductorConsumidor {
    public static void main(String[] args) {
        AreaComun area = new AreaComun(10);
        Productor o_productor = new Productor(10, area);
        Consumidor o_consumidor = new Consumidor(10, area);

        Thread h_productor = new Thread(o_productor);
        Thread h_consumidor = new Thread(o_consumidor);

        h_productor.start();
        h_consumidor.start();

        while(h_productor.isAlive() || h_consumidor.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex){
                System.out.println("Error en la interrupción");
            }
        }
    }

}
