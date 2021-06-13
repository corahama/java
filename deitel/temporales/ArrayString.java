import java.util.ArrayList;

public class ArrayString{
  public static void main(String[] args){
    ArrayList<String> cadena = new ArrayList<String>();

    cadena.add("uno");
    cadena.add("cinco");
    cadena.add("diez");

    System.out.println(cadena);

    for (int count = 0; count < cadena.size(); count++){
      if (cadena.get(count) == "uno")
      cadena.set(count, "dos");
      System.out.println(cadena.get(count));
    }

    System.out.println(cadena);

  }
}
