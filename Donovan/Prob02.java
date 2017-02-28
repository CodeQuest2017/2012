import java.util.*;
import java.io.*;

public class Prob02 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("Prob02.in.txt"));
		int i = 0, times = 0, herald = 0, n = 0;
		while(scan.hasNext()) {
			i++;
			n = scan.nextInt();
			if(i % 2 == 0) {
				herald = n;
				if(times == herald) {
					System.out.println("Times and Herald have the same number of subscribers");
				} else if(times > herald) {
					System.out.println("Times has " + ((times - herald) * 2) + " more subscribers");
				} else {
					System.out.println("Herald has " + ((herald - times) * 2) + " more subscribers");
				}
				times = 0;
				herald = 0;
			} else {
				times = n;
			}
		}
		scan.close();
	}
}