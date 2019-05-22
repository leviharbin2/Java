package assignment3;

import assignment3.MySingleLinkedList.Node;

public class MyDoubleLinkedList<E> {
	private Node start, end;
	private int currentSize;

	public MyDoubleLinkedList()
	{
		start = null;
		end = null;
		currentSize = 0;
	}

	public void swap(int index)
	{
		 
		Node current = start.next;
		Node temp = null;
	
		
		if ( index == 0){
		      temp = start;
		      start = start.next;
		  
		     
		   
		      System.out.println();
		      
		 if ( index == 10){
			      current = start; 
			      start = start.next; 
			      System.out.println();
		 
	
		      
		    
		    
		 }   
		}

	}

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
	public void printListRev()//O(N)
	{
		Node current = end;
		while(current != null)
		{
			System.out.print(current.val+",");
			current = current.prev;//move to prev Node/container in the list
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
			end = start;
			currentSize++;
		}
		else if(index == 0)//first item
		{
			//newItem will be before start
			newItem.next = start;
			start.prev = newItem;
			start = newItem;
			currentSize++;
		}
		else if(index == currentSize)//last item
		{
			newItem.prev = end;
			end.next = newItem;
			end = newItem;
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
			newItem.prev = current;
			newItem.next.prev = newItem;
			currentSize++;
		}
	}
	public void add(E val)//O(1)
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
			if(start != null)//clear out item before new start
			{
				start.prev = null;
			}
			else//very last item was removed, clear out end
			{
				end = null;
			}
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
				if(current.next != null)//was a middle value
				{
					current.next.prev = current;
				}
				else//was the last value
				{
					end = current;
				}
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
				if(start != null)//clear out item before new start
				{
					start.prev = null;
				}
				else//very last item was removed, clear out end
				{
					end = null;
				}
				currentSize--;
				return temp;
			}
			else if(index == currentSize)
			{
				E temp = end.val;
				end = end.prev;
				if(end != null)//clear out item after new end
				{
					end.next = null;
				}
				else//very last item was removed, clear out end
				{
					start = null;
				}
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
				if(current.next != null)//was a middle value
				{
					current.next.prev = current;
				}
				else//was the last value
				{
					end = current;
				}
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
	public E findLast(E val)
	{
		if(end == null)
			return null;
		if(end.val.equals(val))
		{
			return end.val;
		}
		else
		{
			Node current = end;
			while(current.prev != null && !current.prev.val.equals(val))//next containers value equal to what we want to delete
			{
				current = current.prev;
			}
			if(current.prev == null)//wasn't found
				return null;
			else
			{
				return current.prev.val;
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

	private class Node
	{
		public E val;
		public Node next, prev;
		public Node(E v)
		{
			val = v;
			next = null;
			prev = null;
		}
	}

}
