
import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter a number");
	    int N = sc.nextInt();
	   
	   System.out.println(recursiveMethod(N));
	}

	public static int recursiveMethod(int n) {
		int count = 0;
        while (n > 0)
        {
            count += n & 1;
            n >>= 1;
        }
        return count;
	}
	
}
