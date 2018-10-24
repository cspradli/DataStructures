public class LinkedStack<E> implements Stack<E> {

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
    
    private Node<E> top;
    private int size;
    
    public LinkedStack() {
        top = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public E peek() {
        if (isEmpty()) throw new EmptyCollectionException("Stack");
        return top.data;        
    }
    
    public boolean push(E element) {
        top = new Node<>(element, top);
        size++;
        return true;
    }
    
    public E pop() {
        E element = peek();
        top = top.next;
        size--;
        return element;
    }
    
    public boolean clear() {
        top = null;
        size = 0;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 29 * hash + size;
        Node<E> current = top;
        while (current != null) {
            hash = 29 * hash + current.data.hashCode();
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
        LinkedStack<E> stack = (LinkedStack<E>) obj;
        if (size != stack.size) return false;
        Node<E> current = top;
        Node<E> otherCurrent = stack.top;
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
        if (top == null) return "[ ]";
        StringBuilder sb = new StringBuilder("[");
        sb.append(top.data);
        Node<E> current = top.next;
        while (current != null) {
            sb.append(", " + current.data);
            current = current.next;
        }
        return sb.append("]").toString();
    }
}