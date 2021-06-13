package umda;

import java.util.ArrayList;

public class umdaTest {
    public static void main(String[] args){
        umda umda = new umda(100, 5, 2, 20);
        ArrayList<i> history = umda.execute();

        for (i ind : history)
            System.out.printf(" %.4f -", ind.fitness);
    }
}
