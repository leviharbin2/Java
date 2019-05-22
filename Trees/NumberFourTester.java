package assignment6;

public class NumberFourTester {

	public static void main(String[] args) {//creates a heap and then prints out kth largest element
		
		Integer[] ar1 = {1,2,3,4,5,6,7,8,9,10};
		//Integer[] ar1 = {2,4,6,8,10,12,14,16,18,20};
		//Integer[] ar1 = {1,8,6,4,12,33};
	    NumberFour<Integer> mbh2 = new NumberFour<Integer>(ar1);

 
		
		
		System.out.println(mbh2.kTHLargestElement(ar1,4));
	
		

		
	
	}

}
 