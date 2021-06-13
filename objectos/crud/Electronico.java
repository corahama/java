package crud;

import java.util.Scanner;

public abstract class Electronico {
    private Scanner in = new Scanner(System.in);

    private String nSerie;
    private String nombre;
    private String precio;

    public Electronico() {
        System.out.print("Introduce el numero de serie: ");
        nSerie = in.nextLine();
        System.out.print("Introduce el nombre: ");
        nombre = in.nextLine();
        System.out.print("Introduce el precio: ");
        precio = in.nextLine();
    }

    public String tomarNSerie() {
        return nSerie;
    }

    abstract void actualizar();

    public void inicializarActualizar() {
        System.out.println("Atributos del producto: ");
        System.out.println("[1] Numero de serie");
        System.out.println("[2] Nombre");
        System.out.println("[3] Precio");
    }

    public void actualizarAtributo(int atributo) {
        switch (atributo) {
            case 1:
                System.out.print("Introduce el nuevo numero de serie: ");
                nSerie = in.nextLine();
                break;
            case 2:
                System.out.print("Introduce el nuevo nombre: ");
                nombre = in.nextLine();
                break;
            case 3:
                System.out.print("Introduce el nuevo precio: ");
                precio = in.nextLine();
                break;
            default:
                break;
        }
    }

    public String toString() {
        return String.format("Numero de serie: %s\nNombre: %s\nPrecio: %s", nSerie, nombre, precio);
    }
}