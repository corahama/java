import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class EvaluacionDiagnostica {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int idCounter = 0, userInput = -1;
        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        boolean hasDelete;

        System.out.printf("Introduce una de las siguientes opciones:\n0) Terminar el programa\n1) Crear un nuevo restaurante\n2) Buscar por especialidad\n3) Eliminar restaurante por id\n4) Mostrar todos los restaurantes\n");
        System.out.printf("Comando: ");
        userInput = in.nextInt();

        while (userInput != 0) {
            
            switch (userInput) {
                case 0:
                    break;

                case 1:
                    System.out.printf("\nIntroduce la cantidad de mesas: ");
                    int tableNumber = in.nextInt();
                    in.nextLine();
                    System.out.print("Introduce el horario: ");
                    String schedule = in.nextLine();
                    System.out.print("Introduce la especialidad: ");
                    String specialism = in.nextLine();

                    restaurantList.add(createRestaurant(idCounter, tableNumber, schedule, specialism));
                    idCounter += 1;

                    System.out.printf("\n******Restaurante creado exitosamente!******\n");
                    break;
                
                case 2:
                    System.out.printf("\nIntroduce la especialidad: ");
                    in.nextLine();
                    String specialismSearch = in.nextLine();

                    hasDelete = false;
                    for (Restaurant e: restaurantList) {
                        if (e.specialism.equals(specialismSearch)) {
                            System.out.printf("\nRestaurante encontrado:\n%s\n", e.toString());
                            hasDelete = true;
                        }
                    }

                    if (!hasDelete)
                        System.out.printf("\nNo se a encontrado un restaurante con la especialidad ingresada\n");

                    break;

                case 3:
                    System.out.printf("\nIntroduce el id: ");
                    int idSearch = in.nextInt();

                    Iterator<Restaurant> itr = restaurantList.iterator();
                    hasDelete = false;
                    while (itr.hasNext()) {
                        Restaurant x = (Restaurant)itr.next();
                        if (x.id == idSearch) {
                            itr.remove();
                            hasDelete = true;
                            System.out.println("Restaurante borrado exitosamente");
                        }
                    }
                    if (!hasDelete)
                        System.out.printf("\nNo se a encontrado un restaurante con el id ingresado\n");
                    break;

                case 4:                
                    if (restaurantList.size() == 0)
                        System.out.printf("\nNo hay restaurantes registrados\n");
                    else {
                        System.out.printf("\nTodos los restaurantes:\n");
                        for (Restaurant e: restaurantList)
                            System.out.println(e);
                        System.out.println("");
                    }

                    break;

                case 5:
                    System.out.printf("\n0) Terminar el programa\n1) Crear un nuevo restaurante\n2) Buscar por especialidad\n3) Eliminar restaurante por id\n4) Mostrar todos los restaurantes\n");
                    break;

                default:
                    System.out.printf("Opcion invalida, vuelve a introducir un comando: ");
                    userInput = in.nextInt();
                                        
            }

            System.out.printf("\n- Ingresa otro comando (o 5 para volvera mostra el menu): ");
            userInput = in.nextInt();
        }

        System.out.println("****** Sistema terminado ******");
        in.close();
        
    }

    public static Restaurant createRestaurant(int id, int tableNumber, String schedule, String specialism) {
        return new Restaurant(id, tableNumber, schedule, specialism);
    }

}


// RESTAURANT CLASS DECLARATION
class Restaurant {
    int id, tableNumber;
    String schedule, specialism;

    public Restaurant(int id, int tableNumber, String schedule, String specialism) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.schedule = schedule;
        this.specialism = specialism;
    }

    @Override
    public String toString() {
        return String.format("id:%d   |   numero de mesas: %d   |   horario: %s   |   especialidad:%s", this.id, this.tableNumber, this.schedule, this.specialism);
    }
}
