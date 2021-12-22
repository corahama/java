import java.util.Scanner;
import java.util.Arrays;

public class CasaSustentable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n_cases = Integer.parseInt(in.nextLine());

        for (int c = 0; c < n_cases; c++) {
            int[] coords = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int[][] corner_coords = new int[3][2];
            corner_coords[0] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            corner_coords[1] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            corner_coords[2] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            
            boolean out = false;
            for (int i = 0; i < 3; i++) {
                int slope = 1;
                slope = (corner_coords[i][1]-corner_coords[(i+1)%3][1]) /
                    (corner_coords[i][0]-corner_coords[(i+1)%3][0]);
                for (int j = 0; j < 2; j++) {
                    if (j == 0) {
                        if (((coords[1] - corner_coords[i][1]) / slope) - coords[0] < 0) {
                            out = true;
                            break;
                        }
                    } else {
                        if (corner_coords[i][0] + slope*coords[0] - coords[1] < 0) {
                            out = true;
                            break;
                        }

                    }
                }
            }

            System.out.printf("Case #%d: %S\n", c+1, out ? "OUT" : "IN");
        }
    }
    
}
