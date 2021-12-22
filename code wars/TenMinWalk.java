public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10) return false;

        int x = 0; int y = 0;
        for (char c : walk) {
            switch (c) {
                case 'n':
                    x++;
                    break;
                case 's':
                    x--;
                    break;
                case 'e':
                    y++;
                    break;
                case 'w':
                    y--;
                    break;
                default:
                    break;
            }
        }
    
        return (x == 0 && y == 0) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
    }
}