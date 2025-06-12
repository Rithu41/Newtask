public class Calculator 
{
     int sum(int a, int b)
    {
        return a + b;
    }

    double sum(double a, double b)
    {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int intResult = calc.sum(10, 20);
        System.out.println("Sum of integers: " + intResult);

        double doubleResult = calc.sum(5.5, 3.2);
        System.out.println("Sum of doubles: " + doubleResult);
    }
}
