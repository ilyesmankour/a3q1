import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class queries {
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;

    //connect function to connect to database
    public static void connect() {
        String url = "jdbc:postgresql://localhost:5432/a3q1";
        String user = "postgres";
        String password = "postgres";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to database");
            } else {
                System.out.println("Connection failed");
            }
        } catch (Exception e) {
            System.out.print("An unexpected error occured.");
        }
    }
    // getAllStudents function similar to the video posted, it prints all students in the current students table
    public static void getAllStudents() {
        try{
            statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM students");
            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name") + " \t");
                System.out.print(resultSet.getString("last_name") + " \t");
                System.out.print(resultSet.getString("email") + " \t");
                System.out.println(resultSet.getString("enrollment_date"));
            }
        } catch (Exception e) {
            System.out.print("An unexpected error occured.");
        }
    }

    // addStudent function that allows adding students to the students table
    public static void addStudent(String first_name, String last_name, String email, String enrollment_date) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO students (first_name, last_name, email, enrollment_date) " +
                    "VALUES ('" + first_name + "', '" + last_name + "', '" + email + "', '" + enrollment_date + "')");
            resultSet = statement.getResultSet();
            System.out.println("Student added successfully.");
        } catch (Exception e){
            System.out.print("An unexpected error occured.");
        }
    }

    // function that updates the student email using the student ID
    public static void updateStudentEmail(int studentId, String newEmail) {
        try {
            statement = connection.createStatement();
            int update = statement.executeUpdate("UPDATE students SET email = '" + newEmail + "' WHERE student_id = " + studentId);
            if (update > 0) {
                System.out.println("Email updated successfully for student with ID: " + studentId);
            } else {
                System.out.println("No student found with ID: " + studentId);
            }
        } catch (Exception e) {
            System.out.print("An unexpected error occured.");
        }
    }

    // function that deletes students from the current students table
    public static void deleteStudent(int student_id) {
        try {
            statement = connection.createStatement();
            int deleted = statement.executeUpdate("DELETE FROM students WHERE student_id = " + student_id);
            if (deleted > 0) {
                System.out.println("Student with ID " + student_id + " deleted successfully.");
            } else {
                System.out.println("No student found with ID: " + student_id);
            }
        } catch (Exception e) {
            System.out.print("An unexpected error occured.");
        }
    }
}