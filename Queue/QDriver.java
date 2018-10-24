public class QDriver {

    public static void main(String [] args) {
        Queue<String> q1 = new ArrayQueue<String>();
        Queue<String> q2 = new LinkedQueue<String>();
        
        System.out.println(q1);

        // Empty list tests.
        System.out.println("q1 is empty: " + q1.isEmpty());
        try {
            q1.dequeue();
        }
        catch(EmptyCollectionException e) {
            System.out.println("Attempt to dequeue an empty queue.");
        }

        System.out.println("q2 is empty: " + q2.isEmpty());
        try {
            q2.dequeue();
        }
        catch(EmptyCollectionException e) {
            System.out.println("Attempt to dequeue an empty queue.");
        }

        try {
            q1.peek();
        }
        catch(EmptyCollectionException e) {
            System.out.println("Attempt to peek an empty queue.");
        }
        
        try {
            q2.peek();
        }
        catch(EmptyCollectionException e) {
            System.out.println("Attempt to peek an empty queue.");
        }
        
        // Generic add/delete tests.
        q1.enqueue("one");
        q1.enqueue("two");
        q1.dequeue();
        q1.enqueue("three");
        q1.enqueue("four");
        // Not empty tests.
        System.out.println("q1 is empty: " + q1.isEmpty());
        System.out.println(q1);

        q2.enqueue("one");
        q2.enqueue("two");
        q2.dequeue();
        q2.enqueue("three");
        q2.enqueue("four");
        // Not empty tests.
        System.out.println("q2 is empty: " + q2.isEmpty());
        System.out.println(q2);

        // Clear tests.
        q1.clear();
        System.out.println("q1 is empty: " + q1.isEmpty());
        System.out.println(q1);

        q2.clear();
        System.out.println("q2 is empty: " + q2.isEmpty());
        System.out.println(q2);

        q1.enqueue("one");
        System.out.println(q1);
        q1.dequeue();
        System.out.println(q1);
        q2.enqueue("one");
        System.out.println(q2);
        q2.dequeue();
        System.out.println(q2);
    }
}