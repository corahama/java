public class WeightSort {	
	public static String orderWeight(String str) {
        String [] elms = str.trim().replaceAll(" +", " ").split(" ");
        String output = "", temp;
        
        for (int i = 0; i < elms.length - 1; i++) {
            for (int j = i + 1; j < elms.length; j++) {
                if (sumElms(elms[i]) > sumElms(elms[j])) {
                    temp = elms[i];
                    elms[i] = elms[j];
                    elms[j] = temp;
                }
                else if (sumElms(elms[i]) == sumElms(elms[j]))
                    if (elms[i].compareTo(elms[j]) > 0) {
                        temp = elms[i];
                        elms[i] = elms[j];
                        elms[j] = temp;
                    }
            }
        }

        for (String e : elms)
            output += String.format("%s ", e);
        
        return output.trim();
	}

    public static int sumElms(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++)
            res += Character.getNumericValue(str.charAt(i));
        return res;
    }

    public static void main(String[] args) {
        System.out.printf("%S", orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }
}