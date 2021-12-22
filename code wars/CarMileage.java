import java.util.regex.Pattern;

public class CarMileage {
    public static int isInteresting(int number, int[] awesomePhrases) {
        for (int i = 0; i < 3; i++) {
            if (number + i < 100) continue;

            String num = String.valueOf(number + i);

            // Case 1 and 2
            if (Pattern.matches("0+", num.substring(1)) || 
                    Pattern.matches(String.format("%c+", num.charAt(0)), num))
                return i == 0 ? 2 : 1;
            
            // Case 3
            if (num.charAt(0) != 0) {
                boolean sequential = true;
                for (int c = 1; c < num.length(); c++) {
                    if (num.charAt(c) == num.charAt(c-1)+1 || (num.charAt(c) == '0' && num.charAt(c-1) == '9'))
                        continue;
                    sequential = false;
                    break;
                }
                if (sequential) return i == 0 ? 2 : 1;
            }
            
            // Case 4
            boolean sequential = true;
            for (int c = 1; c < num.length(); c++) {
                if (num.charAt(c) == num.charAt(c-1)-1)
                    continue;
                sequential = false;
                break;
            
            }
            if (sequential) return i == 0 ? 2 : 1;

            // Case 5
            double lim = Math.floor((float) num.length() / 2);
            boolean polindrome = true;

            for (int c = 0; c <= lim; c++) {
                if (num.charAt(c) == num.charAt(num.length()-1-c))
                    continue;
                polindrome = false;
                break;                
            }
            if (polindrome) return i == 0 ? 2 : 1;

            // Case 6
            for (int word : awesomePhrases) {
                if (number + i == word)
                    return i == 0 ? 2 : 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        // "boring" numbers
        System.out.println(CarMileage.isInteresting(3, new int[]{1337, 256}));    // 0
        System.out.println(CarMileage.isInteresting(3236, new int[]{1337, 256})); // 0

        // progress as we near an "interesting" number
        System.out.println(CarMileage.isInteresting(11207, new int[]{})); // 0
        System.out.println(CarMileage.isInteresting(11208, new int[]{})); // 0
        System.out.println(CarMileage.isInteresting(11209, new int[]{})); // 1
        System.out.println(CarMileage.isInteresting(11210, new int[]{})); // 1
        System.out.println(CarMileage.isInteresting(11211, new int[]{})); // 2

        // nearing a provided "awesome phrase"
        System.out.println(CarMileage.isInteresting(1335, new int[]{1337, 256})); // 1
        System.out.println(CarMileage.isInteresting(1336, new int[]{1337, 256})); // 1
        System.out.println(CarMileage.isInteresting(1337, new int[]{1337, 256})); // 2

    }
    
  }