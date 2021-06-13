import java.util.ArrayList;
import java.util.Iterator;

public class DeleteArrayListElement {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(3);
        numbers.add(2);
        numbers.add(1);

        for (int e: numbers)
            System.out.println(e);

        Iterator itr = numbers.iterator();

        while (itr.hasNext()) {
            int x = (Integer)itr.next();
            if (x < 2)
                itr.remove();
        }

        System.out.println("");
        for (int e: numbers)
            System.out.println(e);

            

    }
}