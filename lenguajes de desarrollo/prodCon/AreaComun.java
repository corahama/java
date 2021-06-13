package prodCon;

import java.util.ArrayList;

class AreaComun {
    private ArrayList<Integer> area = null;

    public AreaComun(int size) {
        this.area = new ArrayList<Integer>(size);
    }

    synchronized public boolean increases(int value) {
        this.area.add(value);
        return true;
    }

    synchronized public boolean decreases() {
        if (this.area.size() > 0) {
            this.area.remove(this.area.size()-1);
            return true;
        } else {
            return false;
        }
    }

    synchronized public void print() {
        for (int i = 0; i < this.area.size(); i++)
            System.out.printf("%d ", this.area.get(i));
        System.out.println("");
    }

}
