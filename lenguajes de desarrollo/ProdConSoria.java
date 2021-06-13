import java.util.ArrayList;

public class ProdConSoria {
    public static void main(String[] args)  {        
        Areacomun area = new Areacomun(50);
        Productor o_productor = new Productor(50, area);
        Consumidor o_consumidor = new Consumidor(50, area);

        Thread h_productor = new Thread(o_productor);
        Thread h_consumidor = new Thread(o_consumidor);
        
        h_productor.start();
        h_consumidor.start();
        
        
        while(h_productor.isAlive() || h_consumidor.isAlive()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Error en la interrupción");
            }
        }

    }
    
}


class Areacomun {
    private ArrayList<Integer> area = null;
    
    public Areacomun(int size){
        this.area = new ArrayList<Integer>(size);    
   }
    
    public synchronized boolean aumenta (int valor){
        this.area.add(valor);
        return true;
    }
    
    public synchronized boolean disminuye (){
        if(this.area.size() > 0) {
            this.area.remove(this.area.size() - 1);
            return true;
        }
        return false;
    }
    
    public synchronized void imprime(){
        for(int i=0; i<this.area.size(); i++)
            System.out.printf("%d ", this.area.get(i));
        System.out.println("");
    }
    
}


class Productor implements Runnable {    
    private Areacomun area;
    private int veces;
    
    public Productor (int veces, Areacomun area){
        this.veces = veces;
        this.area = area;
    }
    
    @Override
    public void run() {
        int i = 0;
        while(i < veces){
            if (area.aumenta(1)) {
                i++;
                area.imprime();
            }
        }
    }
    
}


class Consumidor extends Thread {

    private Areacomun area;
    private int veces;
    
    public Consumidor (int veces, Areacomun area){
        this.veces = veces;
        this.area = area;
    }
    
    @Override
    public void run() {
        int i = 0;
        while(i < veces){
            if (area.disminuye()) {
                i++;
                area.imprime();
            }
        }
    }
    
}
