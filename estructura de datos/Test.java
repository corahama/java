public class Test {
    public static void main(String[] args) {
        String[] string1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (String c : string1)
            System.out.print(c + " ");
        System.out.println();
        
        // We are goint to cut the element 5
        String target = "5";
        int index = -1;
        for (int i = 0; i < string1.length; i++) {
            if (string1[i].equals(target)) {
                index = i + 1;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < string1.length; i++) {
                string1[i-1] = string1[i];
            }
        }
        string1[string1.length-1] = null;

        for (String c : string1)
            System.out.print(c + " ");
    }
}