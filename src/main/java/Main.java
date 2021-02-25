import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static String UPDATE = "UPDATE public.pleasures SET value = %d WHERE \"pleasure\" = '%s'";

    public static void main(String[] args) {

        String masageUpdate = String.format(UPDATE, 4000, "masage");
        String kissUpdate = String.format(UPDATE, 2500, "kiss");
        List<String> queriesToRun = Arrays.asList(masageUpdate, kissUpdate);
//        QueryExecutor.executeQueries(queriesToRun);

        try {
            QueryExecutor.executeQueriesInOneTransaction(queriesToRun);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
