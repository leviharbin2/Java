package assignment6;

public class NumberThreeTester {

	public static void main(String[] args) {//creates a heap and removes k smallest elements from heap
		
		Integer[] ar1 = {1,2,3,4,5,6,7,8,9,10};
		   NumberThree<Integer> mbh2 = new NumberThree<Integer>(ar1);

 
		System.out.println(mbh2);
		System.out.println(mbh2.deleteKElements(4));

		
		
 
	}

}


