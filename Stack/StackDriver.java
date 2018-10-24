public class StackDriver {

    public static void main(String [] args) {
        Stack<String> s1 = new ArrayStack<String>();
        Stack<String> s2 = new LinkedStack<String>();
        
        System.out.println(s1);

        // Empty list tests.
        System.out.println("s1 is empty: " + s1.isEmpty());
        try {
            s1.pop();
        }
        catch(EmptyCollectionException e) {
            System.out.println("Attempt to pop an empty stack.");
        }

        System.out.println("s2 is empty: " + s2.isEmpty());
        try {
            s2.pop();
        }
        catch(EmptyCollectionException e) {
            System.out.println("Attempt to pop an empty stack.");
        }

        try {
            s1.peek();
        }
        catch(EmptyCollectionException e) {
            System.out.println("Attempt to peek an empty stack.");
        }
        
        try {
            s2.peek();
        }
        catch(EmptyCollectionException e) {
            System.out.println("Attempt to peek an empty stack.");
        }
        
        // Generic add/delete tests.
        s1.push("one");
        s1.push("two");
        s1.pop();
        s1.push("three");
        s1.push("four");
        // Not empty tests.
        System.out.println("s1 is empty: " + s1.isEmpty());
        System.out.println(s1);

        s2.push("one");
        s2.push("two");
        s2.pop();
        s2.push("three");
        s2.push("four");
        // Not empty tests.
        System.out.println("s2 is empty: " + s2.isEmpty());
        System.out.println(s2);

        // Clear tests.
        s1.clear();
        System.out.println("s1 is empty: " + s1.isEmpty());
        System.out.println(s1);

        s2.clear();
        System.out.println("s2 is empty: " + s2.isEmpty());
        System.out.println(s2);

        s1.push("one");
        System.out.println(s1);
        s2.push("one");
        System.out.println(s2);
    }
}