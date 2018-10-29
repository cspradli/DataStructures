/**
* An interface specifying some basic list operations.
*
* @author Charley Sheaffer
* @version 10/28/2018
*
*/

public interface List<E> {

    /**
    *   @return the number of elements in the list
    */
    public int size();

	/**
	*   Determines whether a given object is in the list.
	*   @param obj the object to look for in the list
	*   @return true, if the given object is in the list, false otherwise
	*/
    default boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }
    
    
    /**
    *   Finds the index of a given object.
    *   @param obj the object to look for in the list.
    *   @return the index of the object in the list or -1 if the object is not 
    *   in the list
    */
    public int indexOf(Object obj);
    
    /**
    *   @precondition index is >= 0 and < size of the list
    *   @param index an index of an element in the list
    *   @return the element of the list at the given index
    *   @throws IndexOutOfBoundsException if the index is out of range
    */
    public E get(int index);

    /**
    *   Adds a new element at the end of the list.
    *   @param element element to be added to the list
    *   @return true if element added, false otherwise
    */
    default boolean add(E element) {
        return add(size(), element);
    }
    

    /**
    *   Inserts a new element before a specified index.
    *   @precondition index is >= 0 and <= size of the list
    *   @param element element to be added to the list
    *   @param index index of the element in the list that this element 
    *       is to be inserted before
    *   @return true, if element added, false otherwise
    *   @throws IndexOutOfBoundsException if index is out of range
    */
	public boolean add(int index, E element);

    /**
    *   Removes the specified element.
    *   @param element the element that is to be removed from the list
    *   @return true if the element exists and was removed, false if the 
    *   element was not present in the list
    */
    default boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) return false;
        remove(index);
        return true;
    }
    

    /**
    *   Removes the element at a specified index.
    *   @precondition index is >= 0 and < size of the list
    *   @param index index of the element that is to be removed from the list
    *   @return the element at the index specified
    *   @throws IndexOutOfBoundsException
    */
    public E remove(int index);

    /**
    *   Replaces the element at a specified index with the given element.
    *   @precondition index is >= 0 and < size of the list
    *   @param element element to place at the specified index
    *   @param index index of the element that is to be replaced
    *   @return the element that is being replaced
    *   @throws IndexOutOfBoundsException
    */
	public E set(int index, E element);
	
	/**
	*   Removes all elements from the list
    *   @return true, if the clear succeeds, false otherwise
	*/
	public boolean clear();
	
	/**
	*   Determines whether there are any elements in the list
	*   @return true, if there are no elements in the list, false otherwise
	*/
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
    *   Returns the hash code for this list.
    *   @return the hash code for this list
    */
    public int hashCode();

    /**
    *   Determines if two lists are equal.
    *   @param obj The list to compare to this list for equality. Two lists are
    *   equal if they have equal elements in the same positions.
    *   @return true if this list is equal to the given list
    */
    public boolean equals(Object obj);

    /**
    *   Returns a printable representation for this list.
    *   @return a printable representation for this list
    */
    public String toString();
}


