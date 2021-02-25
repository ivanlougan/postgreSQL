import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class QueryExecutor {

    public static ResultSet executeSelect(String selectQuery) {

        try {
            Connection connection = DBConnector.connect();
            Statement statement = connection.createStatement();
            return statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public static void executeQueries(List<String> queries) {

        queries.forEach(QueryExecutor::executeQuery);
    }

    public static void executeQuery(String query) {

        try {
            Connection connection = DBConnector.connect();
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void executeQueriesInOneTransaction(List<String> queries) throws SQLException {

        Connection connection = DBConnector.connect();
        connection.setAutoCommit(false);
        queries.forEach(query -> executeQuery(query, connection));
        connection.commit();
        connection.close();
    }

    public static void executeQuery(String query, Connection connection) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new RuntimeException("ROLLBACK!");
        }
    }
}







