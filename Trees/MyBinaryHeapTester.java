package assignment6;




//N: 25, 50, 75, 100, 200, 300, 400, 500, 1000, 10000


public class MyBinaryHeapTester {
 
	public static void main(String[] args) {
//======================================================================		
		 long mbhStart = System.nanoTime();
	  Integer[] ar1 = new Integer[25];
      
	    for(int i = 0; i < ar1.length; i++) {
	      ar1[i] = (int)(Math.random()*1000 + 1);
	    }
	    MyBinaryHeap<Integer> mbh = new MyBinaryHeap<>(ar1);
	    long mbhEnd = System.nanoTime(); 
	    System.out.println("Runtime for bulk insert of 25:" +
				String.format( "%12.6f",((mbhStart-mbhEnd)/Math.pow(10,9))));
	    
	    long imbhStart = System.nanoTime();
	    MyBinaryHeap<Integer> imbh = new MyBinaryHeap<>();
    
	      
	    for(int i = 0; i < 25; i++) {
	    imbh.insert((int)(Math.random()*1000 + 1));
	    }
	    long imbhEnd = System.nanoTime();
	    System.out.println("Runtime for individual insert of 25:" +
				String.format( "%12.6f",((imbhStart-imbhEnd)/Math.pow(10,9))));
//======================================================================	    
	    
	    
//======================================================================		
		 long mbh2Start = System.nanoTime();
	  Integer[] ar2 = new Integer[50];
     
	    for(int i = 0; i < ar2.length; i++) {
	      ar2[i] = (int)(Math.random()*1000 + 1);
	    }
	    MyBinaryHeap<Integer> mbh2 = new MyBinaryHeap<>(ar2);
	    long mbh2End = System.nanoTime(); 
	    System.out.println("Runtime for bulk insert of 50:" +
				String.format( "%12.6f",((mbh2Start-mbh2End)/Math.pow(10,9))));
	    
	    long imbh2Start = System.nanoTime();
	    MyBinaryHeap<Integer> imbh2 = new MyBinaryHeap<>();
   
	      
	    for(int i = 0; i < 50; i++) {
	    imbh2.insert((int)(Math.random()*1000 + 1));
	    }
	    long imbh2End = System.nanoTime();
	    System.out.println("Runtime for individual insert of50:" +
				String.format( "%12.6f",((imbh2Start-imbh2End)/Math.pow(10,9))));
		  
//======================================================================	    
		 long mbh3Start = System.nanoTime();
	  Integer[] ar3 = new Integer[75];
    
	    for(int i = 0; i < ar3.length; i++) {
	      ar3[i] = (int)(Math.random()*1000 + 1);
	    }
	    MyBinaryHeap<Integer> mbh3 = new MyBinaryHeap<>(ar3);
	    long mbh3End = System.nanoTime(); 
	    System.out.println("Runtime for bulk insert of 75:" +
				String.format( "%12.6f",((mbh3Start-mbh3End)/Math.pow(10,9))));
	    
	    long imbh3Start = System.nanoTime();
	    MyBinaryHeap<Integer> imbh3 = new MyBinaryHeap<>();
  
	      
	    for(int i = 0; i < 75; i++) {
	    imbh3.insert((int)(Math.random()*1000 + 1));
	    }
	    long imbh3End = System.nanoTime();
	    System.out.println("Runtime for individual insert of 75:" +
				String.format( "%12.6f",((imbh3Start-imbh3End)/Math.pow(10,9))));
			  
//======================================================================
		
		 long mbh4Start = System.nanoTime();
	  Integer[] ar4 = new Integer[100];
   
	    for(int i = 0; i < ar4.length; i++) {
	      ar4[i] = (int)(Math.random()*1000 + 1);
	    }
	    MyBinaryHeap<Integer> mbh4 = new MyBinaryHeap<>(ar4);
	    long mbh4End = System.nanoTime(); 
	    System.out.println("Runtime for bulk insert of 100:" +
				String.format( "%12.6f",((mbh4Start-mbh4End)/Math.pow(10,9))));
	    
	    long imbh4Start = System.nanoTime();
	    MyBinaryHeap<Integer> imbh4 = new MyBinaryHeap<>();
 
	      
	    for(int i = 0; i < 100; i++) {
	    imbh4.insert((int)(Math.random()*1000 + 1));
	    }
	    long imbh4End = System.nanoTime();
	    System.out.println("Runtime for individual insert of 100:" +
				String.format( "%12.6f",((imbh4Start-imbh4End)/Math.pow(10,9))));
//======================================================================
		 long mbh5Start = System.nanoTime();
	  Integer[] ar5 = new Integer[200];
   
	    for(int i = 0; i < ar5.length; i++) {
	      ar5[i] = (int)(Math.random()*1000 + 1);
	    }
	    MyBinaryHeap<Integer> mbh5 = new MyBinaryHeap<>(ar5);
	    long mbh5End = System.nanoTime(); 
	    System.out.println("Runtime for bulk insert of 200:" +
				String.format( "%12.6f",((mbh5Start-mbh5End)/Math.pow(10,9))));
	    
	    long imbh5Start = System.nanoTime();
	    MyBinaryHeap<Integer> imbh5 = new MyBinaryHeap<>();
 
	      
	    for(int i = 0; i < 200; i++) {
	    imbh5.insert((int)(Math.random()*1000 + 1));
	    }
	    long imbh5End = System.nanoTime();
	    System.out.println("Runtime for individual insert of 200:" +
				String.format( "%12.6f",((imbh5Start-imbh5End)/Math.pow(10,9))));
//======================================================================
		 long mbh6Start = System.nanoTime();
	  Integer[] ar6 = new Integer[300];
   
	    for(int i = 0; i < ar5.length; i++) {
	      ar5[i] = (int)(Math.random()*1000 + 1);
	    }
	    MyBinaryHeap<Integer> mbh6 = new MyBinaryHeap<>(ar5);
	    long mbh6End = System.nanoTime(); 
	    System.out.println("Runtime for bulk insert of 300:" +
				String.format( "%12.6f",((mbh6Start-mbh6End)/Math.pow(10,9))));
	    
	    long imbh6Start = System.nanoTime();
	    MyBinaryHeap<Integer> imbh6 = new MyBinaryHeap<>();
 
	      
	    for(int i = 0; i < 300; i++) {
	    imbh6.insert((int)(Math.random()*1000 + 1));
	    }
	    long imbh6End = System.nanoTime();
	    System.out.println("Runtime for individual insert of 300:" +
				String.format( "%12.6f",((imbh6Start-imbh6End)/Math.pow(10,9))));
//======================================================================
		 long mbh7Start = System.nanoTime();
	  Integer[] ar7 = new Integer[400];
   
	    for(int i = 0; i < ar7.length; i++) {
	      ar7[i] = (int)(Math.random()*1000 + 1);
	    }
	    MyBinaryHeap<Integer> mbh7 = new MyBinaryHeap<>(ar7);
	    long mbh7End = System.nanoTime(); 
	    System.out.println("Runtime for bulk insert of 400:" +
				String.format( "%12.6f",((mbh7Start-mbh7End)/Math.pow(10,9))));
	    
	    long imbh7Start = System.nanoTime();
	    MyBinaryHeap<Integer> imbh7 = new MyBinaryHeap<>();
 
	      
	    for(int i = 0; i < 400; i++) {
	    imbh7.insert((int)(Math.random()*1000 + 1));
	    }
	    long imbh7End = System.nanoTime();
	    System.out.println("Runtime for individual insert of 400:" +
				String.format( "%12.6f",((imbh7Start-imbh7End)/Math.pow(10,9))));
//======================================================================
		 long mbh8Start = System.nanoTime();
	  Integer[] ar8 = new Integer[500];
   
	    for(int i = 0; i < ar8.length; i++) {
	      ar8[i] = (int)(Math.random()*1000 + 1);
	    }
	    MyBinaryHeap<Integer> mbh8 = new MyBinaryHeap<>(ar8);
	    long mbh8End = System.nanoTime(); 
	    System.out.println("Runtime for bulk insert of 500:" +
				String.format( "%12.6f",((mbh8Start-mbh8End)/Math.pow(10,9))));
	    
	    long imbh8Start = System.nanoTime();
	    MyBinaryHeap<Integer> imbh8 = new MyBinaryHeap<>();
 
	      
	    for(int i = 0; i < 500; i++) {
	    imbh8.insert((int)(Math.random()*1000 + 1));
	    }
	    long imbh8End = System.nanoTime();
	    System.out.println("Runtime for individual insert of 500:" +
				String.format( "%12.6f",((imbh8Start-imbh8End)/Math.pow(10,9))));
//======================================================================
		 long mbh9Start = System.nanoTime();
	  Integer[] ar9 = new Integer[1000];
   
	    for(int i = 0; i < ar9.length; i++) {
	      ar9[i] = (int)(Math.random()*1000 + 1);
	    }
	    MyBinaryHeap<Integer> mbh9 = new MyBinaryHeap<>(ar9);
	    long mbh9End = System.nanoTime(); 
	    System.out.println("Runtime for bulk insert of 1000:" +
				String.format( "%12.6f",((mbh9Start-mbh9End)/Math.pow(10,9))));
	    
	    long imbh9Start = System.nanoTime();
	    MyBinaryHeap<Integer> imbh9 = new MyBinaryHeap<>();
 
	      
	    for(int i = 0; i < 1000; i++) {
	    imbh9.insert((int)(Math.random()*1000 + 1));
	    }
	    long imbh9End = System.nanoTime();
	    System.out.println("Runtime for individual insert of 1000:" +
				String.format( "%12.6f",((imbh9Start-imbh9End)/Math.pow(10,9))));
//======================================================================
		 long mbh10Start = System.nanoTime();
	  Integer[] ar10 = new Integer[10000];
   
	    for(int i = 0; i < ar10.length; i++) {
	      ar10[i] = (int)(Math.random()*1000 + 1);
	    }
	    MyBinaryHeap<Integer> mbh10 = new MyBinaryHeap<>(ar10);
	    long mbh10End = System.nanoTime(); 
	    System.out.println("Runtime for bulk insert of 10000:" +
				String.format( "%12.6f",((mbh10Start-mbh10End)/Math.pow(10,9))));
	    
	    long imbh10Start = System.nanoTime();
	    MyBinaryHeap<Integer> imbh10 = new MyBinaryHeap<>();
 
	      
	    for(int i = 0; i < 10000; i++) {
	    imbh10.insert((int)(Math.random()*1000 + 1));
	    }
	    long imbh10End = System.nanoTime();
	    System.out.println("Runtime for individual insert of 10000:" +
				String.format( "%12.6f",((imbh10Start-imbh10End)/Math.pow(10,9))));
//======================================================================
	    
	    
	    
				 
	
	  System.out.println("25 value operation count for individual: "+mbh.operationCount("operationcountIndividual"));
	  System.out.println("25 value operation count for bulk insert: "+mbh.operationCount("operationcountBulk"));
	  
	  System.out.println("50 value operation count for individual: "+mbh2.operationCount("operationcountIndividual"));
	  System.out.println("50 value operation count for bulk insert: "+mbh2.operationCount("operationcountBulk"));  

	  System.out.println("75 value operation count for individual: "+mbh3.operationCount("operationcountIndividual"));
	  System.out.println("75 value operation count for bulk insert: "+mbh3.operationCount("operationcountBulk"));
	 
	  System.out.println("100value operation count for individual: "+mbh4.operationCount("operationcountIndividual"));
	  System.out.println("100 value operation count for bulk insert: "+mbh4.operationCount("operationcountBulk"));
	
	  System.out.println("200 value operation count for individual: "+mbh5.operationCount("operationcountIndividual"));
	  System.out.println("200 value operation count for bulk insert: "+mbh5.operationCount("operationcountBulk"));
	
	  System.out.println("300 value operation count for individual: "+mbh6.operationCount("operationcountIndividual"));
	  System.out.println("300 value operation count for bulk insert: "+mbh6.operationCount("operationcountBulk"));
	  
	  System.out.println("400 value operation count for individual: "+mbh7.operationCount("operationcountIndividual"));
	  System.out.println("400 value operation count for bulk insert: "+mbh7.operationCount("operationcountBulk"));
	 
	  System.out.println("500 value operation count for individual: "+mbh8.operationCount("operationcountIndividual"));
	  System.out.println("500 value operation count for bulk insert: "+mbh8.operationCount("operationcountBulk"));
	  
	  System.out.println("1000 value operation count for individual: "+mbh9.operationCount("operationcountIndividual"));
	  System.out.println("1000 value operation count for bulk insert: "+mbh9.operationCount("operationcountBulk"));
	 
	  System.out.println("10000 value operation count for individual: "+mbh10.operationCount("operationcountIndividual"));
	  System.out.println("10000 value operation count for bulk insert: "+mbh10.operationCount("operationcountBulk"));
	
	
		
	
		
		
		
		
		
		
		
		
		
		
		
		
	
 
	}

}
