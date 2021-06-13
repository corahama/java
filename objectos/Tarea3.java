import java.util.Scanner;

public class Tarea3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        char[] letters = new char[size];

        in.nextLine();
        for (int i = 0; i < size; i++) {
            String temp = in.nextLine();
            letters[i] = temp.charAt(0);
        }

        for (int i = 1; i < letters.length; i++) {
            int currentAscii = (int) letters[i];
            int previousAscii = (int) letters[i-1];
            if (currentAscii-previousAscii > 1)
                System.out.println(Character.toString((char)currentAscii-1));
        }

        in.close();
    }
}
