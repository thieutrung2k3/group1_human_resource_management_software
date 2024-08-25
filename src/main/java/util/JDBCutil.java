package util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutil {

    public static Connection getConnection() {
        Connection c = null;
        try {
            // Đăng ký MySQL Driver với DriverManager
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // Các thông số
            String url = "jdbc:mySQL://localhost:3306/db_hr_management_fptshop";
            String username = "root";
<<<<<<< HEAD
            String password = "root";
=======
            String password = "";
>>>>>>> fe132b85f9b069f5bad73c2ec51caf371970f06b

            // Tạo kết nối
            c = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
