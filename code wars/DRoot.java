public class DRoot {
    public static int digital_root(int n) {
        return (n >= 10) ? digital_root(String.valueOf(n).chars()
        .map(c -> Character.getNumericValue(c)).sum()) : n;
    }

    public static void main(String[] args) {
        System.out.println(digital_root(16));
    }
}