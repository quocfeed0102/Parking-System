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
public class DSNhanVienModify {
    
    public static List<DSNhanVien> layDSNhanVien() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static void insertTblNHANVIEN(DSNhanVien DSNV){
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
            String sql = "insert into NHANVIEN(MANV, HOTEN, CMND, GIOITINH, IDVAITRO, DIACHI, SDT) values(?,?,?,?,?,?,?)";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, DSNV.getMANV());
            statement.setString(2, DSNV.getHOTEN());
            statement.setString(3, DSNV.getCMND());
            statement.setString(4, DSNV.getGIOITINH());
            //---------------------------------------
            if("Quản lý".equals(DSNV.getTENVAITRO())){
                statement.setInt(5, 0);
            }
            else{
                statement.setInt(5, 1);
            }
            //---------------------------------------
            statement.setString(6, DSNV.getDIACHI());
            statement.setString(7, DSNV.getSDT());

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
   
    public static void updateTblNHANVIEN(DSNhanVien DSNV){
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
            String sql = "update NHANVIEN set HOTEN = ?, CMND = ?, GIOITINH = ?, IDVAITRO = ?, DIACHI = ?, SDT = ? where MANV =? ";
            statement = conn.prepareCall(sql);
            
            statement.setString(7, DSNV.getMANV());
            statement.setString(1, DSNV.getHOTEN());
            statement.setString(2, DSNV.getCMND());
            statement.setString(3, DSNV.getGIOITINH());
            //---------------------------------------
            if("Quản lý".equals(DSNV.getTENVAITRO())){
                statement.setInt(4, 0);
            }
            else{
                statement.setInt(4, 1);
            }
            //---------------------------------------
            statement.setString(5, DSNV.getDIACHI());
            statement.setString(6, DSNV.getSDT());

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
    public static void deleteTblDSNhanVien(DSNhanVien DSNV){
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
            String sql = "delete from NHANVIEN where MANV =? ";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, DSNV.getMANV());

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
    
        public static List<DSNhanVien> layMANV() {
        
        List<DSNhanVien> MANVList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV from NHANVIEN";
            statement = conn.createStatement();
            
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"));
                MANVList.add(DSNV);
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
        return MANVList;
    }
        
    public static List<DSNhanVien> layTENVAITRO() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select TENVAITRO from VAITRO";
            statement = conn.createStatement();
            
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("TENVAITRO"));
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    
    public static List<DSNhanVien> layGIOITINH() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select GIOITINH from NHANVIEN";
            statement = conn.createStatement();
            
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("GIOITINH"));
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }   
        public static List<DSNhanVien> findByMANV(String MANV) {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO and MANV like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%"+MANV+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static List<DSNhanVien> sortDSNhanVienByMANV() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO order by MANV";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static List<DSNhanVien> sortDSNhanVienByMANVDesc() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO order by MANV DESC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static List<DSNhanVien> sortDSNhanVienByHOTEN() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO order by HOTEN";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static List<DSNhanVien> sortDSNhanVienByHOTENDesc() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO order by HOTEN DESC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static List<DSNhanVien> sortDSNhanVienByCMND() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO order by CMND";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static List<DSNhanVien> sortDSNhanVienByCMNDDesc() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO order by CMND DESC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static List<DSNhanVien> sortDSNhanVienByGIOITINH() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO order by GIOITINH";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static List<DSNhanVien> sortDSNhanVienByGIOITINHDesc() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO order by GIOITINH DESC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static List<DSNhanVien> sortDSNhanVienByTENVAITRO() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO order by TENVAITRO";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static List<DSNhanVien> sortDSNhanVienByTENVAITRODesc() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO order by TENVAITRO DESC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static List<DSNhanVien> sortDSNhanVienByDIACHI() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO order by DIACHI";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static List<DSNhanVien> sortDSNhanVienByDIACHIDesc() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO order by DIACHI DESC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static List<DSNhanVien> sortDSNhanVienBySDT() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO order by SDT";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    public static List<DSNhanVien> sortDSNhanVienBySDTDesc() {
        
        List<DSNhanVien> DSNhanVienList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT from NHANVIEN,VAITRO where NHANVIEN.IDVAITRO = VAITRO.IDVAITRO order by SDT DESC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSNhanVien DSNV = new DSNhanVien(resultSet.getString("MANV"),
                                             resultSet.getString("HOTEN"),
                                             resultSet.getString("CMND"),
                                             resultSet.getString("GIOITINH"),
                                             resultSet.getString("TENVAITRO"),
                                             resultSet.getString("DIACHI"),
                                             resultSet.getString("SDT")
                );
                DSNhanVienList.add(DSNV);
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
        return DSNhanVienList;
    }
    
}
