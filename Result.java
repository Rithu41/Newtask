
class Student {
    String name;
    int rollNumber;
    int mark1, mark2, mark3;

    Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    void assignMarks(int m1, int m2, int m3) {
        mark1 = m1;
        mark2 = m2;
        mark3 = m3;
    }
    int getTotalMarks()
     {
        return mark1 + mark2 + mark3;
    }
    double getAverageMarks() 
    {
        return getTotalMarks() / 3.0;
    }
    void displayResult() 
    {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + mark1 + ", " + mark2 + ", " + mark3);
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.println("Average Marks: " + getAverageMarks());
    }
}

public class Result
{
    public static void main(String[] args)
    {
        Student s1 = new Student("Alice", 101);
        s1.assignMarks(85, 90, 80);
        s1.displayResult();
    }
}