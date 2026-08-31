/* See ArrayList documentation here:
 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 */

/*
 * Your indexed functions should throw IndexOutOfBoundsException if index is invalid!
 */

public class MyArrayList<E> {

	/* Internal Object counter */
	protected int objectCount;

	/* Internal Object array */
	protected E [] internalArray;

	/* Constructor: Create it with whatever capacity you want? */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.internalArray = (E[])new Object[10];
	}

	/* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity){
		this.internalArray = (E[])new Object[initialCapacity];
	}

	/* Return the number of active slots in the array list */
	public int size() {
		return objectCount;
	}

	/* Are there zero objects in the array list? */
	public boolean isEmpty() {
		return size() == 0;
	}

	/* Get the index-th object in the list. */
	public E get(int index) {
		checkElementIndex(index);
		return internalArray[index];
	}

	/* Replace the object at index with obj.  returns object that was replaced. */
	public E set(int index, E obj) {
		checkElementIndex(index);
		E old = get(index);
		internalArray[index] = obj;
		return old;
	}

	/* Returns true if this list contains an element equal to obj;
	 otherwise returns false. */
	public boolean contains(E obj) {
		for (int i = 0; i < objectCount; i++) if (obj == null ? internalArray[i] == null : internalArray[i].equals(obj)) return true;
		return false;
	}

	/* Insert an object at index */
	public void add(int index, E obj) {
		checkPositionIndex(index);
		if (plusOneExceeds()) sizeUp();
		for (int i = objectCount; i > index; i--) internalArray[i] = internalArray[i - 1];
		internalArray[index] = obj;
		objectCount++;
	}

	/* Add an object to the end of the list; returns true */
	public boolean add(E obj) {
		if (plusOneExceeds()) sizeUp();
		internalArray[objectCount] = obj;
		objectCount++;
		return true;
	}

	/* Remove the object at index and shift.  Returns removed object. */
	public E remove(int index) {
		checkElementIndex(index);
		E rem = internalArray[index];
		for (int i = index; i < objectCount - 1; i++) internalArray[i] = internalArray[i + 1];
		internalArray[--objectCount] = null;
		return rem;
	}

	/* Removes the first occurrence of the specified element from this list, 
	 * if it is present. If the list does not contain the element, it is unchanged. 
	 * More formally, removes the element with the lowest index i such that
	 * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists). 
	 * Returns true if this list contained the specified element (or equivalently, 
	 * if this list changed as a result of the call). */
	public boolean remove(E obj) {
		for (int i = 0; i < objectCount; i++) {
			if (obj == null ? internalArray[i] == null : internalArray[i].equals(obj)) {
				remove(i);
				return true;
			}
		}
		return false;
	}


	/* For testing; your string should output as "[X, X, X, X, ...]" where X, X, X, X, ... are the elements in the ArrayList.
	 * If the array is empty, it should return "[]".  If there is one element, "[X]", etc.
	 * Elements are separated by a comma and a space. */
	@Override
	public String toString() {
		if (size() == 0) return "[]";
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < objectCount; i++) sb.append(internalArray[i] == null ? "null" : internalArray[i].toString()).append(", ");
		return sb.delete(sb.length() - 2, sb.length()).append("]").toString();
	}

	public void checkElementIndex(int index) {
		if (index < 0 || index >= objectCount) throw new IndexOutOfBoundsException();
	}

	public void checkPositionIndex(int index) {
		if (index < 0 || index > objectCount) throw new IndexOutOfBoundsException();
	}

	@SuppressWarnings("unchecked")
	public void sizeUp() {
		int nc = internalArray.length == 0
				? 1
				: internalArray.length << 1;
			E[] larger = (E[]) new Object[nc];
			System.arraycopy(internalArray, 0, larger, 0, objectCount);
			internalArray = larger;
	}

	public boolean plusOneExceeds() {
		return (objectCount == internalArray.length);
	}

	public void swap(int index1, int index2) {
		E temp = get(index1);
		set(index1, get(index2));
		set (index2, temp);
	}

}