/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author PC
 */
import java.sql.Connection;
import util.JDBCutil;

public class TestJDBCutil {

    public static void main(String[] args) {
        Connection connection = JDBCutil.getConnection();

        JDBCutil.printInfo(connection);

        JDBCutil.closeConnection(connection);
    }
}
