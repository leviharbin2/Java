

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SelectionProblem {

	public static void main(String[] args) {



//		 Find the Kth largest number in a series of random numbers, where K = N/2 and N is the amount of numbers.
//				 So, for 10 numbers, find the 5th largest.

		int N=10;
		int M=100;
		int O=1000;
		int P=10000;
		int temp=0;
		int count=0;

		
		
		
		
//======================================================================	
		int[] array = new int [N];
		int[] array2 = new int [M];
		int[] array3 = new int [O];
		int[] array4 = new int [P];
		Random rand = new Random();
//======================================================================	

		
		
		
		
		long start = System.nanoTime();
		
		for(int i=0; i<array.length;i++ ){
			array[i] = rand.nextInt(100);
           }
		Arrays.sort(array);
		System.out.println(array[N/2-1]);
		long end = System.nanoTime();
//		System.out.println(Arrays.toString(array));
        System.out.println("Runtime:" +
		String.format( "%12.6f",((end-start)/Math.pow(10,9))));
		
//======================================================================	
	
		
		 start = System.nanoTime();
		
		for(int i=0; i<array2.length;i++ ){
			array2[i] = rand.nextInt(1000);
           }
		Arrays.sort(array2);
		System.out.println(array2[M/2-1]);
		 end = System.nanoTime();
		 System.out.println("Runtime:" +
					String.format( "%12.6f",((end-start)/Math.pow(10,9))));
		 
//======================================================================	
	
		
		
		 start = System.nanoTime();
		
		for(int i=0; i<array3.length;i++ ){
			array3[i] = rand.nextInt(10000);
           }
		Arrays.sort(array3);
		System.out.println(array3[O/2-1]);
		 end = System.nanoTime();
		 System.out.println("Runtime:" +
					String.format( "%12.6f",((end-start)/Math.pow(10,9))));
		
		
		
		
//======================================================================	
	
		
		start = System.nanoTime();
		
		for(int i=0; i<array4.length;i++ ){
			array4[i] = rand.nextInt(100000);
           }
		Arrays.sort(array4);
		System.out.println(array4[P/2-1]);
		 end = System.nanoTime();
		 System.out.println("Runtime:" +
					String.format( "%12.6f",((end-start)/Math.pow(10,9))));
		
		
		
		
//======================================================================	

		
		
		
	
		

		
		
		
		


	}

}
