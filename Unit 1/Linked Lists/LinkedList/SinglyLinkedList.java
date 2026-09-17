// Implements a singly-linked list.


public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList() {
		head = null;
		tail = null;
		nodeCount = 0;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public SinglyLinkedList(E[] values) {
		// head = new ListNode<>(values[0]);
		// tail = head;
		// for (int i = 1; i < values.length; i++) {
		// 	ListNode<E> temp = new ListNode<>(values[i]);
		// 	tail.setNext(temp);
		// 	tail = temp;
		// }
		// nodeCount = values.length;

		head = tail = new ListNode<>(values[0]);
		for (int i = 1; i < values.length; i++) {
			tail.setNext(new ListNode<>(values[i]));
			tail = tail.getNext();
		}
		nodeCount = values.length;
	}
	
	public ListNode<E> getHead() {
		return head;
	}
	
	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		return (nodeCount == 0);
	}

	// Returns the number of elements in this list.
	public int size() {
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		
	}

	// Returns the i-th element.               
	public E get(int i) {
	}

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, E obj) {
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, E obj) {
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {


	}
	

}
