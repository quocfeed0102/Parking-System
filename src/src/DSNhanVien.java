/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author LENOVO
 */
public class DSNhanVien {
    String MANV, HOTEN, CMND, GIOITINH, TENVAITRO, DIACHI, SDT;

    public DSNhanVien() {
    }

    public DSNhanVien(String MANV, String HOTEN, String CMND, String GIOITINH, String TENVAITRO, String DIACHI, String SDT) {
        this.MANV = MANV;
        this.HOTEN = HOTEN;
        this.CMND = CMND;
        this.GIOITINH = GIOITINH;
        this.TENVAITRO = TENVAITRO;
        this.DIACHI = DIACHI;
        this.SDT = SDT;
    }

    public DSNhanVien(String HOTEN, String CMND, String GIOITINH, String TENVAITRO, String DIACHI, String SDT) {
        this.HOTEN = HOTEN;
        this.CMND = CMND;
        this.GIOITINH = GIOITINH;
        this.TENVAITRO = TENVAITRO;
        this.DIACHI = DIACHI;
        this.SDT = SDT;
    }

    public DSNhanVien(String MANV) {
        this.MANV = MANV;
    }
    
    

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public void setHOTEN(String HOTEN) {
        this.HOTEN = HOTEN;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getTENVAITRO() {
        return TENVAITRO;
    }

    public void setTENVAITRO(String TENVAITRO) {
        this.TENVAITRO = TENVAITRO;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    
    
}
