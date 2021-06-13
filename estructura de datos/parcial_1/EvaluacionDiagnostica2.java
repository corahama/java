package parcial_1;
// EXPLANATION: BUILD A PROGRAM THAT STORES AN ARRAY WITH N ELEMENTS (ENTERED BY THE USER) AND REQUEST
// THE USER TO FILL IT WITH CHARS ELEMENTS. FINALLY THE PROGRAM SHOULD REQUEST FOR ANOTHER CHAR ELEMENT
// AND THEN PRINT THE FIRST POSITION OF THE ARRAY IN WHICH AN EQUAL ELEMENT WAS FOUNDED
import java.util.Scanner;
import java.util.Arrays;

public class EvaluacionDiagnostica2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Introduce el tamaño del arrego: ");
        int arrayLenght = in.nextInt();

        String array[] = new String[arrayLenght];
        for (int i = 0; i < arrayLenght; i++) {
            System.out.format("Introduce el elemento %s: ", i+1);
            array[i] = in.next();
        }

        System.out.print("Introduce el caracter a buscar: ");
        String searchKey = in.next();

        int keyIndex = Arrays.binarySearch(array, searchKey);
        if (keyIndex < 0)
            System.out.print("El elemento introducido no fue encontrado");
        else
            System.out.format("El elementro introducido fue encontrado en la posición %d", keyIndex+1);

        System.out.println();
        in.close();
    }
}

