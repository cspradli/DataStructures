public interface Queue<E> {
    
/**
*   @return true if there are no elements in the queue, false otherwise
*/
    public boolean isEmpty();
    
/**
*   @return the number of elements in the queue
*/
    public int size();

/**
*   @return the front element in the queue
*   @throws EmptyCollectionException
*/
    public E peek();
    
/**
*   Adds an element to the rear of the queue.
*   @param  element an element to place at the rear of the queue
*/
    public void enqueue(E element);

/**
*   Removes and returns the front element of the queue.
*   @return the element at the front of the queue
*   @throws EmptyCollectionException
*/
    public E dequeue();

/**
*   Removes all elements from the queue.
*/
    public void clear();

}