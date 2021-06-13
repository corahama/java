import java.util.ArrayList;

public class AreaComun {

    private ArrayList<Integer> area = null;

    public AreaComun(int size){
        this.area = new ArrayList<Integer>(size);
   }

    synchronized public boolean aumenta (int valor){
        this.area.add(valor);
        return true;
    }

    synchronized public boolean disminuye (){
        if(this.area.size()>0)
        {
            this.area.remove(this.area.size()-1);
            return true;
        }
        return false;
    }

    public void imprime(){
        for(int i=0; i<this.area.size(); i++)
            System.out.printf(" %d ", this.area.get(i));
        System.out.println("");
    }


}
