package assignment3;

import assignment3.MySingleLinkedList.Node;

public class MyQueue<E> {
	private Node head;
	private int currentSize;
	
	
	
	
	

	public MyQueue()
	{
		head = null;
		currentSize = 0;
	}
	
	
	
	
	
	
	public int size()
	{
		return currentSize;
	}
	
	
	public void insert(E val)
	{
		Node newItem = new Node(val);
		if(head == null)
			head = newItem;
		else
		{
			Node current = head;
			while(current.next!=null)
			{
				current = current.next;
			}
			
			newItem.next = current.next;
			current.next = newItem;
			currentSize++;
		}
		}
	
	
	public E remove()
	{
		if(head == null)
			return null;
		else
		{
			E temp = head.val;
			head = head.next;
			currentSize--;
			return temp;
		}
	}
	
	
	public E head()
	{
		if(head == null)
			return null;
		else
			return head.val;
	}
	public E peek()
	{
		return head();
	}

	
	
	
	public void printList()
	{
		Node current = head;
		while(current != null)
		{
			System.out.print(current.val+",");
			current = current.next;
		}
		System.out.println();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		private class Node
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






	
	
	
	
	

	