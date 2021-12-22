import java.lang.Math;

public class FactorialTrailingZeros {
    public static int zeros(int n) {
        int zeros = 0;
        int k = (int)(Math.log(n) / Math.log(5));
        
        for (int i = 1; i <= k; i++) {
            zeros += n/Math.pow(5, i);
        }

        return zeros;
    }

    public static void main(String[] args) {
        System.out.println(zeros(12));
    }
    
}
