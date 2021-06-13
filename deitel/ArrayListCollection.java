import java.util.ArrayList;

public class ArrayListCollection{
  public static void main(String[] args){
    ArrayList<String> items = new ArrayList<>();

    items.add("red");
    items.add(0, "yellow");

    System.out.print("Muestra el contenido de la lista con counter-controlled loop:");

    for (int i = 0; i < items.size(); i++)
      System.out.printf(" %s", items.get(i));

    display(items, "%nMuestra el contenido de la lista con enhanced for statement:");

    items.add("green");
    items.add("yellow");
    display(items, "Lista con dos nuevos elementos:");

    items.remove("yellow");
    display(items, "Remover la primera instancia de yellow:");

    items.remove(1);
    display(items, "Remover el secundo elemento de la lista:");

    System.out.printf("\"red\" %s esta en la lista%n", items.contains("red") ? "" : "no");

    System.out.printf("Tamano: %s%n", items.size());
  }

  public static void display(ArrayList<String> items, String header){
    System.out.printf(header);

    for (String item : items)
      System.out.printf(" %s", item);
    System.out.println();
  }
}
