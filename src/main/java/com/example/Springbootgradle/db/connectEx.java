package com.example.Springbootgradle.db;

import java.sql.*;
import java.util.Map;

import static java.lang.System.getenv;

public class connectEx {
    public void add() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://ec2-3-35-79-129.ap-northeast-2.compute.amazonaws.com/spring-db",
                "root", "password");

        PreparedStatement pstmt = con.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
        pstmt.setString(1, "1");
        pstmt.setString(2, "kyeongrok");
        pstmt.setString(3, "12345678");
        pstmt.executeUpdate();
    }

    public void select() throws SQLException, ClassNotFoundException {
        Map<String, String> env = getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbHost, dbUser, dbPassword);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from users");
        rs = st.getResultSet();
        while (rs.next()) {
            String str = rs.getString(1);
            String str2 = rs.getString(2);
            String str3 = rs.getString(3);
            System.out.println(str + str2 + str3);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        connectEx ex = new connectEx();
      //  ex.add();
        ex.select();

    }
}
