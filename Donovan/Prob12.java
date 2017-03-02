// INCOMPLETE
import java.util.*;
import java.io.*;

public class Prob12 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("Prob12.in.txt"));
		List<Boolean[]> maze = new ArrayList<Boolean[]>();
		while(scan.hasNext()) {
			String next = scan.nextLine();
			Boolean[] row = new Boolean[next.length()];
			for(int i = 0, x = row.length; i < x; i++) {
				if(next.charAt(i) == 'O') row[i] = true;
			}
			maze.add(row);
		}
		// Write a recursive call that stores the path into a path array
		final int M = maze.size();
		final int N = maze.get(0).length;
		boolean[][] path = new boolean[M][N];
		for(int i = 0; i < M; i++) {
			System.out.println(Arrays.toString(maze.get(i));
		}
		scan.close();
	}
}
