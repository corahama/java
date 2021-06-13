package parcial_1;
// EXPLANATION: BUILD A PROGRAM THAT STORES AN ARRAY WITH N ELEMENTS (ENTERED BY THE USER) AND REQUEST
// THE USER TO FILL IT, THEN PRINT THE GREATEST ELEMENT, THE LOWEST AND THE AVERAGE.
import java.util.Scanner;
import java.util.Arrays;

public class EvaluacionDiagnostica3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Introduce el tamaño del arrego: ");
        int arrayLenght = in.nextInt();

        int array[] = new int[arrayLenght];
        for (int i = 0; i < arrayLenght; i++) {
            System.out.format("Introduce el elemento %s: ", i+1);
            array[i] = in.nextInt();
        }

        Arrays.sort(array);
        int sum = 0;
        for (int element: array)
            sum += element;
        int average = sum/arrayLenght;

        System.out.format("El elemento mas grande del arrego es: %d \n", array[arrayLenght-1]);
        System.out.format("El elemento mas pequeño del arrego es: %d \n", array[0]);
        System.out.format("El promedio de todos los elementos es: %d \n", average);

        in.close();
    }
}