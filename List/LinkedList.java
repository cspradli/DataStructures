/**
* A linked list implementation of the List interface.
*
* @author Charley Sheaffer
* @version 10/23/2018
*
*/
public class LinkedList<E> implements List<E> {

    private static class Node<E> {
        
        private E data;
        private Node<E> next;
        
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
        
        public Node(E data) {
            this(data, null);
        }
        
        public Node() {
            this(null, null);
        }
    }
    
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    // This implementation uses a dummy head node.
    public LinkedList() {
        head = new Node<>();
        tail = head;
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
  public boolean clear() {
      head.next = null;
      tail = head;
      size = 0;
      return true;
  }
  
  public boolean isEmpty() {
      return size == 0;
  }

  /*
  * Returns the node immediately before the node with a given index.
  */
  private Node<E> getNodeBefore(int index) {
      if (index < 0 || index >= size)
          throw new IndexOutOfBoundsException("index: " + index);
      Node<E> current = head;
      for (int i=0; i<index; i++)
          current = current.next;
      return current;
  }

	public boolean contains(Object obj) {
      return indexOf(obj) != -1;
	}
    
  public int indexOf(Object obj) {
      Node<E> current = head.next;
      int index = 0;
      while (current != null) {
          if (current.data.equals(obj))
              return index;
          current = current.next;
          index++;
      }
      return -1;
  }
    
  public E get(int index) {
      return getNodeBefore(index).next.data;
  }

	public boolean add(E element) {
	    tail.next = new Node<>(element);
	    tail = tail.next;
	    size++;
      return true;
	}

	public boolean add(int index, E element) {
    if (index == size) {
      add(element);
    }
    else {
	    Node<E> previous = getNodeBefore(index);
	    Node<E> current = new Node<>(element, previous.next);
	    previous.next = current;
	    if (tail == previous)
	        tail = current;
	    size++;
    }
    return true;
	}

	public E remove(int index) {
	    Node<E> previous = getNodeBefore(index);
      E data = previous.next.data;
	    previous.next = previous.next.next;
	    if (previous.next == null)
	        tail = previous;
	    size--;
      return data;
	}

  public boolean remove(Object obj) {
      Node<E> current = head;
      while (current.next != null) {
        if (current.next.data.equals(obj)) {
          current.next = current.next.next;
          if (current.next == null) tail = current;
          return true;
        }
        current = current.next;
      }
      return false;
  }

	public E set(int index, E element) {
      Node<E> before = getNodeBefore(index);
      E data = before.next.data;
	    before.next.data = element;
      return data;
	}
	
	@Override
	public String toString() {
	    if (size == 0) return "[ ]";
	    StringBuilder sb = new StringBuilder("[");
	    Node<E> current = head.next;
	    while (current.next != null) {
	        sb.append(current.data + ", ");
	        current = current.next;
	    }
	    sb.append(current.data + "]\n");
	    return sb.toString();
	}
}