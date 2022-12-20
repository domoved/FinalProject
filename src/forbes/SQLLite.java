package forbes;

import java.sql.*;

public class SQLLite {
    private static Connection connection;
    protected static Statement statement;
    public SQLLite(String path) throws SQLException{
        connection = DriverManager.getConnection(path);
        statement = connection.createStatement();
    }

    public static void addTable() throws SQLException{
        statement.execute("""
                CREATE TABLE IF NOT EXISTS Forbes  (
                rank INTEGER,
                name TEXT,
                networth INTEGER,
                age INTEGER,
                country TEXT,
                source TEXT,
                industry TEXT);
                """);
    }
    public void addString(Forbes forbes){
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Forbes (rank, name, networth, age, country, source, industry) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?)")) {
            statement.setObject(1, forbes.getRank());
            statement.setObject(2, forbes.getName().substring(0, forbes.getName().length() - 1));
            statement.setObject(3, forbes.getNetworth());
            statement.setObject(4, forbes.getAge());
            statement.setObject(5, forbes.getCountry());
            statement.setObject(6, forbes.getSource());
            statement.setObject(7, forbes.getIndustry().substring(0, forbes.getIndustry().length() - 1));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
