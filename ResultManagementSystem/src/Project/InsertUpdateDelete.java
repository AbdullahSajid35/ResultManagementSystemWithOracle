package Project;
import static Project.Select.getData;
import javax.swing.JOptionPane;
import java.sql.*;
public class InsertUpdateDelete {
    public static void addData(String query,String Message){
        Connection con=null;
        Statement st=null;
        try{
            con=ConnectionProvider.getCon();
            st=con.createStatement();
            st.executeUpdate(query);
            if (!Message.equals("")){
                JOptionPane.showMessageDialog(null, Message);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void main(String[]args) throws  Exception{
        addData("INSERT INTO Ali VALUES('Syed Ali Taqi','21-SE-59')","Record added!");
        
    }
}
