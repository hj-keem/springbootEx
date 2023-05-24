package com.example.Springbootgradle.db;
import java.sql.*;
import java.util.Map;

import static java.lang.System.getenv;

public class ConnectionChecker {
        public void check() throws SQLException, ClassNotFoundException {
            Map<String, String> env = getenv();
            String dbHost = env.get("DB_HOST");
            String dbUser = env.get("DB_USER");
            String dbPassword = env.get("DB_PASSWORD");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbHost, dbUser, dbPassword);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SHOW DATABASES");
            rs = st.getResultSet();
            while (rs.next()) {
                String str = rs.getString(1);
                System.out.println(str);
            }
        }

        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            ConnectionChecker cc = new ConnectionChecker();
            cc.check();
        }
    }
