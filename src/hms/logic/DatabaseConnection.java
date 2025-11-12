package hms.logic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
    private Connection connection;
    public DatabaseConnection(){
        
    }
    public Connection getConnetion(){
        try {
            this.connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagementSystem", "Nsuku", "Nsuku");
            
        } catch (SQLException ex) {
            System.getLogger(DatabaseConnection.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return connection;
    }
}
