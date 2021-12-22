import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

class SumDigPower {
    
    public static List<Long> sumDigPow(long a, long b) {
        List<Long> result = new ArrayList<>();
        int sumPow;

        for (int i = (int)a, p; i <= (int)b; i++) {
            p = 1;
            sumPow = 0;
            for (char c : String.valueOf(i).toCharArray())
                sumPow += Math.pow(Character.getNumericValue(c), p++);
            if (i == sumPow) result.add((long)sumPow);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(sumDigPow(90, 100));
    }
}