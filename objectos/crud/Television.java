package crud;

import java.util.Scanner;

public class Television extends Electronico {
    private Scanner in = new Scanner(System.in);

    private String marca;
    private String pulgadas;
    private String resolucion;
    private String color;

    public Television() {
        super();
        System.out.print("Introduce la marca: ");
        marca = in.nextLine();
        System.out.print("Introduce las pulgadas: ");
        pulgadas = in.nextLine();
        System.out.print("Introduce la resolucion: ");
        resolucion = in.nextLine();
        System.out.print("Introduce el color: ");
        color = in.nextLine();
    }

    @Override
    public void actualizar() {
        super.inicializarActualizar();
        System.out.println("[4] Marca");
        System.out.println("[5] Pulgadas");
        System.out.println("[6] Resolucion");
        System.out.println("[7] Color");
        System.out.print("Introduce el atributo que quieres actualizar: ");
        int atributo = in.nextInt();
        in.nextLine();
        if (atributo > 0 && atributo <= 3) {
            super.actualizarAtributo(atributo);
        } else {
            switch (atributo) {
                case 4:
                    System.out.print("Introduce la nueva marca: ");
                    marca = in.nextLine();
                    break;
                case 5:
                    System.out.print("Introduce la nueva cantidad de pulgadas: ");
                    pulgadas = in.nextLine();
                    break;
                case 6:
                    System.out.print("Introduce la nueva resolucion: ");
                    resolucion = in.nextLine();
                    break;
                case 7:
                    System.out.print("Introduce el nuevo color: ");
                    color = in.nextLine();
                    break;
                default:
                    System.out.println("Opcion inorrecta.");
                    break;
            }
        }
    }

    public String toString() {
        return String.format("%s\nMarca: %s\nPulgadas: %s\nResolucion: %s\nColor: %s", super.toString(), 
            marca, pulgadas, resolucion, color);
    }
}