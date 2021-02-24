import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {


        try {
            QueryExecutor.executeQuery("INSERT INTO public.pleasures(\"id\", \"pleasure\", \"time\") VALUES (9, 'ticlke', 8)");

            ResultSet result = QueryExecutor.executeSelect("SELECT * FROM public.pleasures");
            result.next();
            String getId = result.getString("id");
            System.out.println("Found: " + getId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
