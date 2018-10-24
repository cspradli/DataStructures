/**
* An array implementation of the List interface.
*
* @author Charley Sheaffer
* @version 10/23/2018
*
*/

public class ArrayList<E> implements List<E> {
    
    private static final int DEFAULTSIZE = 10;
    private E [] elements;
    private int size;
    
    /*
    * Java does not permit declaration of generic arrays. This constructor creates
    * an array of Objects and then casts the array to the generic type. This cast
    * will result in a compiler warning about unchecked types. The
    * @SuppressWarnings annotation is used to indicate that we know what
    * we are doing here; it suppresses the "unchecked" warning.
    * @SuppressWarnings can only apply to a declaration, so we need
    * to declare and initialize a new variable and then copy it to
    * the instance variable.
    */
    public ArrayList(int size) {
        @SuppressWarnings("unchecked")
        E[] newdata = (E[]) new Object[size];
        elements = newdata;
        size = 0;
    }

    public ArrayList() {
        this(DEFAULTSIZE);
    }

    public int size() {
        return size;
    }
    
    public boolean clear() {
        for (int i=0; i<size; i++)
            elements[i] = null;
        size = 0;
        return true;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == elements.length;
    }
    
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }
    
    public int indexOf(Object obj) {
        for (int i=0; i<size; i++)
            if (elements[i].equals(obj))
                return i;
        return -1;
    }
    
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index: " + index);
        return elements[index];
    }
    
    public boolean add(E element) {
        return add(size, element);
    }
    
    public boolean add(int index, E element) {
        if (isFull()) extendArray();
        for (int i=size; i>index; i--) 
            elements[i] = elements[i-1];
        elements[index] = element;
        size++;
        return true;
    }

    public E remove(int index) {
        E element = get(index);
        for (int i=index; i<size; i++)
            elements[i] = elements[i+1];
        size--;
        return element;
    }
    
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) return false;
        remove(index);
        return true;
    }
    
    public E set(int index, E element) {
        E oldElement = get(index);
        elements[index] = element;
        return oldElement;
    } 

    @Override
    public int hashCode() {
        int hash = 11;
        for (int i=0; i<size; i++) {
            hash = 23 * hash + elements[i].hashCode();
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        @SuppressWarnings("unchecked")
        ArrayList<E> list = (ArrayList<E>) obj;
        if (size != list.size) return false;
        for (int i=0; i<size; i++) {
            if (!elements[i].equals(list.elements[i]))
                return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        if (size == 0) return "[ ]";
        StringBuilder sb = new StringBuilder("[");
        for (int i=0; i<size-1; i++)
            sb.append(elements[i] + ", ");
        sb.append(elements[size-1] + "]\n");
        return sb.toString();
    }
    
    private void extendArray() {
        @SuppressWarnings("unchecked")
        E[] newdata = (E[]) new Object[elements.length*2];
        for (int i=0; i<size; i++)
            newdata[i] = elements[i];
        elements = newdata;
    }
}
