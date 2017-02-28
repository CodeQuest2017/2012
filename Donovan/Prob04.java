import java.util.*;
import java.io.*;

public class Prob04 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("Prob04.in.txt"));
		String key = scan.nextLine();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(int i = 0, x = key.length(); i < x; i++) {
			map.put(i + 1, String.valueOf(key.charAt(i)));
		}
		while(scan.hasNext()) {
			String decoded = "";
			String message = scan.nextLine();
			String[] words = message.split(" ");
			for(int i = 0, x = words.length; i < x; i++) {
				String[] ns = words[i].split("-");
				for(int j = 0, y = ns.length; j < y; j++) {
					decoded += map.get(Integer.parseInt(ns[j]));
				}
				if(i + 1 != x) decoded += " ";
			}
			System.out.println(decoded);
		}
		scan.close();
	}
}