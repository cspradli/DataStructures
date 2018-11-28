public class Student {
  
  private int id;
  private String name;
  private double gpa;
  private int hours;
  private String major;

  public Student(int id, String name) {
    this.id = id;
    this.name = name;
    gpa = 0.0;
    hours = 0;
    major = "Undeclared";
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String setName(String name) {
    String oldName = this.name;
    this.name = name;
    return oldName;
  }

  public double getGPA() {
    return gpa;
  }

  public double setGPA(double gpa) {
    double oldGPA = this. gpa;
    this.gpa = gpa;
    return oldGPA;
  }

  public int getHours() {
    return hours;
  }
 
  public int setHours(int hours) {
    int oldHours = this.hours;
    this.hours = hours;
    return oldHours;
  }

  public String getMajor() {
    return major;
  }

  public String setMajor(String major) {
    String oldMajor = this.major;
    this.major = major;
    return oldMajor;
  }

  @Override
  public int hashCode() {
    int hash = 11;
    hash = 31 * hash + id;
    hash = 31 * hash + name.hashCode();
    hash = 31 * hash + Double.valueOf(gpa).hashCode();
    hash = 31 * hash + hours;
    hash = 31 * hash + major.hashCode();
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Student s = (Student) obj;
    return id == s.id && name.equals(s.name) && hours == s.hours
           && major.equals(s.major) && Double.valueOf(gpa).equals(Double.valueOf(s.gpa));
  }

  @Override
  public String toString() {
    return name + "\n"
           + id + "\n"
           + "GPA: " + gpa + "\n"
           + "Hours: " + hours + "\n"
           + "Major: " + major + "\n";
  }
}