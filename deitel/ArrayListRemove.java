import java.util.ArrayList;

public class ArrayListRemove{
  public static void main(String[] args){
    ArrayList<Integer> items = new ArrayList<Integer>();
    items.add(3);
    items.add(2);
    items.add(1);

    System.out.println(items);

    System.out.println(items.size());

    items.remove(2);

    System.out.println(items);

  }
}
