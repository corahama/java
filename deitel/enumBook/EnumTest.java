import java.util.EnumSet;

public class EnumTest{
  public static void main(String[] args){
    System.out.println("Todos los libros: ");

    for (Book book : Book.values())
      System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getCopyrightYear());

    System.out.printf("%nMostrar el rango de constantes enum:%n");

    for (Book book: EnumSet.range(Book.JHTP, Book.CPPHTP))
      System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getCopyrightYear());
  }
}
