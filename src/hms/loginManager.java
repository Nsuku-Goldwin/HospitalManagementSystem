package hms;

import hms.logic.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import objcts.Logs;

public class LoginManager {
    private boolean bool = false;
    private String jobTitle = "";
    private Connection connection;
    //This method is called to verify login details and create the proper object to open the homepage of the application
    public LoginManager(String employeeID, String enteredPassword){
                   
        try{
            connection = new DatabaseConnection().getConnetion();
            String sql = "SELECT employee_id, password, job_title FROM employees WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,employeeID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String password = rs.getString("password");
                if(password.equals(enteredPassword)){
                    String description = "User succesfully logged in to the system";
                    new Logs().addToLogs(employeeID, description, "Succesful");
                    bool = true;
                    jobTitle = rs.getString("job_title");
                }
                else{
                    String description = "User tried to login but failed due to incorect password";
                    new Logs().addToLogs(employeeID, description, "Unsuccesful");
                    JOptionPane.showMessageDialog(null, "Incorect Login Details");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "You do not have access to this system");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }

    public boolean isTrue() {
        return bool;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    
}
