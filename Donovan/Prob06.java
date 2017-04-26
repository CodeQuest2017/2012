import java.util.*;
import java.io.*;

public class Prob06 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File(args[0] + "Prob06.in.txt"));
		String possible = "0123456789abcdefghijklmnopqrstuvwxyz";
		while(scan.hasNext()) {
			String s = scan.nextLine();
			int x = s.length();
			String sl = s.toLowerCase();
			String ns = "";
			for(int i = 0; i < x; i++) {
				String p = String.valueOf(sl.charAt(i));
				if(possible.indexOf(p) > -1) ns += p;
			}
			int y = ns.length();
			boolean palindrome = true;
			for(int i = 0; i < y / 2; i++) {
				if(ns.charAt(i) != ns.charAt(y-i-1)) {
					palindrome = false;
				}
			}
			if(palindrome) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
		scan.close();
	}
}