public class ArrayQueue<E> implements Queue<E> {

    private static final int DEFAULTSIZE = 10;
    private E[] data;
    private int front;
    private int rear;
    private int size;
    
    public ArrayQueue(int capacity) {
        @SuppressWarnings("unchecked")
        E[] newdata = (E[]) new Object[capacity];
        data = newdata;
        front = 0;
        rear = 0;
        size = 0;
    }

    public ArrayQueue() {
        this(DEFAULTSIZE);
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == data.length;
    }
    
    public E peek() {
        if (isEmpty()) throw new EmptyCollectionException("queue");      
        return data[front]; 
    }
    
    public void enqueue(E element) {
        if (isFull()) extendArray();
        data[rear] = element;
        rear = (rear + 1) % data.length;
        size++;
    }
    
    public E dequeue() {     
        E element = peek();
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return element;        
    }
    
    public void clear() {
        while (!isEmpty())
            dequeue();
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 29 * hash + size;
        for (int i=0; i<size; i++) {
            hash = 29 * hash + data[(front+i)%data.length].hashCode();
        }
        return hash;        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        @SuppressWarnings("unchecked")
        ArrayQueue<E> queue = (ArrayQueue<E>) obj;
        if (size != queue.size) return false;
        int index1, index2;
        for (int i=0; i<size; i++) {
            index1 = (front+i)%data.length;
            index2 = (queue.front+i)%queue.data.length;
            if(!data[index1].equals(queue.data[index2]))
                return false;
        }
        return true;
    }

    @Override    
    public String toString() {
        if (size() == 0) return "[ ]";
        StringBuilder sb = new StringBuilder("[");
        sb.append(data[front]);
        for (int i=1; i<size; i++)
            sb.append(", " + data[(front+i)%data.length]);
        return sb.append("]").toString();
    }

    private void extendArray() {
        @SuppressWarnings("unchecked")
        E[] newdata = (E[]) new Object[data.length*2];
        for (int i=0; i<size; i++)
            newdata[i] = data[(front+i)%data.length];
        data = newdata;
        front = 0;
        rear = size;
    }
}
