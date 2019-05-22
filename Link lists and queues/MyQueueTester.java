package assignment3;


public class MyQueueTester {

	public static void main(String[] args) {
		MyQueue<Integer> myQueue = new MyQueue<>();
		myQueue.insert(5);
		myQueue.insert(7);
		myQueue.insert(9);
		myQueue.insert(12);
		myQueue.insert(15);
		myQueue.insert(17);//inserts value at the end of the queue
		myQueue.printList();
		System.out.println(myQueue.peek());//returns the head of the queue
		System.out.println(myQueue.remove());//removes the head of the queue
		myQueue.printList();
		System.out.println(myQueue.remove());
		myQueue.printList();
	    System.out.println(myQueue.peek());
	}

}
