package services.Postgres;

import connections.PostgreConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAllData extends PostgreConnect {
    static final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    static final String jdbcName = "project";
    static final String jdbcPass = "pass";
    static Connection conn = null;

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcName, jdbcPass);
            deleteAllData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    static void deleteAllData() throws SQLException {
        String delCont = "truncate \"Contacts\"";
        PreparedStatement delC  = conn.prepareStatement(delCont);
        delC.execute();
        String delUser = "truncate \"Users\" cascade";
        PreparedStatement delU  = conn.prepareStatement(delUser);
        delU.execute();
    }
}
