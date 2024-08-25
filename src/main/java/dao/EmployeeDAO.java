/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import util.JDBCutil;

public class EmployeeDAO {
    private static EmployeeDAO instance;
    
    public static EmployeeDAO gI(){
        if(instance == null){
            instance = new EmployeeDAO();
        }
        return instance;
    }
    
    public HashMap<String, String> getEmployeeIdAndName(){
        HashMap<String, String> employees = new HashMap<>();
        String sql = "SELECT employee_id, full_name FROM EMPLOYEE ";
        try(Connection connection = JDBCutil.getConnection();
                PreparedStatement preparedStatement = connection.prepareCall(sql);
                ResultSet resultset = preparedStatement.executeQuery()){
            while(resultset.next()){
                employees.put(resultset.getString("employee_id"), resultset.getString("full_name"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
