import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * finds a closest pair from an array
 * 
 * @author Nadeesha Maduranga (nadeesham332@gmail.com)
 *
 */
public class ClosestPair {
	public static void main(String[] args) throws IOException {
		System.out.print("This program will finds a closest pair from an array.\n" + "n - "
				+ "number of integers in input array.\n" + "Enter input array size(n): ");

		// Getting input size from user
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		double a[] = new double[n];
		int inputSize = 0;
		String input;
		// Getting input from the user
		do {
			System.out.print("Enter " + n + " integers, separated using space, to sort (n1 n2 n3 ...): ");
			input = reader.readLine();
			inputSize = input.split(" ").length;
		} while (inputSize != n);

		String[] numbers = input.split(" ");
		for (int j = 0; j < n; j++) {

			a[j] = Double.parseDouble(numbers[j]);
		}

		double mingap = Math.abs(a[0] - a[1]);
		// find the minimum gap
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				double gap = Math.abs(a[i] - a[j]);
				if (i != j && gap < mingap) {
					mingap = gap;
				}
			}
		}
		// find the elements those have minimum gap and print results
		System.out.print("The closest number pairs are : ");
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				double gap = Math.abs(a[i] - a[j]);

				if (gap == mingap) {
					System.out.print("(" + a[i] + " and " + a[j] + ")  ");
				}
			}
		}
	}

}
