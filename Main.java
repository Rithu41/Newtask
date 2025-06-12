
class Person 
{
    String name;
    int age;
     public Person(String name, int age) 
    {
        this.name = name;
        this.age = age;
    }
}
class Employee extends Person 
{
    double basicSalary;
    double allowance;
    double deduction;

    public Employee(String name, int age, double basicSalary, double allowance, double deduction)
     {
        super(name, age); 
        this.basicSalary = basicSalary;
        this.allowance = allowance;
        this.deduction = deduction;
    }
    public double calculateSalary()
    {
       return basicSalary + allowance - deduction;
    }
    public void displayInfo() 
    {
        System.out.println("Employee: " + name);
        System.out.println("Age: " + age);
        System.out.println("Net Salary: ₹" + calculateSalary());
    }
}
public class Main
 {
    public static void main(String[] args)
    {
        Employee emp = new Employee("Sneha", 28, 30000, 8000, 3000);
        emp.displayInfo();
    }
}
