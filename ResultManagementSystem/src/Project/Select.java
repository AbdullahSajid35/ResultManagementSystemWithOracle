package Project;
import java.sql.*;
import javax.swing.JOptionPane;
public class Select {
    public static ResultSet getData(String query){
        Connection con=null;
        Statement st=null;
        try{
            con=ConnectionProvider.getCon();
            st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            return rs;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
       
    }
    
    public static void main(String[]args) throws  Exception{
        ResultSet rs=getData("SELECT * FROM Ali");
        rs.first();
      
    }
}