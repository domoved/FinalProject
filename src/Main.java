import forbes.CSVParser;
import forbes.SQLite;
import forbes.Tasks;
import java.io.File;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String csvPath = "src\\resources\\Forbes.csv";
        String sqlitePath = "jdbc:sqlite:src/resources/Forbes.sqlite";
        CSVParser parser = new CSVParser(csvPath);
        SQLite sqlite = new SQLite(sqlitePath);
        File file = new File("H:\\Programs\\Java\\FinalProject\\src\\resources\\Forbes.csv");

        if (!file.exists()){
            SQLite.createAndFillTable(parser, sqlite);
        }

        Tasks.solveFirstTask();
        Tasks.solveSecondTask();
        Tasks.solveThirdTask();
    }
}