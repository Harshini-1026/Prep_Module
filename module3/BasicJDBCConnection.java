import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasicJDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, user, password);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT id, name FROM students")) {

                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id") + " - " + resultSet.getString("name"));
                }
            }
        } catch (Exception exception) {
            System.out.println("JDBC error: " + exception.getMessage());
        }
    }
}