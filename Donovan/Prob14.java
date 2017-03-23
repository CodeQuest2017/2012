// INCOMPLETE
import java.util.*;
import java.io.*;

public class Prob14 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("Prob14.in.txt"));
		String[] path = scan.nextLine().split(";");
		List<String[]> routes = new ArrayList<String[]>();

		while(scan.hasNext()) {
			String[] route = scan.nextLine().split(";");
			routes.add(route);
		}

		// Get all the cities in the network
		int x = routes.size();
		Map<String, Integer> cities = new HashMap<String, Integer>();
		for(int i = 0, count = -1; i < x; i++) {
			for(int j = 0; j < 2; j++) {
				String city = routes.get(i)[j];
				if(!cities.containsKey(city)) {
					cities.put(city, ++count);
				}
			}
		}

		// Create the network
		final int N = cities.size();
		int[][] network = new int[N][N];

		cities.forEach((city, index) -> {
			// For each route
			for(int i = 0; i < x; i++) {
				String[] route = routes.get(i);
				// If this city goes somewhere
				if(route[0].equals(city)) {
					// Find where it goes
					cities.forEach((city2, index2) -> {
						// If we haven't came here yet
						if(network[index][index2] == 0) {
							// If the current city is where it goes then set the value of the path in the network
							network[index][index2] = (route[1].equals(city2)) ? Integer.parseInt(route[2]) : Integer.MAX_VALUE;
						}
					});
				}
			}
		});

		System.out.println(cities);

		// Most of the network works, but it doesn't save the relation after the first occurrence
		for(int i = 0, y = network.length; i < y; i++) {
			System.out.println(Arrays.toString(network[i]));
		}

		scan.close();
	}
}
