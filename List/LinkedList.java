/**
* A linked list implementation of the List interface.
*
* @author Charley Sheaffer
* @version 10/28/2018
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

	public boolean add(int index, E element) {
      Node<E> previous = (index == size) ? tail : getNodeBefore(index);
      Node<E> current = new Node<>(element, previous.next);
      previous.next = current;
      if (tail == previous)
        tail = current;
      size++;
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

	public E set(int index, E element) {
      Node<E> before = getNodeBefore(index);
      E data = before.next.data;
	  before.next.data = element;
      return data;
	}
	
    @Override
    public int hashCode() {
        int hash = 11;
        Node<E> current = head.next;
        while (current != null) {
            hash = 23 * hash + current.data.hashCode();
            current = current.next;
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        @SuppressWarnings("unchecked")
        LinkedList<E> list = (LinkedList<E>) obj;
        if (size != list.size) return false;
        Node<E> current = head.next;
        Node<E> otherCurrent = list.head.next;
        while (current != null) {
            if (!current.data.equals(otherCurrent.data))
                return false;
            current = current.next;
            otherCurrent = otherCurrent.next;
        }
        return true;
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
