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
public class DSTaiKhoan {
    String MANV,TENDANGNHAP, MATKHAU, hiddenMATKHAU,TRANGTHAI;

    public DSTaiKhoan() {
    }

    public DSTaiKhoan(String MANV, String TENDANGNHAP, String MATKHAU,String TRANGTHAI) {
        this.MANV = MANV;
        this.TENDANGNHAP = TENDANGNHAP;
        this.MATKHAU = MATKHAU;
        this.TRANGTHAI=TRANGTHAI;
    }

    public DSTaiKhoan(String TENDANGNHAP, String MATKHAU) {
        this.TENDANGNHAP = TENDANGNHAP;
        this.MATKHAU = MATKHAU;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(String TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public DSTaiKhoan(String MANV) {
        this.MANV = MANV;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getTENDANGNHAP() {
        return TENDANGNHAP;
    }

    public void setTENDANGNHAP(String TENDANGNHAP) {
        this.TENDANGNHAP = TENDANGNHAP;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public String getHiddenMATKHAU() {
        hiddenMATKHAU = "";
        for(int i = 0; i < getMATKHAU().length(); i++){
            hiddenMATKHAU = hiddenMATKHAU + "*";
        }
        
        return hiddenMATKHAU;
    }

    public void setHiddenMATKHAU(String hiddenMATKHAU) {
        this.hiddenMATKHAU = hiddenMATKHAU;
    }
    
    
    
}
