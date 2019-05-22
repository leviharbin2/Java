


/*




Do #7

*/
























public class NumberFourDriver {

	public static void main(String[] args) {

		int n = 25;
		int operationCount = 0;
//		int n = 50;
//		int n = 75;
//		int n = 100;
//		int n = 125;
//		int n = 150;
//		int n = 175;
//		int n = 200;
		
		

	System.out.println("Summation1 = "+SummationOne(n));
	System.out.println("Summation2 = "+SummationTwo(n));
	System.out.println("Summation3 = "+SummationThree(n));
	System.out.println("Summation4 = "+SummationFour(n));
	System.out.println("Summation5 = "+SummationFive(n));
	System.out.println("Summation6 = "+SummationSix(n));
	}







//f(N) = N
//Big O = O(N)
	public static int SummationOne(int n){
		int operationCount = 0;
		int sum = 0;
		
		operationCount++;
       // 1 unit of time for assignment
		operationCount++;//1 unit of time for i=0
		operationCount++;//1 unit of time for i < n comparison 
		for(int i = 0; i < n; i++){
			
			operationCount++;//1 unit of time for i < n comparison N times
			operationCount+=2;//2 units of time for i++ increment N times
	
			
			
			sum++;
			operationCount+=2;//2 units of time for sum++ increment N times
		
		}

operationCount++;//1 unit of time for return
System.out.println("Summation1 operation count: "+operationCount);
return sum;

	}

	
	
//f(N) = N^2	
//Big O = O(N^2)
	public static int SummationTwo(int n){
		int sum = 0;
		int operationCount = 0;
		operationCount++;
		//sum init.
		operationCount++;//int i init.
		operationCount++;// int j init.
		operationCount++;//i<n comparison
		operationCount++;// j<n comparison
		operationCount++;// j=0 comparison
		for(int i = 0; i < n; i++){
			operationCount++;//i<n comparison
			operationCount+=2;//j++
			
			for(int j = 0; j < n; j++){
			operationCount++;//j<n comparison
			operationCount+=2;//j++
			operationCount+=2;//sum++
			sum++;}
		}
		operationCount++;//return sum
		System.out.println("Summation2 operation count: "+operationCount);

		return sum;

	}
	
//f(N) = f(N^2) * N	
//Big O = O(N^3)
		public static int SummationThree(int n){
		int sum = 0;
		int operationCount = 0;
		operationCount++;// int sum
		operationCount++;//i = 0
		operationCount++;// j = 0
		operationCount++;// i<n
		operationCount+=2;// j<n*n
		
		for(int i = 0; i < n; i++) {
			operationCount+=2;//i++
		operationCount++;//i<n
		for(int j = 0; j < n*n; j++) {
			operationCount+=2;// j<n*n

			operationCount+=2;//sum++
		sum++;
		}
		}
		operationCount++;//return sum
		System.out.println("Summation3 operation count: "+operationCount);

		return sum;
	}
		
		
//f(N) = N^2		
// Big O = O(N^2)
		public static int SummationFour(int n){
		int sum = 0;
		int operationCount = 0;
		operationCount++;//sum =0
		operationCount++;//int i
		operationCount++;//int j
		operationCount+=2;//i<n
		operationCount+=2;//j<i
		for(int i = 0; i < n; i++) {
			operationCount++;//i<n
			operationCount+=2;//i++
		for(int j = 0; j < i; j++) {
			operationCount++;//j<i
			operationCount+=2;//j++
			operationCount+=2;//sum++
		sum++;
		}
		}
		operationCount++;//return sum
		System.out.println("Summation4 operation count: "+operationCount);

		return sum;
	}
		
		
		
		
//f(N) = N^5		
// Big O = O(N^5)
		public static int SummationFive(int n){
		int sum = 0;
		int operationCount = 0;
		operationCount++;//sum =0
		operationCount++;//int i
		operationCount++;//int j
		operationCount++;//int k
		operationCount++;//i < n
		operationCount+=2;//j < (i*i)
		operationCount++;//k < j
		for(int i = 0; i < n; i++) {
			operationCount++;// i<n
			operationCount+=2;//i++
		for(int j = 0; j < (i*i); j++) {
			operationCount+=2;// j < (i*i)
			operationCount+=2;//j++
		for(int k = 0; k < j; k++) {
			operationCount++;// k<j
			operationCount+=2;// k++
			operationCount+=2;// sum++
		sum++;
		}
		}
		}
		operationCount++;// return sum
		System.out.println("Summation5 operation count: "+operationCount);

		return sum;
	}
		
		
		
		
		
		
//f(N) = N^4		
// Big O = O(N^4)
		public static int SummationSix(int n){
		int sum = 0;
		
		
		int operationCount = 0;
		int j = 0;
		int k;
		operationCount++;// sum=0
		operationCount++;//int j
		operationCount++;// int k
		operationCount++;// int i
		operationCount++;//int j
		operationCount++;// int k
		operationCount+=2;//j<n
		operationCount+=2;// i*i
		operationCount+=2;//k<j
		
		
		for(int i = 1; j < n; i++) {
			operationCount+=2;//j<n
			operationCount+=2;// i++
		for(j = 1; j < i*i; j++) {
			operationCount+=2;// i*i
			operationCount+=2;// j++
		
		if(j%i == 0) {
			operationCount+=3;// j%1 ==0
		for(k = 0; k < j; k++) {
			operationCount+=2;// k<j
			operationCount+=2;// k++
			operationCount+=2;// sum++
		sum++;
		}
		}
		}
		}
		operationCount++;// return sum
		System.out.println("Summation6 operation count: "+operationCount);

		return sum;

    }



}
