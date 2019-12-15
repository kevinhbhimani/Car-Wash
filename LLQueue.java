import java.util.LinkedList;

/**
 * LLQueue implements the KQueue interface using a Linked List.
 *
 * @author Kevin H. Bhimani
 * @date October 10,2017
 */

public class LLQueue<T> implements KQueue<T>

{
	LinkedList<T> myList = new LinkedList();

	public LLQueue()

	{
		// initialize instance variables
		this.myList = new LinkedList<T>();
	}

	/**
	 * Returns <code>true</code> if this queue is empty; <code>false</code>
	 * otherwise.
	 **/
	public boolean isEmpty()

	{
		return myList.isEmpty();
	}

	/**
	 * Adds a specified object to the "back" of this queue.
	 *
	 * @param item
	 *            - the object to add to the queue
	 **/
	public void enqueue(T item)

	{
		myList.addLast(item);
	}

	/**
	 * Removes the element at the "front" of this queue.
	 *
	 * @throws NoSuchElementException
	 *             if the queue is empty
	 * @returns the removed element
	 **/
	public T dequeue() {
		return myList.removeFirst();

	}

	/**
	 * Returns the element at the "front" of this queue, without modifying the
	 * queue.
	 *
	 * @throws NoSuchElementException
	 *             if the queue is empty
	 * @returns the element at the front of the queue
	 **/
	public T peekFront()

	{
		return myList.peekFirst();
	}

	/**
	 * Returns information about this queue, without modifying the queue.
	 */
	public String toString()

	{
		return myList.toString();

	}

	/**
	 * Returns returns the size of the queue
	 */

	public int size() {
		return myList.size();
	}

	/*
	 * a test driver for the LLQueue class
	 */

	public static void main(String[] args) {
		KQueue myQueue = new LLQueue();
		// creates three test cases within my queue
		myQueue.enqueue("Element a");
		myQueue.enqueue("Element b");
		myQueue.enqueue("Element c");

		System.out.println("Queue after adding 3 strings");
		System.out.println(myQueue.toString());

		// deletes the first thing placed the queue
		myQueue.dequeue();
		// gets rid of everything the queue
		while (!myQueue.isEmpty()) {
			myQueue.dequeue();
		}

		System.out.println("\n");
		System.out.println("Queue after removing all elements");
		System.out.println(myQueue.toString());

		myQueue.enqueue("Element 1");
		myQueue.enqueue("Element 2");
		myQueue.enqueue("Element 3");
		myQueue.enqueue("Element 4");
		myQueue.enqueue("Element 5");
		myQueue.enqueue("Element 6");
		myQueue.enqueue("Element 7");

		System.out.println("\n");
		System.out.println("Queue after adding several new items.");
		System.out.println(myQueue.toString());
	}

}
