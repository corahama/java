import java.util.List;
import java.util.ArrayList;

public class SqInRect {
	
	public static List<Integer> sqInRect(int lng, int wdth) {
        if (lng == wdth) return null;

        List<Integer> res = new ArrayList<>();
        int tmp;
        
        do {
            if (lng < wdth) {
                tmp = lng;
                lng = wdth;
                wdth = tmp;
            }

            res.add(wdth);
            lng -= wdth;

        } while (lng > 0);
        
		return res;
	}

    public static void main(String[] args) {
        System.out.println(sqInRect(5, 3));
    }
}
