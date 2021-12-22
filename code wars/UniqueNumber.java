import java.util.HashMap;
import java.util.Map;

public class UniqueNumber {
    public static double findUniq(double arr[]) {
        HashMap<Double, Integer> map = new HashMap<>();

        for (double e : arr)
            if (map.containsKey(e))
                map.put(e, map.get(e)+1);
            else
                map.put(e, 1);
        
        for (Map.Entry<Double, Integer> set : map.entrySet())
            if (set.getValue() == 1)
                return set.getKey();
        
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1}));
    }
}