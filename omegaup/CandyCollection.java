import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

public class CandyCollection {
    public static int getTotalCombinations(int size) {
        return size == 0 ? 0 : size + getTotalCombinations(size - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n_cases = Integer.valueOf(in.nextLine());

        for (int c = 0; c < n_cases; c++) {
            int n = Integer.valueOf(in.nextLine());

            int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    int temp_sum = IntStream.of(Arrays.copyOfRange(arr, j, i+1)).sum();
                    if (temp_sum > sum) sum = temp_sum;
                }
            }

            System.out.printf("Case #%d: %d\n", c+1, sum);

        }

        in.close();

    }
}
