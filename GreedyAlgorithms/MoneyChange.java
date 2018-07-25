import java.util.*;

public class Change {

	public static int getChange(int[] denominations, int amount) {
		// If amount equals 0 and denominations are not available, return 0
		if (amount <= 0 || denominations.length == 0)
			return 0;

		// Create array which stores number of coins needed for amount varying from 1 to
		// the total amount needed
		int[] count = new int[amount + 1];

		// for amount 0, number of coins needed is 0
		count[0] = 0;

		// traverse from 1 to amount needed
		for (int i = 1; i <= amount; i++) {
			// consider the maximum possible number of coins initially.
			int minCount = Integer.MAX_VALUE;

			// iterate through denominations and find the minimum number of coins needed for
			// that amount
			for (int coin : denominations)
				if (i - coin >= 0)
					minCount = Math.min(minCount, count[i - coin]);

			// Assign the minimum count value to the appropriate position
			count[i] = (minCount == Integer.MAX_VALUE) ? Integer.MAX_VALUE : minCount + 1;
		}

		/*
		 * if still at the end, the count of coins for the amount needed is equal to max
		 * possible value, return 0, since valid number doesnt exist
		 */
		if (count[amount] == Integer.MAX_VALUE)
			return 0;

		// Return the number of coins for the amount needed which is stored in
		// count[amount]
		return count[amount];
	}

	public static void main(String[] args) {
		// Denominations in which we want the change in minimum possible number of coins
		int[] denominations = { 1, 5, 10 };

		Scanner s = new Scanner(System.in);
		// Amount for which we need change
		int amount = s.nextInt();
		System.out.println(getChange(denominations, amount));
	}
}
