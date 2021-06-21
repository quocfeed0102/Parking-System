/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class DSTaiKhoanModify {
    
    public static List<DSTaiKhoan> layDSTaiKhoan() {
        
        List<DSTaiKhoan> DSTaiKhoanList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select * from TAIKHOAN";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSTaiKhoan DSTK = new DSTaiKhoan( resultSet.getString("MANV"),
                                             resultSet.getString("TENDANGNHAP"),
                                             resultSet.getString("MATKHAU"),
                                             resultSet.getString("TRANGTHAI")
                                             );
                DSTaiKhoanList.add(DSTK);
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("not success!");
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return DSTaiKhoanList;
    }
    public static void insertTblTAIKHOAN(DSTaiKhoan DSTK){
         Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        PreparedStatement statement = null;
        
        try {
            //lay tat ca
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            //???????????????????????????????????????????????
            String sql = "insert into TAIKHOAN(MANV, TENDANGNHAP, MATKHAU,TRANGTHAI) values(?,?,?,'True')";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, DSTK.getMANV());
            statement.setString(2, DSTK.getTENDANGNHAP());
            statement.setString(3, DSTK.getMATKHAU());
            
            statement.execute();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("not success!");
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void updateTblTAIKHOAN(DSTaiKhoan DSTK){
         Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        PreparedStatement statement = null;
        
        try {
            //lay tat ca
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            //???????????????????????????????????????????????
            String sql = "update TAIKHOAN set MATKHAU = ? where MANV = ?";
            statement = conn.prepareCall(sql);
            
    
            statement.setString(1, DSTK.getMATKHAU());
            statement.setString(2, DSTK.getMANV());

            statement.execute();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("not success!");
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void deleteTblTAIKHOAN(DSTaiKhoan DSTK){
         Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        PreparedStatement statement = null;
        
        try {
            //lay tat ca
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            //???????????????????????????????????????????????
            String sql = "delete from TAIKHOAN where MANV = ?";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, DSTK.getMANV());

            statement.execute();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("not success!");
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<DSTaiKhoan> findByMANV(String MANV) {
        
        List<DSTaiKhoan> DSTaiKhoanList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, TENDANGNHAP, MATKHAU, TRANGTHAI from TAIKHOAN where MANV like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%"+MANV+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next())    {
                DSTaiKhoan DSTK = new DSTaiKhoan( resultSet.getString("MANV"),
                                             resultSet.getString("TENDANGNHAP"),
                                             resultSet.getString("MATKHAU"),
                                             resultSet.getString("TRANGTHAI")
                                             );
                
                DSTaiKhoanList.add(DSTK);
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("not success!");
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return DSTaiKhoanList;
    }
    public static List<DSTaiKhoan> sortDSTaiKhoanByMANV() {
        
        List<DSTaiKhoan> DSTaiKhoanList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, TENDANGNHAP, MATKHAU, TRANGTHAI from TAIKHOAN order by MANV";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSTaiKhoan DSTK = new DSTaiKhoan( resultSet.getString("MANV"),
                                             resultSet.getString("TENDANGNHAP"),
                                             resultSet.getString("MATKHAU"),
                                             resultSet.getString("TRANGTHAI")
                                             );
                DSTaiKhoanList.add(DSTK);
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("not success!");
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return DSTaiKhoanList;
    }
    public static List<DSTaiKhoan> sortDSTaiKhoanByTENDANGNHAP() {
        
        List<DSTaiKhoan> DSTaiKhoanList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, TENDANGNHAP, MATKHAU, TRANGTHAI from TAIKHOAN order by TENDANGNHAP";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSTaiKhoan DSTK = new DSTaiKhoan( resultSet.getString("MANV"),
                                             resultSet.getString("TENDANGNHAP"),
                                             resultSet.getString("MATKHAU"),
                                             resultSet.getString("TRANGTHAI")
                                             );
                DSTaiKhoanList.add(DSTK);
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("not success!");
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return DSTaiKhoanList;
    }
   public static List<DSTaiKhoan> sortDSTaiKhoanByMANVDesc() {
        
        List<DSTaiKhoan> DSTaiKhoanList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, TENDANGNHAP, MATKHAU, TRANGTHAI from TAIKHOAN order by MANV DESC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSTaiKhoan DSTK = new DSTaiKhoan( resultSet.getString("MANV"),
                                             resultSet.getString("TENDANGNHAP"),
                                             resultSet.getString("MATKHAU"),
                                             resultSet.getString("TRANGTHAI")
                                             );
                DSTaiKhoanList.add(DSTK);
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("not success!");
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return DSTaiKhoanList;
    }
    public static List<DSTaiKhoan> sortDSTaiKhoanByTENDANGNHAPDesc() {
        
        List<DSTaiKhoan> DSTaiKhoanList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, TENDANGNHAP, MATKHAU, TRANGTHAI from TAIKHOAN order by TENDANGNHAP DESC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSTaiKhoan DSTK = new DSTaiKhoan( resultSet.getString("MANV"),
                                             resultSet.getString("TENDANGNHAP"),
                                             resultSet.getString("MATKHAU"),
                                             resultSet.getString("TRANGTHAI")
                                             );
                DSTaiKhoanList.add(DSTK);
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("not success!");
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DSCaTrucModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return DSTaiKhoanList;
    }
}
