package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static data_bases.persons.Person.createPersonList;

public class PostgreConnect {

   public final static String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
   public final static String jdbcName = "project";
  public final static String jdbcPass = "pass";
    public static Connection conn = null;

    public static void connect(){
        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcName, jdbcPass);
            createPersonList();
            System.out.println("Connection to Postgres established");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

    public static void main(String[] args) {
        connect();
    }
}
