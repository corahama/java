import java.util.Scanner;
import java.util.ArrayList;

public class Tarea2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        int[] elements = new int[size];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = in.nextInt();
        }
        
        pares(elements);

        in.close();
    }

    public static void pares(int[] elements) {
        ArrayList<int[]> newElements = new ArrayList<int[]>();

        for (int i = 0; i < elements.length-1; i++) {
            for (int j = i; j < elements.length; j++) {
                if ((elements[i] - elements[j]) == 2 || (elements[i] - elements[j]) == -2) {
                    int[] tempArray = new int[2];
                    tempArray[0] = elements[i];
                    tempArray[1] = elements[j];
                    newElements.add(tempArray);
                }
            }
        }

        for (int[] e : newElements) {
            if (e[0] > e[1]) {
                int temp = e[0];
                e[0] = e[1];
                e[1] = temp;
            }
        }

        int[][] orderedElts = new int[newElements.size()][2];
        int i = 0;
        while (newElements.size() > 0) {
            int min = Integer.MAX_VALUE;
            int count = 0, index = -1;
            for (int[] e : newElements) {
                if (e[0] < min) {
                    min = e[0];
                    index = count;
                }
                count++;
            }

            orderedElts[i][0] = newElements.get(index)[0];
            orderedElts[i++][1] = newElements.get(index)[1];
            newElements.remove(index);
        }

        for (int[] e : orderedElts)
            System.out.println(e[0] + "," + e[1]);

    }
}
