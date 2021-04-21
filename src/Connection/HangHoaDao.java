/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;



import java.util.ArrayList;
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADMIN
 */
public class HangHoaDao {
    public List<HangHoa> getAllHang(){
    List<HangHoa> hanghoas = new ArrayList<HangHoa>();
    Connection connection = JDBCConnection.JDBCConnection();
    
    String sql = "SELECT * FROM HANG";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                HangHoa hangHoa= new HangHoa();
                hangHoa.setMaHang(rs.getString("MAHANG"));
                hangHoa.setTenHang(rs.getString("TENHANG"));
                hangHoa.setNamSX(rs.getString("NAMSX"));
                hangHoa.setDonGia(rs.getString("DONGIA"));              
                hangHoa.setSoLuong(rs.getString("SOLUONG"));
                hanghoas.add(hangHoa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hanghoas;
}
    
    public HangHoa getHangByMa(String mahang){
        
        Connection connection = JDBCConnection.JDBCConnection();
        String sql = "SELECT * FROM HANG WHERE MAHANG = ?";
        
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, mahang);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                HangHoa hanghoa=new HangHoa();
                hanghoa.setMaHang(rs.getString("MAHANG"));
                hanghoa.setTenHang(rs.getString("TENHANG"));
                hanghoa.setNamSX(rs.getString("NAMSX"));
                hanghoa.setDonGia(rs.getString("DONGIA"));
                hanghoa.setSoLuong(rs.getString("SOLUONG"));
                
                return hanghoa;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void addHang(HangHoa hanghoa){
        Connection connection=JDBCConnection.JDBCConnection();
        String sql="INSERT INTO HANG(MAHANG, TENHANG, NAMSX, DONGIA, SOLUONG ) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, hanghoa.getMaHang());
            preparedStatement.setString(2, hanghoa.getTenHang());
            preparedStatement.setString(3, hanghoa.getNamSX());
            preparedStatement.setString(4, hanghoa.getDonGia());
            preparedStatement.setString(5, hanghoa.getSoLuong());
            
            
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateHang(HangHoa hanghoa){
        Connection connection = JDBCConnection.JDBCConnection();
        String sql= "UPDATE HANG SET TENHANG=?,NAMSX=?,DONGIA=?,SOLUONG=? WHERE MAHANG= ?";
               
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            
           
            preparedStatement.setString(1, hanghoa.getTenHang());
            preparedStatement.setString(2, hanghoa.getNamSX());
            preparedStatement.setString(3, hanghoa.getDonGia());
            preparedStatement.setString(4, hanghoa.getSoLuong());
            preparedStatement.setString(5, hanghoa.getMaHang());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void deleteHang(String mahang){
        Connection connection = JDBCConnection.JDBCConnection();
        String sql= "delete from HANG where mahang = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mahang);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
