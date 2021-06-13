import java.util.Scanner;
import java.util.ArrayList;

public class Tarea5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();

        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 1; i <= num/2; i++) {
            int sum = 0;
            int temp = i*2;
            while (temp != 0) {
                sum += temp%2;
                temp = temp / 2;
            }
            array.add(sum);
        }

        int sum = 0;
        for (int e : array) {
            // System.out.print(e + " ");
            sum += e;
        }

        System.out.println(sum);
    }
}
