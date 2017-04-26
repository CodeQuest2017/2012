import java.util.*;
import java.io.*;

public class Prob10 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File(args[0] + "Prob10.in.txt"));
		while(scan.hasNext()) {
			long n = scan.nextInt();
			long ans = 1;
			for(long i = 2; i <= n; i++) {
				ans *= i;
			}
			System.out.println(ans);
		}
		scan.close();
	}
}