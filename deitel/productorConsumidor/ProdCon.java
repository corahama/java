import java.util.logging.Level;
import java.util.logging.Logger;


public class ProdCon {


    public static void main(String[] args)  {

        AreaComun area = new AreaComun(1);
        Productor oproductor = new Productor(10, area);
        Consumidor oconsumidor = new Consumidor(10, area);

        Thread h_productor = new Thread(oproductor);
        Thread h_consumidor = new Thread(oconsumidor);

        h_productor.start();
        h_consumidor.start();


        while(h_productor.isAlive() || h_consumidor.isAlive()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProdCon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }

}
