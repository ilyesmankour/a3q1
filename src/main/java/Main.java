import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        // Connects to database
        queries.connect();

        // Main menu of the application
        while (true) {
            System.out.println("\n1. getAllStudents(): Retrieves and displays all records from the students table.");
            System.out.println("2. addStudent(first_name, last_name, email, enrollment_date): Inserts a new student record into the students table.");
            System.out.println("3. updateStudentEmail(student_id, new_email): Updates the email address for a student with the specified student_id.");
            System.out.println("4. deleteStudent(student_id): Deletes the record of the student with the specified student_id.");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            option = scanner.nextInt();

            // Switch case for each CRUD function depending on user input
            switch (option) {
                case 1:
                    queries.getAllStudents();
                    break;
                case 2:
                    // To add a student, the user will be asked to enter each information (first name, last name, ...) of the student and the values will then be used in the query
                    scanner.nextLine();
                    System.out.print("Enter first name: ");
                    String first_name = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String last_name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter enrollment date (YYYY-MM-DD): ");
                    String enrollment_date = scanner.nextLine();
                    queries.addStudent(first_name, last_name, email, enrollment_date);
                    break;
                case 3:
                    // Same idea as case 2
                    System.out.print("Enter student ID: ");
                    int student_id = scanner.nextInt();
                    System.out.print("Enter new email: ");
                    scanner.nextLine();
                    String new_email = scanner.nextLine();
                    queries.updateStudentEmail(student_id, new_email);
                    break;
                case 4:
                    // Same idea as case 2
                    System.out.print("Enter student ID: ");
                    student_id = scanner.nextInt();
                    queries.deleteStudent(student_id);
                    break;
                case 0:
                    System.out.println("Exiting application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 0 to 4.");
                    break;
            }

        }
    }
}

