package assignment3;

public class MySingleLinkedList<E> {
	private Node start;
	private int currentSize;

	public MySingleLinkedList()
	{
		start = null;
		currentSize = 0;
	}
	public void swap(int index)
	{
		
		Node current = start;
		Node temp = null;
		
		if ( index == 0){
		      temp = start; 
		      start = start.next;
		      System.out.println();
		      
		 if ( index == 10){
			current = start;
			 while(current != null)
				{
					System.out.print(current.val+",");
					current = current.next;//move to next Node/container in the list
				if(current.val.equals(10)) {
					current.next = current;
				}
				}
			 
			 
			 
			 
			 
			 
			      System.out.println();
		 
	
		      
		    
		    
		 }   
		}

	}
	//1 8 5 9
	
	
/*	if (10 !=null)
	 swap 10 and 11;
	}
*/
	public void printList()//O(N)
	{
		Node current = start;
		while(current != null)
		{
			System.out.print(current.val+",");
			current = current.next;//move to next Node/container in the list
		}
		System.out.println();
	}

	public void insert(E val, int index)//O(index)
	{
		//fix index values to correct range
		if(index > currentSize)
			index = currentSize;
		if(index < 0)
			index = 0;

		Node newItem = new Node(val);

		//start is null//list is empty
		if(start == null)
		{
			start = newItem;
			currentSize++;
		}
		else if(index == 0)
		{
			//newItem will be before start
			newItem.next = start;
			start = newItem;
			currentSize++;
		}
		else
		{
			Node current = start;//current is now position 0
			for(int i = 0; i < index-1; i++)//stop current at the item before where the new one goes
			{
				current = current.next;
			}
			//current is the item before where we want the new one
			newItem.next = current.next;
			current.next = newItem;
			currentSize++;
		}
	}
	public void add(E val)//O(N)
	{
		insert(val, currentSize);
	}
	public void addFirst(E val)//O(1)
	{
		insert(val, 0);
	}

	public E remove(E val)
	{
		if(start == null)
			return null;
		if(start.val.equals(val))
		{
			E temp = start.val;
			start = start.next;
			currentSize--;
			return temp;
		}
		else
		{
			Node current = start;
			while(current.next != null && !current.next.val.equals(val))//next containers value equal to what we want to delete
			{
				current = current.next;
			}
			if(current.next == null)//wasn't found
				return null;
			else
			{
				E temp = current.next.val;//value found
				current.next = current.next.next;
				currentSize--;
				return temp;
			}
		}
	}
	public E delete(int index)
	{
		if(index < 0 && index >= currentSize)
			return null;
		else
		{
			if(index == 0)
			{
				E temp = start.val;
				start = start.next;
				currentSize--;
				return temp;
			}
			else
			{
				Node current = start;
				for(int i = 0; i < index-1; i++)
				{
					current = current.next;
				}
				E temp = current.next.val;//value found
				current.next = current.next.next;
				currentSize--;
				return temp;
			}
		}
	}

	public E find(E val)
	{
		if(start == null)
			return null;
		if(start.val.equals(val))
		{
			return start.val;
		}
		else
		{
			Node current = start;
			while(current.next != null && !current.next.val.equals(val))//next containers value equal to what we want to delete
			{
				current = current.next;
			}
			if(current.next == null)//wasn't found
				return null;
			else
			{
				return current.next.val;
			}
		}
	}
	public E get(int index)
	{
		if(index < 0 && index >= currentSize)
			return null;
		else
		{
			if(index == 0)
			{
				return start.val;
			}
			else
			{
				Node current = start;
				for(int i = 0; i < index-1; i++)
				{
					current = current.next;
				}
				return current.next.val;
			}
		}
	}

	public class Node
	{
		public E val;
		public Node next;
		public Node(E v)
		{
			val = v;
			next = null;
		}
	}

}
