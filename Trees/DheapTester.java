package bonus3;

public class DheapTester {

	public static void main(String[] args) {
   // Integer[] array = {10, 8, 6, 4, 2, 12, 14, 16, 18, 20};
    Integer[] array = {1};
    

    Dheap<Integer> DHP = new Dheap<>(array,3);//3 is Dheap Value, change to 4 for  4-heap
   
   System.out.println(DHP);
   DHP.insert(2);
   System.out.println(DHP);
   DHP.insert(3);
   System.out.println(DHP);
   DHP.insert(4);
   System.out.println(DHP);
   //DHP.insert(5);
    
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
