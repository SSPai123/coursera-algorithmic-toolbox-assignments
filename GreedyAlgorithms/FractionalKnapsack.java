import java.util.*;

public class FractionalKnapsack {
	private static double getOptimalValue(long capacity, long[] values, long[] weights) {
		double value = 0;

   // sort 2 arrays in increasing order of values based on the value/weight ratio
		if(values.length > 1) {
			for (int n = 0; n < values.length - 1; n++) {
				for (int m = 0; m < values.length - n - 1; m++) {
					if (((double) values[m] / weights[m]) < ((double) values[m + 1] / weights[m + 1])) {
						long temp1 = values[m];
						values[m] = values[m + 1];
						values[m + 1] = temp1;
						long temp2 = weights[m];
						weights[m] = weights[m + 1];
						weights[m + 1] = temp2;
					}
				}
			}

		}
		
		  long weightOfKs = 0;
			for (int i = 0; i < weights.length; i++) {
				//add whole item if the weights is less than the total capacity and add the corresponding values
				if (weightOfKs + weights[i] <= capacity) {
					weightOfKs += weights[i];
					value += values[i];
				} else {
					//add fraction of it to the knapsack and corresponding effective values 
					long fraction = Math.abs(capacity - weightOfKs);
					value += values[i] * ((double) fraction / weights[i]);
					break;
				}
			}
		
		return value;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
    //number of items
		long n = scanner.nextLong();
    //total capacity of the knapsack
		long capacity = scanner.nextLong();
    //values and weights of the n items
		long[] values = new long[(int) n];
		long[] weights = new long[(int) n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextLong();
			weights[i] = scanner.nextLong();
		}
		System.out.println(getOptimalValue(capacity, values, weights));
	}
}
