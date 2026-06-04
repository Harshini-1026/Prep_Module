import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTransactionExample {
    public static void main(String[] args) {
        AccountService accountService = new AccountService("jdbc:mysql://localhost:3306/bankdb", "root", "root");

        try {
            accountService.transfer(1, 2, 500.0);
            System.out.println("Transfer completed.");
        } catch (SQLException exception) {
            System.out.println("Transaction failed: " + exception.getMessage());
        }
    }
}

class AccountService {
    private final String url;
    private final String user;
    private final String password;

    AccountService(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    void transfer(int fromAccount, int toAccount, double amount) throws SQLException {
        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement debit = connection.prepareStatement(debitSql);
             PreparedStatement credit = connection.prepareStatement(creditSql)) {

            connection.setAutoCommit(false);

            debit.setDouble(1, amount);
            debit.setInt(2, fromAccount);
            debit.executeUpdate();

            credit.setDouble(1, amount);
            credit.setInt(2, toAccount);
            credit.executeUpdate();

            connection.commit();
        } catch (SQLException exception) {
            throw exception;
        }
    }
}