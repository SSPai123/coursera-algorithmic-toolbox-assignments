import java.util.*;

public class DotProduct {

    private static long maxDotProduct(List<Long> a, List<Long> b) {
        long result = 0;
        
        //Sort the list of profits per clicks in descending order
        Collections.sort(a);
        Collections.reverse(a);
        
        //Sort the list of average number of clicks per day in descending order
        Collections.sort(b);
        Collections.reverse(b);
        
        //maximum dot product is the sum of individual products of values sorted in descending order
        for (int i = 0; i < a.size(); i++) {
            result += a.get(i) * b.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        //profit per click of the i-th ad
        List<Long> a = new ArrayList<Long>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextLong());
        }
        
        //average number of clicks per day of the i-th slot
        List<Long> b = new ArrayList<Long>();
        for (int i = 0; i < n; i++) {
        	b.add(scanner.nextLong());
        }
        System.out.println(maxDotProduct(a, b));
    }
}

