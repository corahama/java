import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

public class Decompose {
    public static String decompose(long n) {
        TreeMap<Long, Long> map = new TreeMap<>();

        long i = n - 1, fi;
        n = (long) Math.pow(n, 2);
        do {
            fi = i;
            map.put(i, n);
            n -= (long) Math.pow(i, 2);
            i = (long) Math.sqrt(n);
        } while (n > 0 && i < fi);

        if (n == 0)
            return String.join(" ", map.keySet().stream().map(String::valueOf).toArray(String[]::new));

        ArrayList<Long> subsequence = new ArrayList<>();
        for (Map.Entry<Long, Long> e : map.entrySet()) {
            for (i = e.getKey().longValue() - 1; i > 0; i--) {
                subsequence.clear();
                n = e.getValue();
                long ci = i;
                do {
                    fi = ci;
                    subsequence.add(ci);
                    n -= (long) Math.pow(ci, 2);
                    ci = (long) Math.sqrt(n);
                } while (n > 0 && ci < fi);
                if (n == 0) {
                    final long limit = e.getKey();
                    return String.join(" ", subsequence.stream().sorted().map(String::valueOf).toArray(String[]::new)) + " " + String.join(" ", map.keySet().stream().filter(c -> c > limit).map(String::valueOf).toArray(String[]::new));
                }
            }
        }
        
        return null;
    }

    public static void main(String[] args) {
        System.out.println(decompose(11));
    }
}