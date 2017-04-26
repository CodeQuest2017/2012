// INCOMPLETE
import java.util.*;
import java.io.*;

public class Prob05 {
    public static double originalPrincipal;
    public static double interestRate;
    public static double numMonths;
    public static double monthsPaid;
    public static double monthlyPayment;
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File(args[0] + "Prob05.in.txt"));
		while(scan.hasNext()) {
			originalPrincipal = scan.nextDouble();
			interestRate = scan.nextDouble();
			numMonths = scan.nextDouble();
			monthsPaid = scan.nextDouble();
			monthlyPayment = calculateMonthlyPayment();
			double remainingPrincipal = originalPrincipal;
			for(int i = 0; i < numMonths; i++) {
			    remainingPrincipal = makePayment(remainingPrincipal);
			}
			System.out.println(remainingPrincipal);
		}
		scan.close();
	}
	
	public static double calculateMonthlyPayment() {
	    return originalPrincipal * ((interestRate / 1200) / (1 - Math.pow(1 + interestRate, -numMonths)));
	}
	
	public static double makePayment(double remainingPrincipal) {
	    return remainingPrincipal - (monthlyPayment - (remainingPrincipal * (interestRate / 1200)));
	}
}

