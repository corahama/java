public class ASum {
	
	public static long findNb(long m) {
        long n = 1, sum = 0;
		while (m > sum) {
            sum += n * n * n;
            if (sum == m)
                return n;
            n++;
        }

        return -1;
	}

    public  static void main(String[] args) {
        System.out.println(findNb(40539911473216L));
    }
}