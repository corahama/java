import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;

public class Lento {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        int[] bunches = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] evens = Arrays.stream(bunches).filter(c -> c % 2 == 0).toArray();
        int[] odds = Arrays.stream(bunches).filter(c -> c % 2 != 0).toArray();

        Arrays.sort(odds);

        if (odds.length == 0) {
            System.out.printf("0\n");

        } else {
            int result = IntStream.of(odds).sum();
            result += IntStream.of(evens).sum();

            if (result % 2 == 1) {
                System.out.println(result);
            } else {
                System.out.println(result-odds[0]);
            }

        }

        in.close();
    }
}
