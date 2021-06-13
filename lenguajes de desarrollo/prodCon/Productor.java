package prodCon;

class Productor implements Runnable {
    private AreaComun area = null;
    private int times;

    public Productor(int times, AreaComun area) {
        this.times = times;
        this.area = area;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < this.times) {
            area.increases(1);
            i++;
            area.print();
        }
    }

}