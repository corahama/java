import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FindingFacebook {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n_cases = Integer.valueOf(br.readLine());
        char[] word = {'f', 'a', 'c', 'e', 'b', 'o', 'o', 'k'};

        for (int c = 0; c < n_cases; c++) {
            String str = br.readLine();
            int j = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == word[j]) j++;
                if (j == 8) break;
            }

            System.out.printf("Case #%d: %s\n", c + 1, j == 8 ? "YES" : "NO");
        }
    }
}
