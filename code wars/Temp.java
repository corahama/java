import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Temp {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        IntStream.of(Arrays.copyOfRange(arr, 1, 3)).forEach(System.out::println);
        
        
    }
}