package forbes;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static forbes.SQLLite.statement;

public class Tasks {
    public static void firstTask() throws SQLException {
        Map<String, Float> countryCapital = new HashMap<>();
        ResultSet resultSet = statement.executeQuery( "" + "SELECT DISTINCT country, SUM(networth) AS capital " +
                "FROM Forbes " +
                "GROUP BY country;");
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
    public static void secondTask() throws SQLException {
        System.out.println(String.format(
                "Самый молодой миллиардер из Франции, капитал которого превышает 10 млрд - %s\n",
                statement.executeQuery("" +
                        "SELECT name, MIN(age) " +
                        "FROM Forbes " +
                        "WHERE country == 'France' " +
                        "    and networth > 10;").getString("name"))
        );
    }

    public static void thirdTask() throws SQLException {
        System.out.println(String.format(
                "%s из компании %s - бизнесмен из США, имеющий самый большой капитал в сфере Energy.\n",
                statement.executeQuery("" +
                        "SELECT name, MAX(networth) " +
                        "FROM Forbes " +
                        "WHERE country == 'United States' " +
                        "    and industry == 'Energy';").getString("name"),
                statement.executeQuery("" +
                        "SELECT source, MAX(networth) " +
                        "FROM Forbes " +
                        "WHERE country == 'United States' " +
                        "    and industry == 'Energy';").getString("source"))
        );
    }
}