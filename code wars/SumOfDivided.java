public class SumOfDivided {
    public static String sumOfDivided(int[] l) {
        int max = Math.abs(l[0]);
        for (int n : l) {
            n = Math.abs(n);
            if (n > max) max = n;
        }

        String output = "";

        int sum2 = 0;
        boolean div2 = false;
        for (int n : l) {
            if (Math.abs(n) % 2 == 0) {
                sum2 += n;
                div2 = true;
            }
        }
        if (sum2 != 0 || div2) output += String.format("(%d %d)", 2, sum2);

        for (int i = 3; i <= max; i+=2) {
            boolean prime = true;
            for (int j = 2; j < Math.sqrt(i) + 1; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (!prime) continue;

            int sum = 0;
            boolean div = false;
            for (int n : l) {
                if (Math.abs(n) % i == 0) {
                    sum += n;
                    div = true;
                }
            }
            if (sum != 0 || div) output += String.format("(%d %d)", i, sum);
        }
        
        return output;
    }

    public static void main(String[] args) {
        // int[] l = {-29804, -4209, -28265, -72769, -31744};
        // int[] l = {12,15};
        int[] l = {100000,1000000};
        System.out.println(sumOfDivided(l)); // (2 12)(3 27)(5 15)
    }
  }
  