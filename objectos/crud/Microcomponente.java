package crud;

import java.util.Scanner;

public class Microcomponente extends Electronico {
    private Scanner in = new Scanner(System.in);

    private String marca;
    private String arquitectura;
    private String frecuencia;

    public Microcomponente() {
        super();
        System.out.print("Introduce la marca: ");
        marca = in.nextLine();
        System.out.print("Introduce la cantidad de arquitectura: ");
        arquitectura = in.nextLine();
        System.out.print("Introduce los GHz del frecuencia: ");
        frecuencia = in.nextLine();
    }

    @Override
    public void actualizar() {
        super.inicializarActualizar();
        System.out.println("[4] Marca");
        System.out.println("[5] Arquitectura");
        System.out.println("[6] Frecuencia");
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
                    System.out.print("Introduce la nueva arquitectura: ");
                    arquitectura = in.nextLine();
                    break;
                case 6:
                    System.out.print("Introduce la nueva frecuencia: ");
                    frecuencia = in.nextLine();
                    break;
                default:
                    System.out.println("Opcion inorrecta.");
                    break;
            }
        }
    }

    public String toString() {
        return String.format("%s\nMarca: %s\nArquitectura: %s\nFrecuencia: %sGHz", super.toString(), 
            marca, arquitectura, frecuencia);
    }
}