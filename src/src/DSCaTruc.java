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
public class DSCaTruc {
    String IDCATRUC;
    String NGAYTRUC,IDLOAICATRUC,MANV,IDNHIEMVU,TENCATRUC;

    public DSCaTruc() {
    }

    public DSCaTruc(String IDCATRUC, String NGAYTRUC, String IDLOAICATRUC, String MANV, String IDNHIEMVU, String TENCATRUC) {
        this.IDCATRUC = IDCATRUC;
        this.NGAYTRUC = NGAYTRUC;
        this.IDLOAICATRUC = IDLOAICATRUC;
        this.MANV = MANV;
        this.IDNHIEMVU = IDNHIEMVU;
        this.TENCATRUC = TENCATRUC;
    }

    public DSCaTruc(String IDCATRUC, String NGAYTRUC, String IDLOAICATRUC, String MANV, String IDNHIEMVU) {
        this.IDCATRUC = IDCATRUC;
        this.NGAYTRUC = NGAYTRUC;
        this.IDLOAICATRUC = IDLOAICATRUC;
        this.MANV = MANV;
        this.IDNHIEMVU = IDNHIEMVU;
    }

    public DSCaTruc(String NGAYTRUC, String IDLOAICATRUC, String MANV, String IDNHIEMVU) {
        this.NGAYTRUC = NGAYTRUC;
        this.IDLOAICATRUC = IDLOAICATRUC;
        this.MANV = MANV;
        this.IDNHIEMVU = IDNHIEMVU;
    }

    DSCaTruc(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DSCaTruc(String IDLOAICATRUC) {
        this.IDLOAICATRUC = IDLOAICATRUC;
    }

    public String getTENCATRUC() {
        return TENCATRUC;
    }

    public void setTENCATRUC(String TENCATRUC) {
        this.TENCATRUC = TENCATRUC;
    }
    
    

    public String getIDCATRUC() {
        return IDCATRUC;
    }

    public void setIDCATRUC(String IDCATRUC) {
        this.IDCATRUC = IDCATRUC;
    }

    public String getNGAYTRUC() {
        return NGAYTRUC;
    }

    public void setNGAYTRUC(String NGAYTRUC) {
        this.NGAYTRUC = NGAYTRUC;
    }

    public String getIDLOAICATRUC() {
        return IDLOAICATRUC;
    }

    public void setCATRUC(String IDLOAICATRUC) {
        this.IDLOAICATRUC = IDLOAICATRUC;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getIDNHIEMVU() {
        return IDNHIEMVU;
    }

    public void setIDNHIEMVU(String IDNHIEMVU) {
        this.IDNHIEMVU = IDNHIEMVU;
    }
    
    
            
}
