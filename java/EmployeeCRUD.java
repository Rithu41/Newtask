import java.io.*;
import java.util.*;

public class EmployeeCRUD {
    static final String FILE_NAME = "employee.txt";

    // CREATE
    public static void addEmployee(String id, String name, String dept, String salary) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(id + "," + name + "," + dept + "," + salary);
            bw.newLine();
            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // READ
    public static void viewEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("Employee Records:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // UPDATE
    public static void updateEmployee(String id, String newDept, String newSalary) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean updated = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(id)) {
                    writer.write(id + "," + parts[1] + "," + newDept + "," + newSalary);
                    updated = true;
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }

            if (updated) {
                System.out.println("Employee updated successfully!");
            } else {
                System.out.println("Employee ID not found.");
            }

            inputFile.delete();
            tempFile.renameTo(inputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DELETE
    public static void deleteEmployee(String id) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.split(",")[0].equals(id)) {
                    found = true;
                    continue;
                }
                writer.write(line);
                writer.newLine();
            }

            if (found) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee ID not found.");
            }

            inputFile.delete();
            tempFile.renameTo(inputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Simple menu for interaction
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n---- Employee Record System ----");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Salary: ");
                    String salary = sc.nextLine();
                    addEmployee(id, name, dept, salary);
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    String updateId = sc.nextLine();
                    System.out.print("New Department: ");
                    String newDept = sc.nextLine();
                    System.out.print("New Salary: ");
                    String newSal = sc.nextLine();
                    updateEmployee(updateId, newDept, newSal);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    String delId = sc.nextLine();
                    deleteEmployee(delId);
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}
