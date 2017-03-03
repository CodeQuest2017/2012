// INCOMPLETE
import java.util.*;
import java.io.*;

public class Prob12 {
    public static List<Boolean[]> maze = new ArrayList<Boolean[]>();
    public static boolean[][] path; // Global to override in recursive call
	public static int M;
	public static int N;
	
	public static void main(String[] args) throws IOException {
	    init();
		// For each block in col[0]:
		for(int i = 0; i < M; i++) {
		    // If the current block is a potential block A:
		    if(maze.get(i)[0]) {
		    	// While we are not at block B and we can move somewhere
		    	boolean canMove = true;
		    	boolean notB = true;
		    	int currentRow = i;
		    	int currentColumn = 0;
		    	List<Integer[]> subpath = new ArrayList<Integer[]>(); 
		    	// Store the path array
		    	path = new boolean[M][N];
		    	// Keep track of our last move
		    	int lastMove = 0;
		    	while(canMove && notB) {
		    		boolean canMoveLeft = false;
		    		boolean canMoveRight = false;
		    		boolean canMoveUp = false;
		    		boolean canMoveDown = false;
		    		// If we can move somewhere else, move there
		    		
		    		// When we move somewhere, save that value in path[][]
		    		// If we find a dead end, remove all values from path[][]
		    		
		    		// If we can move to more than one place, save that intersection
		    		if(currentColumn > 0 && maze.get(currentRow)[currentColumn - 1] && lastMove != 2) canMoveLeft = true;
		    		if(currentColumn + 1 < N && maze.get(currentRow)[currentColumn + 1] && lastMove != 1) canMoveRight = true;
		    		if(currentRow + 1 < M && maze.get(currentRow + 1)[currentColumn] && lastMove != 4) canMoveUp = true;
		    		if(currentRow > 0 && maze.get(currentRow - 1)[currentColumn] && lastMove != 3) canMoveDown = true;
		    		
		    		if(!canMoveLeft && !canMoveRight && !canMoveUp && !canMoveDown) {
		    			System.out.println("Can't move anywhere at Row: " + currentRow + ", Column: " + currentColumn);
		    			System.exit(0);
		    		}
		    		
		    		// If we can only go one way, go that way
		    		if(canMoveLeft ^ canMoveRight ^ canMoveUp ^ canMoveDown) {
		    			if(canMoveLeft) {
		    				path[currentRow][currentColumn - 1] = true;
		    				currentColumn--;
		    				lastMove = 1;
		    			}
		    			if(canMoveRight) {
		    				path[currentRow][currentColumn + 1] = true;
		    				currentColumn++;
		    				lastMove = 2;
		    			}
		    			if(canMoveUp) {
		    				path[currentRow - 1][currentColumn] = true;
		    				currentRow--;
		    				lastMove = 3;
		    			}
		    			if(canMoveDown) {
		    				path[currentRow + 1][currentColumn] = true;
		    				currentRow++;
		    				lastMove = 4;
		    			}
		    		} else {
		    			// Otherwise, we can go more than one way
		    			System.out.println("We can go more than one way at: " + currentColumn + ", " + currentRow);
		    			break;
		    		}
		    	}
		    }
		}
	}
	
	public static void init() throws IOException {
		Scanner scan = new Scanner(new File("Prob12.in.txt"));
		while(scan.hasNext()) {
			String next = scan.nextLine();
			Boolean[] row = new Boolean[next.length()];
			for(int i = 0, x = row.length; i < x; i++) {
				row[i] = next.charAt(i) == 'O';
			}
			maze.add(row);
		}
		// Write a recursive call that stores the path into a path array
		M = maze.size();
		N = maze.get(0).length;
		scan.close();
	}
}