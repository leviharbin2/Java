package assignment6;


public class MyBinaryHeap<E extends Comparable<? super E>> {
	private static int DEFAULT_CAPACITY = 0;
	private int currentSize;
	private E[] heap;
	public int operationcountIndividual = 0;
	public int operationcountBulk = 0;

	public MyBinaryHeap()
	{
		this(DEFAULT_CAPACITY);
		operationcountIndividual++;
		operationcountBulk++;
	}
	public MyBinaryHeap(int newSize)
	{
		heap = (E[]) new Comparable[nextSize(newSize)];
		operationcountIndividual+=2;
		operationcountBulk+=2;
		currentSize = 0;
		operationcountIndividual++;
		operationcountBulk++;
	}
	public MyBinaryHeap(E[] items)
	{
		heap = (E[]) new Comparable[nextSize(items.length)];
		operationcountBulk+=2;
		currentSize = items.length;
		operationcountBulk+=2;
		//System.out.println(items.length);
		operationcountBulk+=2;
		for(int i = 0; i < items.length; i++)
		{
			heap[i+1] = items[i];
			operationcountBulk++;
			operationcountBulk+=2;
		}
		buildHeap();
		operationcountBulk++;
	}
	public void addAll(E[] items)
	{
		operationcountBulk+=5;// 1 for size, 2 for length and add operation , 1 for heap length, 1 for comparison
		if(currentSize + items.length+1 > heap.length)//array is full or more than full
		{
			growArray(nextSize(currentSize+items.length+1));
			operationcountBulk+=6;//1 for grow array, 1 for next size, 1 for currentsize, 2 for length+1, 1 for current+items
		}
		currentSize++;
		
		operationcountBulk+=2;
		for(int i = 0; i < items.length; i++, currentSize++)
		{
			operationcountBulk++;
			heap[currentSize] = items[i];
			operationcountBulk+=2;
		}
		buildHeap();
		operationcountBulk++;
	}
	private void buildHeap()//restore heap order property
	{
		operationcountIndividual+=2;
		operationcountBulk+=2;
		for(int i = currentSize>>1; i > 0; i--)
		{
			operationcountBulk++;
			operationcountIndividual++;
			percolateDown(i);
			operationcountBulk+=2;
			operationcountIndividual+=2;
		}
	}

	public boolean isEmpty()
	{
		operationcountBulk+=2;
		operationcountIndividual+=2;
		return (currentSize == 0);
	}
	public void makeEmpty()
	{
		operationcountBulk++;
		operationcountIndividual++;
		currentSize = 0;
	}
	private void growArray(int newSize)
	{
		//System.out.println("Grow");
		E[] temp = heap;
		operationcountBulk++;
		operationcountIndividual++;
		heap = (E[]) new Comparable[newSize];
		operationcountBulk+=2;
		operationcountIndividual+=2;
		
		
		operationcountBulk+=2;
		operationcountIndividual+=2;
		for(int i = 1; i <= currentSize; i++)
		{
			operationcountBulk++;
			operationcountIndividual++;
			heap[i] = temp[i];
			operationcountBulk+=2;
			operationcountIndividual+=2;
		}
	}
	private void growArray()
	{
		operationcountBulk+=3;//one for grow array, one for heap length, one for shift one binary
		operationcountIndividual+=3;
		growArray(heap.length << 1);//same as heap.length * 2
	}
	private int nextSize(int newSize)
	{
		operationcountBulk+=5;// one for return, one for shift, one for integer method, one for newsize call, one for length call
		operationcountIndividual+=5;
		return 1 << (Integer.toBinaryString(newSize).length());
	}

	public String toString()
	{
		//current size can never be equal to length, because we are reserving heap[0] for inserts
		operationcountBulk++;
		operationcountIndividual++;
		String output = "Heap: ";
		
		operationcountBulk+=2;
		operationcountIndividual+=2;
		for(int i = 1; i <= currentSize; i++)
		{
			operationcountBulk+=2;
			operationcountIndividual+=2;
			output += heap[i]+",";
			operationcountBulk+=2;
			operationcountIndividual+=2;
		}
		operationcountBulk++;
		operationcountIndividual++;
		return output;
	}


	public void insert(E value)
	{
		operationcountIndividual+=3;//one for addition, one for ==, one for heap length
		if(currentSize + 1 == heap.length)//array is full
		{
			operationcountIndividual++;
			growArray();
		}
		operationcountIndividual++;
		currentSize++;//update to position that needs to be filled
		operationcountIndividual++;
		heap[0] = value;//temporary home for value while making room
		operationcountIndividual+=2;
		percolateUp(currentSize);
	}
	private void percolateUp(int pos)
	{
		//pos>>1 == pos/2
		//check if parent is larger than what is being inserted
		operationcountBulk+=2;
		operationcountIndividual+=2;
		for(; heap[pos>>1].compareTo(heap[0]) > 0; pos = pos>>1)
		{
			operationcountBulk+=2;
			operationcountIndividual+=2;
			//if parent larger, move down and try again on next level
			heap[pos] = heap[pos>>1];
			operationcountBulk+=2;
			operationcountIndividual+=2;
		}
		operationcountBulk+=2;
		operationcountIndividual+=2;
		heap[pos] = heap[0];//insert into empty position made by percolate
	}
	public E findMin()
	{
		//heap[1] always contains smallest value
		operationcountBulk++;
		operationcountIndividual++;
		if(currentSize > 0) {
			operationcountBulk++;
		operationcountIndividual++;
			return heap[1];
		}
		else {
			operationcountBulk++;
			operationcountIndividual++;
		
			return null;
		}
	}
	public E deleteMin()
	{
		operationcountBulk++;
		operationcountIndividual++;
		if(currentSize > 0)
		{
			operationcountBulk++;
			operationcountIndividual++;
			E temp = heap[1];
			operationcountBulk++;
			operationcountIndividual++;
			heap[1] = heap[currentSize];//not using heap[0] so this works the same for buildHeap method
			operationcountBulk++;
			operationcountIndividual++;
			currentSize--;
			operationcountBulk++;
			operationcountIndividual++;
			percolateDown(1);
			operationcountBulk++;
			operationcountIndividual++;
			return temp;
		}
		else {
			operationcountBulk++;
			operationcountIndividual++;
			return null;
		}
		
	}
	private void percolateDown(int pos)
	{
		operationcountBulk+=2;
		operationcountIndividual+=2;
		int child = pos << 1;
		operationcountBulk++;
		operationcountIndividual++;
		E temp = heap[pos];//not using heap[0] so this works the same for buildHeap method
		//pos<<1 == pos * 2
		operationcountBulk+=2;
		operationcountIndividual+=2;
		for(; pos<<1 <= currentSize; pos = child, child = pos<<1)
		{
		operationcountBulk+=5;//1 for != , 1 for &&, 1 for child+1, 1 for compareTo,1 for<0
		operationcountIndividual+=5;
			if(child != currentSize //there is a second child
					&& heap[child+1].compareTo(heap[child]) < 0)//second is smaller than first
			{
				operationcountBulk++;
				operationcountIndividual++;
				child++;
			}
			//child is now the index of the smaller of the two children if there are two
			
			//if child is smaller than temp, move child up
			operationcountBulk+=2;
			operationcountIndividual+=2;
			if(heap[child].compareTo(temp) < 0)
			{
				operationcountBulk++;
				operationcountIndividual++;
				heap[pos] = heap[child];
			}
			else
			{
				operationcountBulk++;
				operationcountIndividual++;
				break;//prevent increment from running in for loop
			}
		}
		operationcountBulk++;
		operationcountIndividual++;
		heap[pos] = temp;
	}
	public int operationCount(String choice) {
		if(choice.equalsIgnoreCase("operationcountIndividual")) {
			return operationcountIndividual;
		}
		else if(choice.equalsIgnoreCase("operationcountBulk")) {
		return operationcountBulk;
	}
		else return 0;
	}
}


