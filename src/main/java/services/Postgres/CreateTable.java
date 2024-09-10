package services.Postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public final static String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    public final static String jdbcName = "project";
    public final static String jdbcPass = "pass";
    public static Connection conn = null;
    public static Statement statement;

    public static void main(String[] args) throws SQLException {
        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcName, jdbcPass);
            statement = conn.createStatement();
            String createSt = "create table if not exists \"Users\"(\n" +
                    "id int generated always as identity,\n" +
                    "name varchar(20) not null,\n" +
                    "primary key (id)\n" +
                    ");\n" +
                    "create table if not exists \"Contacts\"(\n" +
                    "id int generated always as identity,\n" +
                    "\"ContactsId\" int,\n" +
                    "phone varchar(100) not null,\n" +
                    "email varchar(100),\n" +
                    "primary key(id),\n" +
                    "foreign key(\"ContactsId\")\n" +
                    "references \"Users\"(id)\n" +
                    ");";
            statement.execute(createSt);
            System.out.println("Table created successfully");
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());;
                }
            }
        }
    }
}
