import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++)
            arrayList.add(i);

        System.out.println(Math.pow(6,2));
            
        System.out.println(arrayList.get(3));
    }
}