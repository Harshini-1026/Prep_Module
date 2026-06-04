import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsertUpdateExample {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO("jdbc:mysql://localhost:3306/studentdb", "root", "root");

        try {
            studentDAO.insertStudent(101, "Anita");
            studentDAO.updateStudentName(101, "Anita Sharma");
            System.out.println("Insert and update completed.");
        } catch (SQLException exception) {
            System.out.println("JDBC error: " + exception.getMessage());
        }
    }
}

class StudentDAO {
    private final String url;
    private final String user;
    private final String password;

    StudentDAO(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    void insertStudent(int id, String name) throws SQLException {
        String sql = "INSERT INTO students (id, name) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.executeUpdate();
        }
    }

    void updateStudentName(int id, String name) throws SQLException {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }
}