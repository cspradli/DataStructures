import java.util.Collection;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class HashExample {
  
  public static void main(String[] args) {
    Map<Integer, Student> students = new HashMap<>();
    students.put(1234, new Student(1234, "Bob"));
    students.put(3618, new Student(3618, "Bill"));
    students.put(5378, new Student(5378, "Jill"));
    students.put(4541, new Student(4541, "Jane"));

    Collection<Student> sList = students.values();
    for (Student s : sList) {
      System.out.println(s);
    }

    Set<Integer> keys = students.keySet();
    for (int key : keys) {
      System.out.print(key + " ");
    }
    System.out.println();

    Student s1 = students.get(5378);
    s1.setGPA(3.6);
    s1.setHours(15);
    s1.setMajor("Computer Science");

    for (Student s : sList) {
      System.out.println(s);
    }

    for (Map.Entry<Integer, Student> s : students.entrySet()) {
      System.out.println("Entry key: " + s.getKey());
      System.out.println("Entry value: " + s.getValue());
    }
  }
}