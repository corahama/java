package agricultura;

public class Ejecutable {


    public static void main(String[] args)  {

        int ciclos = 7000000;
        Parcela parcela = new Parcela(1);
        AreaConsumo consumo = new AreaConsumo(1, parcela);

        ProductorFresa ofresa = new ProductorFresa(ciclos, parcela);
        ProductorLechuga olechuga = new ProductorLechuga(ciclos, parcela);

        Evalua oevalua = new Evalua(ciclos, parcela);

        Recolector orecolector1 = new Recolector(ciclos, 25, consumo);
        Recolector orecolector2 = new Recolector(ciclos, 50, consumo);
        Recolector orecolector3 = new Recolector(ciclos, 75, consumo);

        Consumidor oconsumidor1 = new Consumidor(ciclos, 50, consumo);
        Consumidor oconsumidor2 = new Consumidor(ciclos, 60, consumo);
        Consumidor oconsumidor3 = new Consumidor(ciclos, 70, consumo);
        Consumidor oconsumidor4 = new Consumidor(ciclos, 80, consumo);
        Consumidor oconsumidor5 = new Consumidor(ciclos, 90, consumo);


        Thread h_fresa = new Thread(ofresa);
        Thread h_lechuga = new Thread(olechuga);

        Thread h_evalua = new Thread(oevalua);

        Thread h_recolector1 = new Thread(orecolector1);
        Thread h_recolector2 = new Thread(orecolector2);
        Thread h_recolector3 = new Thread(orecolector3);

        Thread h_consumidor1 = new Thread(oconsumidor1);
        Thread h_consumidor2 = new Thread(oconsumidor2);
        Thread h_consumidor3 = new Thread(oconsumidor3);
        Thread h_consumidor4 = new Thread(oconsumidor4);
        Thread h_consumidor5 = new Thread(oconsumidor5);

        h_fresa.start();
        h_lechuga.start();

        h_evalua.start();

        h_recolector1.start();
        h_recolector2.start();
        h_recolector3.start();

        h_consumidor1.start();
        h_consumidor2.start();
        h_consumidor3.start();
        h_consumidor4.start();
        h_consumidor5.start();


    }

}
