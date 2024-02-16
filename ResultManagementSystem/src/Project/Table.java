package Project;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Table {
    public static void main(String args[]) {
        Connection con = null;
        Statement st = null;

        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();

            // Create the 'student' table
            String createTableQuery = "CREATE TABLE student (" +
  "student_name VARCHAR2(50)," +
  "regno VARCHAR2(20)," +
  "\"student_department\" NUMBER," +
  "student_session VARCHAR2(10)," +
  "cnic VARCHAR2(15)," +
  "email VARCHAR2(50)," +
  "student_password VARCHAR2(50)" +
")";


            st.executeUpdate(createTableQuery);

            JOptionPane.showMessageDialog(null, "Table 'student' created successfully");
        } catch (Exception e) {
            e.printStackTrace(); // print the exception details to diagnose the issue
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}
