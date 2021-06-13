package crud;

import java.util.Scanner;

public class Computadora extends Electronico {
    private Scanner in = new Scanner(System.in);

    private String modelo;
    private String ram;
    private String procesador;

    public Computadora() {
        super();
        System.out.print("Introduce el modelo: ");
        modelo = in.nextLine();
        System.out.print("Introduce la cantidad de ram: ");
        ram = in.nextLine();
        System.out.print("Introduce los GHz del procesador: ");
        procesador = in.nextLine();
    }

    @Override
    public void actualizar() {
        super.inicializarActualizar();
        System.out.println("[4] Modelo");
        System.out.println("[5] RAM");
        System.out.println("[6] Procesador");
        System.out.print("Introduce el atributo que quieres actualizar: ");
        int atributo = in.nextInt();
        in.nextLine();
        if (atributo > 0 && atributo <= 3) {
            super.actualizarAtributo(atributo);
        } else {
            switch (atributo) {
                case 4:
                    System.out.print("Introduce el nuevo modelo: ");
                    modelo = in.nextLine();
                    break;
                case 5:
                    System.out.print("Introduce la nueva cantidad de RAM: ");
                    ram = in.nextLine();
                    break;
                case 6:
                    System.out.print("Introduce la nueva velocidad del procesador: ");
                    procesador = in.nextLine();
                    break;
                default:
                    System.out.println("Opcion inorrecta.");
                    break;
            }
        }
    }

    public String toString() {
        return String.format("%s\nModelo: %s\nRAM: %sGB\nProcesador: %sGHz", super.toString(), 
            modelo, ram, procesador);
    }
}