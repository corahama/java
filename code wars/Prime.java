import java.lang.Math;
import java.util.ArrayList;

public class Prime {
    static ArrayList<Integer> primes = new ArrayList<>() ;

    public static boolean isPrime(int num) {
        num = Math.abs(num);
        if (num == 1) return false;

        for (int i = 2; i <= (int)Math.sqrt(num)+1; i++) {
            if (check(i))
                primes.add(i);
        }

        for (Integer p : primes) {
            if (num % p == 0)
                break;
            return true;
        }

        return false;
    }

    public static boolean check(int n) {
        for (Integer p : primes) {
            if (n % p == 0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(Prime.isPrime(20));
    }
    
}
