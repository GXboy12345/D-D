import java.util.Objects;

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

		if(values.length == 0) {
			head = null;
			tail = null;
			nodeCount = 0;
			return;
		}

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
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		if(nodeCount == 0) return false;
		ListNode<E> i = head;
		while (i != tail)
				if(Objects.equals(i.getValue(), obj)) return true;
				else i = i.getNext();
		return Objects.equals(tail.getValue(), (obj));
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		if(nodeCount == 0) return -1;
		ListNode<E> i = head;
		int c = 0;
		while (i != tail)
				if(Objects.equals(i.getValue(), obj)) return c;
				else {
					i = i.getNext();
					c++; //heh. get it?
				}
		
		return Objects.equals(tail.getValue(), (obj)) ? nodeCount - 1 : -1;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		if(nodeCount == 0) {head = tail = new ListNode<>(obj); nodeCount++; return true;}
		try {
			tail.setNext(new ListNode<>(obj));
			tail = tail.getNext();
			nodeCount++;
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		if(nodeCount == 0) return false;
		if(tail == head) {if(Objects.equals(tail.getValue(), (obj))) {nodeCount--; head = tail = null; return true;} else return false;}
		if(Objects.equals(head.getValue(), (obj))) {head = head.getNext(); nodeCount--; return true;}
		ListNode<E> buffer = head;
		while(buffer.getNext() != tail) {
			if(Objects.equals(buffer.getNext().getValue(), (obj))) {
				buffer.setNext(buffer.getNext().getNext());
				nodeCount--;
				return true;
			} else buffer = buffer.getNext();
		}
		if(Objects.equals(tail.getValue(), (obj))) {tail = buffer; tail.setNext(null); nodeCount--; return true;}
		return false;
	}

	// Returns the i-th element.
	public E get(int i) {
		if(i < 0 || i >= nodeCount) throw new IndexOutOfBoundsException();
		ListNode<E> r = head;
		for (int j = 0; j < i; j++) {
			r = r.getNext();
		}
		return r.getValue();
	}
	
	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, E obj) {
		if(i < 0 || i >= nodeCount) throw new IndexOutOfBoundsException();
		ListNode<E> r = head;
		for (int j = 0; j < i; j++) {
			r = r.getNext();
		}
		E v = r.getValue();
		r.setValue(obj);
		return v;
	}
	
	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, E obj) {
		if(head == null && i == 0) {
			head = tail = new ListNode<>(obj);
			nodeCount++;
			return;
		}
		if(i == nodeCount) {tail.setNext(new ListNode<>(obj)); tail = tail.getNext(); nodeCount++; return;}
		if(i < 0 || i > nodeCount) throw new IndexOutOfBoundsException();
		ListNode<E> r = head;
		for (int j = 0; j < i; j++) {
			r = r.getNext();
		}
		r.setNext(new ListNode<>(r.getValue(), r.getNext()));
		r.setValue(obj);
		if (r == tail) tail = r.getNext();
		nodeCount++;
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		if(i < 0 || i >= nodeCount) throw new IndexOutOfBoundsException();
		if(i == 0) {
			if(head == tail) {E v = head.getValue(); head = tail = null; nodeCount--; return v;} 
				else {E v = head.getValue(); head = head.getNext(); nodeCount--; return v;}
		}
		ListNode<E> buffer = head;
		for (int j = 1; j < i; j++) {
			buffer = buffer.getNext();
		}
		E v = buffer.getNext().getValue();
		if(buffer.getNext() == tail) tail = buffer;
		buffer.setNext(buffer.getNext().getNext());
		nodeCount--;
		return v;
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	@Override
	public String toString() {
		if(nodeCount == 0) return "[]";
		StringBuilder sb = new StringBuilder("[");
		ListNode<E> e = head;
		sb.append(e.getValue().toString()).append(", ");
		for (int i = 0; i < nodeCount - 1; i++) {
			e = e.getNext();
			sb.append(e.getValue().toString()).append(", ");
		}
		sb.setLength(sb.length() - 2);
		return sb.append("]").toString();
	}
	

}
