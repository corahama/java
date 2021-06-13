import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor implements Runnable{

    private AreaComun area = null;
    private int veces =0;


    public Consumidor (int v, AreaComun a){
        this.veces =v;
        this.area =a;
    }

    @Override
    public void run() {
        int i =0;
        while(i< this.veces){
            if(area.disminuye()){
                i++;
            }
            else{
                try {
                    sleep(50);
                } catch (InterruptedException ex) {
                    System.out.println("Error");
                }
            }
           area.imprime();
        }
    }

}
