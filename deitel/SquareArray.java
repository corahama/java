import java.util.Scanner;

public class SquareArray {
    public static void main(String[] args) {
        int N, sum;
        int[][] array;
        String row;
        String[] rowElements;
        Scanner in = new Scanner(System.in);

        System.out.print("Tamaño de la matriz: ");
        N = in.nextInt();
        array = new int[N][N];
        in.nextLine();

        // Introducción de los elementos de la matriz
        for (int i = 0; i < N; i++) {
            System.out.printf("Introduce los elementos de la Fila %d separados por espacio: ", i+1);
            row = in.nextLine();
            rowElements = row.split(" ");
            for (int j = 0; j < N; j++)
                array[i][j] = Integer.parseInt(rowElements[j]);
        }

        // Calculo de promedios por fila
        for (int i = 0; i < N; i++) {
            sum = 0;
            for (int j = 0; j < N; j++) {
                sum += array[i][j];
            }
            System.out.printf("Promedio Fila %d = %d\n", i+1, sum/N);
        }

        // Calculo de promedios por columna
        for (int j = 0; j < N; j++) {
            sum = 0;
            for (int i = 0; i < N; i++) {
                sum += array[i][j];
            }
            System.out.printf("Promedio Columna %d = %d\n", j+1, sum/N);
        }

        in.close();
    }
    
}
