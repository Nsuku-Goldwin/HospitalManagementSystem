package hms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import objcts.Logs;

public class loginManager {
    private boolean bool = false;
    //This method is called to verify login details and create the proper object to open the homepage of the application
    public loginManager(String employeeID, String enteredPassword){
        
        String url = "jdbc:derby://localhost:1527/HospitalManagementSystem", user = "Nsuku", pass = "Nsuku";
//            System.out.println("Helo");
        try{
            Connection connection = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT employee_id, password FROM login_info WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,employeeID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String password = rs.getString("password");
                if(password.equals(enteredPassword)){
                    String description = "User succesfully logged in to the system";
                    new Logs().addToLogs(employeeID, description, "Succesful");
                    System.out.println("successful");
                    bool = true;
                    
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

    public boolean isBool() {
        return bool;
    }
    
}
