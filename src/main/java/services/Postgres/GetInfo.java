package services.Postgres;

import data_bases.persons.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetInfo{
    public final static String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    public final static String jdbcName = "project";
    public final static String jdbcPass = "pass";
    public static Connection conn = null;
    public static Statement statement;
    static Map<String, Object> data;
static List<Map> dataList= new ArrayList<>();

    public static List<Map> getInfo() throws SQLException {
    conn = DriverManager.getConnection(jdbcUrl, jdbcName, jdbcPass);
    statement = conn.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Users\" u left join \"Contacts\" c on c.\"ContactsId\" = u.id;");

   while (resultSet.next()) {
      String name = resultSet.getString("name");
      String phone = resultSet.getString("phone");
      String email = resultSet.getString("email");
        data = new HashMap<>();
data.put("name", name);
data.put("phone", phone);
data.put("email", email);
dataList.add(data);
        System.out.println(name+" "+ phone+" "+ email);
  }
    return dataList;
}

    public static void main(String[] args) throws SQLException {
        getInfo();
    }

}
