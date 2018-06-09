import java.util.*;
/**To find the last digit of any nth Fibonacci number specifically efficient for the large values of n*/
public class FibonacciLastDigit {

    private static int getFibonacciLastDigit(int n) {
    	//return the number as it is if it is 1 or 0
    	 if(n==1 || n==0) {
   		  return n;
  		}
    	
    	/**
    	 * We just need to focus on the last digits of first 60 fibonacci series because of the 
    	 * cyclicity property of the last digit of the fibonacci numbers. 
    	 * Last digit starts to repeat after every 60 numbers*/
    	ArrayList<Integer> fib=new ArrayList<>();
   	  	fib.add(0);
   	  	fib.add(1);
   	  	for (int i = 2; i <= 59; i++)
   	  		fib.add((fib.get(i-1) + fib.get(i-2)) % 10);
       
        return fib.get((int)(n % 60L));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }
}

