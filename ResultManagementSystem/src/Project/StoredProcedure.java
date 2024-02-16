/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PMYLS
 */
public class StoredProcedure {
    public static ResultSet runProcedure(String reg_no){
        Connection con=null;
        Statement st=null;
        try{
            con=ConnectionProvider.getCon();
            st=con.createStatement();
          CallableStatement callableStatement = con.prepareCall("{CALL GetEmployeeByDepartment(?)}");
          callableStatement.setInt(1, 3);
          ResultSet resultSet = callableStatement.executeQuery();
          return resultSet;

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
       return null;
    }
    
    public static void main(String[]args) throws  Exception{
       
      
    }
}
