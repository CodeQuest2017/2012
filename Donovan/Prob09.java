import java.util.*;
import java.io.*;

public class Prob09 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("Prob09.in.txt"));
		List<String> words = new ArrayList<String>();
		while(scan.hasNext()) {
			words.add(scan.next());
		}
		// For each word in the line
		for(int i = 0, x = words.size(); i < x; i++) {
			String a = words.get(i).toLowerCase();
			// For each word following that word
			for(int j = i + 1; j < x; j++) {
				String b = words.get(j).toLowerCase();
				int size = a.length();
				if(size == b.length() && !a.equals(b)) {
					// Count how many letters are the same
					int count = 0;
					for(int k = 0; k < size; k++) if(a.charAt(k) == b.charAt(k)) count++;
					if(count == size - 1) System.out.println(words.get(i) + " " + words.get(j));
				}
			}
		}
		scan.close();
	}
}