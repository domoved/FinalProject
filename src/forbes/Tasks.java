package forbes;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Tasks {
    public static void solveFirstTask() throws SQLException {
        Map<String, Float> countryCapital = new HashMap<>();
        String request = "SELECT DISTINCT country, SUM(networth) AS capital " +
                "FROM Forbes " +
                "GROUP BY country;";
        ResultSet resultSet = forbes.SQLite.statement.executeQuery(request);
        while (resultSet.next()){
            countryCapital.put(
                    resultSet.getString("country"),
                    Float.parseFloat(resultSet.getString("capital"))
            );
        }

        EventQueue.invokeLater(() -> {
            var plot = new Plot(countryCapital);
            plot.setVisible(true);
        });
    }
    public static void solveSecondTask() throws SQLException {
        String request = "SELECT name, MIN(age) " +
                "FROM Forbes " +
                "WHERE country == 'France' " +
                "    and networth > 10;";
        System.out.printf(
                "Второе задание%nСамый молодой миллиардер из Франции, капитал которого превышает 10 млрд - %s.\n%n",
                SQLite.statement.executeQuery(request).getString("name"));
    }

    public static void solveThirdTask() throws SQLException {
        String firstRequest = "SELECT name, MAX(networth) " +
                "FROM Forbes " +
                "WHERE country == 'United States' " +
                "    and industry == 'Energy';";
        String secondRequest = "SELECT source, MAX(networth) " +
                "FROM Forbes " +
                "WHERE country == 'United States' " +
                "    and industry == 'Energy';";
        System.out.printf(
                "Третье задание%n%s из компании %s - бизнесмен из США, имеющий самый большой капитал в сфере Energy.",
                forbes.SQLite.statement.executeQuery(firstRequest).getString("name"),
                forbes.SQLite.statement.executeQuery(secondRequest).getString("source")
        );
    }
}