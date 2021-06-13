package crud;

import java.util.Scanner;
import java.util.ArrayList;

public class CRUDPrdsElcts {
    public static void main(String[] args) {
        new CRUDPrdsElcts();
        System.out.println();
    }

    private ArrayList<Electronico> electronicos;
    Scanner in;

    CRUDPrdsElcts() {
        electronicos = new ArrayList<Electronico>();
        in = new Scanner(System.in);

        boolean activo = true;

        System.out.println("******Bienvenido al CRUD Productos Electronicos******");
        System.out.println("Introduce uno de los siguientes comandos para realizar una accion: ");
        System.out.println("[1] Crear un nuevo producto");
        System.out.println("[2] Ver todos los productos creados");
        System.out.println("[3] Actualizar un producto");
        System.out.println("[4] Eliminar un producto");
        System.out.println("[0] Salirse del programa");

        while (activo) {
            activo = ejecutarCommando();
        }
    }

    public boolean ejecutarCommando() {
        System.out.print("Comando: ");
        int comando = in.nextInt();

        switch(comando) {
            case 1:
                System.out.printf("\n*Opcion: crear nuevo producto.\nProductos en el catalogo:\n");
                System.out.println("[1] Computadora");
                System.out.println("[2] Television");
                System.out.println("[3] Microcomponente");
                System.out.print("Introduce el producto que quieres crear: ");
                int opnCatlgo = in.nextInt();
                System.out.println();

                Electronico producto = null;
                switch(opnCatlgo) {
                    case 1:
                        producto = new Computadora();
                        break;
                    case 2:
                        producto = new Television();
                        break;
                    case 3:
                        producto = new Microcomponente();
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
                if (producto != null) {
                    electronicos.add(producto);
                    System.out.println("Producto creado con exito.");
                }
                break;

            case 2:
                System.out.printf("\n*Opcion: ver todos los producto.\n");
                if (electronicos.size() == 0) {
                    System.out.println("No hay productos.");
                    break;
                }

                for (int i = 0; i < electronicos.size(); i++) {
                    System.out.printf("Producto [%d]\n", i+1);
                    System.out.println(electronicos.get(i));
                }
                break;

            case 3:
                System.out.printf("\n*Opcion: actualizar un producto.\n");
                System.out.print("Introduce el numero de serie del producto: ");
                int nSerie = in.nextInt();
                boolean encontrado = false;

                for (Electronico p : electronicos) {
                    if (nSerie == Integer.parseInt(p.tomarNSerie())) {
                        p.actualizar();
                        encontrado = true;
                    }
                }

                System.out.println(encontrado ? "Producto actualizado correctamente." 
                : "Producto no encontrado");

                break;
            
            case 4:
                System.out.printf("\n*Opcion: eliminar un producto.\n");
                System.out.print("Introduce el numero de serie del producto: ");
                int nSerieD = in.nextInt();
                boolean encontradoD = false;

                for (int i = 0; i < electronicos.size(); i++) {
                    if (nSerieD == Integer.parseInt(electronicos.get(i).tomarNSerie())) {
                        electronicos.remove(i);
                        encontradoD = true;
                    }
                }

                System.out.println(encontradoD ? "Producto eliminado correctamente." 
                    : "Producto no encontrado");
                break;

            case 0:
                System.out.println("Bye bye");
                in.close();
                return false;

            default:
                System.out.println("Opcion invalida, introduce otro comando: ");
                break;
            
        }
        System.out.println();
        return true;
    }

}