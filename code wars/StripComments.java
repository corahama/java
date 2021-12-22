public class StripComments {

	public static String stripComments(String text, String[] commentSymbols) {
        String[] splits = text.split("\n");
        String output = "";
        int tail;

        for (String str : splits) {
            if (str.isBlank()) {output += "\n"; continue;}

            tail = str.length();
            for (String sy : commentSymbols) {
                if (str.contains(sy)) {
                    tail = str.indexOf(sy);
                    break;
                }
            }

            if (tail == 0) {output += "\n"; continue;}
            
            while (str.charAt(tail - 1) == ' ') tail--;
            output += str.substring(0, tail) + "\n";
        }

		return output.substring(0, output.length() - 1);
	}
    
    public static void main(String[] args) {
        System.out.println(stripComments("#\nc\nd $e f g", new String[] { "#", "$" }));
    }
}
