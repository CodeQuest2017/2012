import java.util.*;
import java.io.*;

public class Prob01 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File(args[0] + "Prob01.in.txt"));
		double ans = 0;
		while(scan.hasNext()) {
			String line = scan.next();
			String coin = line.split("=")[0];
			int value = Integer.parseInt(line.split("=")[1]);
			double v = 0;
			switch(coin) {
				case "DIME": v = 0.10; break;
				case "NICKEL": v = 0.05; break;
				case "PENNY": v = 0.01; break;
				case "HALFDOLLAR": v = 0.50; break;
				case "QUARTER": v = 0.25; break;
			}
			ans += value * v;
		}
		System.out.printf("$%.2f", ans);
		System.out.print("\n");
		scan.close();
	}
}
