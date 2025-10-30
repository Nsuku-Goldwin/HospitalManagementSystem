package hms.logic.admin;

import java.sql.*;
import java.util.*;

public class AdminLogic {
    private Connection connection;

    public AdminLogic() {
        try {
            String url = "jdbc:derby://localhost:1527/HospitalManagementSystem";
            String user = "Nsuku";
            String password = "Nsuku";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Call this method when AdministratorGui is initiated
    public Object[][] viewAllLogs() {
        List<Object[]> logsList = new ArrayList<>();

        String sql = """
            SELECT e.employee_id, e.name, e.surname, 
            l.date, l.time, l.description, l.status
            FROM logs l
            JOIN employees e ON l.employee_id = e.employee_id
            ORDER BY l.date DESC, l.time DESC
            """;

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                logsList.add(new Object[]{
                    rs.getString("employee_id"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getDate("date"),
                    rs.getTime("time"),
                    rs.getString("description"),
                    rs.getString("status")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Convert List<Object[]> → Object[][]
        return logsList.toArray(new Object[0][]);
    }
}
