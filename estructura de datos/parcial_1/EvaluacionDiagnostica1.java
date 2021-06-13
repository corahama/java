package parcial_1;
// EXPLANATION: BUILD A PROGRAM THAT STORES AN ARRAY WITH N ELEMENTS (ENTERED BY THE USER) AND REQUEST
// THE USER TO FILL IT. FINALLY PRINT THE ELEMENTS OF THE ARRAY IN REVERSE ORDER
import java.util.Scanner;

public class EvaluacionDiagnostica1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Ingresa el tamaño del arreglo: ");
        int arrayLength = in.nextInt();

        String array[] = new String[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            System.out.format("Introduce el elemento %d: ", i+1);
            array[i] = in.next();
        }

        for (int i = arrayLength-1; i >= 0; i--)
            System.out.print(array[i]+" ");

        System.out.println();
        in.close();
    }
}