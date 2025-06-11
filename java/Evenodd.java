import java.util.Scanner;
 public class Evenodd
 {
    public static void main(String args[])
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter an integer:");
        int num=input.nextInt();
        if(num%2==0)
        {
            System.out.println(num + "even");
        }
    }
 }