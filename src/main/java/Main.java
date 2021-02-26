import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static String UPDATE = "UPDATE public.pleasures SET value = %d WHERE \"pleasure\" = '%s'";
    private static String UPDATE1 = "UPDATE public.pleasures SET time = %d WHERE \"pleasure\" = '%s'";
    private static String DELETE = "DELETE FROM public.pleasures WHERE \"pleasure\" = '%s'";
    private static String INSERT = "INSERT INTO public.people (\"personid\", \"name\", \"city\") VALUES( %d, '%s', '%s')";

    public static void main(String[] args) {

        String masageUpdate = String.format(UPDATE, 222211, "masage");
        String kissUpdate = String.format(UPDATE, 7841, "kiss");
        String eyeContactUpdate = String.format(UPDATE, 650, "eye contact");
        String touchUpdate = String.format(UPDATE, 4754, "touch");
        String lickingUpdate = String.format(UPDATE, 7974, "licking");
        String drapankoUpdate = String.format(UPDATE, 684, "drapanko");
        String miziankoUpdate = String.format(UPDATE, 4500, "mizianko");
        String giggleUpdate = String.format(UPDATE, 658, "giggle");
        String giggle1Update = String.format(UPDATE1, 16, "licking");
        String timeUpdate = String.format(UPDATE1, 22, "drapanko");
        String lickingDelete = String.format(DELETE, "licking");
        List<String> queriesToRun = Arrays.asList(masageUpdate, kissUpdate, eyeContactUpdate,touchUpdate,
                lickingUpdate, drapankoUpdate, miziankoUpdate, giggleUpdate, giggle1Update, lickingDelete, timeUpdate);
//        QueryExecutor.executeQueries(queriesToRun);

        try {
            QueryExecutor.executeQueriesInOneTransaction(queriesToRun);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet result = QueryExecutor.executeSelect("SELECT * FROM public.pleasures");
            while(result.next()) {
                System.out.println("Wartości z tabeli pleasures: " + result.getString("pleasure"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        QueryExecutor.executeQuery("CREATE TABLE public.people (PersonID int, Name varchar, City varchar);");

        String insert = String.format(INSERT, 1, "Robertinio", "Preston");
        String insert1 = String.format(INSERT, 2, "Chłop", "Mazury");
        String insert2 = String.format(INSERT, 3, "Robert", "Manchester");
        String insert3 = String.format(INSERT, 4, "Agata", "Liverpool");
        String insert4 = String.format(INSERT, 5, "Kaśka", "Kraków");
        String insert5 = String.format(INSERT, 6, "Konrad", "Janikowice");

        QueryExecutor.executeQuery(insert);
        List<String> myListToExecute = Arrays.asList(insert, insert1, insert2, insert3, insert4, insert5);
        QueryExecutor.executeQueries(myListToExecute);

    }
}
