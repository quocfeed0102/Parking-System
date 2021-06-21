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
 * CRUD (list, insert, update, delete)
 * @author LENOVO
 */

public class DSCaTrucModify {
    

    public static List<DSCaTruc> layDSCaTruc() {
        
        List<DSCaTruc> DSCaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select CATRUC.IDCATRUC,NGAYTRUC,IDLOAICATRUC,PHANCONG.MANV,IDNHIEMVU from CATRUC,PHANCONG where CATRUC.IDCATRUC = PHANCONG.IDCATRUC order by [NO.]";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("IDCATRUC"),
                                             resultSet.getString("NGAYTRUC"),
                                             resultSet.getString("IDLOAICATRUC"),
                                             resultSet.getString("MANV"),
                                             resultSet.getString("IDNHIEMVU"));
                DSCaTrucList.add(DSCT);
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
        return DSCaTrucList;
    }
    
    
    public static List<DSCaTruc> layTENCATRUC() {
        
         List<DSCaTruc> CaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select TENCATRUC from LOAICATRUC group by TENCATRUC";
            statement = conn.createStatement();
            
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("TENCATRUC"));
                CaTrucList.add(DSCT);
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
        return CaTrucList;
    }
    
    public static List<DSCaTruc> layIDNHIEMVU() {
        
         List<DSCaTruc> CaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select IDNHIEMVU from PHANCONG group by IDNHIEMVU";
            statement = conn.createStatement();
            
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("IDNHIEMVU"));
                CaTrucList.add(DSCT);
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
        return CaTrucList;
    }  
    public static List<DSCaTruc> layTENNHIEMVU() {
        
         List<DSCaTruc> CaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select TENNHIEMVU from NHIEMVU group by TENNHIEMVU";
            statement = conn.createStatement();
            
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("TENNHIEMVU"));
                CaTrucList.add(DSCT);
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
        return CaTrucList;
    }
    
        
    public static String findIDCATRUC(String NGAYTRUC, String IDLOAICATRUC) {
                
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        PreparedStatement statement = null;
        
        
        String IDCATRUC = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select CATRUC.IDCATRUC from CATRUC where NGAYTRUC = ? and IDLOAICATRUC = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, NGAYTRUC);
            statement.setString(2, IDLOAICATRUC);
            
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                IDCATRUC = resultSet.getString("IDCATRUC");           
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
        return IDCATRUC;
    }
    
    public static void insertTblCATRUC(DSCaTruc DSCT){
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
            String sql = "insert into CATRUC(NGAYTRUC,IDLOAICATRUC,IDCATRUC) values(?,?,'')";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, DSCT.getNGAYTRUC());
            statement.setString(2, DSCT.getIDLOAICATRUC());

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
    
    
     public static void insertTblPHANCONG(DSCaTruc DSCT){
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
            String sql = "insert into PHANCONG(IDCATRUC,MANV,IDNHIEMVU) values(?,?,?)";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, DSCT.getIDCATRUC());
            statement.setString(2, DSCT.getMANV());
            statement.setString(3, DSCT.getIDNHIEMVU());

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
     
    public static void updateTblCATRUC(DSCaTruc DSCT){
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
            //?????????????????????????????????????????????????
            String sql = "update CATRUC set NGAYTRUC = ?, IDLOAICATRUC = ? where IDCATRUC = ?";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, DSCT.getNGAYTRUC());
            statement.setString(2, DSCT.getIDLOAICATRUC());
            statement.setString(3, DSCT.getIDCATRUC());
            
            
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
    
        public static void updateTblPHANCONG(DSCaTruc DSCT){
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
                //?????????????????????????????????????????????????
                String sql = "update PHANCONG set IDNHIEMVU = ? where IDCATRUC = ? and MANV = ?";
                statement = conn.prepareCall(sql);

                statement.setString(1, DSCT.getIDNHIEMVU());
                statement.setString(2, DSCT.getIDCATRUC());
                statement.setString(3, DSCT.getMANV());


                statement.execute();

            } 
            catch (ClassNotFoundException | SQLException e) {
                System.out.println("not success!");
                e.printStackTrace();
            } 
            finally {
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
    
    public static void deleteTblPHANCONG(DSCaTruc DSCT){
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
            //??????????????????????????/
            String sql = "delete from PHANCONG where IDCATRUC = ? and MANV = ?";
            statement = conn.prepareCall(sql);
 
            statement.setString(1, DSCT.getIDCATRUC());
            statement.setString(2, DSCT.getMANV());
            

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
    
    public static void deleteTblPHANCONGByMANV(DSCaTruc DSCT){
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
            //??????????????????????????/
            String sql = "delete from PHANCONG where MANV = ?";
            statement = conn.prepareCall(sql);
 
            statement.setString(1, DSCT.getMANV());
            

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
    
    public static void deleteTblCATRUC (DSCaTruc DSCT){
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
            //??????????????????????????/
            String sql = "delete from CATRUC where IDCATRUC = ?";
            statement = conn.prepareCall(sql);
 
            statement.setString(1, DSCT.getIDCATRUC());
            

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
    public static List<DSCaTruc> findByMANV(String MANV) {
        
        List<DSCaTruc> DSCaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select CATRUC.IDCATRUC,NGAYTRUC,IDLOAICATRUC,PHANCONG.MANV,IDNHIEMVU from CATRUC,PHANCONG where CATRUC.IDCATRUC = PHANCONG.IDCATRUC and PHANCONG.MANV like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%"+MANV+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("IDCATRUC"),
                                             resultSet.getString("NGAYTRUC"),
                                             resultSet.getString("IDLOAICATRUC"),
                                             resultSet.getString("MANV"),
                                             resultSet.getString("IDNHIEMVU"));
                DSCaTrucList.add(DSCT);
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
        return DSCaTrucList;
    }
    public static List<DSCaTruc> findByIDCATRUC(String IDCATRUC) {
        
        List<DSCaTruc> DSCaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select CATRUC.IDCATRUC,NGAYTRUC,IDLOAICATRUC,PHANCONG.MANV,IDNHIEMVU from CATRUC,PHANCONG where CATRUC.IDCATRUC = PHANCONG.IDCATRUC and CATRUC.IDCATRUC = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, IDCATRUC);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("IDCATRUC"),
                                             resultSet.getString("NGAYTRUC"),
                                             resultSet.getString("IDLOAICATRUC"),
                                             resultSet.getString("MANV"),
                                             resultSet.getString("IDNHIEMVU"));
                DSCaTrucList.add(DSCT);
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
        return DSCaTrucList;
    }
    
        public static List<DSCaTruc> sortDSCaTrucByIDCATRUC() {
        
        List<DSCaTruc> DSCaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select CATRUC.IDCATRUC,NGAYTRUC,IDLOAICATRUC,PHANCONG.MANV,IDNHIEMVU from CATRUC,PHANCONG where CATRUC.IDCATRUC = PHANCONG.IDCATRUC order by CATRUC.[NO.]";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("IDCATRUC"),
                                             resultSet.getString("NGAYTRUC"),
                                             resultSet.getString("IDLOAICATRUC"),
                                             resultSet.getString("MANV"),
                                             resultSet.getString("IDNHIEMVU"));
                DSCaTrucList.add(DSCT);
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
        return DSCaTrucList;
    }
        
    public static List<DSCaTruc> sortDSCaTrucByNGAYTRUC() {
        
        List<DSCaTruc> DSCaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select CATRUC.IDCATRUC,NGAYTRUC,IDLOAICATRUC,PHANCONG.MANV,IDNHIEMVU from CATRUC,PHANCONG where CATRUC.IDCATRUC = PHANCONG.IDCATRUC order by NGAYTRUC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("IDCATRUC"),
                                             resultSet.getString("NGAYTRUC"),
                                             resultSet.getString("IDLOAICATRUC"),
                                             resultSet.getString("MANV"),
                                             resultSet.getString("IDNHIEMVU"));
                DSCaTrucList.add(DSCT);
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
        return DSCaTrucList;
    }
    
    public static List<DSCaTruc> sortDSCaTrucByCATRUC() {
        
        List<DSCaTruc> DSCaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select CATRUC.IDCATRUC,NGAYTRUC,IDLOAICATRUC,PHANCONG.MANV,IDNHIEMVU from CATRUC,PHANCONG where CATRUC.IDCATRUC = PHANCONG.IDCATRUC order by IDLOAICATRUC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("IDCATRUC"),
                                             resultSet.getString("NGAYTRUC"),
                                             resultSet.getString("IDLOAICATRUC"),
                                             resultSet.getString("MANV"),
                                             resultSet.getString("IDNHIEMVU"));
                DSCaTrucList.add(DSCT);
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
        return DSCaTrucList;
    }
    
    public static List<DSCaTruc> sortDSCaTrucByMANV() {
        
        List<DSCaTruc> DSCaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select CATRUC.IDCATRUC,NGAYTRUC,IDLOAICATRUC,PHANCONG.MANV,IDNHIEMVU from CATRUC,PHANCONG where CATRUC.IDCATRUC = PHANCONG.IDCATRUC order by MANV";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("IDCATRUC"),
                                             resultSet.getString("NGAYTRUC"),
                                             resultSet.getString("IDLOAICATRUC"),
                                             resultSet.getString("MANV"),
                                             resultSet.getString("IDNHIEMVU"));
                DSCaTrucList.add(DSCT);
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
        return DSCaTrucList;
    }
    
    public static List<DSCaTruc> sortDSCaTrucByIDNHIEMVU() {
        
        List<DSCaTruc> DSCaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select CATRUC.IDCATRUC,NGAYTRUC,IDLOAICATRUC,PHANCONG.MANV,IDNHIEMVU from CATRUC,PHANCONG where CATRUC.IDCATRUC = PHANCONG.IDCATRUC order by IDNHIEMVU";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("IDCATRUC"),
                                             resultSet.getString("NGAYTRUC"),
                                             resultSet.getString("IDLOAICATRUC"),
                                             resultSet.getString("MANV"),
                                             resultSet.getString("IDNHIEMVU"));
                DSCaTrucList.add(DSCT);
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
        return DSCaTrucList;
    }
    
            public static List<DSCaTruc> sortDSCaTrucByIDCATRUCDesc() {
        
        List<DSCaTruc> DSCaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select CATRUC.IDCATRUC,NGAYTRUC,IDLOAICATRUC,PHANCONG.MANV,IDNHIEMVU from CATRUC,PHANCONG where CATRUC.IDCATRUC = PHANCONG.IDCATRUC order by CATRUC.[NO.] DESC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("IDCATRUC"),
                                             resultSet.getString("NGAYTRUC"),
                                             resultSet.getString("IDLOAICATRUC"),
                                             resultSet.getString("MANV"),
                                             resultSet.getString("IDNHIEMVU"));
                DSCaTrucList.add(DSCT);
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
        return DSCaTrucList;
    }
        
    public static List<DSCaTruc> sortDSCaTrucByNGAYTRUCDesc() {
        
        List<DSCaTruc> DSCaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select CATRUC.IDCATRUC,NGAYTRUC,IDLOAICATRUC,PHANCONG.MANV,IDNHIEMVU from CATRUC,PHANCONG where CATRUC.IDCATRUC = PHANCONG.IDCATRUC order by NGAYTRUC DESC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("IDCATRUC"),
                                             resultSet.getString("NGAYTRUC"),
                                             resultSet.getString("IDLOAICATRUC"),
                                             resultSet.getString("MANV"),
                                             resultSet.getString("IDNHIEMVU"));
                DSCaTrucList.add(DSCT);
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
        return DSCaTrucList;
    }
    
    public static List<DSCaTruc> sortDSCaTrucByCATRUCDesc() {
        
        List<DSCaTruc> DSCaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select CATRUC.IDCATRUC,NGAYTRUC,IDLOAICATRUC,PHANCONG.MANV,IDNHIEMVU from CATRUC,PHANCONG where CATRUC.IDCATRUC = PHANCONG.IDCATRUC order by IDLOAICATRUC DESC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("IDCATRUC"),
                                             resultSet.getString("NGAYTRUC"),
                                             resultSet.getString("IDLOAICATRUC"),
                                             resultSet.getString("MANV"),
                                             resultSet.getString("IDNHIEMVU"));
                DSCaTrucList.add(DSCT);
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
        return DSCaTrucList;
    }
    
    public static List<DSCaTruc> sortDSCaTrucByMANVDesc() {
        
        List<DSCaTruc> DSCaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select CATRUC.IDCATRUC,NGAYTRUC,IDLOAICATRUC,PHANCONG.MANV,IDNHIEMVU from CATRUC,PHANCONG where CATRUC.IDCATRUC = PHANCONG.IDCATRUC order by MANV DESC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("IDCATRUC"),
                                             resultSet.getString("NGAYTRUC"),
                                             resultSet.getString("IDLOAICATRUC"),
                                             resultSet.getString("MANV"),
                                             resultSet.getString("IDNHIEMVU"));
                DSCaTrucList.add(DSCT);
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
        return DSCaTrucList;
    }
    
    public static List<DSCaTruc> sortDSCaTrucByIDNHIEMVUDesc() {
        
        List<DSCaTruc> DSCaTrucList = new ArrayList<>();
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        Statement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select CATRUC.IDCATRUC,NGAYTRUC,IDLOAICATRUC,PHANCONG.MANV,IDNHIEMVU from CATRUC,PHANCONG where CATRUC.IDCATRUC = PHANCONG.IDCATRUC order by IDNHIEMVU DESC";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next())    {
                DSCaTruc DSCT = new DSCaTruc(resultSet.getString("IDCATRUC"),
                                             resultSet.getString("NGAYTRUC"),
                                             resultSet.getString("IDLOAICATRUC"),
                                             resultSet.getString("MANV"),
                                             resultSet.getString("IDNHIEMVU"));
                DSCaTrucList.add(DSCT);
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
        return DSCaTrucList;
    }
    public static void updateIDCATRUC(){
            Connection conn = null;
            String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
            String user = "sa";
            String pass = "123";
            PreparedStatement statement = null;
        
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(url, user, pass);

                //query
                String sql = "update CATRUC set IDCATRUC = 'CT'+ convert(nvarchar(50),CATRUC.[NO.])";
                statement = conn.prepareCall(sql);


                statement.execute();

            } 
            catch (ClassNotFoundException | SQLException e) {
                System.out.println("update IDCATRUC not success!");
                e.printStackTrace();
            } 
            finally {
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
    public static String layTENCATRUCByIDLOAICATRUC(String IDLOAICATRUC) {
                
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        PreparedStatement statement = null;
        
        
        String TENCATRUC = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select TENCATRUC from LOAICATRUC where IDLOAICATRUC = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, IDLOAICATRUC);
            
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                TENCATRUC = resultSet.getString("TENCATRUC");           
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
        return TENCATRUC;
    }
    public static String layIDLOAICATRUCByTENCATRUC(String TENCATRUC) {
                
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        PreparedStatement statement = null;
        
        
        String IDLOAICATRUC = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select IDLOAICATRUC from LOAICATRUC where TENCATRUC = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, TENCATRUC);
            
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                IDLOAICATRUC = resultSet.getString("IDLOAICATRUC");           
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
        return IDLOAICATRUC;
    }
    public static boolean checkInputCaTruc(DSCaTruc DSCT) {
        
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select IDNHIEMVU from CATRUC,PHANCONG where CATRUC.IDCATRUC = PHANCONG.IDCATRUC and NGAYTRUC = ? and IDLOAICATRUC = ? and MANV = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, DSCT.getNGAYTRUC());
            statement.setString(2, DSCT.getIDLOAICATRUC());
            statement.setString(3, DSCT.getMANV());
            
            ResultSet resultSet = statement.executeQuery();
            int count = 0;
            
            
            if(resultSet.next()){
                count++;          
            }
            
            return count == 0;
 
            
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
        return false;
        //ket thuc.
    }
    public static String layTENNHIEMVUByIDNHIEMVU(String IDNHIEMVU) {
                
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=QuanLyNhaXeHVCS";
        String user = "sa";
        String pass = "123";
        
        PreparedStatement statement = null;
        
        
        String TENNHIEMVU = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            
            //query
            String sql = "select TENNHIEMVU from NHIEMVU where IDNHIEMVU = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, IDNHIEMVU);
            
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                TENNHIEMVU = resultSet.getString("TENNHIEMVU");           
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
        return TENNHIEMVU;
    }
}
