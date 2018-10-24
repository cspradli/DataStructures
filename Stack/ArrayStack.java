public class ArrayStack<E> implements Stack<E> {

    private static final int DEFAULTSIZE = 10;
    private E[] data;
    private int top;
    
    public ArrayStack(int size) {
        @SuppressWarnings("unchecked")
        E[] newdata = (E[]) new Object[size];
        data = newdata;
        top = 0;
    }

    public ArrayStack() {
        this(DEFAULTSIZE);
    }
    
    public boolean isEmpty() {
        return top == 0;
    }
    
    public int size() {
        return top;
    }

    public E peek() {
        if (isEmpty()) throw new EmptyCollectionException("Stack");
        return data[top-1];
    }
    
    public boolean push(E element) {
        if (top == data.length) extendArray();
        data[top] = element;
        top++;
        return true;
    }
    
    public E pop() {
        E element = peek();
        top--;
        data[top] = null;
        return element;
    }
    
    public boolean clear() {
        while (!isEmpty())
            pop();
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 23 * hash + top;
        for (int i=0; i<top; i++)
            hash = 23 * hash + data[i].hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        @SuppressWarnings("unchecked")
        ArrayStack<E> stack = (ArrayStack<E>) obj;
        if (top != stack.top) return false;
        for (int i=0; i<top; i++) {
            if (!data[i].equals(stack.data[i]))
                return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        if (top == 0) return "[ ]";
        StringBuilder sb = new StringBuilder("[");
        sb.append(data[top-1]);
        for (int i=top-2; i>=0; i--)
            sb.append(", " + data[i].toString());
        return sb.append("]").toString();
    }

    private void extendArray() {
        @SuppressWarnings("unchecked")
        E[] newdata = (E[]) new Object[data.length*2];
        for (int i=0; i<top; i++)
            newdata[i] = data[i];
        data = newdata;
    }
}