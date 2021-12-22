public class PrimeDecomp {
    public static String factors(int n) {
        String output = "";
        int i = 2, count = 0;
        
        while (n > 1) {
            count = 0;
            while (n % i == 0) {
                n = n / i;
                count++;
            }
            if (count != 0)
                output += (count == 1) ? String.format("(%d)", i) : String.format("(%d**%d)", i, count);
            i++;
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(factors(7775460));
    }
       
}