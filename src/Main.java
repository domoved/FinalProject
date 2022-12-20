import com.opencsv.exceptions.CsvException;
import forbes.*;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, CsvException, SQLException {
        CSVParser parser = new CSVParser("src\\resources\\Forbes.csv");
        SQLLite sqlLite = new SQLLite("jdbc:sqlite:src/resources/forbes.sqlite");
//        SQLLite.addTable();
//        parser.forbesList.forEach(sqlLite::addString);
        Tasks.firstTask();
        Tasks.secondTask();
        Tasks.thirdTask();
    }
}