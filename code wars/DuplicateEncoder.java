public class DuplicateEncoder {
	static String encode(String word){
        String output = "";
        boolean twice;
        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            twice = false;
            for (int j = i + 1; j < word.length() + i; j++) {
                if (word.charAt(i) == word.charAt(j % word.length())) {
                    output += ")";
                    twice = true;
                    break;
                }
            }
            if (!twice) output += "(";
        }
        
        return output;
    }

    public static void main(String[] args) {
        System.out.println(encode("(( @"));
    }
}
