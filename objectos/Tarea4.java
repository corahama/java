import java.util.Scanner;

public class Tarea4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        firstLine = firstLine.replace(" ", "");
        String[] flvalues = firstLine.split(",");
        int m = Integer.parseInt(flvalues[0]), n = Integer.parseInt(flvalues[1]), 
                o = Integer.parseInt(flvalues[2]), p = Integer.parseInt(flvalues[3]);

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            String row = in.nextLine();
            String[] rowValues = row.split(",");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(rowValues[j]);
            }
        }

        // for (int[] i : matrix) {
        //     for (int j : i) {
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }
        in.close();

        int sum = 0, best = 0;
        int x = 0, y = 0;
        char position = 'X';

        for (int i = 0; i <= m - o; i++) {
            for (int j = 0; j <= n - p; j++) {
                sum = 0;
                for (int a = i; a < o + i; a++) {
                    for (int b = j; b < p + j; b++) {
                        sum += matrix[a][b];
                    }
                }
                if (sum > best) {
                    best = sum;
                    x = i;
                    y = j;
                    position = 'H';
                }
            }
        }

        System.out.println(best);

        for (int i = 0; i <= n - o; i++) {
            for (int j = 0; j <= m - p; j++) {
                sum = 0;
                for (int a = j; a < p + j; a++) {
                    for (int b = i; b < o + i; b++) {
                        sum += matrix[a][b];
                    }
                }
                if (sum >= best) {
                    best = sum;
                    if (i == x && j == y) {
                        position = 'I';
                    } else {
                        position = 'V';
                    }
                    x = i;
                    y = j;
                }
            }
        }
        
        System.out.printf(" (%d, %d)\n%d\n%c", x, y, best, position);
        System.out.println();
    }
}