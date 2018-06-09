import java.util.*;
/**To find GCD of 2 numbers using Euclid's Lemma
*   Euclid's Lemma:The GCD of 2 numbers is the largest number that divides both of them without leaving a remainder.
*   In case of very large numbers, replace int by long eveerywhere.
*/
public class GCD {
  private static int gcd(int a, int b) {
    int rem=0;
    while(b!=0) {
    	rem=a%b;
    	a=b;
    	b=rem;
    }

    return a;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
