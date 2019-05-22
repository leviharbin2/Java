

import java.util.Arrays;
import java.util.Random;

public class NumberSevenDriver {

	public static void main(String[] args) {
		int[] array = new int[10];
	
		
			
		System.out.println(Arrays.toString(array));		
		algorithmOne(array);
		System.out.println("blank array^");
		System.out.println(Arrays.toString(array));
		System.out.println("Algorithm 1^ ");
		algorithmTwo(array);
		System.out.println(Arrays.toString(array));	
		System.out.println("Algorithm 2^ ");
		algorithmThree(array);
		System.out.println(Arrays.toString(array));		
		System.out.println("Algorithm 3^ ");
	

	}
//O(N^3)
	public static void algorithmOne(int[] a) {
		for (int i = 0; i < a.length; i++) {
		    a[i] = (int)(Math.random()*10);

		    for (int j = 0; j < i; j++) {
		        if (a[i] == a[j]) {
		            i--; 
		            break;
		        }
		    }  
		}
	}
	
	//O(N^2)
	public static void algorithmTwo(int[] a) {
		int[] used = new int[a.length];
		for (int i = 0; i < a.length; i++) {
		used[i]=(int) (Math.random()*10);
		if((used[i]==a[i])==true)
			a[i]=(int) (Math.random()*10);
		
		}
	
	}
	
		
	
	
	//O(N)
	public static void algorithmThree(int[] a) {
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i]=i+1;
			for(i = 1; i < a.length; i++)
				swapReferences(a[i], a[rand.nextInt(i)]);
			
			
			
	}
	}
	private static void swapReferences(int i, int j) {
		
		int temp = j;
		j = i;
		i=temp;
		
		
		
	}
}
