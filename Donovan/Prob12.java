// INCOMPLETE
import java.util.*;
import java.io.*;

public class Prob12 {
    public static Character[][] maze;
    public static boolean[][] marked;
	public static int M;
	public static int N;
	
	public static void main(String[] args) throws IOException {
	    init();
	    for(int i = 0; i < M; i++) {
	    	if(maze[i][0] == 'O') {
	    		System.out.println(solveMaze(i, 0));
	    	}
	    }
	}
	public static Stack R = new Stack();
	public static Stack C = new Stack();
	public static int solveMaze(int row, int col) {
		System.out.println("row: " + row + ", col: " + col);
		// If we reached the end of the maze
		if(col == N - 1) {
			return 1;
		} else {
			boolean down = row + 1 < M && maze[row + 1][col] == 'O' && !marked[row + 1][col];
			boolean left = col > 0 && maze[row][col - 1] == 'O' && !marked[row][col - 1];
			boolean up = row > 0 && maze[row - 1][col] == 'O' && !marked[row - 1][col];
			boolean right = col + 1 < N && maze[row][col + 1] == 'O' && !marked[row][col + 1];
			int numMoves = 0;
			numMoves += down ? 1 : 0;
			numMoves += left ? 1 : 0;
			numMoves += up ? 1 : 0;
			numMoves += down ? 1 : 0;
			if(numMoves >= 2) {
				R.push(row);
				C.push(col);
			}
			// Can we go down?
			if(down) {
				marked[row][col] = true;
				return solveMaze(row + 1, col);
			}
			// Left?
			if(left) {
				marked[row][col] = true;
				return solveMaze(row, col - 1);
			}
			// Up?
			if(up) {
				marked[row][col] = true;
				return solveMaze(row - 1, col);
			}
			// Right?
			if(right) {
				marked[row][col] = true;
				return solveMaze(row, col + 1);
			}
		}
		// We didn't reach the end of the maze, and we can't go anywhere.
		// Time to backtrack.
		return solveMaze(R.pop(), C.pop());
	}

	public static void init() throws IOException {
		Scanner scan = new Scanner(new File("Prob12.in.txt"));
		List<Character[]> mazeTemp = new ArrayList<Character[]>();
		while(scan.hasNext()) {
			String next = scan.nextLine();
			Character[] row = new Character[next.length()];
			for(int i = 0, x = row.length; i < x; i++) {
				row[i] = next.charAt(i);
			}
			mazeTemp.add(row);
		}
		M = mazeTemp.size();
		N = mazeTemp.get(0).length;
		maze = new Character[M][N];
		marked = new boolean[M][N];
		for(int i = 0; i < M; i++) {
			maze[i] = mazeTemp.get(i);
		}
		scan.close();
	}
}