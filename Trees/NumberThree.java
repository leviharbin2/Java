package assignment6;
/*
 Implement the following algorithm as a Java method.
We are interested in finding the kth smallest element. 
Generate N elements into an array. Create a heap from the array, 
ensureing buildHeap is used and not individual inserts. 
Perform k deleteMin operations. 
The last element extracted using deleteMin is the kth smallest value, 
return this value.
 */

public class NumberThree<E extends Comparable<? super E>> {
	private static int DEFAULT_CAPACITY = 0;
	private int currentSize;
	private E[] heap;

	public NumberThree()
	{
		this(DEFAULT_CAPACITY);
	}
	public NumberThree(int newSize)
	{
		heap = (E[]) new Comparable[nextSize(newSize)];
		currentSize = 0;
	}
	public NumberThree(E[] items)
	{
		heap = (E[]) new Comparable[nextSize(items.length)];
		currentSize = items.length;
		System.out.println("Array Size : "+items.length);
		for(int i = 0; i < items.length; i++)
		{
			heap[i+1] = items[i];
		}
		buildHeap();
	}
	public void addAll(E[] items)
	{
		if(currentSize + items.length+1 > heap.length)//array is full or more than full
		{
			growArray(nextSize(currentSize+items.length+1));
		}
		currentSize++;
		for(int i = 0; i < items.length; i++, currentSize++)
		{
			heap[currentSize] = items[i];
		}
		buildHeap();
	}
	private void buildHeap()//restore heap order property
	{
		for(int i = currentSize>>1; i > 0; i--)
		{
			percolateDown(i);
		}
	}

	public boolean isEmpty()
	{
		return (currentSize == 0);
	}
	public void makeEmpty()
	{
		currentSize = 0;
	}
	private void growArray(int newSize)
	{
		//System.out.println("Grow");
		E[] temp = heap;
		heap = (E[]) new Comparable[newSize];
		for(int i = 1; i <= currentSize; i++)
		{
			heap[i] = temp[i];
		}
	}
	private void growArray()
	{
		growArray(heap.length << 1);//same as heap.length * 2
	}
	private int nextSize(int newSize)
	{
		return 1 << (Integer.toBinaryString(newSize).length());
	}

	public String toString()
	{
		//current size can never be equal to length, because we are reserving heap[0] for inserts
		String output = "Heap: ";
		for(int i = 1; i <= currentSize; i++)
		{
			output += heap[i]+",";
		}
		return output;
	}


	public void insert(E value)
	{
		if(currentSize + 1 == heap.length)//array is full
		{
			growArray();
		}

		currentSize++;//update to position that needs to be filled
		heap[0] = value;//temporary home for value while making room
		percolateUp(currentSize);
	}
	private void percolateUp(int pos)
	{
		//pos>>1 == pos/2
		//check if parent is larger than what is being inserted
		for(; heap[pos>>1].compareTo(heap[0]) > 0; pos = pos>>1)
		{
			//if parent larger, move down and try again on next level
			heap[pos] = heap[pos>>1];
		}
		heap[pos] = heap[0];//insert into empty position made by percolate
	}
	public E findMin()
	{
		//heap[1] always contains smallest value
		if(currentSize > 0)
			return heap[1];
		else
			return null;
	}
	public E deleteMin()
	{
		if(currentSize > 0)
		{
			E temp = heap[1];
			heap[1] = heap[currentSize];//not using heap[0] so this works the same for buildHeap method
			currentSize--;
			percolateDown(1);
			return temp;
		}
		else
			return null;
	}
	private void percolateDown(int pos)
	{
		int child = pos << 1;
		E temp = heap[pos];//not using heap[0] so this works the same for buildHeap method
		//pos<<1 == pos * 2
		for(; pos<<1 <= currentSize; pos = child, child = pos<<1)
		{
			if(child != currentSize //there is a second child
					&& heap[child+1].compareTo(heap[child]) < 0)//second is smaller than first
			{
				child++;
			}
			//child is now the index of the smaller of the two children if there are two
			
			//if child is smaller than temp, move child up
			if(heap[child].compareTo(temp) < 0)
			{
				heap[pos] = heap[child];
			}
			else
			{
				break;//prevent increment from running in for loop
			}
		}
		heap[pos] = temp;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String deleteKElements(int userIntChoice) {// pass user selected number of delete mins
	
		int intChosen = userIntChoice;
		E finalInt = null;
		for (int i = 0; i < intChosen; i++) {// call deleteMin the amount of times the user defines
			System.out.println("item being deleted: "+findMin());//display each min
			
		    finalInt = deleteMin();//item being deleted
			
			
			
		}
		
		
		
		
		
		
		
		return "The kth item removed is: "+finalInt;//the last item deleted
	}
}
