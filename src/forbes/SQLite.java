package forbes;

import java.sql.*;

public class SQLite {
    private static Connection connection;
    protected static Statement statement;
    public SQLite(String path) throws SQLException {
        connection = DriverManager.getConnection(path);
        statement = connection.createStatement();
    }

    public static void createAndFillTable(CSVParser parser, SQLite sqlite) throws SQLException{
        String request = """
                CREATE TABLE IF NOT EXISTS Forbes (
                rank INTEGER,
                name TEXT,
                networth INTEGER,
                age INTEGER,
                country TEXT,
                source TEXT,
                industry TEXT);
                """;
        statement.execute(request);
        parser.forbesList.forEach(sqlite::addLine);
    }

    public void addLine(Forbes forbes){
        String request = "INSERT INTO Forbes (rank, name, networth, age, country, source, industry) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            statement.setObject(1, forbes.rank());
            statement.setObject(2, forbes.name().substring(0, forbes.name().length() - 1));
            statement.setObject(3, forbes.networth());
            statement.setObject(4, forbes.age());
            statement.setObject(5, forbes.country());
            statement.setObject(6, forbes.source());
            statement.setObject(7, forbes.industry().substring(0, forbes.industry().length() - 1));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
