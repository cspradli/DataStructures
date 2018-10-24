public class LinkedQueue<E> implements Queue<E> {

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
    
    private Node<E> front;
    private Node<E> rear;
    private int size;
    
    public LinkedQueue() {
        front = new Node<>();
        rear = front;
        size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public E peek() {
        if (isEmpty()) throw new EmptyCollectionException("queue");
        return front.next.data;        
    }
    
    public void enqueue(E element) {
        Node<E> node = new Node<>(element);
        rear.next = node;
        rear = node;
        size++;
    }
    
    public E dequeue() {
        E element = peek();
        front.next = front.next.next;
        size--;
        if (isEmpty()) rear = front;
        return element;  
    }
    
    public void clear() {
        front.next = null;
        rear = front;
        size = 0;
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 29 * hash + size;
        Node current = front.next;
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
        LinkedQueue<E> queue = (LinkedQueue<E>) obj;
        if (size != queue.size) return false;
        Node current = front.next;
        Node otherCurrent = queue.front.next;
        while (current != null) {
            if(!current.data.equals(otherCurrent.data))
                return false;
            current = current.next;
            otherCurrent = otherCurrent.next;
        }
        return true;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[ ]";
        StringBuilder sb = new StringBuilder("[");
        sb.append(front.next.data);
        Node current = front.next.next;
        while (current != null) {
            sb.append(", " + current.data);
            current = current.next;
        }
        return sb.append("]").toString();
    }
}