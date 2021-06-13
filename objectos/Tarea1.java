import java.util.ArrayList;
import java.util.Scanner;

public class Tarea1 {
    public static void main(String[] args) {
        ArrayList<Integer> customList = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        int num;

        num = in.nextInt();
        while (num != -1) {
            customList.add(num);            
            num = in.nextInt();
        }

        int sum = 0;
        boolean even = false;
        int idouble;
        for (int i = customList.size()-1; i >= 0; i--) {
            if (even) {
                idouble = customList.get(i)*2;
                if (idouble > 9) {
                    idouble -= 9;
                }
                sum += idouble;
                even = false;
            } else {
                sum += customList.get(i);
                even = true;
            }
        }

        if (sum % 10 == 0 || sum == 0) {
            System.out.println("Valido");
        } else {
            System.out.println("No Valido");
        }

        in.close();
    }   
}