import java.util.ArrayList;
import java.util.Scanner;

// Handles CRUD operations for students
public class StudentManager {
    private ArrayList<Student> students;
    private Scanner scanner;

    // Constructor
    public StudentManager() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Add new student
    public void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        if (findStudentById(id) != null) {
            System.out.println("Error: Student with ID " + id + " already exists!");
            return;
        }
        scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();
        if (marks < 0 || marks > 100) {
            System.out.println("Error: Marks should be between 0 and 100!");
            return;
        }
        Student newStudent = new Student(id, name, marks);
        students.add(newStudent);
        System.out.println("Student added successfully!");
    }

    // View all students
    public void viewAllStudents() {
        System.out.println("\n--- All Students ---");
        if (students.isEmpty()) {
            System.out.println("No students found in the system.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("\n\nTotal Students: " + students.size());
    }

    // Find student by ID
    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Update student info
    public void updateStudent() {
        System.out.println("\n--- Update Student ---");
        if (students.isEmpty()) {
            System.out.println("No students available to update.");
            return;
        }
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student with ID " + id + " not found!");
            return;
        }
        System.out.println("Current Student Information:");
        System.out.println(student);
        scanner.nextLine();
        System.out.print("Enter new name (or press Enter to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.trim().isEmpty()) {
            student.setName(newName);
        }
        System.out.print("Enter new marks (or -1 to keep current): ");
        double newMarks = scanner.nextDouble();
        if (newMarks != -1) {
            if (newMarks >= 0 && newMarks <= 100) {
                student.setMarks(newMarks);
            } else {
                System.out.println("Invalid marks! Keeping current marks.");
            }
        }
        System.out.println("Student updated successfully!");
        System.out.println("Updated Information: " + student);
    }

    // Delete student
    public void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        if (students.isEmpty()) {
            System.out.println("No students available to delete.");
            return;
        }
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student with ID " + id + " not found!");
            return;
        }
        System.out.println("Student to be deleted:");
        System.out.println(student);
        System.out.print("Are you sure you want to delete this student? (y/n): ");
        char confirmation = scanner.next().toLowerCase().charAt(0);
        if (confirmation == 'y') {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Delete operation cancelled.");
        }
    }

    // Search students by name
    public void searchStudentByName() {
        System.out.println("\n--- Search Student by Name ---");
        if (students.isEmpty()) {
            System.out.println("No students available to search.");
            return;
        }
        scanner.nextLine();
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine().toLowerCase();
        boolean found = false;
        System.out.println("Search Results:");
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(searchName)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with name containing: " + searchName);
        }
    }
}