import java.util.Scanner;

// Main class for CLI and entry point
public class StudentRecordManagementSystem {
    // Static variables for manage and scanner
    private static StudentManager manage = new StudentManager();
    private static Scanner scanner = new Scanner(System.in);

    // Program entry point
    public static void main(String[] args) {
        System.out.println("=== Welcome to Student Record Management System ===");
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            processChoice(choice);
        }
        // Loop exits via System.exit(0)
    }

    // Show menu options
    private static void displayMenu() {
        System.out.print("\n" + "=".repeat(50) + "\n           STUDENT MANAGEMENT MENU\n" + "=".repeat(50) + "\n1. Add New Student\n2. View All Students\n3. Update Student Information\n4. Delete Student\n5. Search Student by Name\n0. Exit System\n" + "=".repeat(50) + "\nEnter your choice (0-5): ");
    }

    // Get and validate user input
    private static int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            return choice;
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.nextLine();
            return -1;
        }
    }

    // Handle user choice
    private static void processChoice(int choice) {
        switch (choice) {
            case 1:
                manage.addStudent();
                break;
            case 2:
                manage.viewAllStudents();
                break;
            case 3:
                manage.updateStudent();
                break;
            case 4:
                manage.deleteStudent();
                break;
            case 5:
                manage.searchStudentByName();
                break;
            case 0:
                System.out.println("\nThank you for using Student Record Management System!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice! Please select a number between 0-5.");
        }
        pauseForUser();
    }

    // Pause until user presses Enter
    private static void pauseForUser() {
        System.out.print("\nPress Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            // Ignore
        }
    }
}