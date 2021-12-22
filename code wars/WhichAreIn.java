import java.util.ArrayList;
import java.util.Arrays;

public class WhichAreIn { 	
	public static String[] inArray(String[] array1, String[] array2) {
        ArrayList<String> sArray = new ArrayList<>();

        for (String str : array1) {
            for (String str2 : array2) {
                if (str2.contains(str)) {
                    sArray.add(str);
                    break;
                }

            }
        }

        String[] r = sArray.toArray(new String[sArray.size()]);
        Arrays.sort(r);

        return r;
	}

    public static void main(String[] args) {
        for (String str : inArray(new String[] { "arp", "live", "strong" },
        new String[] { "lively", "alive", "harp", "sharp", "armstrong" }))
            System.out.println(str);
    }
}
