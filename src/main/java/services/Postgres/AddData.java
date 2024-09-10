package services.Postgres;

import data_bases.persons.Person;

import java.sql.*;

public class AddData {
    static final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    static final String jdbcName = "project";
    static final String jdbcPass = "pass";
    static Connection conn = null;

    public static void main(String[] args) throws SQLException {

        conn = DriverManager.getConnection(jdbcUrl, jdbcName, jdbcPass);
Person.createPersonList();

        for (int i = 0; i< Person.listP.size(); i++) {
            String sqlUsers = "INSERT INTO \"Users\" (name) values ('"
                    + Person.listP.get(i).name + "');";
            PreparedStatement psUsers = conn.prepareStatement(sqlUsers);
           psUsers.execute();

            String sqlContacts = "Insert into \"Contacts\" (\"ContactsId\", \"phone\", \"email\") values \n" +
                    "("+Person.listP.get(i).id+",'" + Person.listP.get(i).phone + "','" + Person.listP.get(i).email + "');";
            PreparedStatement psContacts = conn.prepareStatement(sqlContacts);
           psContacts.execute();
        }
        System.out.println("Data was added successfully");
    }
}
