package assignment7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SortingMethods {

	//method static so the class doesn't need to be initialized as an object
	//E must have comparable implemented on itself or one of its parents
	public static <E extends Comparable<? super E>> void insertSort(E[] arr)
	{
		//hole where item will move to
		int hole = 1;
		int positionsMoved = 0;

		//process from 2nd item to end of list, skip first item because already considered sorted
		for(int i = 1; i < arr.length; i++)
		{
			//temp variable holding item at current position while others moved
			E temp = arr[i];
			//hole starts at position and moves to start of list
			//stop when hole is zero or comparison says prev item is smaller
			for(hole = i;hole > 0 && temp.compareTo(arr[hole-1]) < 0; hole--)
			{
				//move item from prev forward to current hole location
				arr[hole] = arr[hole-1];
				positionsMoved++;
			}
			//set temp into hole
			arr[hole] = temp;
		}
		System.out.println("Arr Size:"+arr.length);
		System.out.println("Total Moves:"+positionsMoved);
	}

	//E must have comparable implemented on itself or one of its parents
	public static <E extends Comparable<? super E>> void shellSort(E[] arr)
	{
		//hole where item will move to
		int hole = 1;
		int positionsMoved = 0;

		//set sequence/shell layer to be processed, starting at half array size,
		//divide by 2 each time as long as sequence > 0
		for(int sequence = arr.length/2;sequence > 0;sequence /= 2)
		{
			//System.out.println("Sequence:"+sequence);
			//loop through each sub-list, starting at sequence and going to end of list
			for(int sublist = sequence; sublist < arr.length ;sublist++)
			{
				//temp variable holding item at current sub-list while others moved
				E temp = arr[sublist];
				//hole set to sublist, then moved down by sequence at a time
				//continue while hole >= sequence and compare temp to hole - prev(by sequence)
				for(hole = sublist; hole >= sequence && temp.compareTo(arr[hole-sequence]) < 0 ;hole -= sequence)
				{
					//move prev val forward
					arr[hole] = arr[hole-sequence];
					positionsMoved++;
				}
				//put temp into hole
				arr[hole] = temp;
			}
			//System.out.println(Arrays.toString(arr));
		}
		System.out.println("Arr Size:"+arr.length);
		System.out.println("Total Moves:"+positionsMoved);
	}

	//E must have comparable implemented on itself or one of its parents
	public static <E extends Comparable<? super E>> void heapSort(E[] arr)
	{
		//create heap from array
		PriorityQueue<E> heap = new PriorityQueue<>();
		heap.addAll(Arrays.asList(arr));//performs buildHeap in O(N)
		//loop until heap empty
		int pos = 0;
		while(!heap.isEmpty())
		{
			//copy back into array
			arr[pos] = heap.poll();
			pos++;
		}
	}

	//E must have comparable implemented on itself or one of its parents
	public static <E extends Comparable<? super E>> void mergeSort(E[] arr)
	{
		//call mergeSort(arr, temp[], 0, length-1)
		mergeSort(arr, (E[])new Comparable[arr.length], 0, arr.length-1);
	}
	public static <E extends Comparable<? super E>> void mergeSort(E[] arr, E[] temp, int left, int right)
	{
		//System.out.println("Left:"+left+" :: Right:"+right + " :: Center:"+((right+left)/2));
		//if left < right
		if(left < right)
		{
			//find center
			int center = (right+left)/2;
			//call mergeSort on left half (left,center)
			mergeSort(arr, temp, left, center);
			//call mergeSort on right half (center+1,right)
			mergeSort(arr, temp, center+1, right);
			//call merge over left/right halves
			merge(arr, temp, left, center+1, right);
			//System.out.println(left+":"+right+"::"+Arrays.toString(arr));
		}
	}
	public static <E extends Comparable<? super E>> void merge(E[] arr, E[] temp, int leftStart, int rightStart, int rightEnd)
	{
		//System.out.println("Merge "+leftStart+":"+rightEnd);
		//determine leftEnd
		int leftEnd = rightStart-1;
		//set temp array position (same as left start)
		int currPos = leftStart;
		//determine number of elements (end - start + 1)
		int mergeCount = rightEnd-leftStart+1;
		//while items left in both lists
		while(leftStart <= leftEnd && rightStart <= rightEnd)
		{
			//put smaller into temp array, move pointers forward
			if(arr[leftStart].compareTo(arr[rightStart]) < 0)
			{
				temp[currPos] = arr[leftStart];
				leftStart++;
			}
			else
			{
				temp[currPos] = arr[rightStart];
				rightStart++;
			}
			currPos++;
		}
		//while items left in either list
		while(leftStart <= leftEnd)
		{
			//add left over items to end of temp array
			temp[currPos] = arr[leftStart];
			leftStart++;
			currPos++;
		}
		//while items left in either list
		while(rightStart <= rightEnd)
		{
			//add left over items to end of temp array
			temp[currPos] = arr[rightStart];
			rightStart++;
			currPos++;
		}
		//merge temp data to original using number of items and rightEnd
		for(; mergeCount > 0; mergeCount--, rightEnd--)
		{
			arr[rightEnd] = temp[rightEnd];
		}
	}

	//E must have comparable implemented on itself or one of its parents
	public static <E extends Comparable<? super E>> void quickSort(E[] list)
	{
		//This method is used when trying to sort an array instead of a list

		//convert array to list
		List<E> newList = new LinkedList<>();
		newList.addAll(Arrays.asList(list));
		//run quicksort on list
		quickSort(newList);
		//convert list back to array
		int pos = 0;
		for(E item : newList)
		{
			list[pos] = item;
			pos++;
		}
	}
	public static <E extends Comparable<? super E>> void quickSort(List<E> list)
	{
		//if list has more than 1 item
		if(list.size() > 1)
		{
			//create 3 lists (smaller, same, larger)
			List<E> smaller = new LinkedList<>();
			List<E> same = new LinkedList<>();
			List<E> larger = new LinkedList<>();
			//pick item for middle/pivot
			//E pivot = list.get(0);//not best if list is sorted/reverse
			/**/
			E pivota = list.get(0);
			E pivotb = list.get(list.size()-1);
			E pivotc = list.get(list.size()/2);
			E pivot;
			if(pivota.compareTo(pivotb) > 0 && pivota.compareTo(pivotc) < 0)
				pivot = pivota;
			else if(pivotb.compareTo(pivota) > 0 && pivotb.compareTo(pivotc) < 0)
				pivot = pivotb;
			else
				pivot = pivotc;
			/**/
			//loop through list putting items into correct containers
			for(E item : list)//O(N)
			{
				if(item.compareTo(pivot) > 0)
				{
					larger.add(item);
				}
				else if(item.compareTo(pivot) < 0)
				{
					smaller.add(item);
				}
				else
				{
					same.add(item);
				}
			}
			//System.out.println("Smaller:"+smaller.size()+" :: Same:"+same.size()+" :: Larger:"+larger.size());
			//recursively sort smaller/larger
			quickSort(smaller);
			quickSort(larger);
			//put all items into original list [.clear(), .addAll()]
			list.clear();
			list.addAll(smaller);
			list.addAll(same);
			list.addAll(larger);

		}
	}

	public static void bucketSort(Integer[] arr, int min, int max)
	{
		//number of buckets
		int bucketCount = max-min+1;
		//create buckets for range
		int[] buckets = new int[bucketCount];
		//add each item from array to correct bucket counter (shift if needed)
		for(int i = 0; i < arr.length; i++)
		{
			buckets[arr[i]-min]++;//-min to shift into correct index range
		}
		//run through buckets to refill array in correct order (shift back if needed)
		int pos = 0;
		for(int i = 0; i < buckets.length; i++)
		{
			//put the number of identical items back into the array
			for(int j = 0; j < buckets[i]; j++)
			{
				arr[pos] = i+min;//+min is to shift back into correct range
				pos++;
			}
		}
	}

	public static void radixSortSameLength(String[] arr, int maxLength)
	{
		//number of buckets (256 in standard character set)
		int bucketCount = 256;
		//buckets can't be counters, need to be lists
		List<String>[] buckets = new LinkedList[bucketCount];
		//create all buckets needed
		for(int i = 0; i < buckets.length; i++)
		{
			buckets[i] = new LinkedList<>();
		}
		//loop from end of string to beginning to properly sort
		for(int currChar = maxLength-1;currChar >= 0; currChar--)
		{
			//loop through each string
			for(int i = 0; i < arr.length; i++)
			{
				//add to appropriate bucket
				buckets[arr[i].charAt(currChar)].add(arr[i]);
				//arr[i].charAt(currChar) converts to the ASCII number automatically
			}
			//loop through buckets
			int pos = 0;
			for(int i = 0; i < buckets.length; i++)
			{
				//put each item from the bucket into original array
				for(String item : buckets[i])
				{
					arr[pos] = item;
					pos++;
				}
				//clear bucket
				buckets[i].clear();
			}
			System.out.println(Arrays.toString(arr));
		}
	}

	public static void radixSortDifferentLength(String[] arr)


		{
			//number of buckets (256 in standard character set)
			int bucketCount = 256;

			//buckets can't be counters, need to be lists
			List<String>[] buckets = new LinkedList[bucketCount];
			//create all buckets needed
			for(int i = 0; i < buckets.length; i++)
			{


				buckets[i] = new LinkedList<>();
			}
			//loop from end of string to beginning to properly sort




			for(int currChar = 1;currChar >= 0; currChar--)

			{
				//loop through each string
				for(int b = 0; b < arr.length; b++)
				{
					//add to appropriate bucket
					buckets[arr[b].charAt(currChar)].add(arr[b]);
					//arr[i].charAt(currChar) converts to the ASCII number automatically
				}
				//loop through buckets
				int pos = 0;
				for(int c = 0; c < buckets.length; c++)
				{
					//put each item from the bucket into original array
					for(String item : buckets[c])
					{
						arr[pos] = item;
						pos++;
					}
					//clear bucket
					buckets[c].clear();
				}
				System.out.println(Arrays.toString(arr));

			}


	}
}