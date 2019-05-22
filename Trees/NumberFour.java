package assignment6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberFour<E extends Comparable<? super E>> {
	/*
	We are interested in finding the kth largest element.
	Generate N elements into an array.
	At any point in time, we want to maintain a set 'S' of the k largest elements.
	Create a heap from the first k elements in the array,
	ensuring the buildHeap is used and not individual inserts.
	For each remaining element in the array,
	if it is larger than the smallest value in the heap,
	remove the smallest and insert the new value.
	When all array elements have been processed,
	the smallest value in the heap is the kth largest value in the list,
	return this value.
*/




		private static int DEFAULT_CAPACITY = 0;
		private int currentSize;
		private E[] heap;
		
		
  
		public NumberFour()
		{
			this(DEFAULT_CAPACITY);
		}
		public NumberFour(int newSize)
		{
			heap = (E[]) new Comparable[nextSize(newSize)];
			currentSize = 0;
		}
		public NumberFour(E[] items)
		{
			heap = (E[]) new Comparable[nextSize(items.length)];
			currentSize = items.length;
			System.out.println("size of array: "+items.length);
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
			String output = "Heap Space:"+heap.length+":Space Used:"+currentSize+"\n";
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
		
		
		
		
		
		public String kTHLargestElement(E[] userArrayChoice, int userIntChoice) {// pass user selected number and array
			E finalInt = null;
			currentSize = userIntChoice;
		
			
			
			
			
			
			
			
			
			
			
			if(userArrayChoice.length<userIntChoice) {//if k> length of array, tell user to change k
				return"Array size is too small for value picked";
			}
			else {
				  heap = (E[]) new Comparable[userIntChoice+1];
					
					
					for(int i = 0; i < userIntChoice; i++)//copy user values to array based off number of large values
					{
						heap[i+1] = userArrayChoice[i];
					    
						
					}	
					buildHeap();
					System.out.println("******************************");
					
					
					for(int i = userIntChoice; i < userArrayChoice.length; i++) {//loop through the larger elements
						

						if((int)userArrayChoice[i]>(int)findMin()) {//if the value in array is bigger than the smallest heap value, switch it into the heap
							deleteMin();
							insert(userArrayChoice[i]);
							
							
							
						}
						
					}
					
					finalInt = findMin();
				
					 HashSet <E> newset = new HashSet <E>(Arrays.asList(heap));//pass the heap of large values into a unique set, deleting redundant values
					  
			        System.out.println("unique set of largest elements"+"\n"+newset+"\n");
					
					
					System.out.println("userArray"+"\n"+Arrays.toString(userArrayChoice)+"\n");
					
					
					
					
					
					return "The number "+userIntChoice +" largest element is: "+finalInt;//the last item deleted
				
			}
			
	
		
	}
}
