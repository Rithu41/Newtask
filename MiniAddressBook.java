import java.util.Scanner;

public class MiniAddressBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[5];
        String[] phones = new String[5];

        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter name for contact " + (i + 1) + ": ");
            names[i] = scanner.nextLine();

            System.out.print("Enter phone number for " + names[i] + ": ");
            phones[i] = scanner.nextLine();
        }
        System.out.println("\nMini Address Book:");
        for (int i = 0; i < names.length; i++) {
            System.out.println("Contact " + (i + 1) + ": " + names[i] + " - " + phones[i]);
        }

        scanner.close();
    }
}
