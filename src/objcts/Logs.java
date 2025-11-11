package objcts;
import hms.logic.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Logs {
    private Connection connection;
    public Logs() {
        connection = new DatabaseConnection().getConnetion();
    }
    public void addToLogs(String employeeID, String description, String status){
        String url = "jdbc:derby://localhost:1527/HospitalManagementSystem", user = "Nsuku", password = "Nsuku";
        String sql = "INSERT INTO logs (employee_id, date, time, description, status) VALUES(?,?,?,?,?)";
        Date date = Date.valueOf(LocalDate.now());
        Time time = Time.valueOf(LocalTime.now());
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,employeeID);
            ps.setDate(2, date);
            ps.setTime(3, time);
            ps.setString(4, description);
            ps.setString(5, status);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
