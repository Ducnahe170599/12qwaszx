package com.example.dao;

import com.example.db.DBContext;
import static com.example.db.DBContext.getConnection;
import com.example.model.RegistrationsAdd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationsDBContext extends DBContext{
 
    private DBContext dbContext = new DBContext();
    
    
    public List<RegistrationsAdd> getAllRegistrations() {
        List<RegistrationsAdd> registrations = new ArrayList<>();
        Connection connection = null;
        try {
            // Lấy kết nối từ DBContext
            connection = DBContext.getConnection();
            if (connection != null) {
                String sql = "SELECT RegisterID, UserID, SubjectID, PackageID, total_cost, status, valid_from, valid_to, created_at FROM Registrations";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    RegistrationsAdd registration = new RegistrationsAdd(
                            resultSet.getInt("RegisterID"),
                            resultSet.getInt("UserID"),
                            resultSet.getInt("SubjectID"),
                            resultSet.getInt("PackageID"),
                            resultSet.getBigDecimal("total_cost"),
                            resultSet.getInt("status"),
                            resultSet.getDate("valid_from"),
                            resultSet.getDate("valid_to"),
                            resultSet.getTimestamp("created_at")
                    );
                    registrations.add(registration);
                }
            } else {
                System.out.println("Connection is null");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng kết nối sau khi sử dụng xong
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return registrations;
    }
    
    
//    public void addRegistration(int userID, int subjectID, int packageID, double totalCost, int status, String validFrom, String validTo, String createdAt) {
//        String query = "INSERT INTO registrations (UserID, SubjectID, PackageID, total_cost, status, valid_from, valid_to, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        
//        try (Connection conn = dbContext.getConnection();
//             PreparedStatement ps = conn.prepareStatement(query)) {
//            ps.setInt(1, userID);
//            ps.setInt(2, subjectID);
//            ps.setInt(3, packageID);
//            ps.setDouble(4, totalCost);
//            ps.setInt(5, status);
//            ps.setDate(6, java.sql.Date.valueOf(validFrom));
//            ps.setDate(7, java.sql.Date.valueOf(validTo));
//            ps.setTimestamp(8, java.sql.Timestamp.valueOf(createdAt));
//            
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        RegistrationsDBContext registrationsDBContext = new RegistrationsDBContext();
        List<RegistrationsAdd> registrations = registrationsDBContext.getAllRegistrations();
        for (RegistrationsAdd registration : registrations) {
            System.out.println(registration);
        }
   // Tạo một đối tượng RegistrationsDAO
//        RegistrationsDBContext dao = new RegistrationsDBContext();
//        
//        // Thêm một bản ghi mới vào bảng registrations
//        dao.addRegistration(1, 2, 4, 300.00, 2, "2024-05-25", "2024-05-31", "2024-05-25 12:32:11.000");
//        
//        // In ra thông báo khi thêm thành công
//        System.out.println("Added successfully!");
    }
}
