import java.util.*;
import java.io.*;

public class Prob07 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("Prob07.in.txt"));
		int P = scan.nextInt();
		int N = 100 / P;
		
		scan.nextLine(); // Advance to the next line
		
		String[] correct = new String[N];
		for(int i = 0; i < N; i++) correct[i] = scan.nextLine();
		
		while(scan.hasNext()) {
			String ans = scan.nextLine();
			int numCorrect = 0;
			
			for(int i = 0; i < N; i++) {
				if(correct[i].equals(scan.nextLine())) numCorrect++;
			}
			
			System.out.println(ans + ": " + P * numCorrect);
		}
		scan.close();
	}
}
