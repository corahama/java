package prodCon;

class Consumidor implements Runnable {
    private AreaComun area = null;
    private int times;

    public Consumidor(int times, AreaComun area) {
        this.times = times;
        this.area = area;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < this.times) {
            if (area.decreases()) {
                i++;
            } else {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex){
                    System.out.println("Error en la interrupción");
                }
            }
            area.print();
        }
    }
}