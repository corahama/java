public class Productor implements Runnable{

    private AreaComun area = null;
    private int veces = 0;


    public Productor (int v, AreaComun a){
        this.veces = v;
        this.area = a;
    }

    @Override
    public void run() {
        int i =0;
        while(i < this.veces){
            area.aumenta(1);
            i++;
            area.imprime();
        }
    }

}
