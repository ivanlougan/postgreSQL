import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static String URL = "jdbc:postgresql://localhost:5432/postgres";

    private static String USER = "postgres";

    private static String PASSWORD = "password";

    public static Connection connect() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
