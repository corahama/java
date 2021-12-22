public class Dubstep {
    public static String SongDecoder (String song) {
        int i = 0;
        String output = "";
        boolean swtch = true;
        
        while (i < song.length()-3) {
            if (song.substring(i, i+3).equals("WUB") && swtch)
                i += 3;
            else if (song.substring(i, i+3).equals("WUB") && !swtch) {
                i += 3;
                swtch = true;
                output += " ";
            }
            else {
                output += song.substring(i, i+1);
                i++;
                swtch = false;
            }
        }
        
        try {
            if (!song.substring(song.length()-3, song.length()).equals("WUB") && swtch)
                output += song.substring(i, song.length());
            else if (!song.substring(song.length()-3, song.length()).equals("WUB"))
                output += song.substring(song.length()-3, song.length());
        } catch (Exception e) {
            output = song;            
        }

        return (output.substring(output.length()-1, output.length()).equals(" ") ? output.substring(0, output.length()-1) : output);
    }

    public static void main(String[] args) {
        System.out.print(SongDecoder("WUBWEWUBWUBWUBAREWUBTHEWUBCHAMPIONSWUBMYWUBWUBWUBFRIENDWUB"));
        // =>  WE ARE THE CHAMPIONS MY FRIEND
    }
}

