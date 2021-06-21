/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//last
package src;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Thread.sleep;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author 84378
 */
public class view extends javax.swing.JFrame {

    //-------- 16/05/2021--------
    //--------- Có thêm phí sau 17h--------------
    //AN-1   
    DefaultTableModel tableModel; //DSCaTruc table Model
    DefaultTableModel tableModel2; //DSNhanVien table Model
    DefaultTableModel tableModel3; //DSTaiKhoan table Model
    List<DSCaTruc> DSCaTrucList = DSCaTrucModify.layDSCaTruc();
    List<DSNhanVien> DSNhanVienList = DSNhanVienModify.layDSNhanVien();
    List<DSTaiKhoan> DSTaiKhoanList = DSTaiKhoanModify.layDSTaiKhoan();
    int selectedRow = -1;
    int selectedHeader = -1;
    //----
    int ToggleIDCATRUCSort1 = 0; // 0 = Descent, 1 = Ascent
    int ToggleNGAYTRUCSort1 = 0;
    int ToggleCATRUCSort1 = 0;
    int ToggleMANVSort1 = 0;
    int ToggleIDNHIEMVUSort1 = 0;
    //-----
    int ToggleMANVSort2 = 0;
    int ToggleHOTENSort1 = 0;
    int ToggleCMNDSort1 = 0;
    int ToggleGIOITINHSort1 = 0;
    int ToggleTENVAITROSort1 = 0;
    int ToggleDIACHISort1 = 0;
    int ToggleSDTSort1 = 0;
    //-----
    int ToggleMANVSort3 = 0;
    int ToggleTENDANGNHAPSort = 0;

    /**
     * Creates new form view
     */
    public view() {
        //YEN
        initComponents();
        this.setLocationRelativeTo(null);//153,255,153  204,255,204
        this.getContentPane().setBackground(new Color(153, 255, 153));
        jDialog1.getContentPane().setBackground(Color.WHITE);
        jDialog2.getContentPane().setBackground(Color.WHITE);
        jDialog3.getContentPane().setBackground(Color.WHITE);
        jDialog4.getContentPane().setBackground(Color.WHITE);
        jDialog5.getContentPane().setBackground(Color.WHITE);
        jDialog6.getContentPane().setBackground(Color.WHITE);
        jDialog7.getContentPane().setBackground(Color.WHITE);
        jDialog8.getContentPane().setBackground(Color.WHITE);
        jDialog9.getContentPane().setBackground(Color.WHITE);
        this.setTitle("GIAO DIỆN LÀM VIỆC");
        Xe quanLiXe = new Xe();
        quanLiXe.clock();
        quanLiXe.loadMaThe();
        quanLiXe.loadLoaiXe();
        quanLiXe.loadHinhThucGui();
        quanLiXe.layDSXe();
        quanLiXe.capNhapTinhTrangDV();
        quanLiXe.kiemTraGiaHanThe();
        quanLiXe.layDSDKHinhThucGui();
        quanLiXe.layDSGuiXe();
        quanLiXe.sortDSXe();
        quanLiXe.sortDSDangKyHTG();
        quanLiXe.sortChiTietRaVao();
        quanLiXe.loadBangGia();
        jLabel_LoiBSX.setVisible(false);
        jLabel_LoiLoaiXe.setVisible(false);
        jLabel_LoiHTG.setVisible(false);
        jLabel_LoiThe.setVisible(false);
        jLabel_loiGiaTien1.setVisible(false);
        jLabel_loiGiaTien2.setVisible(false);
        jLabel_loiTienPhuPhi1.setVisible(false);
        jLabel_loiTienPhuPhi2.setVisible(false);
        jLabel_loiPhiMatThe1.setVisible(false);
        jLabel_loiPhiMatThe2.setVisible(false);

        //QUOC
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        the quanLiThe = new the();

        String req = quanLiThe.layIDVAITROLogin().trim();
        quanLiThe.phanQuyen(req);
        quanLiThe.loadTableThe();
        quanLiThe.countIDThe();
        quanLiThe.layTenLogin();
        quanLiThe.layVaiTroLogin();
        quanLiThe.sortDSThe();
        quanLiThe.layDSTK();
        quanLiThe.sortDSTK();
        jLabel14.setText(quanLiThe.layVaiTroLogin());
        jlbXeTrongBen.setText(String.valueOf(quanLiThe.xeTrongBen()));
        jLabel168.setText(String.valueOf(quanLiThe.xeDangDangKy()));
        jLabel169.setText(String.valueOf(quanLiThe.xeDangChoGiaHan()));
        //AN
        jLabel_loiMaNV.setVisible(false);
        jLabel_loiTenNV.setVisible(false);
        jLabel_loiCMND.setVisible(false);
        jLabel_loiSDT.setVisible(false);
        jLabel_loiTenTK.setVisible(false);
        jLabel_loiMK.setVisible(false);
        jLabel_loiNgayTruc.setVisible(false);
        jLabel_loiNVu.setVisible(false);

        tableModel = (DefaultTableModel) jTable_DSCaTruc.getModel();
        tableModel2 = (DefaultTableModel) jTable_DSNV.getModel();
        tableModel3 = (DefaultTableModel) jTable_DSTK.getModel();
        showDSCaTruc();
        showDSNhanVien();
        showDSTaiKhoan();

        DocumentListener TENNVDocListnr = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                String a = jTenNV.getText();
                a = a.trim();
                int row = chooseIndexByMANV(jTable_DSNV.getModel(), a, 1);

                if (row >= 0) {
                    jTable_DSNV.setRowSelectionInterval(row, row);
                    selectedRow = jTable_DSNV.getSelectedRow();

                    if (selectedRow >= 0) {
                        DSNhanVien DSNV = DSNhanVienList.get(selectedRow);
                        jMaNV.setText(DSNV.getMANV());
                        jCMND.setText(DSNV.getCMND());
                        jComboBox_GioiTinh.setSelectedItem(DSNV.getGIOITINH());
                        jComboBox_VaiTro.setSelectedItem(DSNV.getTENVAITRO());
                        jDiaChi.setText(DSNV.getDIACHI());
                        jSDT.setText(DSNV.getSDT());
                    }
                } else {
                    jMaNV.setText("");
                    jCMND.setText("");
                    jDiaChi.setText("");
                    jSDT.setText("");
                    resetCombobox();
                    jTable_DSNV.getSelectionModel().clearSelection();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                String a = jTenNV.getText();
                a = a.trim();
                int row = chooseIndexByMANV(jTable_DSNV.getModel(), a, 2);

                if (row >= 0) {
                    jTable_DSNV.setRowSelectionInterval(row, row);
                    selectedRow = jTable_DSNV.getSelectedRow();

                    if (selectedRow >= 0) {
                        DSNhanVien DSNV = DSNhanVienList.get(selectedRow);
                        jMaNV.setText(DSNV.getMANV());
                        jCMND.setText(DSNV.getCMND());
                        jComboBox_GioiTinh.setSelectedItem(DSNV.getGIOITINH());
                        jComboBox_VaiTro.setSelectedItem(DSNV.getTENVAITRO());
                        jDiaChi.setText(DSNV.getDIACHI());
                        jSDT.setText(DSNV.getSDT());
                    }
                } else {
                    jMaNV.setText("");
                    jCMND.setText("");
                    jDiaChi.setText("");
                    jSDT.setText("");
                    resetCombobox();
                    jTable_DSNV.getSelectionModel().clearSelection();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }

        };

        jTenNV.getDocument().addDocumentListener(TENNVDocListnr);

        jTable_DSCaTruc.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                selectedRow = jTable_DSCaTruc.getSelectedRow();
                if (selectedRow >= 0) {
                    DSCaTruc DSCT = DSCaTrucList.get(selectedRow);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

                    try {
                        jFormattedTextField_NgayTruc.setSelectedDate(dateConverterRev2(DSCT.getNGAYTRUC()));
                    } catch (ParseException ex) {
                        Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jComboBox6.setSelectedItem(DSCT.getMANV());
                    jComboBox_CaTruc.setSelectedItem(DSCaTrucModify.layTENCATRUCByIDLOAICATRUC(DSCT.getIDLOAICATRUC()));
                    jComboBox_NhiemVu.setSelectedItem(DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU()));
                }

            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
        //DSCaTruc table column's header selection
        jTable_DSCaTruc.getTableHeader().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                selectedHeader = jTable_DSCaTruc.columnAtPoint(me.getPoint());

                switch (selectedHeader) {
                    case 0:
                        if (ToggleIDCATRUCSort1 == 0) {
                            DSCaTrucList = DSCaTrucModify.sortDSCaTrucByIDCATRUC();
                            tableModel.setRowCount(0);

                            DSCaTrucList.forEach((DSCT) -> {
                                tableModel.addRow(new Object[]{DSCT.getIDCATRUC(), dateConverter(DSCT.getNGAYTRUC()), DSCT.getIDLOAICATRUC(), DSCT.getMANV(), DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU())});
                            });
                            ToggleIDCATRUCSort1 = 1;
                        } else {
                            DSCaTrucList = DSCaTrucModify.sortDSCaTrucByIDCATRUCDesc();
                            tableModel.setRowCount(0);

                            DSCaTrucList.forEach((DSCT) -> {
                                tableModel.addRow(new Object[]{DSCT.getIDCATRUC(), dateConverter(DSCT.getNGAYTRUC()), DSCT.getIDLOAICATRUC(), DSCT.getMANV(), DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU())});
                            });

                            ToggleIDCATRUCSort1 = 0;
                        }
                        break;
                    case 1:
                        if (ToggleNGAYTRUCSort1 == 0) {
                            DSCaTrucList = DSCaTrucModify.sortDSCaTrucByNGAYTRUC();
                            tableModel.setRowCount(0);

                            DSCaTrucList.forEach((DSCT) -> {
                                tableModel.addRow(new Object[]{DSCT.getIDCATRUC(), dateConverter(DSCT.getNGAYTRUC()), DSCaTrucModify.layTENCATRUCByIDLOAICATRUC(DSCT.getIDLOAICATRUC()), DSCT.getMANV(), DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU())});
                            });
                            ToggleNGAYTRUCSort1 = 1;
                        } else {
                            DSCaTrucList = DSCaTrucModify.sortDSCaTrucByNGAYTRUCDesc();
                            tableModel.setRowCount(0);

                            DSCaTrucList.forEach((DSCT) -> {
                                tableModel.addRow(new Object[]{DSCT.getIDCATRUC(), dateConverter(DSCT.getNGAYTRUC()), DSCaTrucModify.layTENCATRUCByIDLOAICATRUC(DSCT.getIDLOAICATRUC()), DSCT.getMANV(), DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU())});
                            });
                            ToggleNGAYTRUCSort1 = 0;
                        }
                        break;
                    case 2:
                        if (ToggleCATRUCSort1 == 0) {
                            DSCaTrucList = DSCaTrucModify.sortDSCaTrucByCATRUC();
                            tableModel.setRowCount(0);

                            DSCaTrucList.forEach((DSCT) -> {
                                tableModel.addRow(new Object[]{DSCT.getIDCATRUC(), dateConverter(DSCT.getNGAYTRUC()), DSCaTrucModify.layTENCATRUCByIDLOAICATRUC(DSCT.getIDLOAICATRUC()), DSCT.getMANV(), DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU())});
                            });
                            ToggleCATRUCSort1 = 1;
                        } else {
                            DSCaTrucList = DSCaTrucModify.sortDSCaTrucByCATRUCDesc();
                            tableModel.setRowCount(0);

                            DSCaTrucList.forEach((DSCT) -> {
                                tableModel.addRow(new Object[]{DSCT.getIDCATRUC(), dateConverter(DSCT.getNGAYTRUC()), DSCaTrucModify.layTENCATRUCByIDLOAICATRUC(DSCT.getIDLOAICATRUC()), DSCT.getMANV(), DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU())});
                            });
                            ToggleCATRUCSort1 = 0;
                        }
                        break;
                    case 3:
                        if (ToggleMANVSort1 == 0) {
                            DSCaTrucList = DSCaTrucModify.sortDSCaTrucByMANV();
                            tableModel.setRowCount(0);

                            DSCaTrucList.forEach((DSCT) -> {
                                tableModel.addRow(new Object[]{DSCT.getIDCATRUC(), dateConverter(DSCT.getNGAYTRUC()), DSCaTrucModify.layTENCATRUCByIDLOAICATRUC(DSCT.getIDLOAICATRUC()), DSCT.getMANV(), DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU())});
                            });
                            ToggleMANVSort1 = 1;
                        } else {
                            DSCaTrucList = DSCaTrucModify.sortDSCaTrucByMANVDesc();
                            tableModel.setRowCount(0);

                            DSCaTrucList.forEach((DSCT) -> {
                                tableModel.addRow(new Object[]{DSCT.getIDCATRUC(), dateConverter(DSCT.getNGAYTRUC()), DSCaTrucModify.layTENCATRUCByIDLOAICATRUC(DSCT.getIDLOAICATRUC()), DSCT.getMANV(), DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU())});
                            });
                            ToggleMANVSort1 = 0;
                        }
                        break;
                    case 4:
                        if (ToggleIDNHIEMVUSort1 == 0) {
                            DSCaTrucList = DSCaTrucModify.sortDSCaTrucByIDNHIEMVU();
                            tableModel.setRowCount(0);

                            DSCaTrucList.forEach((DSCT) -> {
                                tableModel.addRow(new Object[]{DSCT.getIDCATRUC(), dateConverter(DSCT.getNGAYTRUC()), DSCaTrucModify.layTENCATRUCByIDLOAICATRUC(DSCT.getIDLOAICATRUC()), DSCT.getMANV(), DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU())});
                            });
                            ToggleIDNHIEMVUSort1 = 1;
                        } else {
                            DSCaTrucList = DSCaTrucModify.sortDSCaTrucByIDNHIEMVUDesc();
                            tableModel.setRowCount(0);

                            DSCaTrucList.forEach((DSCT) -> {
                                tableModel.addRow(new Object[]{DSCT.getIDCATRUC(), dateConverter(DSCT.getNGAYTRUC()), DSCaTrucModify.layTENCATRUCByIDLOAICATRUC(DSCT.getIDLOAICATRUC()), DSCT.getMANV(), DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU())});
                            });
                            ToggleIDNHIEMVUSort1 = 0;
                        }
                        break;

                    default:
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });

        //DSNhanVien table's row selection
        jTable_DSNV.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                selectedRow = jTable_DSNV.getSelectedRow();
                if (selectedRow >= 0) {
                    DSNhanVien DSNV = DSNhanVienList.get(selectedRow);

                    jMaNV.setText(DSNV.getMANV());
                    jTenNV.setText(DSNV.getHOTEN());
                    jCMND.setText(DSNV.getCMND());
                    jComboBox_GioiTinh.setSelectedItem(DSNV.getGIOITINH());
                    jComboBox_VaiTro.setSelectedItem(DSNV.getTENVAITRO());
                    jDiaChi.setText(DSNV.getDIACHI());
                    jSDT.setText(DSNV.getSDT());

                }

            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });

        jTable_DSNV.getTableHeader().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                selectedHeader = jTable_DSCaTruc.columnAtPoint(me.getPoint());

                switch (selectedHeader) {
                    case 0:
                        if (ToggleMANVSort2 == 0) {
                            DSNhanVienList = DSNhanVienModify.sortDSNhanVienByMANV();
                            tableModel2.setRowCount(0);

                            DSNhanVienList.forEach((dsnhanvien) -> {
                                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
                            });
                            ToggleMANVSort2 = 1;
                        } else {
                            DSNhanVienList = DSNhanVienModify.sortDSNhanVienByMANVDesc();
                            tableModel2.setRowCount(0);

                            DSNhanVienList.forEach((dsnhanvien) -> {
                                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
                            });
                            ToggleMANVSort2 = 0;

                        }

                        break;
                    case 1:
                        if (ToggleHOTENSort1 == 0) {
                            DSNhanVienList = DSNhanVienModify.sortDSNhanVienByHOTEN();
                            tableModel2.setRowCount(0);

                            DSNhanVienList.forEach((dsnhanvien) -> {
                                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
                            });
                            ToggleHOTENSort1 = 1;
                        } else {
                            DSNhanVienList = DSNhanVienModify.sortDSNhanVienByHOTENDesc();
                            tableModel2.setRowCount(0);

                            DSNhanVienList.forEach((dsnhanvien) -> {
                                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
                            });
                            ToggleHOTENSort1 = 0;

                        }

                        break;
                    case 2:
                        if (ToggleCMNDSort1 == 0) {
                            DSNhanVienList = DSNhanVienModify.sortDSNhanVienByCMND();
                            tableModel2.setRowCount(0);

                            DSNhanVienList.forEach((dsnhanvien) -> {
                                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
                            });
                            ToggleCMNDSort1 = 1;
                        } else {
                            DSNhanVienList = DSNhanVienModify.sortDSNhanVienByCMNDDesc();
                            tableModel2.setRowCount(0);

                            DSNhanVienList.forEach((dsnhanvien) -> {
                                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
                            });
                            ToggleCMNDSort1 = 0;

                        }

                        break;
                    case 3:
                        if (ToggleGIOITINHSort1 == 0) {
                            DSNhanVienList = DSNhanVienModify.sortDSNhanVienByGIOITINH();
                            tableModel2.setRowCount(0);

                            DSNhanVienList.forEach((dsnhanvien) -> {
                                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
                            });
                            ToggleGIOITINHSort1 = 1;
                        } else {
                            DSNhanVienList = DSNhanVienModify.sortDSNhanVienByGIOITINHDesc();
                            tableModel2.setRowCount(0);

                            DSNhanVienList.forEach((dsnhanvien) -> {
                                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
                            });
                            ToggleGIOITINHSort1 = 0;

                        }

                        break;
                    case 4:
                        if (ToggleTENVAITROSort1 == 0) {
                            DSNhanVienList = DSNhanVienModify.sortDSNhanVienByTENVAITRO();
                            tableModel2.setRowCount(0);

                            DSNhanVienList.forEach((dsnhanvien) -> {
                                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
                            });
                            ToggleTENVAITROSort1 = 1;
                        } else {
                            DSNhanVienList = DSNhanVienModify.sortDSNhanVienByTENVAITRODesc();
                            tableModel2.setRowCount(0);

                            DSNhanVienList.forEach((dsnhanvien) -> {
                                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
                            });
                            ToggleTENVAITROSort1 = 0;

                        }

                        break;
                    case 5:
                        if (ToggleDIACHISort1 == 0) {
                            DSNhanVienList = DSNhanVienModify.sortDSNhanVienByDIACHI();
                            tableModel2.setRowCount(0);

                            DSNhanVienList.forEach((dsnhanvien) -> {
                                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
                            });
                            ToggleDIACHISort1 = 1;
                        } else {
                            DSNhanVienList = DSNhanVienModify.sortDSNhanVienByDIACHIDesc();
                            tableModel2.setRowCount(0);

                            DSNhanVienList.forEach((dsnhanvien) -> {
                                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
                            });
                            ToggleDIACHISort1 = 0;

                        }

                        break;
                    case 6:
                        if (ToggleSDTSort1 == 0) {
                            DSNhanVienList = DSNhanVienModify.sortDSNhanVienBySDT();
                            tableModel2.setRowCount(0);

                            DSNhanVienList.forEach((dsnhanvien) -> {
                                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
                            });
                            ToggleSDTSort1 = 1;
                        } else {
                            DSNhanVienList = DSNhanVienModify.sortDSNhanVienBySDTDesc();
                            tableModel2.setRowCount(0);

                            DSNhanVienList.forEach((dsnhanvien) -> {
                                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
                            });
                            ToggleSDTSort1 = 0;

                        }

                        break;

                    default:
                        break;
                }

            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });

        jTable_DSTK.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                selectedRow = jTable_DSTK.getSelectedRow();
                if (selectedRow >= 0) {
                    DSTaiKhoan DSTK = DSTaiKhoanList.get(selectedRow);
                    jComboBox_MaNV1.setSelectedItem(DSTK.getMANV());
                    jTenTK.setText(DSTK.getTENDANGNHAP());
                    jMatKhau.setText(DSTK.getMATKHAU());
                }

            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
        jTable_DSTK.getTableHeader().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                selectedHeader = jTable_DSCaTruc.columnAtPoint(me.getPoint());

                switch (selectedHeader) {
                    case 0:
                        if (ToggleMANVSort3 == 0) {
                            DSTaiKhoanList = DSTaiKhoanModify.sortDSTaiKhoanByMANV();
                            tableModel3.setRowCount(0);

                            DSTaiKhoanList.forEach((dstaikhoan) -> {
                                tableModel3.addRow(new Object[]{dstaikhoan.getMANV(), dstaikhoan.getTENDANGNHAP(), dstaikhoan.getHiddenMATKHAU()});
                            });
                            ToggleMANVSort3 = 1;
                        } else {
                            DSTaiKhoanList = DSTaiKhoanModify.sortDSTaiKhoanByMANVDesc();
                            tableModel3.setRowCount(0);

                            DSTaiKhoanList.forEach((dstaikhoan) -> {
                                tableModel3.addRow(new Object[]{dstaikhoan.getMANV(), dstaikhoan.getTENDANGNHAP(), dstaikhoan.getHiddenMATKHAU()});
                            });
                            ToggleMANVSort3 = 0;

                        }

                        break;
                    case 1:
                        if (ToggleTENDANGNHAPSort == 0) {
                            DSTaiKhoanList = DSTaiKhoanModify.sortDSTaiKhoanByTENDANGNHAP();
                            tableModel3.setRowCount(0);

                            DSTaiKhoanList.forEach((dstaikhoan) -> {
                                tableModel3.addRow(new Object[]{dstaikhoan.getMANV(), dstaikhoan.getTENDANGNHAP(), dstaikhoan.getHiddenMATKHAU()});
                            });
                            ToggleTENDANGNHAPSort = 1;
                        } else {
                            DSTaiKhoanList = DSTaiKhoanModify.sortDSTaiKhoanByTENDANGNHAPDesc();
                            tableModel3.setRowCount(0);

                            DSTaiKhoanList.forEach((dstaikhoan) -> {
                                tableModel3.addRow(new Object[]{dstaikhoan.getMANV(), dstaikhoan.getTENDANGNHAP(), dstaikhoan.getHiddenMATKHAU()});
                            });
                            ToggleTENDANGNHAPSort = 0;

                        }

                        break;
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
    }

    private String chuanHoa(String t) {
        t = t.trim();
        t = t.replaceAll("\\s+", " ");
        String ht[] = t.split(" ");
        t = "";
        for (String x : ht) {
            t = t + (x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase());
            t = t + " ";
        }
        t = t.trim();
        return t;
    }

    private boolean kiemTraPhone(String sdt) {
        String x = "0[0-9]{9,10}";
        if (!sdt.matches(x)) {
            return false;   //không hợp lệ
        }
        return true; // hợp lệ
    }

    private boolean kiemTraCMND(String CMND) {
        String x = "[0-9]{9}";
        if (!CMND.matches(x)) {
            return false;   //không hợp lệ
        }
        return true;  // hợp lệ
    }

    private boolean kiemTraMaNhanVien(String maNV) {
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "select MANV from NHANVIEN where MANV='" + maNV + "'";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Loi kiemTraMaNV");
        }
        return false;
    }

    private boolean kiemTraCMNDTonTai(String CMND) {
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "select CMND from NHANVIEN where CMND='" + CMND + "'";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Loi kiemTraCMND");
        }
        return false;
    }

    private String kiemTraSDTTonTai2(String sdt) {
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "select MANV from NHANVIEN where SDT='" + sdt + "'";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Loi kiemTraSDT");
        }
        return "-1";
    }

    private String kiemTraCMNDTonTai2(String CMND) {
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "select MANV from NHANVIEN where CMND='" + CMND + "'";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Loi kiemTraCMND");
        }
        return "-1";
    }

    private boolean kiemTraSDTTonTai(String sdt) {
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "select SDT from NHANVIEN where SDT='" + sdt + "'";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Loi kiemTraSDT");
        }
        return false;
    }

    private boolean kiemTraMaNVTonTai(String maNV) {
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "select MANV from TAIKHOAN where TAIKHOAN.MANV='" + maNV + "'";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Loi kiemTraMaNVTonTai");
        }
        return false;
    }

    private boolean kiemTraTenTK(String tenTK) {
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "select TENDANGNHAP from TAIKHOAN where TAIKHOAN.TENDANGNHAP='" + tenTK + "'";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Loi kiemTraTenTK");
        }
        return false;
    }

    private boolean kiemTraIDCaTruc(String ngayTruc, String tenCaTruc) {
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "select IDCATRUC from CATRUC,LOAICATRUC where NGAYTRUC='" + ngayTruc + "' and CATRUC.IDLOAICATRUC = LOAICATRUC.IDLOAICATRUC and TENCATRUC='" + tenCaTruc + "'";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Loi kiemTraIDCaTruc");
        }
        return false;
    }

    private String maHoaMatKhau(String matKhau) {
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "SELECT CONVERT(VARCHAR(32), HashBytes('MD5', '" + matKhau + "'), 2) as md5";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi maHoaMatKhau");
        }
        return "-1";
    }

    private int timMaNhanVienLonNhat() {
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "select max(y.x) AS MAX from (select convert(int, substring(MANV,3, LEN(NHANVIEN.MANV)) ) as x from NHANVIEN) y";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("MAX");

            }
        } catch (SQLException e) {
            System.out.println("Lỗi timMaNhanVienLonNhat");
        }
        return -1;
    }

    //========================================================  
    public static DefaultComboBoxModel MANVComboBoxModel() {
        List<DSNhanVien> MANVList = DSNhanVienModify.layMANV();
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();

        MANVList.forEach((dsnv) -> {
            comboBoxModel.addElement(dsnv.getMANV());
        });
        return comboBoxModel;
    }

    public static DefaultComboBoxModel CATRUCComboBoxModel() {
        List<DSCaTruc> CaTrucList = DSCaTrucModify.layTENCATRUC();
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();

        CaTrucList.forEach((dsct) -> {
            comboBoxModel.addElement(dsct.IDLOAICATRUC);
        });
        return comboBoxModel;
    }

    public static DefaultComboBoxModel IDNHIEMVUComboBoxModel() {
        List<DSCaTruc> CaTrucList = DSCaTrucModify.layTENNHIEMVU();
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();

        CaTrucList.forEach((dsct) -> {
            comboBoxModel.addElement(dsct.IDLOAICATRUC);
        });
        return comboBoxModel;
    }

    //DSNhanVien get jcombo boxes models
    public static DefaultComboBoxModel VATROComboBoxModel() {
        List<DSNhanVien> DSNhanVienList = DSNhanVienModify.layTENVAITRO();
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();

        DSNhanVienList.forEach((dsnv) -> {
            comboBoxModel.addElement(dsnv.getMANV());
        });
        return comboBoxModel;
    }

    public static DefaultComboBoxModel GIOITINHComboBoxModel() {
        List<DSNhanVien> DSNhanVienList = DSNhanVienModify.layGIOITINH();
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();

        DSNhanVienList.forEach((dsnv) -> {
            comboBoxModel.addElement(dsnv.getMANV());
        });
        return comboBoxModel;
    }

    //DSCaTruc reset combobox afer insert and update
    private void resetCombobox() {
        jComboBox6.setModel(MANVComboBoxModel());
        jComboBox_CaTruc.setModel(CATRUCComboBoxModel());
        jComboBox_NhiemVu.setModel(IDNHIEMVUComboBoxModel());
        jComboBox_MaNV1.setModel(MANVComboBoxModel());

    }

    //-----------------------------
    private void showDSCaTruc() {
        DSCaTrucList = DSCaTrucModify.layDSCaTruc();
        tableModel.setRowCount(0);

        DSCaTrucList.forEach((DSCT) -> {
            tableModel.addRow(new Object[]{DSCT.getIDCATRUC(), dateConverter(DSCT.getNGAYTRUC()), DSCaTrucModify.layTENCATRUCByIDLOAICATRUC(DSCT.getIDLOAICATRUC()), DSCT.getMANV(), DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU())});
        });
    }

    private void showDSNhanVien() {
        DSNhanVienList = DSNhanVienModify.layDSNhanVien();
        tableModel2.setRowCount(0);

        DSNhanVienList.forEach((dsnhanvien) -> {
            tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
        });
    }

    private void showDSTaiKhoan() {
        DSTaiKhoanList = DSTaiKhoanModify.layDSTaiKhoan();
        tableModel3.setRowCount(0);

        DSTaiKhoanList.forEach((dstaikhoan) -> {
            tableModel3.addRow(new Object[]{dstaikhoan.getMANV(), dstaikhoan.getTENDANGNHAP(), dstaikhoan.getHiddenMATKHAU()});
        });

    }

    private String dateConverter(String Date) {
        LocalDate dateA = LocalDate.parse(Date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String SDateA = dateA.format(formatter);
        LocalDate parsedDate = LocalDate.parse(SDateA, formatter);
        String date = parsedDate.format(formatter);

        return date;
    }

    private String dateConverter2(String Date) {
        LocalDate dateA = LocalDate.parse(Date, DateTimeFormatter.ofPattern("M/d/yy"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String SDateA = dateA.format(formatter);
        LocalDate parsedDate = LocalDate.parse(SDateA, formatter);
        String date = parsedDate.format(formatter);

        return date;
    }

    private String dateConverterRev(String Date) {
        LocalDate dateA = LocalDate.parse(Date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String SDateA = dateA.format(formatter);
        LocalDate parsedDate = LocalDate.parse(SDateA, formatter);
        String date = parsedDate.format(formatter);

        return date;
    }

    private Calendar dateConverterRev2(String Date) throws ParseException {

        LocalDate dateA = LocalDate.parse(Date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
        String SDateA = dateA.format(formatter);

        Date date1 = new SimpleDateFormat("M/d/yy").parse(SDateA);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        return calendar;

    }

    //DSNhanVien choose index by manv
    private int chooseIndexByMANV(TableModel model, Object value, int column) {

        for (int i = model.getRowCount() - 1; i >= 0; --i) {
//                for (int j = model.getColumnCount() - 1; j >= 0; --j) {
            String ABC = (String) model.getValueAt(i, column);
            ABC = ABC.trim();
            if (ABC != null && ABC.equals(value)) { //(i,j)
                return i;
            }
        }
        //           }
        return -1;
    }

    //DSTAIKHOAN choose index by TENDANGNHAP
    private int chooseIndexByTENDANGNHAP(TableModel model, Object value) {

        for (int i = model.getRowCount() - 1; i >= 0; --i) {
//                for (int j = model.getColumnCount() - 1; j >= 0; --j) {
            String ABC = (String) model.getValueAt(i, 1);
            ABC = ABC.trim();
            if (ABC != null && ABC.equals(value)) { //(i,j)
                return i;
            }
        }
        //           }
        return -1;
    }

    private int chooseIndexByNGAYTRUC(TableModel model, Object NGAYTRUC, Object CATRUC, Object MANV) {

        for (int i = model.getRowCount() - 1; i >= 0; --i) {
            String NgayTruc = (String) model.getValueAt(i, 1);
            String CaTruc = (String) model.getValueAt(i, 2);
            String MaNV = (String) model.getValueAt(i, 3);
            NgayTruc = NgayTruc.trim();
            CaTruc = CaTruc.trim();
            MaNV = MaNV.trim();
            if (NgayTruc != null && CaTruc != null && MaNV != null && NgayTruc.equals(NGAYTRUC) && CaTruc.equals(CATRUC) && MaNV.equals(MANV)) {
                return i;
            }
        }
        return -1;
    }
    //AN-3

    public class Xe {

        DefaultTableModel dtm4, dtm6, dtm7, dtm8, dtm9;

        public void clock() {
            Thread clock = new Thread() {
                public void run() {
                    try {
                        while (true) {
                            Calendar cal = new GregorianCalendar();
                            int second = cal.get(Calendar.SECOND);
                            int minute = cal.get(Calendar.MINUTE);
                            int hour = cal.get(Calendar.HOUR_OF_DAY);
                            String thu;
                            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);//Con số kết quả nằm trong khoảng từ 1 (Chủ nhật) đến 7 (Thứ bảy)
                            if (dayOfWeek == 1) {
                                thu = "Chủ nhật";
                            } else {
                                thu = "Thứ " + Integer.toString(dayOfWeek);
                            }
                            int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
                            int month = (cal.get(Calendar.MONTH) + 1);  // sử dụng Calendar.MONTH vì tháng trong Java sẽ chạy từ 0 đến 11
                            int year = cal.get(Calendar.YEAR); //tức là nếu hiện giờ là tháng 7 thì chương trình sẽ hiển thị là tháng 6 
                            jLabel_time.setText(hour + ":" + minute + ":" + second);// vì vậy để hiển thị đúng thì ta sẽ cộng thêm tháng đó cho 1
                            jLabel_ngay.setText(thu + " ,Ngày " + dayOfMonth + " Tháng " + month + " Năm " + year);
                            sleep(1000);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            clock.start();
        }

        private void sortDSXe() {
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(dtm4);
            jTable_DSXDK.setRowSorter(sorter);
        }

        private void sortDSDangKyHTG() {
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(dtm6);
            jTable_DSDKHTG.setRowSorter(sorter);
        }

        private void sortChiTietRaVao() {
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(dtm7);
            jTable_CTRV.setRowSorter(sorter);
        }

        private void loadBangGia() {
            long gia1 = layGiaLoaiXe("XE MÁY");
            long gia2 = layGiaLoaiXe("OTO");
            long giaPhuPhi1 = layTienPhuPhi("XE MÁY");
            long giaPhuPhi2 = layTienPhuPhi("OTO");
            long phiMatThe1 = layPhiMatThe("XE MÁY");
            long phiMatThe2 = layPhiMatThe("OTO");
            jTextField_giaLoaiXe1.setText(gia1 + "");
            jTextField_giaLoaiXe2.setText(gia2 + "");
            jTextField_tienPhuPhi1.setText(giaPhuPhi1 + "");
            jTextField_tienPhuPhi2.setText(giaPhuPhi2 + "");
            jTextField_phiMatThe1.setText(phiMatThe1 + "");
            jTextField_phiMatThe2.setText(phiMatThe2 + "");
        }

        private void loadMaThe() {
            jComboBox_MaThe.removeAllItems();
            jComboBox_MaThe.addItem("");
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select IDTHE from THE where THE.TRANGTHAI= N'true'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    jComboBox_MaThe.addItem(rs.getString("IDTHE"));
                }
            } catch (SQLException e) {
                System.out.println("Lỗi loadMaThe");
            }
        }

        private void loadMaThe2() {
            jComboBox_MaThe.removeAllItems();
            jComboBox_MaThe.addItem("");
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select IDTHE from THE where THE.TRANGTHAI= N'true'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    jComboBox_maThe2.addItem(rs.getString("IDTHE"));
                }
            } catch (SQLException e) {
                System.out.println("Lỗi loadMaThe2");
            }
        }

        private void loadLoaiXe() {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select TENLOAIXE from LOAIXE";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    jComboBox_LoaiXe.addItem(rs.getString("TENLOAIXE"));
                }
            } catch (SQLException e) {
                System.out.println("Lỗi loadLoaiXe");
            }
        }

        private void loadHinhThucGui() {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select TENHINHTHUC from HINHTHUCGUI";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    jComboBox_HinhThucGui.addItem(rs.getString("TENHINHTHUC"));
                    jComboBox_TimKiemTheoHTG.addItem(rs.getString("TENHINHTHUC"));
                }
            } catch (SQLException e) {
                System.out.println("Lỗi loadHinhThucGui");
            }
        }

        private String layIDLoaiXe(String tenLoaiXe) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select IDLOAIXE from LOAIXE where LOAIXE.TENLOAIXE = N'" + tenLoaiXe + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("IDLOAIXE");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layIDLoaiXe");
            }
            return "-1";
        }

        private String layIDHinhThucGui(String tenHinhThuc) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select IDHINHTHUC from HINHTHUCGUI where HINHTHUCGUI.TENHINHTHUC =N'" + tenHinhThuc + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("IDHINHTHUC");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layIDHinhThucGui");
            }
            return "-1";
        }

        private String layIDTinhTrangHTG(String tenTinhTrang) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select IDTINHTRANG from TINHTRANG_HINHTHUCGUI where TINHTRANG_HINHTHUCGUI.TENTINHTRANG =N'" + tenTinhTrang + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("IDTINHTRANG");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layIDTinhTrang");
            }
            return "-1";
        }

        private long layGiaLoaiXe(String tenLoaiXe) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select GIATIEN from LOAIXE where LOAIXE.TENLOAIXE =N'" + tenLoaiXe + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("GIATIEN");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layGiaLoaiXe");
            }
            return -1;
        }

        private long layTienPhuPhi(String tenLoaiXe) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select TIENPHUPHI from LOAIXE where LOAIXE.TENLOAIXE =N'" + tenLoaiXe + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("TIENPHUPHI");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layTienPhuPhi");
            }
            return -1;
        }

        private long layPhiMatThe(String tenLoaiXe) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select PHIMATTHE from LOAIXE where LOAIXE.TENLOAIXE =N'" + tenLoaiXe + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("PHIMATTHE");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layPhiMatThe");
            }
            return -1;
        }

        private float layHeSoGui(String tenHinhThuc) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select HESOGUI from HINHTHUCGUI where HINHTHUCGUI.TENHINHTHUC =N'" + tenHinhThuc + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getFloat("HESOGUI");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layHeSoGui");
            }
            return -1;
        }

        private String layIDDangKy(String bienSoXe, String tenHinhThuc, String ngayDK) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select IDDANGKY from DANGKY_HINHTHUCGUI where BIENSOXE ='" + bienSoXe + "' and IDHINHTHUC ='" + layIDHinhThucGui(tenHinhThuc) + "' and NGAYDK = '" + ngayDK + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("IDDANGKY");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layIDDangKy");
            }
            return "-1";
        }

        private String layNgayDK(String bienSoXe, String ngayHienTai) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select MAX(NGAYDK) from DANGKY_HINHTHUCGUI where NGAYDK <= '" + ngayHienTai + "' "
                    + "and BIENSOXE ='" + bienSoXe + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString(1);
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layNgayDK");
            }
            return "-1";

        }

        private String layNgayKT(String bienSoXe, String tenHinhThuc, String ngayDK) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select NGAYKT from DANGKY_HINHTHUCGUI where BIENSOXE ='" + bienSoXe + "' and IDHINHTHUC ='" + layIDHinhThucGui(tenHinhThuc) + "' and NGAYDK= '" + ngayDK + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("NGAYKT");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layNgayKT");
            }
            return "-1";
        }

        private String layTenHinhThuc(String bienSoXe, String ngayDK) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select TENHINHTHUC from DANGKY_HINHTHUCGUI, HINHTHUCGUI where NGAYDK = '" + ngayDK + "' and DANGKY_HINHTHUCGUI.IDHINHTHUC = HINHTHUCGUI.IDHINHTHUC and BIENSOXE ='" + bienSoXe + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("TENHINHTHUC");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layTenHinhThuc");
            }
            return "-1";
        }

        private String layIDThe(String bienSoXe, String ngayDK) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select IDTHE from DANGKY_HINHTHUCGUI where NGAYDK = '" + ngayDK + "' and BIENSOXE ='" + bienSoXe + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("IDTHE");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layIDThe");
            }
            return "-1";
        }

        private String layTrangThaiThe(String idThe) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select TRANGTHAI from THE where IDTHE = '" + idThe + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("TRANGTHAI");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layTrangThaiThe");
            }
            return "-1";
        }

        private String layIDLoaiCaTruc(String gioHienTai) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            try {
                CallableStatement c = ketNoi.prepareCall("{call TIM_IDLOAICATRUC (?)}");
                c.setString(1, gioHienTai);
                ResultSet rs = c.executeQuery();
                if (rs.next()) {
                    return rs.getString(1);
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layIDLoaiCaTruc");
            }
            return "-1";
        }

        private String layIDCaTruc(String ngayTruc, String idLoaiCaTruc) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select IDCATRUC from CATRUC where NGAYTRUC= '" + ngayTruc + "' and IDLOAICATRUC = N'" + idLoaiCaTruc + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("IDCATRUC");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layIDCATRUC");
            }
            return "-1";
        }

        private String layTGVao(String idDangKy) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select TGVAO from GUIXE where IDDANGKY = '" + idDangKy + "' and TGRA is null";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("TGVAO");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layTGVao");
            }
            return "-1";
        }

        private String layTenTinhTrangDV(String bienSoXe, String ngayDK) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select TENTINHTRANG from DANGKY_HINHTHUCGUI,TINHTRANG_HINHTHUCGUI where DANGKY_HINHTHUCGUI.IDTINHTRANG = TINHTRANG_HINHTHUCGUI.IDTINHTRANG and BIENSOXE ='" + bienSoXe + "' and NGAYDK= '" + ngayDK + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("TENTINHTRANG");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi layTenTinhTrangDV");
            }
            return "-1";
        }

        private int timIDDangKyLonNhat() {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            try {
                CallableStatement c = ketNoi.prepareCall("{call TIM_IDDANGKY_MAX}");
                ResultSet rs = c.executeQuery();
                if (rs.next()) {
                    return rs.getInt("MAX");

                }
            } catch (SQLException e) {
                System.out.println("Lỗi timIDDangKyLonNhat");
            }
            return -1;
        }

        //     private String s
        private void trangThaiThe(String idThe, String trangThai) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "update THE set TRANGTHAI=? where THE.IDTHE =?";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, trangThai);
                ps.setString(2, idThe);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Lỗi trangThaiThe");
            }
        }

        private void luuXe(String bienSoXe, String tenXe, String mauXe, String tenLoaiXe) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "insert into XE values (?,?,?,?)";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, bienSoXe.trim());
                ps.setString(2, tenXe.trim().toUpperCase());
                ps.setString(3, mauXe.trim().toUpperCase());
                ps.setString(4, layIDLoaiXe(tenLoaiXe));

                ps.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Lỗi luuXe");
            }
        }

        private String luuNgayDK() {
            Date d = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.format(d);
        }

        private String luuNgayKT(String ngayDK) {
            Date d = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            // Định nghĩa mốc thời gian ban đầu là ngày 31-07-2011
            try {
                d = df.parse(ngayDK);
            } catch (Exception e) {
            }
            c1.setTime(d);
            c2.setTime(d);

            c2.add(Calendar.DATE, 30);
            return String.valueOf(df.format(c2.getTime()));
        }

        private String luuTime() {
            Date d = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.format(d);
        }

        private String chuyenDinhDang(String ngay) {
            Date d1 = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat df1 = new SimpleDateFormat("dd / MM / yyyy");
            try {
                d1 = df.parse(ngay);
                return df1.format(d1);
            } catch (Exception e) {

            }
            return null;
        }

        private String chuyenDinhDang2(String time) {
            Date d1 = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat df1 = new SimpleDateFormat("dd / MM / yyy HH:mm:ss");
            try {
                d1 = df.parse(time);
                return df1.format(d1);
            } catch (Exception e) {

            }
            return null;
        }

        private String chuyenDinhDang3(String time) {
            Date d1 = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                d1 = df.parse(time);
                return df1.format(d1);
            } catch (Exception e) {

            }
            return null;
        }

        private String chuyenDinhDang4(String time) {
            Date d1 = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat df1 = new SimpleDateFormat("HH:mm:ss");
            try {
                d1 = df.parse(time);
                return df1.format(d1);
            } catch (Exception e) {

            }
            return null;
        }

        private String chuyenDinhDang5(String time) {
            Date d1 = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat df1 = new SimpleDateFormat("HH");
            try {
                d1 = df.parse(time);
                return df1.format(d1);
            } catch (Exception e) {

            }
            return null;
        }

        private void luuDKHinhThucGui(String bienSoXe, String tenHinhThuc, String ngayDK, String ngayKT, long tienThu, String idThe, String tenTinhTrang) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "insert into DANGKY_HINHTHUCGUI values (?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, bienSoXe);
                ps.setString(2, layIDHinhThucGui(tenHinhThuc));
                ps.setString(3, ngayDK);
                ps.setString(4, ngayKT);
                ps.setString(5, "DK" + (timIDDangKyLonNhat() + 1));
                ps.setLong(6, tienThu);
                ps.setString(7, idThe);
                ps.setString(8, layIDTinhTrangHTG(tenTinhTrang));
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Lỗi DKHinhThucGui");
            }
        }

        private void capNhapHinhThucGui(String bienSoXe, String tenHinhThuc, String ngayDK, String ngayKT) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "update DANGKY_HINHTHUCGUI set NGAYKT=? where BIENSOXE =? and IDHINHTHUC=? and NGAYDK=?";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, ngayKT);
                ps.setString(2, bienSoXe);
                ps.setString(3, layIDHinhThucGui(tenHinhThuc));
                ps.setString(4, ngayDK);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Lỗi capNhapHinhThucGui");
            }
        }

        private void capNhapGiaLoaiXe(String tenLoaiXe, String giaTien, String tienPhuPhi, String phiMatThe) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "update LOAIXE set GIATIEN=?,TIENPHUPHI=?,PHIMATTHE=? where IDLOAIXE =?";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, giaTien);
                ps.setString(2, tienPhuPhi);
                ps.setString(3, phiMatThe);
                ps.setString(4, layIDLoaiXe(tenLoaiXe));

                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Lỗi capNhatGiaTienLoaiXe");
            }
        }

        private void capNhapGuiXe(String idDangKy, String tgVao, String tgRa, long tienThu, String idCaTruc) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "update GUIXE set TGRA=?,SOTIEN=?,IDCATRUC=? where TGVAO =? and IDDANGKY=?";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tgRa);
                ps.setLong(2, tienThu);
                ps.setString(3, idCaTruc);
                ps.setString(4, tgVao);
                ps.setString(5, idDangKy);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Lỗi capNhapGuiXe");
            }
        }

        private void capNhapTheMoi(String bienSoXe, String tenHinhThuc, String ngayDK, String idThe) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "update DANGKY_HINHTHUCGUI set IDTHE=? where BIENSOXE =? and IDHINHTHUC=? and NGAYDK=?";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, idThe);
                ps.setString(2, bienSoXe);
                ps.setString(3, layIDHinhThucGui(tenHinhThuc));
                ps.setString(4, ngayDK);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Lỗi capNhapTheMoi");
            }
        }

        private void capNhatTinhTrangHTG(String tenTinhTrangDV, String bienSoXe, String tenHinhThuc, String ngayDK) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "update DANGKY_HINHTHUCGUI set IDTINHTRANG=? where BIENSOXE =? and IDHINHTHUC=? and NGAYDK=?";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, layIDTinhTrangHTG(tenTinhTrangDV));
                ps.setString(2, bienSoXe);
                ps.setString(3, layIDHinhThucGui(tenHinhThuc));
                ps.setString(4, ngayDK);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Lỗi capNhapGuiXe");
            }
        }

        private void luuGuiXe(String idDangKy, String tgVao, String tgRa, long soTien, String idCaTruc) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "insert into GUIXE values (?,?,?,?,?)";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, idDangKy);
                ps.setString(2, tgVao);
                ps.setString(3, tgRa);
                ps.setLong(4, soTien);
                ps.setString(5, idCaTruc);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Lỗi luuGuiXe");
            }
        }

        private void luuChiTietMatThe(String idDangKy, String ngayMatThe, long tien) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "insert into CHITIET_MATTHE values (?,?,?)";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, idDangKy);
                ps.setString(2, ngayMatThe);
                ps.setLong(3, tien);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Lỗi luuChiTietMatThe");
            }
        }

        private void layDSXe() {
            dtm4 = (DefaultTableModel) jTable_DSXDK.getModel();
            dtm4.setNumRows(0);
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select BIENSOXE, TENXE, MAUXE, TENLOAIXE from XE, LOAIXE where XE.IDLOAIXE = LOAIXE.IDLOAIXE";
            Vector vt;
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    vt = new Vector();
                    vt.add(rs.getString(1));
                    vt.add(rs.getString(2));
                    vt.add(rs.getString(3));
                    vt.add(rs.getString(4));
                    dtm4.addRow(vt);
                }
                jTable_DSXDK.setModel(dtm4);
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("Loi layDSXe");
            }
        }

        private void layDSDKHinhThucGui() {
            dtm6 = (DefaultTableModel) jTable_DSDKHTG.getModel();
            dtm6.setNumRows(0);
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select IDTHE,BIENSOXE,TENHINHTHUC,NGAYDK,NGAYKT,TIENDATHU,TENTINHTRANG from DANGKY_HINHTHUCGUI, HINHTHUCGUI,TINHTRANG_HINHTHUCGUI "
                    + "where DANGKY_HINHTHUCGUI.IDHINHTHUC= HINHTHUCGUI.IDHINHTHUC and DANGKY_HINHTHUCGUI.IDTINHTRANG = TINHTRANG_HINHTHUCGUI.IDTINHTRANG";
            Vector vt;
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    vt = new Vector();
                    vt.add(rs.getString(1));
                    vt.add(rs.getString(2));
                    vt.add(rs.getString(3));
                    vt.add(chuyenDinhDang(rs.getString(4)));
                    vt.add(chuyenDinhDang(rs.getString(5)));
                    vt.add(rs.getString(6));
                    vt.add(rs.getString(7));
                    dtm6.addRow(vt);
                }
                jTable_DSDKHTG.setModel(dtm6);
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("Loi layDSDKHinhThucGui");
            }
        }

        private void layDSGuiXe() {
            dtm7 = (DefaultTableModel) jTable_CTRV.getModel();
            dtm7.setNumRows(0);
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select BIENSOXE, TENHINHTHUC, TGVAO, TGRA,SOTIEN, IDCATRUC from DANGKY_HINHTHUCGUI, HINHTHUCGUI, GUIXE where GUIXE.IDDANGKY = DANGKY_HINHTHUCGUI.IDDANGKY and DANGKY_HINHTHUCGUI.IDHINHTHUC = HINHTHUCGUI.IDHINHTHUC";
            Vector vt;
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    vt = new Vector();
                    vt.add(rs.getString(1));
                    vt.add(rs.getString(2));
                    vt.add(chuyenDinhDang2(rs.getString(3)));
                    vt.add(chuyenDinhDang2(rs.getString(4)));
                    vt.add(rs.getString(5));
                    vt.add(rs.getString(6));
                    dtm7.addRow(vt);
                }
                jTable_CTRV.setModel(dtm7);
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("Loi layDSGuiXe");
            }
        }

        private void xoaGuiXe(String bienSoXe) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "delete from GUIXE WHERE GuiXe.IDDANGKY IN "
                    + "(select GUIXE.IDDANGKY from GUIXE,DANGKY_HINHTHUCGUI "
                    + "where GUIXE.IDDANGKY=DANGKY_HINHTHUCGUI.IDDANGKY and DANGKY_HINHTHUCGUI.BIENSOXE='" + bienSoXe + "')";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Loi xoaGuiXe");
            }
        }

        private void xoaDangKyHinhThucGui(String bienSoXe) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "delete from DANGKY_HINHTHUCGUI where DANGKY_HINHTHUCGUI.BIENSOXE='" + bienSoXe + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Loi xoaDangKyHinhThucGui");
            }
        }

        private void xoaXe(String bienSoXe) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "delete from XE where XE.BIENSOXE='" + bienSoXe + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Loi xoaXe");
            }
        }

        private boolean kiemTraBienSoXe(String bienSoXe) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select BIENSOXE from XE where XE.BIENSOXE='" + bienSoXe + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("Loi kiemTraBSX");
            }
            return false;
        }

        private String kiemTraGiaHanThe() {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            try {
                CallableStatement c = ketNoi.prepareCall("{call KIEM_TRA_GIA_HAN_THE}");
                ResultSet rs = c.executeQuery();
                while (rs.next()) {
                    String ngayHienTai = luuNgayDK();
                    String ngayCuoiGiaHan = timNgayCuoiGiaHan(rs.getString(3));
                    String layTGVao = layTGVao(rs.getString(5));
                    if (soSanhNgay(ngayHienTai, ngayCuoiGiaHan) > 0 && rs.getString(6).equals("CHỜ GIA HẠN")) {
                        if (layTGVao.equals("-1")) {
                            String tinhTrangMoi = "ĐÃ HỦY";
                            capNhatTinhTrangHTG(tinhTrangMoi, rs.getString(1), "THÁNG", rs.getString(2));
                            String trangThai = "true";
                            trangThaiThe(rs.getString(4), trangThai);
                            jTextFiel_BSX.setText("");
                            jTextField_MauXe.setText("");
                            jTextField_TenXe.setText("");
                            loadMaThe();
                            jComboBox_MaThe.setSelectedIndex(-1);
                            jComboBox_LoaiXe.setSelectedIndex(-1);
                            jComboBox_HinhThucGui.setSelectedIndex(-1);
                        } else {
                            String tenTinhTrangDVMoi = "ĐÃ HỦY";
                            String ngayDKMoi = tinhNgayDKMoi(rs.getString(3));
                            String ngayKTMoi = null;
                            long tien = 0;
                            String ngayTruc = chuyenDinhDang3(ngayDKMoi);
                            String idLoaiCaTruc = "LCT1";
                            String idCaTruc = layIDCaTruc(ngayTruc, idLoaiCaTruc);

                            capNhatTinhTrangHTG(tenTinhTrangDVMoi, rs.getString(1), "THÁNG", rs.getString(2));
                            luuDKHinhThucGui(rs.getString(1), "NGÀY", ngayDKMoi, ngayKTMoi, tien, rs.getString(4), "KÍCH HOẠT");
                            // String idDangKy = "DK" + (demSoLanDangKy());  vì luuDKHinhThuc roi nen dung DK do' them qua GuiXe lun
                            String idDangKy = layIDDangKy(rs.getString(1), "NGÀY", ngayDKMoi);
                            String tgRa = null;
                            luuGuiXe(idDangKy, ngayDKMoi, tgRa, tien, idCaTruc);
                            layDSGuiXe();
                        }
                    }
                }
            } catch (SQLException e) {
                System.out.println("Lỗi kiemTraGiaHan");
            }
            return "-1";
        }

        private String capNhapTinhTrangDV() {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql1 = "select BIENSOXE,NGAYDK,NGAYKT from DANGKY_HINHTHUCGUI where IDHINHTHUC ='" + 2 + "'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql1);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String ngayHienTai = luuNgayDK();
                    String ngayCuoiGiaHan = timNgayCuoiGiaHan(rs.getString(3));
                    if (soSanhNgay(ngayHienTai, rs.getString(3)) >= 0 && soSanhNgay(ngayHienTai, ngayCuoiGiaHan) <= 0) {
                        String tenTinhTrangDVMoi = "CHỜ GIA HẠN";
                        capNhatTinhTrangHTG(tenTinhTrangDVMoi, rs.getString(1), "THÁNG", rs.getString(2));
                    }
                }

            } catch (SQLException e) {
                System.out.println("Lỗi capNhapTinhTrangDV");
            }
            return "-1";
        }

        private long tinhSoNgayGui(String tgVao, String tgRa) {
            Date d = new Date();
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
            String tgVao1 = "", tgRa1 = "";
            try {
                d = df1.parse(tgVao);

                tgVao1 = df2.format(d);
                d = df1.parse(tgRa);
                tgRa1 = df2.format(d);
            } catch (Exception e) {

            }
            DateTimeFormatter df3 = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate d1 = LocalDate.parse(tgVao1, df3);
            LocalDate d3 = LocalDate.parse(tgRa1, df3);
            return (ChronoUnit.DAYS.between(d1, d3));
        }

        private int soSanhNgay(String ngayHienTai, String ngayCuoiGiaHan) {
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
            Date d = new Date();
            String ngayHT = "", ngayCGH = "";
            try {
                d = df1.parse(ngayHienTai);
                ngayHT = df2.format(d);
                d = df1.parse(ngayCuoiGiaHan);
                ngayCGH = df2.format(d);
            } catch (Exception e) {
            }
            return ngayHT.compareTo(ngayCGH);
        }

        private String timNgayCuoiGiaHan(String ngayKT) {
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            // Định nghĩa mốc thời gian ban đầu là ngày 31-07-2011
            Date d = new Date();
            try {
                d = df1.parse(ngayKT);
            } catch (Exception e) {
            }
            c1.setTime(d);
            c2.setTime(d);

            c2.add(Calendar.DATE, 3);
            return String.valueOf(df1.format(c2.getTime()));
        }

        private String tinhNgayDKMoi(String ngayKT) {
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            // Định nghĩa mốc thời gian ban đầu là ngày 31-07-2011
            Date d = new Date();
            try {
                d = df1.parse(ngayKT);
            } catch (Exception e) {
            }
            c1.setTime(d);
            c2.setTime(d);

            //   System.out.println("Ngày ban đầu : " + df1.format(c1.getTime()));
            c2.add(Calendar.DATE, 1);
            //c2.add(Calendar.DATE, -8); // Giảm ngày 8 ngày ==> 23-07-2011
            //  System.out.println("Ngày được tăng thêm 1 ngày (Sử dụng add)  : "
            //          + df1.format(c2.getTime()));
            return String.valueOf(df1.format(c2.getTime()));
        }

        public boolean ktBienSoXe(String bienSoXe, String tenLoaiXe) {
            String kt1 = "\\d{2}\\-[A-Z]\\d\\-((\\d{4})|(\\d{3}\\.\\d{2}))";
            String kt2 = "\\d{2}[A-Z]\\-\\d{3}\\.\\d{2}";
            if (tenLoaiXe.equals("XE MÁY")) {
                if (!bienSoXe.matches(kt1)) {
                    return false;
                } else {
                    return true;
                }
            } else {
                if (!bienSoXe.matches(kt2)) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    public class the {

        private String IDTHE;
        private boolean TRANGTHAI;

        DefaultTableModel dtmThe1;

        private void phanQuyen(String req) {
            if (req.equals("1")) {
                jButton_ThemNV.setEnabled(false);
                jButton_ThemTK.setEnabled(false);
                jButton_ThemCaTruc.setEnabled(false);
                jButton_XoaNV.setEnabled(false);
                jButton_XoaTK.setEnabled(false);
                jButton_XoaCaTruc.setEnabled(false);
                jButton_ThemTheMoi.setEnabled(false);
                jTable_DSTK.setVisible(false);
                jButton_CapNhatCaTruc.setEnabled(false);
                jButton_ThongKe.setEnabled(false);
                jButton_DatLaiThongKe.setEnabled(false);
                jButton_CapNhatLaiGia.setEnabled(false);
                jButton_CapNhatNV.setEnabled(false);
            } else {
                jButton_DangKy.setEnabled(false);
                jButton_CapNhatXe.setEnabled(false);
                jButton_matThe.setEnabled(false);
                jButton_VaoBen.setEnabled(false);
                jButton_XuatBen.setEnabled(false);
                jButton_GiaHan.setEnabled(false);
                jButton_HuyGiaHan.setEnabled(false);
            }
        }

        private String layMANVLogin() {
            String res = "";
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select MANV from TAIKHOAN where TRANGTHAI='False'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    res = rs.getString(1);
                }
            } catch (SQLException e) {
                System.out.println("err1745");
            }
            return res;
        }

        private String layTenDangNhapLogin() {
            String res = "";
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String trangThai = "false";
            String sql = "select TENDANGNHAP from TAIKHOAN where TRANGTHAI=?";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, trangThai);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    res = rs.getString(1);
                }
            } catch (SQLException e) {
                System.out.println("err");
            }
            return res.trim();
        }

        private String layMatKhauLogin() {
            String res = "";
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String trangThai = "false";
            String sql = "select MATKHAU from TAIKHOAN where TRANGTHAI=?";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, trangThai);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    res = rs.getString(1);
                }
            } catch (SQLException e) {
                System.out.println("err");
            }
            return res.trim();
        }

        private void setNgay() {
            Date date2 = new Date();
            DateFormat timeFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            String time2 = timeFormat2.format(date2);
            jLabel99.setText(time2);
        }

        private void layTenLogin() {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String trangThai = "false";
            String sql = "select HOTEN from TAIKHOAN, NHANVIEN where TRANGTHAI=? and TAIKHOAN.MANV=NHANVIEN.MANV";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, trangThai);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    labelTenNhanVien.setText(rs.getString(1));
                }
            } catch (SQLException e) {
                System.out.println("err");
            }
        }

        private String layVaiTroLogin() {
            String res = "";
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String trangThai = "false";
            String sql = "select TENVAITRO from TAIKHOAN,NHANVIEN,VAITRO where TAIKHOAN.MANV=NHANVIEN.MANV and NHANVIEN.IDVAITRO=VAITRO.IDVAITRO and TRANGTHAI=?";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, trangThai);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    res = rs.getString(1);
                }
            } catch (SQLException e) {
                System.out.println("err");
            }
            return res;
        }

        private String layIDVAITROLogin() {
            String res = "";
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select NHANVIEN.IDVAITRO from TAIKHOAN,NHANVIEN where TRANGTHAI='False' and TAIKHOAN.MANV=NHANVIEN.MANV";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    res = rs.getString(1);
                }
            } catch (SQLException e) {
                System.out.println("err1761");
            }
            return res;
        }

        private String layIDVAITRO(String ma) {
            String res = "";
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select NHANVIEN.IDVAITRO from NHANVIEN where MANV=?";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, ma);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    res = rs.getString(1);
                }
            } catch (SQLException e) {
                System.out.println("err1761");
            }
            return res;
        }

        private void sortDSThe() {
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(dtmThe1);
            jTable_DSThe.setRowSorter(sorter);
        }

        private void loadTableThe() {

            dtmThe1 = (DefaultTableModel) jTable_DSThe.getModel();
            dtmThe1.setNumRows(0);
            Connection ketNoi = ketNoiSQL.layKetNoi();

            Vector vt, vt1, vt2;
            try {
                CallableStatement c = ketNoi.prepareCall("{call THONG_KE_THE_False}");
                ResultSet rs = c.executeQuery();
                while (rs.next()) {
                    vt = new Vector();
                    vt.add(rs.getString(1));
                    vt.add(rs.getString(2));
                    vt.add("ĐANG SỬ DỤNG");
                    vt.add(rs.getString(3));
                    dtmThe1.addRow(vt);
                }
                jTable_DSThe.setModel(dtmThe1);
            } catch (SQLException e) {
                System.out.println("Loi layDSThe");
            }
            try {
                CallableStatement c = ketNoi.prepareCall("{call THONG_KE_THE_True}");
                ResultSet rs = c.executeQuery();
                while (rs.next()) {
                    vt1 = new Vector();
                    vt1.add(rs.getString(1));
                    vt1.add("");
                    vt1.add("TRỐNG");
                    vt1.add("");
                    dtmThe1.addRow(vt1);
                }
                jTable_DSThe.setModel(dtmThe1);

            } catch (SQLException e) {
                System.out.println("Loi layDSThe");
            }
            try {
                CallableStatement c = ketNoi.prepareCall("{call THONG_KE_THE_Null}");
                ResultSet rs = c.executeQuery();
                while (rs.next()) {
                    vt2 = new Vector();
                    vt2.add(rs.getString(1));
                    vt2.add("");
                    vt2.add("ĐÃ KHÓA");
                    vt2.add("");
                    dtmThe1.addRow(vt2);
                }
                jTable_DSThe.setModel(dtmThe1);
                rs.close();
                c.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("Loi layDSThe");
            }
        }

        public the() {
        }

        private void countIDThe() {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(IDTHE) from the";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    jlabelCountIDThe.setText(rs.getString(1));
                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("Loi lay count IDThe");
            }
        }

        private String demTheMat(String tuNgay, String denNgay) {
            String res = "0";
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(IDDANGKY) from CHITIET_MATTHE where NGAYMATTHE>=? and NGAYMATTHE<=?";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }

                    res = rs.getString(1);
                }
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR2145");
            }
            return res;
        }

        private String tienTheMat(String tuNgay, String denNgay) {
            String res = "0";
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select sum(TIENTHEMAT) from CHITIET_MATTHE where NGAYMATTHE>=? and NGAYMATTHE<=?";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }

                    res = rs.getString(1);
                }
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR2172");
            }
            return res;
        }

        private int xeTrongBen() {
            int res = 0;
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(IDDANGKY) from GUIXE where TGRA is null";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    res = Integer.valueOf(rs.getString(1));
                }
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR2172");
            }
            return res;
        }

        private int xeDangDangKy() {
            int res = 0;
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(IDDANGKY) from DANGKY_HINHTHUCGUI where IDTINHTRANG='KH'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    res = Integer.valueOf(rs.getString(1));
                }
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR2352");
            }
            return res;
        }

        private int xeDangChoGiaHan() {
            int res = 0;
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(IDDANGKY) from DANGKY_HINHTHUCGUI where IDTINHTRANG='CGH'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    res = Integer.valueOf(rs.getString(1));
                }
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR2372");
            }
            return res;
        }

        private String tk_Oto_Ngay(String tuNgay, String denNgay) {
            String res = "0";
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select sum(SOTIEN) from XE,DANGKY_HINHTHUCGUI, HINHTHUCGUI, GUIXE where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE and GUIXE.IDDANGKY = DANGKY_HINHTHUCGUI.IDDANGKY and DANGKY_HINHTHUCGUI.IDHINHTHUC = HINHTHUCGUI.IDHINHTHUC  and TENHINHTHUC='Ngày' and TGRA>= ? and TGRA<=? and XE.IDLOAIXE='2'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }

                    res = rs.getString(1);
                }
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR1876");

            }
            return res;
        }

        private String tk_Oto_Thang(String tuNgay, String denNgay) {
            String res = "0";
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select sum(TIENDATHU) from XE,DANGKY_HINHTHUCGUI where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE  and IDHINHTHUC='2' and NGAYDK>= ? and NGAYDK<= ?  and XE.IDLOAIXE='2'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }

                    res = rs.getString(1);
                }
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR1876");

            }
            return res;
        }

        private String tk_Xe_Ngay(String tuNgay, String denNgay) {
            String res = "0";

            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select sum(SOTIEN) from XE,DANGKY_HINHTHUCGUI, GUIXE where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE and GUIXE.IDDANGKY = DANGKY_HINHTHUCGUI.IDDANGKY  and DANGKY_HINHTHUCGUI.IDHINHTHUC='1' and TGRA>= ? and TGRA<=? and XE.IDLOAIXE='1'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }

                    res = rs.getString(1);
                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR1935");
            }
            return res;
        }

        private String tk_Xe_Thang(String tuNgay, String denNgay) {
            String res = "0";

            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select sum(TIENDATHU) from XE,DANGKY_HINHTHUCGUI, HINHTHUCGUI, GUIXE where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE and GUIXE.IDDANGKY = DANGKY_HINHTHUCGUI.IDDANGKY and DANGKY_HINHTHUCGUI.IDHINHTHUC = HINHTHUCGUI.IDHINHTHUC  and TENHINHTHUC='Tháng' and NGAYDK>= ? and NGAYDK<=? and XE.IDLOAIXE='1'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }
                    res = rs.getString(1);

                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR1966");
            }
            return res;
        }

        private String tk_count_Xe_Ngay(String tuNgay, String denNgay) {
            String res = "0";
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(DANGKY_HINHTHUCGUI.BIENSOXE) from XE,DANGKY_HINHTHUCGUI where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE and IDHINHTHUC='1' and NGAYDK>= ? and NGAYDK<=? and XE.IDLOAIXE='1'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }
                    res = rs.getString(1);
                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR");
            }
            return res;
        }

        private String tk_count_Oto_Ngay(String tuNgay, String denNgay) {
            String res = "0";

            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(DANGKY_HINHTHUCGUI.BIENSOXE) from XE,DANGKY_HINHTHUCGUI where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE and IDHINHTHUC='1' and NGAYDK>= ? and NGAYDK<=? and XE.IDLOAIXE='2'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }
                    res = rs.getString(1);
                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR");
            }
            return res;
        }

        private String tk_count_Xe_Thang(String tuNgay, String denNgay) {
            String res = "0";

            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(DANGKY_HINHTHUCGUI.BIENSOXE) from XE,DANGKY_HINHTHUCGUI where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE and IDHINHTHUC='2' and NGAYDK>= ? and NGAYDK<=? and XE.IDLOAIXE='1'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }
                    res = rs.getString(1);
                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR");
            }
            return res;
        }

        private String tk_count_Oto_Thang(String tuNgay, String denNgay) {
            String res = "0";

            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(DANGKY_HINHTHUCGUI.BIENSOXE) from XE,DANGKY_HINHTHUCGUI where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE and IDHINHTHUC='2' and NGAYDK>= ? and NGAYDK<=? and XE.IDLOAIXE='2'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }
                    res = rs.getString(1);
                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR");
            }
            return res;
        }

        private String tk_count_Xe_Ngay_Vao(String tuNgay, String denNgay) {
            String res = "0";
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(GUIXE.IDDANGKY) from GUIXE,DANGKY_HINHTHUCGUI,XE where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE  and GUIXE.IDDANGKY=DANGKY_HINHTHUCGUI.IDDANGKY and IDHINHTHUC='1' and TGVAO>= ? and TGVAO<=? and XE.IDLOAIXE='1'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }
                    res = rs.getString(1);
                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR1995");
            }
            return res;
        }

        private String tk_count_Xe_Ngay_Ra(String tuNgay, String denNgay) {
            String res = "0";
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(GUIXE.IDDANGKY) from GUIXE,DANGKY_HINHTHUCGUI,XE where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE  and GUIXE.IDDANGKY=DANGKY_HINHTHUCGUI.IDDANGKY and IDHINHTHUC='1' and TGRA>= ? and TGRA<=? and XE.IDLOAIXE='1'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }
                    res = rs.getString(1);
                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR1995");
            }
            return res;
        }

        private String tk_count_Oto_Ngay_Vao(String tuNgay, String denNgay) {
            String res = "0";

            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(GUIXE.IDDANGKY) from GUIXE,DANGKY_HINHTHUCGUI,XE where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE  and GUIXE.IDDANGKY=DANGKY_HINHTHUCGUI.IDDANGKY and IDHINHTHUC='1' and TGVAO>= ? and TGVAO<=? and XE.IDLOAIXE='2'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }
                    res = rs.getString(1);
                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR2025");
            }
            return res;
        }

        private String tk_count_Oto_Ngay_Ra(String tuNgay, String denNgay) {
            String res = "0";

            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(GUIXE.IDDANGKY) from GUIXE,DANGKY_HINHTHUCGUI,XE where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE  and GUIXE.IDDANGKY=DANGKY_HINHTHUCGUI.IDDANGKY and IDHINHTHUC='1' and TGRA>= ? and TGRA<=? and XE.IDLOAIXE='2'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }
                    res = rs.getString(1);
                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR2025");
            }
            return res;
        }

        private String tk_count_Xe_Thang_Vao(String tuNgay, String denNgay) {
            String res = "0";

            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(GUIXE.IDDANGKY) from GUIXE,DANGKY_HINHTHUCGUI,XE where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE  and GUIXE.IDDANGKY=DANGKY_HINHTHUCGUI.IDDANGKY and IDHINHTHUC='2' and TGVAO>= ? and TGVAO<=? and XE.IDLOAIXE='1'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }
                    res = rs.getString(1);
                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR2055");
            }
            return res;
        }

        private String tk_count_Xe_Thang_Ra(String tuNgay, String denNgay) {
            String res = "0";

            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(GUIXE.IDDANGKY) from GUIXE,DANGKY_HINHTHUCGUI,XE where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE  and GUIXE.IDDANGKY=DANGKY_HINHTHUCGUI.IDDANGKY and IDHINHTHUC='2' and TGRA>= ? and TGRA<=? and XE.IDLOAIXE='1'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }
                    res = rs.getString(1);
                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR2055");
            }
            return res;
        }

        private String tk_count_Oto_Thang_Vao(String tuNgay, String denNgay) {
            String res = "0";

            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(GUIXE.IDDANGKY) from GUIXE,DANGKY_HINHTHUCGUI,XE where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE  and GUIXE.IDDANGKY=DANGKY_HINHTHUCGUI.IDDANGKY and IDHINHTHUC='2' and TGVAO>= ? and TGVAO<=? and XE.IDLOAIXE='2'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }
                    res = rs.getString(1);
                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR2085");
            }
            return res;
        }

        private String tk_count_Oto_Thang_Ra(String tuNgay, String denNgay) {
            String res = "0";

            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select count(GUIXE.IDDANGKY) from GUIXE,DANGKY_HINHTHUCGUI,XE where XE.BIENSOXE=DANGKY_HINHTHUCGUI.BIENSOXE  and GUIXE.IDDANGKY=DANGKY_HINHTHUCGUI.IDDANGKY and IDHINHTHUC='2' and TGRA>= ? and TGRA<=? and XE.IDLOAIXE='2'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString(1) == null) {
                        return res;
                    }
                    res = rs.getString(1);
                }

                rs.close();

                ps.close();

                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("ERR2085");
            }
            return res;
        }

        private void layDSTK() {
            Xe qlx = new Xe();
            DefaultTableModel dtm77 = (DefaultTableModel) jTable_TK.getModel();
            dtm77.setNumRows(0);
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select BIENSOXE, TENHINHTHUC, TGVAO, TGRA,SOTIEN from DANGKY_HINHTHUCGUI, HINHTHUCGUI, GUIXE where GUIXE.IDDANGKY = DANGKY_HINHTHUCGUI.IDDANGKY and DANGKY_HINHTHUCGUI.IDHINHTHUC = HINHTHUCGUI.IDHINHTHUC and SOTIEN!=0 and TGRA IS not NULL and DANGKY_HINHTHUCGUI.IDHINHTHUC='1'";
            Vector vt;
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    vt = new Vector();
                    vt.add(rs.getString(1));
                    vt.add(rs.getString(2));
                    vt.add(qlx.chuyenDinhDang2(rs.getString(3)));
                    vt.add(qlx.chuyenDinhDang2(rs.getString(4)));
                    vt.add(rs.getString(5));

                    dtm77.addRow(vt);
                }
                jTable_TK.setModel(dtm77);
//                rs.close();
//                ps.close();
//                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("Loi layDSTK");
            }
            String sql2 = "select BIENSOXE, TENHINHTHUC, NGAYDK,NGAYKT,TIENTHEMAT from DANGKY_HINHTHUCGUI, HINHTHUCGUI, CHITIET_MATTHE where CHITIET_MATTHE.IDDANGKY=DANGKY_HINHTHUCGUI.IDDANGKY  and  DANGKY_HINHTHUCGUI.IDHINHTHUC = HINHTHUCGUI.IDHINHTHUC ";
            Vector vt2;
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql2);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    vt2 = new Vector();
                    vt2.add(rs.getString(1));
                    vt2.add(rs.getString(2));
                    vt2.add(qlx.chuyenDinhDang2(rs.getString(3)));
                    vt2.add(qlx.chuyenDinhDang2(rs.getString(4)));
                    vt2.add(rs.getString(5));

                    dtm77.addRow(vt2);
                }
                jTable_TK.setModel(dtm77);

            } catch (SQLException e) {
                System.out.println("Loi layDSTK");
            }

            String sql1 = "select DANGKY_HINHTHUCGUI.BIENSOXE, TENHINHTHUC, NGAYDK, NGAYKT,TIENDATHU from DANGKY_HINHTHUCGUI, HINHTHUCGUI, GUIXE where GUIXE.IDDANGKY = DANGKY_HINHTHUCGUI.IDDANGKY and DANGKY_HINHTHUCGUI.IDHINHTHUC = HINHTHUCGUI.IDHINHTHUC and DANGKY_HINHTHUCGUI.IDHINHTHUC='2'";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql1);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    vt = new Vector();
                    String bsx = rs.getString(1);
                    vt.add(bsx);
                    vt.add(rs.getString(2));
                    vt.add(qlx.chuyenDinhDang2(rs.getString(3)));
                    vt.add(qlx.chuyenDinhDang2(rs.getString(4)));
                    vt.add(rs.getString(5));

                    dtm77.addRow(vt);
                }
                jTable_TK.setModel(dtm77);
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("Loi layDSTK");
            }

        }

        private void sortDSTK() {
            DefaultTableModel dtm77 = (DefaultTableModel) jTable_TK.getModel();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(dtm77);
            jTable_TK.setRowSorter(sorter);
        }

        private void laySortDSTK(String tuNgay, String denNgay) {
            Xe qlx = new Xe();
            DefaultTableModel dtm77 = (DefaultTableModel) jTable_TK.getModel();
            dtm77.setNumRows(0);
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select BIENSOXE, TENHINHTHUC, TGVAO, TGRA,SOTIEN from DANGKY_HINHTHUCGUI, HINHTHUCGUI, GUIXE where GUIXE.IDDANGKY = DANGKY_HINHTHUCGUI.IDDANGKY and DANGKY_HINHTHUCGUI.IDHINHTHUC = HINHTHUCGUI.IDHINHTHUC and SOTIEN!=0 and TGRA IS not NULL and DANGKY_HINHTHUCGUI.IDHINHTHUC='1' and TGRA>=? and TGRA<=?";
            Vector vt;
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    vt = new Vector();
                    vt.add(rs.getString(1));
                    vt.add(rs.getString(2));
                    vt.add(qlx.chuyenDinhDang2(rs.getString(3)));
                    vt.add(qlx.chuyenDinhDang2(rs.getString(4)));
                    vt.add(rs.getString(5));

                    dtm77.addRow(vt);
                }
                jTable_TK.setModel(dtm77);
//                rs.close();
//                ps.close();
//                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("Loi layDSTK");
            }
            String sql2 = "select BIENSOXE, TENHINHTHUC, NGAYDK,NGAYKT,TIENTHEMAT from DANGKY_HINHTHUCGUI, HINHTHUCGUI, CHITIET_MATTHE where CHITIET_MATTHE.IDDANGKY=DANGKY_HINHTHUCGUI.IDDANGKY  and  DANGKY_HINHTHUCGUI.IDHINHTHUC = HINHTHUCGUI.IDHINHTHUC and NGAYMATTHE>=? and NGAYMATTHE<=? ";
            Vector vt2;
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql2);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    vt2 = new Vector();
                    vt2.add(rs.getString(1));
                    vt2.add(rs.getString(2));
                    vt2.add(qlx.chuyenDinhDang2(rs.getString(3)));
                    vt2.add(qlx.chuyenDinhDang2(rs.getString(4)));
                    vt2.add(rs.getString(5));

                    dtm77.addRow(vt2);
                }
                jTable_TK.setModel(dtm77);
//                rs.close();
//                ps.close();
//                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("Loi layDSTK");
            }

            String sql1 = "select DANGKY_HINHTHUCGUI.BIENSOXE, TENHINHTHUC, NGAYDK, NGAYKT,TIENDATHU from DANGKY_HINHTHUCGUI, HINHTHUCGUI, GUIXE where GUIXE.IDDANGKY = DANGKY_HINHTHUCGUI.IDDANGKY and DANGKY_HINHTHUCGUI.IDHINHTHUC = HINHTHUCGUI.IDHINHTHUC and DANGKY_HINHTHUCGUI.IDHINHTHUC='2' and NGAYDK>=? and NGAYDK<=?";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql1);
                ps.setString(1, tuNgay);
                ps.setString(2, denNgay);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    vt = new Vector();
                    String bsx = rs.getString(1);
                    vt.add(bsx);
                    vt.add(rs.getString(2));
                    vt.add(qlx.chuyenDinhDang2(rs.getString(3)));
                    vt.add(qlx.chuyenDinhDang2(rs.getString(4)));
                    vt.add(rs.getString(5));

                    dtm77.addRow(vt);
                }
                jTable_TK.setModel(dtm77);
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("Loi layDSTK");
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel70 = new javax.swing.JLabel();
        jButton_XacNhanMatThe = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel_MT1 = new javax.swing.JLabel();
        jLabel_MT2 = new javax.swing.JLabel();
        jLabel_MT3 = new javax.swing.JLabel();
        jLabel_MT4 = new javax.swing.JLabel();
        jDialog2 = new javax.swing.JDialog();
        jLabel100 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel_TTN1 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel_TTN2 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel_TTN3 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel_TTN4 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel_TTN5 = new javax.swing.JLabel();
        jButton_HuyTTN = new javax.swing.JButton();
        jButton_DongYTTN = new javax.swing.JButton();
        jDialog3 = new javax.swing.JDialog();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jButton_HuyThanhToan = new javax.swing.JButton();
        jLabel_TT1 = new javax.swing.JLabel();
        jLabel_TT2 = new javax.swing.JLabel();
        jLabel_TT3 = new javax.swing.JLabel();
        jLabel_TT4 = new javax.swing.JLabel();
        jLabel_TT5 = new javax.swing.JLabel();
        jButton_DongYThanhToan = new javax.swing.JButton();
        jDialog4 = new javax.swing.JDialog();
        jLabel44 = new javax.swing.JLabel();
        jButton_DongYXoaXe = new javax.swing.JButton();
        jButton_HuyXoaXe = new javax.swing.JButton();
        jLabel163 = new javax.swing.JLabel();
        jDialog5 = new javax.swing.JDialog();
        jButton4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jDialog6 = new javax.swing.JDialog();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jButton_DongYThanhToanGiaHan = new javax.swing.JButton();
        jButton_HuyThanhToanGiaHan = new javax.swing.JButton();
        jLabel_TTGH1 = new javax.swing.JLabel();
        jLabel_TTGH2 = new javax.swing.JLabel();
        jLabel_TTGH3 = new javax.swing.JLabel();
        jLabel_TTGH4 = new javax.swing.JLabel();
        jLabel_TTGH5 = new javax.swing.JLabel();
        jDialog7 = new javax.swing.JDialog();
        jLabel30 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jComboBox_maThe2 = new javax.swing.JComboBox<>();
        jLabel64 = new javax.swing.JLabel();
        jButton_XacNhanMaTheMoi = new javax.swing.JButton();
        jDialog8 = new javax.swing.JDialog();
        jLabel147 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDialog9 = new javax.swing.JDialog();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jButton_dkHinhThucNgay = new javax.swing.JButton();
        jButton_xuatBenKhiHuyGiaHan = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_DSXDK = new javax.swing.JTable();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton_GiaHan = new javax.swing.JButton();
        jButton_HuyGiaHan = new javax.swing.JButton();
        jButton_matThe = new javax.swing.JButton();
        jButton_XuatBen = new javax.swing.JButton();
        jButton_VaoBen = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jTextField_TenXe = new javax.swing.JTextField();
        jTextField_MauXe = new javax.swing.JTextField();
        jComboBox_MaThe = new javax.swing.JComboBox<>();
        jLabel_LoiThe = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextFiel_BSX = new javax.swing.JTextField();
        jLabel_LoiBSX = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox_LoaiXe = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel_LoiLoaiXe = new javax.swing.JLabel();
        jComboBox_HinhThucGui = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel_LoiHTG = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jButton_DangKy = new javax.swing.JButton();
        jButton_CapNhatXe = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable_DSDKHTG = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField_TimKiemTheoBSX1 = new javax.swing.JTextField();
        jButton_TimKiemTheoBSX1 = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        jButton_TimKiemTheoNgayDK = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        jButton_TimKiemTheoHTG = new javax.swing.JButton();
        jLabel93 = new javax.swing.JLabel();
        jButton_DatLaiDSDK = new javax.swing.JButton();
        jComboBox_TimKiemTheoHTG = new javax.swing.JComboBox<>();
        dateChooserCombo3 = new datechooser.beans.DateChooserCombo();
        jLabel13 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_CTRV = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField_TimKiemTheoBSX2 = new javax.swing.JTextField();
        jButton_TimKiemTheoBSX2 = new javax.swing.JButton();
        jButton_DatLaiCTRV = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jlbXeTrongBen = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jlabelCountIDThe = new javax.swing.JLabel();
        jButton_DatLaiThe = new javax.swing.JButton();
        jButton_DSTT = new javax.swing.JButton();
        jButton_DSTDD = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_DSThe = new javax.swing.JTable();
        jButton_ThemTheMoi = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        jPanel_new = new javax.swing.JPanel();
        jLabel_loaiXe2 = new javax.swing.JLabel();
        jLabel_loaiXe1 = new javax.swing.JLabel();
        jTextField_giaLoaiXe2 = new javax.swing.JTextField();
        jTextField_giaLoaiXe1 = new javax.swing.JTextField();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jButton_CapNhatLaiGia = new javax.swing.JButton();
        jLabel155 = new javax.swing.JLabel();
        jLabel_loiGiaTien1 = new javax.swing.JLabel();
        jLabel_loiGiaTien2 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jTextField_tienPhuPhi1 = new javax.swing.JTextField();
        jTextField_tienPhuPhi2 = new javax.swing.JTextField();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel_loiTienPhuPhi1 = new javax.swing.JLabel();
        jLabel_loiTienPhuPhi2 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jTextField_phiMatThe2 = new javax.swing.JTextField();
        jTextField_phiMatThe1 = new javax.swing.JTextField();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel_loiPhiMatThe1 = new javax.swing.JLabel();
        jLabel_loiPhiMatThe2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTenNV = new javax.swing.JTextField();
        jCMND = new javax.swing.JTextField();
        jDiaChi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSDT = new javax.swing.JTextField();
        jTimKiemTheoMaNV1 = new javax.swing.JTextField();
        jButton_TimKiemTheoMaNV1 = new javax.swing.JButton();
        jButton_ThemNV = new javax.swing.JButton();
        jButton_XoaNV = new javax.swing.JButton();
        jButton_CapNhatNV = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_DSNV = new javax.swing.JTable();
        jLabel74 = new javax.swing.JLabel();
        jComboBox_GioiTinh = new javax.swing.JComboBox<>();
        jComboBox_VaiTro = new javax.swing.JComboBox<>();
        jLabel82 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jButton_DatLaiDSNV = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        jLabel_loiMaNV = new javax.swing.JLabel();
        jLabel_loiTenNV = new javax.swing.JLabel();
        jLabel_loiCMND = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel_loiSDT = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jMaNV = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jTenTK = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jButton_TimKiemTheoMaNV2 = new javax.swing.JButton();
        jButton_ThemTK = new javax.swing.JButton();
        jButton_XoaTK = new javax.swing.JButton();
        jTimKiemTheoMaNV2 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_DSTK = new javax.swing.JTable();
        jLabel96 = new javax.swing.JLabel();
        jComboBox_MaNV1 = new javax.swing.JComboBox<>();
        jLabel67 = new javax.swing.JLabel();
        jButton_DatLaiDSTK = new javax.swing.JButton();
        jLabel_loiTenTK = new javax.swing.JLabel();
        jLabel_loiMK = new javax.swing.JLabel();
        jMatKhau = new javax.swing.JPasswordField();
        jLabel107 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jButton_CapNhatTK = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jButton_TimKiemTheoMaNV3 = new javax.swing.JButton();
        jTimKiemTheoMaNV3 = new javax.swing.JTextField();
        jButton_ThemCaTruc = new javax.swing.JButton();
        jButton_XoaCaTruc = new javax.swing.JButton();
        jButton_CapNhatCaTruc = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable_DSCaTruc = new javax.swing.JTable();
        jLabel95 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel66 = new javax.swing.JLabel();
        jComboBox_NhiemVu = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton_TimKiemTheoIDCaTruc = new javax.swing.JButton();
        jButton_DatLaiDSCT = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jComboBox_CaTruc = new javax.swing.JComboBox<>();
        jLabel_loiNgayTruc = new javax.swing.JLabel();
        jLabel_loiNVu = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jFormattedTextField_NgayTruc = new datechooser.beans.DateChooserCombo();
        jPanel9 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        jLabel65 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_TK = new javax.swing.JTable();
        jButton_ThongKe = new javax.swing.JButton();
        dateChooserTuNgay = new datechooser.beans.DateChooserCombo();
        dateChooserDenNgay = new datechooser.beans.DateChooserCombo();
        jButton_DatLaiThongKe = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jlabelfail = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabelTongTien = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        labelTenNhanVien = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton_DangXuat = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel_ngay = new javax.swing.JLabel();
        jLabel_time = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();

        jDialog1.setBackground(new java.awt.Color(255, 255, 255));
        jDialog1.setLocation(new java.awt.Point(450, 150));
        jDialog1.setSize(new java.awt.Dimension(370, 320));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(153, 0, 0));
        jLabel70.setText("THANH TOÁN TIỀN LÀM MẤT THẺ");

        jButton_XacNhanMatThe.setText("XÁC NHẬN");
        jButton_XacNhanMatThe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XacNhanMatTheActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("BIỂN SỐ XE: ");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("MÃ THẺ:");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("NGÀY BÁO MẤT THẺ: ");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("SỐ TIỀN CẦN THANH TOÁN: ");

        jLabel_MT1.setText("jLabel63");

        jLabel_MT2.setText("jLabel64");

        jLabel_MT3.setText("jLabel65");

        jLabel_MT4.setText("jLabel73");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addComponent(jLabel58)
                                .addGap(113, 113, 113)
                                .addComponent(jLabel62))
                            .addComponent(jLabel59)
                            .addComponent(jLabel60)
                            .addComponent(jLabel61))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_MT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_MT3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addComponent(jLabel_MT1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel_MT4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jButton_XacNhanMatThe)))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel70)
                .addGap(84, 84, 84))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel62)
                    .addComponent(jLabel_MT1))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jLabel_MT2))
                .addGap(27, 27, 27)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jLabel_MT3))
                .addGap(27, 27, 27)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jLabel_MT4))
                .addGap(42, 42, 42)
                .addComponent(jButton_XacNhanMatThe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jDialog2.setBackground(new java.awt.Color(255, 255, 255));
        jDialog2.setLocation(new java.awt.Point(450, 150));
        jDialog2.setSize(new java.awt.Dimension(380, 390));

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(204, 0, 0));
        jLabel100.setText("THANH TOÁN");

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel102.setText("BIẾN SỐ XE");

        jLabel_TTN1.setText("61A-123456");

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel104.setText("HÌNH THỨC GỬI");

        jLabel_TTN2.setText("NGÀY");

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel106.setText("THỜI GIAN VÀO");

        jLabel_TTN3.setText("21/3/2021");

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel108.setText("THỜI GIAN RA");

        jLabel_TTN4.setText("21/3/2021");

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel110.setText("TIỀN THU");

        jLabel_TTN5.setText("3000");

        jButton_HuyTTN.setText("HỦY");
        jButton_HuyTTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HuyTTNActionPerformed(evt);
            }
        });

        jButton_DongYTTN.setText("ĐỒNG Ý");
        jButton_DongYTTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DongYTTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jButton_DongYTTN)
                .addGap(73, 73, 73)
                .addComponent(jButton_HuyTTN)
                .addGap(98, 98, 98))
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel108)
                                    .addComponent(jLabel106)
                                    .addComponent(jLabel110)
                                    .addComponent(jLabel104)))
                            .addComponent(jLabel102))
                        .addGap(46, 46, 46)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_TTN2)
                            .addComponent(jLabel_TTN3)
                            .addComponent(jLabel_TTN1)
                            .addComponent(jLabel_TTN5)
                            .addComponent(jLabel_TTN4)))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel100)
                .addGap(18, 18, 18)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(jLabel_TTN1))
                .addGap(36, 36, 36)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104)
                    .addComponent(jLabel_TTN2))
                .addGap(36, 36, 36)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel106)
                    .addComponent(jLabel_TTN3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel108)
                    .addComponent(jLabel_TTN4))
                .addGap(30, 30, 30)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(jLabel_TTN5))
                .addGap(44, 44, 44)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_HuyTTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_DongYTTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jDialog3.setBackground(new java.awt.Color(255, 255, 255));
        jDialog3.setLocation(new java.awt.Point(450, 150));
        jDialog3.setSize(new java.awt.Dimension(380, 350));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(153, 0, 0));
        jLabel33.setText("THANH TOÁN");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("BIỂN SỐ XE");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("HÌNH THỨC GỬI");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("NGÀY ĐĂNG KÝ");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("NGÀY HẾT HẠN");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("TIỀN");

        jButton_HuyThanhToan.setText("HỦY");
        jButton_HuyThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HuyThanhToanActionPerformed(evt);
            }
        });

        jLabel_TT1.setText("jLabel39");

        jLabel_TT2.setText("jLabel40");

        jLabel_TT3.setText("jLabel41");

        jLabel_TT4.setText("jLabel42");

        jLabel_TT5.setText("jLabel43");

        jButton_DongYThanhToan.setText("ĐỒNG Ý");
        jButton_DongYThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DongYThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog3Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel38)))
                            .addGroup(jDialog3Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jButton_DongYThanhToan)))
                        .addGap(55, 55, 55)
                        .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_TT5)
                                .addComponent(jLabel_TT4)
                                .addComponent(jLabel_TT3)
                                .addComponent(jLabel_TT1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_TT2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialog3Layout.createSequentialGroup()
                                .addComponent(jButton_HuyThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))))
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel33)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel_TT1))
                .addGap(18, 18, 18)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel_TT2))
                .addGap(18, 18, 18)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel_TT3))
                .addGap(27, 27, 27)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel_TT4))
                .addGap(18, 18, 18)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel_TT5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_HuyThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_DongYThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        jDialog4.setBackground(new java.awt.Color(255, 255, 255));
        jDialog4.setLocation(new java.awt.Point(450, 200));
        jDialog4.setSize(new java.awt.Dimension(400, 250));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("BẠN CÓ CHẮC CHẮN MUỐN XÓA");

        jButton_DongYXoaXe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_DongYXoaXe.setText("ĐỒNG Ý");
        jButton_DongYXoaXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DongYXoaXeActionPerformed(evt);
            }
        });

        jButton_HuyXoaXe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_HuyXoaXe.setText("HỦY");
        jButton_HuyXoaXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HuyXoaXeActionPerformed(evt);
            }
        });

        jLabel163.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(255, 0, 0));
        jLabel163.setText("CHÚ Ý");

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog4Layout.createSequentialGroup()
                .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog4Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel163))
                    .addGroup(jDialog4Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel44))
                    .addGroup(jDialog4Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jButton_DongYXoaXe)
                        .addGap(54, 54, 54)
                        .addComponent(jButton_HuyXoaXe, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel163)
                .addGap(41, 41, 41)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_DongYXoaXe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_HuyXoaXe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        jDialog5.setBackground(new java.awt.Color(255, 255, 255));
        jDialog5.setLocation(new java.awt.Point(450, 150));
        jDialog5.setSize(new java.awt.Dimension(415, 240));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("ĐÓNG");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 0, 0));
        jLabel39.setText("THÔNG BÁO");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("THẺ BẠN ĐÃ HẾT HẠN VÀ VẪN CÒN THỜI GIAN GIA HẠN");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("VUI LÒNG CHỌN GIA HẠN HOẶC HỦY GIA HẠN");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("TRƯỚC KHI VÀO BẾN");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(jLabel39))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jLabel42)))
                        .addGap(112, 112, 112)))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addGap(45, 45, 45))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jDialog5Layout = new javax.swing.GroupLayout(jDialog5.getContentPane());
        jDialog5.getContentPane().setLayout(jDialog5Layout);
        jDialog5Layout.setHorizontalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog5Layout.createSequentialGroup()
                .addGroup(jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog5Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog5Layout.setVerticalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jDialog6.setBackground(new java.awt.Color(255, 255, 255));
        jDialog6.setLocation(new java.awt.Point(450, 150));
        jDialog6.setSize(new java.awt.Dimension(390, 350));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(204, 0, 0));
        jLabel43.setText("THANH TOÁN ĐỂ TIẾP TỤC GIA HẠN");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("BIỂN SỐ XE");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("HÌNH THỨC GỬI");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("NGÀY ĐĂNG KÝ");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("NGÀY HẾT HẠN");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("TIỀN");

        jButton_DongYThanhToanGiaHan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_DongYThanhToanGiaHan.setText("ĐỒNG Ý");
        jButton_DongYThanhToanGiaHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DongYThanhToanGiaHanActionPerformed(evt);
            }
        });

        jButton_HuyThanhToanGiaHan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_HuyThanhToanGiaHan.setText("HỦY");
        jButton_HuyThanhToanGiaHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HuyThanhToanGiaHanActionPerformed(evt);
            }
        });

        jLabel_TTGH1.setText("jLabel54");

        jLabel_TTGH2.setText("jLabel55");

        jLabel_TTGH3.setText("jLabel56");

        jLabel_TTGH4.setText("jLabel57");

        jLabel_TTGH5.setText("jLabel58");

        javax.swing.GroupLayout jDialog6Layout = new javax.swing.GroupLayout(jDialog6.getContentPane());
        jDialog6.getContentPane().setLayout(jDialog6Layout);
        jDialog6Layout.setHorizontalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog6Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addGroup(jDialog6Layout.createSequentialGroup()
                        .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addComponent(jLabel53)
                            .addComponent(jLabel48)
                            .addGroup(jDialog6Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton_DongYThanhToanGiaHan)))
                        .addGap(75, 75, 75)
                        .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_TTGH1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_TTGH2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_TTGH3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_TTGH4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_TTGH5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_HuyThanhToanGiaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jDialog6Layout.setVerticalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel43)
                .addGap(26, 26, 26)
                .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel_TTGH1))
                .addGap(18, 18, 18)
                .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel_TTGH2))
                .addGap(18, 18, 18)
                .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jLabel_TTGH3))
                .addGap(18, 18, 18)
                .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel_TTGH4))
                .addGap(18, 18, 18)
                .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jLabel_TTGH5))
                .addGap(28, 28, 28)
                .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_DongYThanhToanGiaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_HuyThanhToanGiaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jDialog7.setBackground(new java.awt.Color(255, 255, 255));
        jDialog7.setLocation(new java.awt.Point(450, 150));
        jDialog7.setSize(new java.awt.Dimension(380, 300));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("VUI LÒNG CHỌN MÃ THẺ MỚI");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 0, 0));
        jLabel56.setText("Vui lòng chọn mã thẻ !");

        jComboBox_maThe2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setText("MÃ THẺ");

        jButton_XacNhanMaTheMoi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_XacNhanMaTheMoi.setText("XÁC NHẬN");
        jButton_XacNhanMaTheMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XacNhanMaTheMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog7Layout = new javax.swing.GroupLayout(jDialog7.getContentPane());
        jDialog7.getContentPane().setLayout(jDialog7Layout);
        jDialog7Layout.setHorizontalGroup(
            jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog7Layout.createSequentialGroup()
                .addGroup(jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog7Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel64)
                        .addGap(18, 18, 18)
                        .addGroup(jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_maThe2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56)))
                    .addGroup(jDialog7Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jButton_XacNhanMaTheMoi))
                    .addGroup(jDialog7Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel30)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jDialog7Layout.setVerticalGroup(
            jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog7Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel30)
                .addGap(61, 61, 61)
                .addGroup(jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(jComboBox_maThe2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel56)
                .addGap(18, 18, 18)
                .addComponent(jButton_XacNhanMaTheMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jDialog8.setBackground(new java.awt.Color(255, 255, 255));
        jDialog8.setMinimumSize(new java.awt.Dimension(380, 350));

        jLabel147.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(153, 0, 0));
        jLabel147.setText("ĐỔI MẬT KHẨU TÀI KHOẢN CÁ NHÂN");

        jLabel149.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel149.setText("NHẬP MẬT KHẨU CŨ");

        jLabel150.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel150.setText("NHẬP MẬT KHẨU MỚI");

        jLabel151.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel151.setText("XÁC NHẬN MẬT KHẨU MỚI");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("ĐỔI");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("HỦY BỎ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog8Layout = new javax.swing.GroupLayout(jDialog8.getContentPane());
        jDialog8.getContentPane().setLayout(jDialog8Layout);
        jDialog8Layout.setHorizontalGroup(
            jDialog8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog8Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jDialog8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel149)
                    .addComponent(jLabel150)
                    .addComponent(jLabel151))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDialog8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField1)
                    .addComponent(jPasswordField2)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addGap(85, 85, 85))
            .addGroup(jDialog8Layout.createSequentialGroup()
                .addGroup(jDialog8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog8Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel147))
                    .addGroup(jDialog8Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jButton3)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jDialog8Layout.setVerticalGroup(
            jDialog8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog8Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel147)
                .addGap(49, 49, 49)
                .addGroup(jDialog8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel149)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jDialog8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel150)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jDialog8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel151)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jDialog8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jDialog9.setBackground(new java.awt.Color(255, 255, 255));
        jDialog9.setSize(new java.awt.Dimension(450, 200));

        jLabel173.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(153, 0, 0));
        jLabel173.setText("VÌ XE BẠN VẪN CÒN ĐANG TRONG BẾN ");

        jLabel174.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(153, 0, 0));
        jLabel174.setText("BẠN CÓ MUỐN CHUYỄN SANG HÌNH THỨC ĐĂNG KÝ NGÀY");

        jLabel175.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(153, 0, 0));
        jLabel175.setText("HAY BẠN MUỐN XUẤT BẾN ");

        jButton_dkHinhThucNgay.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_dkHinhThucNgay.setText("ĐĂNG KÝ NGÀY");
        jButton_dkHinhThucNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dkHinhThucNgayActionPerformed(evt);
            }
        });

        jButton_xuatBenKhiHuyGiaHan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_xuatBenKhiHuyGiaHan.setText("XUẤT BẾN");
        jButton_xuatBenKhiHuyGiaHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_xuatBenKhiHuyGiaHanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog9Layout = new javax.swing.GroupLayout(jDialog9.getContentPane());
        jDialog9.getContentPane().setLayout(jDialog9Layout);
        jDialog9Layout.setHorizontalGroup(
            jDialog9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog9Layout.createSequentialGroup()
                .addGroup(jDialog9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog9Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel175))
                    .addGroup(jDialog9Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButton_dkHinhThucNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton_xuatBenKhiHuyGiaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog9Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jDialog9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog9Layout.createSequentialGroup()
                        .addComponent(jLabel174)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog9Layout.createSequentialGroup()
                        .addComponent(jLabel173)
                        .addGap(92, 92, 92))))
        );
        jDialog9Layout.setVerticalGroup(
            jDialog9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel173)
                .addGap(18, 18, 18)
                .addComponent(jLabel174)
                .addGap(18, 18, 18)
                .addComponent(jLabel175)
                .addGap(27, 27, 27)
                .addGroup(jDialog9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_dkHinhThucNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_xuatBenKhiHuyGiaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));
        setSize(new java.awt.Dimension(900, 500));

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jPanel6.setBackground(new java.awt.Color(144, 226, 177));

        jTable_DSXDK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BIỂN SỐ", "TÊN XE", "MÀU XE", "LOẠI XE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_DSXDK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_DSXDKMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_DSXDK);

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel89.setText("THÔNG TIN ĐĂNG KÝ");

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel90.setText("CHỨC NĂNG");

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel91.setText("DANH SÁCH XE ĐÃ ĐĂNG KÍ");

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel69.setText("ĐĂNG KÍ HÌNH THỨC GỬI");

        jPanel10.setBackground(new java.awt.Color(144, 226, 177));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(144, 226, 177));

        jButton_GiaHan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_GiaHan.setText("GIA HẠN");
        jButton_GiaHan.setBorder(null);
        jButton_GiaHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GiaHanActionPerformed(evt);
            }
        });

        jButton_HuyGiaHan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_HuyGiaHan.setText("HỦY GIA HẠN");
        jButton_HuyGiaHan.setBorder(null);
        jButton_HuyGiaHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HuyGiaHanActionPerformed(evt);
            }
        });

        jButton_matThe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_matThe.setText("MẤT THẺ");
        jButton_matThe.setBorder(null);
        jButton_matThe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_matTheActionPerformed(evt);
            }
        });

        jButton_XuatBen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_XuatBen.setText("XUẤT BẾN");
        jButton_XuatBen.setBorder(null);
        jButton_XuatBen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XuatBenActionPerformed(evt);
            }
        });

        jButton_VaoBen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_VaoBen.setText("VÀO BẾN");
        jButton_VaoBen.setBorder(null);
        jButton_VaoBen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VaoBenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButton_GiaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jButton_HuyGiaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jButton_matThe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_VaoBen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jButton_XuatBen, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_GiaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_HuyGiaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_matThe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_XuatBen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_VaoBen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(144, 226, 177));

        jTextField_TenXe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField_MauXe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jComboBox_MaThe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel_LoiThe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_LoiThe.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_LoiThe.setText("Vui lòng chọn mã thẻ !");

        jLabel52.setForeground(new java.awt.Color(255, 0, 0));
        jLabel52.setText("*");

        jLabel16.setText("TÊN XE");

        jLabel18.setText("MÀU XE");

        jLabel32.setText("MÃ THẺ");

        jTextFiel_BSX.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextFiel_BSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFiel_BSXMouseClicked(evt);
            }
        });
        jTextFiel_BSX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFiel_BSXKeyTyped(evt);
            }
        });

        jLabel_LoiBSX.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_LoiBSX.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_LoiBSX.setText("Vui lòng nhập biển số xe !");

        jLabel49.setForeground(new java.awt.Color(255, 0, 0));
        jLabel49.setText("*");

        jLabel11.setText("BIỂN SỐ XE");

        jComboBox_LoaiXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel50.setForeground(new java.awt.Color(255, 0, 0));
        jLabel50.setText("*");

        jLabel15.setText("LOẠI XE");

        jLabel_LoiLoaiXe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_LoiLoaiXe.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_LoiLoaiXe.setText("Vui lòng chọn loại xe !");

        jComboBox_HinhThucGui.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel31.setText("HÌNH THỨC GỬI");

        jLabel_LoiHTG.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_LoiHTG.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_LoiHTG.setText("Vui lòng chọn hình thức gửi !");

        jLabel51.setForeground(new java.awt.Color(255, 0, 0));
        jLabel51.setText("*");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_LoiBSX)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jComboBox_LoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jTextFiel_BSX, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel_LoiLoaiXe)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jComboBox_HinhThucGui, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel_LoiHTG))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_MauXe, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_TenXe, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jComboBox_MaThe, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel_LoiThe))))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel11))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFiel_BSX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel49)
                        .addComponent(jLabel16)
                        .addComponent(jTextField_TenXe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel_LoiBSX)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jComboBox_LoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_MauXe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_LoiLoaiXe)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox_HinhThucGui, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_LoiHTG)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox_MaThe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_LoiThe)
                        .addGap(33, 33, 33))))
        );

        jButton_DangKy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_DangKy.setText("ĐĂNG KÍ");
        jButton_DangKy.setBorder(null);
        jButton_DangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DangKyActionPerformed(evt);
            }
        });

        jButton_CapNhatXe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_CapNhatXe.setText("CẬP NHẬT ");
        jButton_CapNhatXe.setBorder(null);
        jButton_CapNhatXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CapNhatXeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton_DangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jButton_CapNhatXe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel91)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1086, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel90))
                            .addComponent(jLabel89))
                        .addGap(39, 39, 39)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel69)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_DangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_CapNhatXe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel91)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );

        jTabbedPane3.addTab(" QUẢN LÝ XE", jPanel6);

        jPanel4.setBackground(new java.awt.Color(144, 226, 177));

        jTable_DSDKHTG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ THẺ", "BIỂN SỐ XE", "HÌNH THỨC GỬI", "NGÀY ĐĂNG KÝ", "NGÀY HẾT HẠN", "TIỀN ĐÃ THU", "TÌNH TRẠNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(jTable_DSDKHTG);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("TÌM KIẾM");

        jLabel20.setText("TÌM KIẾM THEO BIỂN SỐ");

        jTextField_TimKiemTheoBSX1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton_TimKiemTheoBSX1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_TimKiemTheoBSX1.setText("TÌM");
        jButton_TimKiemTheoBSX1.setBorder(null);
        jButton_TimKiemTheoBSX1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemTheoBSX1ActionPerformed(evt);
            }
        });

        jLabel78.setText("TÌM KIẾM THEO NGÀY ĐĂNG KÍ");

        jButton_TimKiemTheoNgayDK.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_TimKiemTheoNgayDK.setText("TÌM");
        jButton_TimKiemTheoNgayDK.setBorder(null);
        jButton_TimKiemTheoNgayDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemTheoNgayDKActionPerformed(evt);
            }
        });

        jLabel85.setText("TÌM KIẾM THEO HÌNH THỨC GỬI");

        jButton_TimKiemTheoHTG.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_TimKiemTheoHTG.setText("TÌM");
        jButton_TimKiemTheoHTG.setBorder(null);
        jButton_TimKiemTheoHTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemTheoHTGActionPerformed(evt);
            }
        });

        jLabel93.setText("ĐẶT LẠI TÌM KIẾM");

        jButton_DatLaiDSDK.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_DatLaiDSDK.setText("ĐẶT LẠI");
        jButton_DatLaiDSDK.setBorder(null);
        jButton_DatLaiDSDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DatLaiDSDKActionPerformed(evt);
            }
        });

        jComboBox_TimKiemTheoHTG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        dateChooserCombo3.setCalendarPreferredSize(new java.awt.Dimension(350, 250));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("DANH SÁCH ĐĂNG KÍ");

        jLabel166.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(0, 0, 255));
        jLabel166.setText("Tổng số xe đang đăng ký:");

        jLabel167.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(51, 0, 255));
        jLabel167.setText("Tổng số xe đang chờ gia hạn:");

        jLabel168.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(255, 0, 0));
        jLabel168.setText(".....");

        jLabel169.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(255, 0, 0));
        jLabel169.setText(".....");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1074, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jLabel166)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel168)
                                .addGap(117, 117, 117))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jTextField_TimKiemTheoBSX1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton_TimKiemTheoBSX1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel20))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel167)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel169)
                                .addGap(18, 18, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel85)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(88, 88, 88)
                                        .addComponent(jButton_TimKiemTheoNgayDK, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                                        .addComponent(jComboBox_TimKiemTheoHTG, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)))
                        .addComponent(jButton_TimKiemTheoHTG, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(265, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_DatLaiDSDK, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(461, 461, 461)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel78)
                                .addComponent(dateChooserCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(575, 575, 575)
                            .addComponent(jLabel93))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel166)
                    .addComponent(jLabel167)
                    .addComponent(jLabel168)
                    .addComponent(jLabel169))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel85, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel78)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooserCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_TimKiemTheoNgayDK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox_TimKiemTheoHTG, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_TimKiemTheoHTG, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_TimKiemTheoBSX1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_TimKiemTheoBSX1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel93)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_DatLaiDSDK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("DANH SÁCH ĐĂNG KÍ", jPanel4);

        jPanel3.setBackground(new java.awt.Color(144, 226, 177));

        jTable_CTRV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "BIỂN SỐ XE", "HÌNH THỨC GỬI", "THỜI GIAN VÀO", "THỜI GIAN RA", "SỐ TIỀN", "ID CA TRỰC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable_CTRV);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("CHỨC NĂNG");

        jLabel10.setText("TÌM KIẾM THEO BIỂN SỐ XE");

        jTextField_TimKiemTheoBSX2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField_TimKiemTheoBSX2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TimKiemTheoBSX2ActionPerformed(evt);
            }
        });

        jButton_TimKiemTheoBSX2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_TimKiemTheoBSX2.setText("TÌM");
        jButton_TimKiemTheoBSX2.setBorder(null);
        jButton_TimKiemTheoBSX2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemTheoBSX2ActionPerformed(evt);
            }
        });

        jButton_DatLaiCTRV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_DatLaiCTRV.setText("ĐẶT LẠI");
        jButton_DatLaiCTRV.setBorder(null);
        jButton_DatLaiCTRV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DatLaiCTRVActionPerformed(evt);
            }
        });

        jLabel28.setText("ĐẶT LẠI TÌM KIẾM");

        jLabel164.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(51, 0, 255));
        jLabel164.setText("Xe trong bến:");

        jlbXeTrongBen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbXeTrongBen.setForeground(new java.awt.Color(255, 0, 0));
        jlbXeTrongBen.setText("...");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1099, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel25)
                                .addGap(461, 461, 461))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jTextField_TimKiemTheoBSX2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton_TimKiemTheoBSX2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(237, 237, 237)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_DatLaiCTRV, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel164)
                                .addGap(18, 18, 18)
                                .addComponent(jlbXeTrongBen, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbXeTrongBen)
                    .addComponent(jLabel164))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel25))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_TimKiemTheoBSX2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_TimKiemTheoBSX2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_DatLaiCTRV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("CHI TIẾT RA VÀO", jPanel3);

        jPanel7.setBackground(new java.awt.Color(144, 226, 177));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("THÔNG TIN THẺ");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 0, 255));
        jLabel22.setText("TỔNG SỐ THẺ");

        jlabelCountIDThe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabelCountIDThe.setForeground(new java.awt.Color(255, 0, 0));
        jlabelCountIDThe.setText("100");

        jButton_DatLaiThe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_DatLaiThe.setText("ĐẶT LẠI");
        jButton_DatLaiThe.setBorder(null);
        jButton_DatLaiThe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DatLaiTheActionPerformed(evt);
            }
        });

        jButton_DSTT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_DSTT.setText("DANH SÁCH THẺ TRỐNG");
        jButton_DSTT.setBorder(null);
        jButton_DSTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DSTTActionPerformed(evt);
            }
        });

        jButton_DSTDD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_DSTDD.setText("DANH SÁCH THẺ ĐANG DÙNG");
        jButton_DSTDD.setBorder(null);
        jButton_DSTDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DSTDDActionPerformed(evt);
            }
        });

        jTable_DSThe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable_DSThe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ THẺ", "BIỂN SỐ", "TRẠNG THÁI", "LOẠI THẺ HIỆN TẠI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable_DSThe);

        jButton_ThemTheMoi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_ThemTheMoi.setText("THÊM");
        jButton_ThemTheMoi.setBorder(null);
        jButton_ThemTheMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemTheMoiActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("DANH SÁCH THẺ");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("THẺ MẤT");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(539, 539, 539)
                        .addComponent(jButton_ThemTheMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel21))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_DSTT, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(jlabelCountIDThe, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(89, 89, 89)
                        .addComponent(jButton_DSTDD, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(jButton_DatLaiThe, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jlabelCountIDThe))
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_DSTDD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_DSTT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_DatLaiThe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_ThemTheMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("QUẢN LÍ THẺ", jPanel7);

        jPanel16.setBackground(new java.awt.Color(144, 226, 177));

        jLabel152.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel152.setText("BẢNG GIÁ ỨNG VỚI LOẠI XE GỬI HIỆN TẠI");

        jPanel_new.setBackground(new java.awt.Color(153, 255, 153));
        jPanel_new.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel_loaiXe2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_loaiXe2.setText("OTO");

        jLabel_loaiXe1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_loaiXe1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_loaiXe1.setText("XE MÁY");

        jTextField_giaLoaiXe2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField_giaLoaiXe2.setText("0");
        jTextField_giaLoaiXe2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField_giaLoaiXe1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField_giaLoaiXe1.setText("0");
        jTextField_giaLoaiXe1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_motor_scooter_96px.png"))); // NOI18N

        jLabel154.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_automobile_96px.png"))); // NOI18N

        jButton_CapNhatLaiGia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_CapNhatLaiGia.setText("CẬP NHẬT");
        jButton_CapNhatLaiGia.setBorder(null);
        jButton_CapNhatLaiGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CapNhatLaiGiaActionPerformed(evt);
            }
        });

        jLabel155.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_money_100px_1.png"))); // NOI18N

        jLabel_loiGiaTien1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_loiGiaTien1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_loiGiaTien1.setText("Vui lòng nhập giá tiền!");

        jLabel_loiGiaTien2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_loiGiaTien2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_loiGiaTien2.setText("Vui lòng nhập giá tiền!");

        jLabel156.setText("Đ");

        jLabel157.setText("Đ");

        jLabel158.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(0, 0, 255));
        jLabel158.setText("GIÁ LOẠI XE");

        jLabel159.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(51, 0, 255));
        jLabel159.setText("TIỀN PHỤ PHÍ TỪ 17h TRỞ ĐI");

        jTextField_tienPhuPhi1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField_tienPhuPhi1.setText("0");
        jTextField_tienPhuPhi1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField_tienPhuPhi2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField_tienPhuPhi2.setText("0");
        jTextField_tienPhuPhi2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel160.setText("Đ");

        jLabel161.setText("Đ");

        jLabel_loiTienPhuPhi1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_loiTienPhuPhi1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_loiTienPhuPhi1.setText("Vui lòng nhập giá tiền!");

        jLabel_loiTienPhuPhi2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_loiTienPhuPhi2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_loiTienPhuPhi2.setText("Vui lòng nhập giá tiền!");

        jLabel165.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(51, 0, 255));
        jLabel165.setText("PHÍ ĐỀN BÙ MẤT THẺ");

        jTextField_phiMatThe2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField_phiMatThe2.setText("0");
        jTextField_phiMatThe2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField_phiMatThe1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField_phiMatThe1.setText("0");
        jTextField_phiMatThe1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel170.setText("Đ");

        jLabel171.setText("Đ");

        jLabel_loiPhiMatThe1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_loiPhiMatThe1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_loiPhiMatThe1.setText("Vui lòng nhập giá tiền!");

        jLabel_loiPhiMatThe2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_loiPhiMatThe2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_loiPhiMatThe2.setText("Vui lòng nhập giá tiền!");

        javax.swing.GroupLayout jPanel_newLayout = new javax.swing.GroupLayout(jPanel_new);
        jPanel_new.setLayout(jPanel_newLayout);
        jPanel_newLayout.setHorizontalGroup(
            jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_newLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_newLayout.createSequentialGroup()
                        .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_newLayout.createSequentialGroup()
                                .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_loiGiaTien1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField_giaLoaiXe1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel_newLayout.createSequentialGroup()
                                        .addGap(256, 256, 256)
                                        .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_loiTienPhuPhi1)
                                            .addComponent(jTextField_tienPhuPhi1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_newLayout.createSequentialGroup()
                                        .addGap(157, 157, 157)
                                        .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel_newLayout.createSequentialGroup()
                                                .addComponent(jTextField_tienPhuPhi2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel161))
                                            .addComponent(jLabel_loiTienPhuPhi2)
                                            .addGroup(jPanel_newLayout.createSequentialGroup()
                                                .addComponent(jTextField_giaLoaiXe2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel160))
                                            .addGroup(jPanel_newLayout.createSequentialGroup()
                                                .addComponent(jTextField_phiMatThe2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel_loiPhiMatThe2)
                                            .addComponent(jLabel_loiGiaTien2)))
                                    .addComponent(jLabel156)))
                            .addComponent(jLabel159)
                            .addGroup(jPanel_newLayout.createSequentialGroup()
                                .addComponent(jLabel165)
                                .addGap(102, 102, 102)
                                .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_loiPhiMatThe1)
                                    .addGroup(jPanel_newLayout.createSequentialGroup()
                                        .addComponent(jTextField_phiMatThe1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel170, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel155)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel_newLayout.createSequentialGroup()
                        .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_newLayout.createSequentialGroup()
                                .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton_CapNhatLaiGia, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_newLayout.createSequentialGroup()
                                        .addComponent(jLabel158)
                                        .addGap(478, 478, 478)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_newLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_newLayout.createSequentialGroup()
                                        .addComponent(jLabel_loaiXe1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(230, 230, 230))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_newLayout.createSequentialGroup()
                                        .addComponent(jLabel153)
                                        .addGap(220, 220, 220)))))
                        .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel154)
                            .addGroup(jPanel_newLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel_loaiXe2)))
                        .addGap(273, 273, 273))))
        );
        jPanel_newLayout.setVerticalGroup(
            jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_newLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel155)
                .addGap(40, 40, 40)
                .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_phiMatThe2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_phiMatThe1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel170, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel165))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_loiPhiMatThe1)
                    .addComponent(jLabel_loiPhiMatThe2))
                .addGap(110, 110, 110))
            .addGroup(jPanel_newLayout.createSequentialGroup()
                .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_newLayout.createSequentialGroup()
                        .addComponent(jLabel153)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_loaiXe1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_giaLoaiXe1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel156)
                            .addComponent(jLabel158))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_loiGiaTien1))
                    .addGroup(jPanel_newLayout.createSequentialGroup()
                        .addComponent(jLabel154)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel_loaiXe2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_giaLoaiXe2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel160))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_loiGiaTien2)))
                .addGap(50, 50, 50)
                .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_tienPhuPhi2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel161)
                    .addComponent(jLabel159)
                    .addComponent(jTextField_tienPhuPhi1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_loiTienPhuPhi2)
                    .addComponent(jLabel_loiTienPhuPhi1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(jButton_CapNhatLaiGia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(543, Short.MAX_VALUE)
                .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(430, 430, 430))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(122, 122, 122)
                    .addComponent(jPanel_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel152)
                .addContainerGap(648, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(111, 111, 111)
                    .addComponent(jPanel_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane3.addTab("QUẢN LÝ GIÁ XE", jPanel16);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1441, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("     XE      ", jPanel2);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 102));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jPanel5.setBackground(new java.awt.Color(144, 226, 177));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("THÔNG TIN NHÂN VIÊN");

        jLabel3.setText("TÊN NHÂN VIÊN");

        jLabel4.setText("CMND");

        jLabel5.setText("GIỚI TÍNH");

        jLabel7.setText("ĐỊA CHỈ");

        jLabel9.setText("SỐ ĐIỆN THOẠI");

        jLabel6.setText("VAI TRÒ");

        jTenNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jCMND.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDiaChi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setText("MÃ NHÂN VIÊN");

        jSDT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTimKiemTheoMaNV1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton_TimKiemTheoMaNV1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_TimKiemTheoMaNV1.setText("TÌM");
        jButton_TimKiemTheoMaNV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemTheoMaNV1ActionPerformed(evt);
            }
        });

        jButton_ThemNV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_ThemNV.setText("THÊM");
        jButton_ThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemNVActionPerformed(evt);
            }
        });

        jButton_XoaNV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_XoaNV.setText("XÓA");
        jButton_XoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaNVActionPerformed(evt);
            }
        });

        jButton_CapNhatNV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_CapNhatNV.setText("CẬP NHẬT");
        jButton_CapNhatNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CapNhatNVActionPerformed(evt);
            }
        });

        jTable_DSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ NHÂN VIÊN", "TÊN NHÂN VIÊN", "CMND", "GIỚI TÍNH", "VAI TRÒ", "ĐỊA CHỈ", "SĐT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_DSNV);

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel74.setText("CHỨC NĂNG");

        jComboBox_GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jComboBox_VaiTro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân viên trông coi" }));

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel82.setText("DANH SÁCH NHÂN VIÊN");

        jLabel97.setText("TÌM KIẾM THEO MÃ NHÂN VIÊN");

        jButton_DatLaiDSNV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_DatLaiDSNV.setText("ĐẶT LẠI");
        jButton_DatLaiDSNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DatLaiDSNVActionPerformed(evt);
            }
        });

        jLabel68.setText("ĐẶT LẠI TÌM KIẾM");

        jLabel_loiMaNV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_loiMaNV.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_loiMaNV.setText("Vui lòng nhập mã nhân viên !");

        jLabel_loiTenNV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_loiTenNV.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_loiTenNV.setText("Vui lòng nhập tên nhân viên  !");

        jLabel_loiCMND.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_loiCMND.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_loiCMND.setText("Vui lòng nhập CMND  !");

        jLabel72.setForeground(new java.awt.Color(255, 0, 0));
        jLabel72.setText("*");

        jLabel73.setForeground(new java.awt.Color(255, 0, 0));
        jLabel73.setText("*");

        jLabel92.setForeground(new java.awt.Color(255, 0, 0));
        jLabel92.setText("*");

        jLabel94.setForeground(new java.awt.Color(255, 0, 0));
        jLabel94.setText("*");

        jLabel98.setForeground(new java.awt.Color(255, 0, 0));
        jLabel98.setText("*");

        jLabel_loiSDT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_loiSDT.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_loiSDT.setText("Vui lòng nhập SĐT  !");

        jLabel172.setForeground(new java.awt.Color(255, 0, 0));
        jLabel172.setText("*");

        jMaNV.setBackground(new java.awt.Color(204, 204, 204));
        jMaNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMaNV.setToolTipText("");
        jMaNV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMaNV.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTimKiemTheoMaNV1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_TimKiemTheoMaNV1)
                .addGap(75, 75, 75)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68)
                    .addComponent(jButton_DatLaiDSNV))
                .addGap(358, 358, 358))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel74))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton_ThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(159, 159, 159)
                                .addComponent(jButton_XoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(149, 149, 149)
                                .addComponent(jButton_CapNhatNV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel_loiCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_loiSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jCMND, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                            .addComponent(jTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                            .addComponent(jComboBox_GioiTinh, 0, 174, Short.MAX_VALUE)
                                            .addComponent(jLabel_loiMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel_loiTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(216, 216, 216)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel7))
                                                .addGap(55, 55, 55))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)))
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                            .addComponent(jComboBox_VaiTro, 0, 155, Short.MAX_VALUE)
                                            .addComponent(jSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel82)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox_VaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72)
                    .addComponent(jLabel98)
                    .addComponent(jLabel2)
                    .addComponent(jMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_loiMaNV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel73)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_loiTenNV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel92)
                    .addComponent(jLabel172))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_loiCMND)
                    .addComponent(jLabel_loiSDT))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel94))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_ThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_XoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_CapNhatNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(jLabel68))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTimKiemTheoMaNV1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_TimKiemTheoMaNV1)
                    .addComponent(jButton_DatLaiDSNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel82)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );

        jTabbedPane2.addTab("QUẢN LÝ NHÂN VIÊN", jPanel5);

        jPanel11.setBackground(new java.awt.Color(144, 226, 177));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel75.setText("THÔNG TIN TÀI KHOẢN");

        jLabel76.setText("TÊN TÀI KHOẢN");

        jLabel77.setText("MẬT KHẨU");

        jLabel79.setText("MÃ NHÂN VIÊN");

        jTenTK.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel81.setText("CHỨC NĂNG");

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel83.setText("DANH SÁCH TÀI KHOẢN");

        jButton_TimKiemTheoMaNV2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_TimKiemTheoMaNV2.setText("TÌM");
        jButton_TimKiemTheoMaNV2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemTheoMaNV2ActionPerformed(evt);
            }
        });

        jButton_ThemTK.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_ThemTK.setText("THÊM");
        jButton_ThemTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemTKActionPerformed(evt);
            }
        });

        jButton_XoaTK.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_XoaTK.setText("XÓA");
        jButton_XoaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaTKActionPerformed(evt);
            }
        });

        jTimKiemTheoMaNV2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTable_DSTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "MÃ NHÂN VIÊN", "TÊN ĐĂNG NHẬP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable_DSTK);

        jLabel96.setText("TÌM KIẾM THEO MÃ NHÂN VIÊN");

        jComboBox_MaNV1.setModel(MANVComboBoxModel());

        jLabel67.setText("ĐẶT LẠI TÌM KIẾM");

        jButton_DatLaiDSTK.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_DatLaiDSTK.setText("ĐẶT LẠI");
        jButton_DatLaiDSTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DatLaiDSTKActionPerformed(evt);
            }
        });

        jLabel_loiTenTK.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_loiTenTK.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_loiTenTK.setText("Vui lòng nhập tên tài khoản  !");

        jLabel_loiMK.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_loiMK.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_loiMK.setText("Vui lòng nhập mật khẩu  !");

        jMatKhau.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel107.setForeground(new java.awt.Color(255, 0, 0));
        jLabel107.setText("*");

        jLabel109.setForeground(new java.awt.Color(255, 0, 0));
        jLabel109.setText("*");

        jLabel117.setForeground(new java.awt.Color(255, 0, 0));
        jLabel117.setText("*");

        jButton_CapNhatTK.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_CapNhatTK.setText("ĐỔI MẬT KHẨU");
        jButton_CapNhatTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CapNhatTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(jLabel79)
                                .addGap(27, 27, 27)
                                .addComponent(jComboBox_MaNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(115, 115, 115))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGap(376, 376, 376)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel96)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jTimKiemTheoMaNV2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton_TimKiemTheoMaNV2)))
                                .addGap(70, 70, 70)))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel77))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jTenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel_loiMK)
                                    .addComponent(jLabel_loiTenTK)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel67)
                                    .addComponent(jButton_DatLaiDSTK))
                                .addGap(156, 156, 156))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jButton_ThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(jButton_XoaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jButton_CapNhatTK)))
                .addGap(0, 363, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75)
                    .addComponent(jLabel83)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel75)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79)
                    .addComponent(jLabel76)
                    .addComponent(jComboBox_MaNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107)
                    .addComponent(jLabel109))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_loiTenTK)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel81)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_ThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_XoaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_CapNhatTK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel77)
                            .addComponent(jMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel117))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_loiMK)))
                .addGap(38, 38, 38)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTimKiemTheoMaNV2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_TimKiemTheoMaNV2)
                    .addComponent(jButton_DatLaiDSTK))
                .addGap(26, 26, 26)
                .addComponent(jLabel83)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("QUẢN LÝ TÀI KHOẢN", jPanel11);

        jPanel12.setBackground(new java.awt.Color(144, 226, 177));

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel84.setText("THÔNG TIN CA TRỰC");

        jLabel80.setText("NGÀY TRỰC");

        jLabel86.setText("CA TRỰC");

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel87.setText("CHỨC NĂNG");

        jButton_TimKiemTheoMaNV3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_TimKiemTheoMaNV3.setText("TÌM");
        jButton_TimKiemTheoMaNV3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemTheoMaNV3ActionPerformed(evt);
            }
        });

        jTimKiemTheoMaNV3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton_ThemCaTruc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_ThemCaTruc.setText("THÊM");
        jButton_ThemCaTruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemCaTrucActionPerformed(evt);
            }
        });

        jButton_XoaCaTruc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_XoaCaTruc.setText("XÓA");
        jButton_XoaCaTruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaCaTrucActionPerformed(evt);
            }
        });

        jButton_CapNhatCaTruc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_CapNhatCaTruc.setText("CẬP NHẬT");
        jButton_CapNhatCaTruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CapNhatCaTrucActionPerformed(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel88.setText("DANH SÁCH CA TRỰC");

        jTable_DSCaTruc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, "", null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID CA TRỰC", "NGÀY TRỰC", "CA TRỰC", "MÃ NHÂN VIÊN", "NHIỆM VỤ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTable_DSCaTruc);

        jLabel95.setText("TÌM KIẾM THEO MÃ NHÂN VIÊN");

        jLabel24.setText("MÃ NHÂN VIÊN");

        jComboBox6.setModel(MANVComboBoxModel());
        jComboBox6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox6ItemStateChanged(evt);
            }
        });

        jLabel66.setText("NHIỆM VỤ");

        jComboBox_NhiemVu.setModel(IDNHIEMVUComboBoxModel());
        jComboBox_NhiemVu.setBorder(null);

        jLabel8.setText("TÌM KIẾM THEO ID CA TRỰC");

        jTextField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton_TimKiemTheoIDCaTruc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_TimKiemTheoIDCaTruc.setText("TÌM");
        jButton_TimKiemTheoIDCaTruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemTheoIDCaTrucActionPerformed(evt);
            }
        });

        jButton_DatLaiDSCT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_DatLaiDSCT.setText("ĐẶT LẠI ");
        jButton_DatLaiDSCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DatLaiDSCTActionPerformed(evt);
            }
        });

        jLabel19.setText("ĐẶT LẠI TÌM KIẾM");

        jComboBox_CaTruc.setModel(CATRUCComboBoxModel());
        jComboBox_CaTruc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_CaTrucItemStateChanged(evt);
            }
        });

        jLabel_loiNgayTruc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_loiNgayTruc.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_loiNgayTruc.setText("Vui lòng nhập ngày trực !");

        jLabel_loiNVu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_loiNVu.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_loiNVu.setText("Vui lòng chọn nhiệm vụ  !");

        jLabel99.setForeground(new java.awt.Color(255, 0, 0));
        jLabel99.setText("*");

        jLabel101.setForeground(new java.awt.Color(255, 0, 0));
        jLabel101.setText("*");

        jLabel103.setForeground(new java.awt.Color(255, 0, 0));
        jLabel103.setText("*");

        jLabel105.setForeground(new java.awt.Color(255, 0, 0));
        jLabel105.setText("*");

        jFormattedTextField_NgayTruc.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    jFormattedTextField_NgayTruc.setCalendarPreferredSize(new java.awt.Dimension(350, 250));
    jFormattedTextField_NgayTruc.addCommitListener(new datechooser.events.CommitListener() {
        public void onCommit(datechooser.events.CommitEvent evt) {
            jFormattedTextField_NgayTrucOnCommit(evt);
        }
    });

    javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
    jPanel12.setLayout(jPanel12Layout);
    jPanel12Layout.setHorizontalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel12Layout.createSequentialGroup()
            .addGap(77, 77, 77)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel88)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 253, Short.MAX_VALUE))
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel84)
                                .addComponent(jLabel87)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addGap(122, 122, 122)
                                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel86)
                                                .addComponent(jLabel80))
                                            .addGap(55, 55, 55)
                                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jComboBox_CaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel_loiNgayTruc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(jFormattedTextField_NgayTruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                            .addComponent(jButton_ThemCaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(88, 88, 88)))
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(61, 61, 61)
                            .addComponent(jButton_XoaCaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGap(126, 126, 126)
                                    .addComponent(jButton_CapNhatCaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGap(105, 105, 105)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(37, 37, 37)
                                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel12Layout.createSequentialGroup()
                                                    .addComponent(jComboBox_NhiemVu, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel_loiNVu, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel24)
                                            .addGap(27, 27, 27)
                                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTimKiemTheoMaNV3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel95))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton_TimKiemTheoMaNV3)
                            .addGap(130, 130, 130)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_TimKiemTheoIDCaTruc))
                                .addComponent(jLabel8))
                            .addGap(102, 102, 102)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_DatLaiDSCT)
                                .addComponent(jLabel19))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );
    jPanel12Layout.setVerticalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel12Layout.createSequentialGroup()
            .addGap(26, 26, 26)
            .addComponent(jLabel84)
            .addGap(17, 17, 17)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(jLabel24)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101)
                    .addComponent(jLabel103))
                .addComponent(jFormattedTextField_NgayTruc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel_loiNgayTruc)
            .addGap(27, 27, 27)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jComboBox_CaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel66)
                .addComponent(jComboBox_NhiemVu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel86)
                .addComponent(jLabel99)
                .addComponent(jLabel105))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel_loiNVu))
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel87)))
            .addGap(14, 14, 14)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton_ThemCaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton_XoaCaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton_CapNhatCaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(31, 31, 31)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel95)
                .addComponent(jLabel8)
                .addComponent(jLabel19))
            .addGap(6, 6, 6)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTimKiemTheoMaNV3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton_TimKiemTheoMaNV3)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton_TimKiemTheoIDCaTruc)
                .addComponent(jButton_DatLaiDSCT))
            .addGap(23, 23, 23)
            .addComponent(jLabel88)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(144, Short.MAX_VALUE))
    );

    jTabbedPane2.addTab("QUẢN LÝ CA TRỰC", jPanel12);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1450, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 753, Short.MAX_VALUE)
    );

    jTabbedPane1.addTab("NHÂN VIÊN", jPanel1);

    jPanel9.setBackground(new java.awt.Color(144, 226, 177));

    jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel29.setText("TỪ NGÀY");

    jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel65.setText("ĐẾN NGÀY");

    jTable_TK.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
        },
        new String [] {
            "BIỂN SỐ XE", "HÌNH THỨC GỬI", "NGÀY ĐĂNG KÍ", "NGÀY KÊT THÚC", "TIỀN"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jScrollPane5.setViewportView(jTable_TK);

    jButton_ThongKe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jButton_ThongKe.setText("THỐNG KÊ");
    jButton_ThongKe.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_ThongKeActionPerformed(evt);
        }
    });

    dateChooserTuNgay.setCalendarPreferredSize(new java.awt.Dimension(350, 250));

    dateChooserDenNgay.setCalendarPreferredSize(new java.awt.Dimension(350, 250));

    jButton_DatLaiThongKe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jButton_DatLaiThongKe.setText("ĐẶT LẠI");
    jButton_DatLaiThongKe.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_DatLaiThongKeActionPerformed(evt);
        }
    });

    jPanel15.setBackground(new java.awt.Color(144, 226, 177));

    jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel57.setText("Ngày");

    jLabel114.setText("Xe Máy");

    jLabel111.setText("0");

    jLabel119.setText("Oto");

    jLabel112.setText("0");

    jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel71.setText("Tháng");

    jLabel113.setText("Xe Máy");

    jLabel115.setText("0");

    jLabel120.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel120.setText("Tổng xe máy:");

    jLabel116.setText("0");

    jLabel118.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel118.setText("TIỀN THU");

    jLabel123.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel123.setText("Thẻ mất");

    jLabel124.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel124.setText("Tiền thẻ mất");

    jLabel126.setText("0");

    jLabel127.setText("0");

    jLabel137.setText("0");

    jLabel138.setText("0");

    jLabel140.setText("Oto");

    jLabel141.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel141.setText("Tổng oto:");

    jLabel142.setText("0");

    jLabel143.setText("0");

    jLabel121.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel121.setText("RA VÀO");

    jLabel131.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel131.setText("Ra");

    jLabel132.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel132.setText("Vào");

    jLabel128.setText("0");

    jLabel129.setText("0");

    jLabel122.setText("Xe Máy");

    jLabel133.setText("Xe Máy");

    jLabel130.setText("0");

    jLabel135.setText("0");

    jLabel134.setText("Oto");

    jLabel136.setText("0");

    jLabel125.setText("Oto");

    jlabelfail.setText("0");

    javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
    jPanel15.setLayout(jPanel15Layout);
    jPanel15Layout.setHorizontalGroup(
        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel15Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel71)
                .addComponent(jLabel57)
                .addComponent(jLabel123)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel124)))
            .addGap(16, 16, 16)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel138, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addComponent(jLabel126, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel127, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel137, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addComponent(jLabel120)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel113)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel114)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(39, 39, 39)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel140, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel119))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel112)
                        .addComponent(jLabel116, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addComponent(jLabel141)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(95, 95, 95)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addComponent(jLabel132)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                            .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addComponent(jLabel131)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel122, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel133, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel130, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addComponent(jLabel135, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(62, 62, 62)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel125)
                        .addComponent(jLabel134))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel136, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addComponent(jlabelfail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(32, 32, 32))
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addComponent(jLabel121)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );
    jPanel15Layout.setVerticalGroup(
        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel15Layout.createSequentialGroup()
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel118)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120)
                    .addComponent(jLabel142)
                    .addComponent(jLabel141)
                    .addComponent(jLabel143)
                    .addComponent(jLabel121)))
            .addGap(17, 17, 17)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel114)
                .addComponent(jLabel111)
                .addComponent(jLabel119)
                .addComponent(jLabel112)
                .addComponent(jLabel57)
                .addComponent(jLabel126)
                .addComponent(jLabel131)
                .addComponent(jLabel128)
                .addComponent(jLabel122)
                .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel125)
                .addComponent(jlabelfail))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(jLabel113)
                    .addComponent(jLabel115)
                    .addComponent(jLabel116)
                    .addComponent(jLabel140)
                    .addComponent(jLabel132)
                    .addComponent(jLabel129)
                    .addComponent(jLabel133)
                    .addComponent(jLabel134)
                    .addComponent(jLabel136)
                    .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel123)
                .addComponent(jLabel137))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel124)
                .addComponent(jLabel138))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel27.setForeground(new java.awt.Color(255, 0, 0));
    jLabel27.setText("TỔNG TIỀN");

    jLabelTongTien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabelTongTien.setText("0");

    jLabel144.setText("Đ");

    jLabel162.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_money_100px_1.png"))); // NOI18N

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel9Layout.createSequentialGroup()
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(376, 376, 376)
                            .addComponent(jLabel65)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(dateChooserDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addGap(176, 176, 176)
                            .addComponent(jLabel29)
                            .addGap(18, 18, 18)
                            .addComponent(dateChooserTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(59, 59, 59)
                    .addComponent(jButton_ThongKe)
                    .addGap(73, 73, 73)
                    .addComponent(jButton_DatLaiThongKe)
                    .addGap(86, 86, 86)
                    .addComponent(jLabel162))
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(115, 115, 115)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1075, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabelTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel144)))))
            .addContainerGap(241, Short.MAX_VALUE))
    );
    jPanel9Layout.setVerticalGroup(
        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel9Layout.createSequentialGroup()
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_DatLaiThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(dateChooserTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel29)
                                    .addGap(10, 10, 10)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dateChooserDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel65)))))
                    .addGap(33, 33, 33))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel162)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel27)
                .addComponent(jLabelTongTien)
                .addComponent(jLabel144))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                    .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(368, 368, 368))
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );

    jTabbedPane1.addTab("THỐNG KÊ", jPanel9);

    labelTenNhanVien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    labelTenNhanVien.setForeground(new java.awt.Color(0, 0, 255));
    labelTenNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_user_32px.png"))); // NOI18N
    labelTenNhanVien.setText(".....................");

    jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel14.setForeground(new java.awt.Color(0, 0, 204));
    jLabel14.setText(".............");

    jButton_DangXuat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jButton_DangXuat.setText("Đăng xuất");
    jButton_DangXuat.setBorder(null);
    jButton_DangXuat.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_DangXuatActionPerformed(evt);
        }
    });

    jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_exit_32px_1.png"))); // NOI18N

    jLabel_ngay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel_ngay.setText("date");

    jLabel_time.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
    jLabel_time.setText("time");

    jLabel139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_timeline_week_24px.png"))); // NOI18N
    jLabel139.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

    jLabel145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_clock_24px.png"))); // NOI18N
    jLabel145.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

    jLabel146.setBackground(new java.awt.Color(204, 255, 204));
    jLabel146.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel146.setForeground(new java.awt.Color(255, 0, 0));

    jLabel148.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel148.setForeground(new java.awt.Color(255, 0, 0));
    jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_nho.png"))); // NOI18N
    jLabel148.setText("QUẢN LÝ BÃI XE HỌC VIỆN CƠ SỞ");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(127, 127, 127)
            .addComponent(jLabel146)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel145)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel_time))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel139)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel_ngay)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelTenNhanVien)
            .addGap(18, 18, 18)
            .addComponent(jLabel14)
            .addGap(56, 56, 56)
            .addComponent(jLabel17)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton_DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(68, 68, 68))
        .addComponent(jTabbedPane1)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel139)
                                .addComponent(jLabel_ngay))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel145)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel_time)
                                    .addGap(4, 4, 4))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel148)
                                .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(labelTenNhanVien)
                            .addComponent(jButton_DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(17, 17, 17)))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, Short.MAX_VALUE)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_HuyTTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HuyTTNActionPerformed
        // TODO add your handling code here:
        jDialog2.dispose();
        the quanLiThe = new the();
        jlbXeTrongBen.setText(String.valueOf(quanLiThe.xeTrongBen()));
        jLabel168.setText(String.valueOf(quanLiThe.xeDangDangKy()));
        jLabel169.setText(String.valueOf(quanLiThe.xeDangChoGiaHan()));
    }//GEN-LAST:event_jButton_HuyTTNActionPerformed

    private void jButton_HuyThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HuyThanhToanActionPerformed
        // TODO add your handling code here:
        jDialog3.dispose();
    }//GEN-LAST:event_jButton_HuyThanhToanActionPerformed

    private void jButton_DongYXoaXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DongYXoaXeActionPerformed
        // TODO add your handling code here:
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        a.xoaGuiXe(bienSoXe);
        a.xoaDangKyHinhThucGui(bienSoXe);
        a.xoaXe(bienSoXe);
        a.layDSXe();
        a.layDSDKHinhThucGui();
        a.layDSGuiXe();
        jTextFiel_BSX.setText("");
        jTextField_MauXe.setText("");
        jTextField_TenXe.setText("");
        a.loadMaThe();
        jComboBox_MaThe.setSelectedItem("");
        jComboBox_LoaiXe.setSelectedItem("");
        jComboBox_HinhThucGui.setSelectedItem("");
        JOptionPane.showMessageDialog(this, "XE ĐÃ BỊ XÓA", "XÓA THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);
        jDialog4.setVisible(false);
    }//GEN-LAST:event_jButton_DongYXoaXeActionPerformed

    private void jButton_HuyXoaXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HuyXoaXeActionPerformed
        // TODO add your handling code here:
        jDialog4.setVisible(false);
    }//GEN-LAST:event_jButton_HuyXoaXeActionPerformed

    private void jButton_DongYThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DongYThanhToanActionPerformed
        // TODO add your handling code here:
        jDialog3.dispose();
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        String tenXe = jTextField_TenXe.getText();
        String mauXe = jTextField_MauXe.getText();
        String tenLoaiXe = (String) jComboBox_LoaiXe.getSelectedItem();
        String idThe = (String) jComboBox_MaThe.getSelectedItem();
        String tenHinhThucGui = (String) jComboBox_HinhThucGui.getSelectedItem();
        String ngayDK = a.luuNgayDK();
        boolean check = a.kiemTraBienSoXe(bienSoXe);
        if (check == false) {  //xe chua dk thi luu, dk roi thi khong luu
            a.luuXe(bienSoXe, tenXe, mauXe, tenLoaiXe);
        }
        JOptionPane.showMessageDialog(this, "Đăng Ký Thành Công!  Mời vào bến", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);
        a.layDSXe();
        String ngayKT = a.luuNgayKT(ngayDK);
        long tienThu = (long) (a.layGiaLoaiXe(tenLoaiXe) * a.layHeSoGui(tenHinhThucGui) * 30);
        String tentinhTrangDV = "KÍCH HOẠT";
        a.luuDKHinhThucGui(bienSoXe, tenHinhThucGui, ngayDK, ngayKT, tienThu, idThe, tentinhTrangDV);
        a.layDSDKHinhThucGui();
        String trangThai = "false";
        a.trangThaiThe(idThe, trangThai);
        //    jButton_DangKy.setEnabled(false);
    }//GEN-LAST:event_jButton_DongYThanhToanActionPerformed

    private void jButton_DongYTTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DongYTTNActionPerformed
        // TODO add your handling code here:
        jDialog2.dispose();
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        String tenLoaiXe = (String) jComboBox_LoaiXe.getSelectedItem();
        String tenHinhThuc = (String) jComboBox_HinhThucGui.getSelectedItem();

        String ngayHienTai = a.luuNgayDK();
        String ngayDK = a.layNgayDK(bienSoXe, ngayHienTai);
        String idDangKy = a.layIDDangKy(bienSoXe, tenHinhThuc, ngayDK);
        String tgVao = a.layTGVao(idDangKy);
        String tgRa = a.luuTime();
        String ngayKT = a.luuNgayDK();
        String idThe = a.layIDThe(bienSoXe, ngayDK);

        //-------------       
        long gia = (long) (a.layGiaLoaiXe(tenLoaiXe));
        float heSoGui = a.layHeSoGui(tenHinhThuc);
        long tienPhuPhi = (long) (a.layTienPhuPhi(tenLoaiXe));
        long tienThanhToan, tienNgayTruoc, tienHomNay;
        long soNgay = a.tinhSoNgayGui(tgVao, tgRa);
        int gio = Integer.valueOf(a.chuyenDinhDang5(tgRa));
        if (soNgay > 0) {
            tienNgayTruoc = (long) (soNgay * (gia + tienPhuPhi));
        } else {
            tienNgayTruoc = 0;
        }
        if (gio >= 17) {
            tienHomNay = gia + tienPhuPhi;
        } else {
            tienHomNay = gia;
        }
        tienThanhToan = (long) ((tienNgayTruoc + tienHomNay) * heSoGui);
        //--------------

        String ngayTruc = a.chuyenDinhDang3(ngayHienTai);
        String gioHienTai = a.chuyenDinhDang4(ngayHienTai);
        String idLoaiCaTruc = a.layIDLoaiCaTruc(gioHienTai);
        String idCaTruc = a.layIDCaTruc(ngayTruc, idLoaiCaTruc);
        if (idCaTruc.equals("-1")) {
            JOptionPane.showMessageDialog(this, "QUẢN LÝ CHƯA PHÂN CÔNG CA TRỰC CHO HÔM NAY! ", "XUẬT BẾN THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            return;
        }
        a.capNhapGuiXe(idDangKy, tgVao, tgRa, tienThanhToan, idCaTruc);
        a.capNhapHinhThucGui(bienSoXe, tenHinhThuc, ngayDK, ngayKT);
        a.layDSDKHinhThucGui();
        a.layDSGuiXe();
        a.layDSXe();
        String tinhTrangThe = "ĐÃ HỦY";
        a.capNhatTinhTrangHTG(tinhTrangThe, bienSoXe, tenHinhThuc, ngayDK);
        a.layDSDKHinhThucGui();
        jTextFiel_BSX.setText("");
        jTextField_MauXe.setText("");
        jTextField_TenXe.setText("");
        //    jComboBox_MaThe.removeAllItems();
        String trangThaiCu = a.layTrangThaiThe(idThe);
        String trangThaiMoi = "";
        if (trangThaiCu == null) {
            trangThaiMoi = null;
        } else {
            trangThaiMoi = "true";
        }
        a.trangThaiThe(idThe, trangThaiMoi);
        a.loadMaThe();
        jComboBox_MaThe.setSelectedIndex(-1);
        jComboBox_LoaiXe.setSelectedIndex(-1);
        jComboBox_HinhThucGui.setSelectedIndex(-1);
        JOptionPane.showMessageDialog(this, "ĐÃ XUẤT BẾN");
        jButton_DangKy.setEnabled(true);
        the quanLiThe = new the();
        jlbXeTrongBen.setText(String.valueOf(quanLiThe.xeTrongBen()));
        jLabel168.setText(String.valueOf(quanLiThe.xeDangDangKy()));
        jLabel169.setText(String.valueOf(quanLiThe.xeDangChoGiaHan()));
    }//GEN-LAST:event_jButton_DongYTTNActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jDialog5.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton_DongYThanhToanGiaHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DongYThanhToanGiaHanActionPerformed
        // TODO add your handling code here:
        jDialog6.dispose();
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        String tenLoaiXe = (String) jComboBox_LoaiXe.getSelectedItem();
        String idThe = (String) jComboBox_MaThe.getSelectedItem();
        String tenHinhThucGui = (String) jComboBox_HinhThucGui.getSelectedItem();
        String ngayHienTai = a.luuNgayDK();
        String ngayDK = a.layNgayDK(bienSoXe, ngayHienTai);
        String ngayKT = a.layNgayKT(bienSoXe, tenHinhThucGui, ngayDK);

        String tenTinhTrangDVMoi = "KÍCH HOẠT";
        String ngayDKMoi = a.tinhNgayDKMoi(ngayKT);
        String ngayKTMoi = a.luuNgayKT(ngayDKMoi);
        long tienThu = (long) (a.layGiaLoaiXe(tenLoaiXe) * a.layHeSoGui(tenHinhThucGui) * 30);
        a.luuDKHinhThucGui(bienSoXe, tenHinhThucGui, ngayDKMoi, ngayKTMoi, tienThu, idThe, tenTinhTrangDVMoi);

        a.capNhatTinhTrangHTG("ĐÃ HỦY", bienSoXe, tenHinhThucGui, ngayDK);
        a.layDSDKHinhThucGui();
        JOptionPane.showMessageDialog(this, "BẠN ĐÃ GIA HẠN THÀNH CÔNG!", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);
        String idDangKy = a.layIDDangKy(bienSoXe, tenHinhThucGui, ngayDK); //idDangKy cu~ de kiem tra xem xe da vao ben hay ra ben
        String layTGVao = a.layTGVao(idDangKy);
        long tien = 0;

        String ngayTruc = a.chuyenDinhDang3(ngayHienTai);
        String gioHienTai = a.chuyenDinhDang4(ngayHienTai);
        String idLoaiCaTruc = a.layIDLoaiCaTruc(gioHienTai);
        String idCaTruc = a.layIDCaTruc(ngayTruc, idLoaiCaTruc);
        String idDangKyMoi = a.layIDDangKy(bienSoXe, tenHinhThucGui, ngayDKMoi);
        String tgRa = null;
        if (!(layTGVao.equals("-1"))) {
            a.luuGuiXe(idDangKyMoi, ngayDKMoi, tgRa, tien, idCaTruc);
            a.layDSGuiXe();
        }
        the quanLiThe = new the();
        jlbXeTrongBen.setText(String.valueOf(quanLiThe.xeTrongBen()));
        jLabel168.setText(String.valueOf(quanLiThe.xeDangDangKy()));
        jLabel169.setText(String.valueOf(quanLiThe.xeDangChoGiaHan()));
    }//GEN-LAST:event_jButton_DongYThanhToanGiaHanActionPerformed

    private void jButton_XacNhanMatTheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XacNhanMatTheActionPerformed
        // TODO add your handling code here:
        jDialog1.setVisible(false);
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        String tenLoaiXe = (String) jComboBox_LoaiXe.getSelectedItem();
        String tenHinhThucGui = (String) jComboBox_HinhThucGui.getSelectedItem();
        String idThe = (String) jComboBox_MaThe.getSelectedItem();
        String ngayHienTai = a.luuNgayDK();
        String ngayDK = a.layNgayDK(bienSoXe, ngayHienTai);
        String idDangKy = a.layIDDangKy(bienSoXe, tenHinhThucGui, ngayDK);
        String ngayMatThe = a.luuNgayDK();
        Long tienMatThe = a.layPhiMatThe(tenLoaiXe);
        a.luuChiTietMatThe(idDangKy, ngayMatThe, tienMatThe);
        a.trangThaiThe(idThe, null);
        JOptionPane.showMessageDialog(this, "Thanh Toán Thành Công!");
        JOptionPane.showMessageDialog(this, "Thẻ " + idThe + " đã bị khóa!", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
        if (tenHinhThucGui.equals("THÁNG")) {
            a.loadMaThe2();
            jDialog7.setVisible(true);
        }


    }//GEN-LAST:event_jButton_XacNhanMatTheActionPerformed

    private void jButton_XacNhanMaTheMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XacNhanMaTheMoiActionPerformed
        // TODO add your handling code here:
        jDialog7.setVisible(false);
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        String tenHinhThucGui = (String) jComboBox_HinhThucGui.getSelectedItem();
        String ngayHienTai = a.luuNgayDK();
        String ngayDK = a.layNgayDK(bienSoXe, ngayHienTai);
        //    String mauXe = jTextField_MauXe.getText();
        String idThe = (String) jComboBox_maThe2.getSelectedItem();
        int ktIDThe = 0;
        if (idThe.equals("")) {
            jLabel_LoiThe.setVisible(true);
            ktIDThe = 1;
        } else {
            jLabel_LoiThe.setVisible(false);
        }
        if (ktIDThe == 0) {
            a.capNhapTheMoi(bienSoXe, tenHinhThucGui, ngayDK, idThe);
            a.trangThaiThe(idThe, "false");
            String idTheMoi = a.layIDThe(bienSoXe, ngayDK);
            jComboBox_HinhThucGui.setSelectedItem(tenHinhThucGui);
            jComboBox_MaThe.removeAllItems();
            jComboBox_MaThe.addItem(idTheMoi); //chu y~~~~~~~~~~
            jComboBox_MaThe.setSelectedItem(idTheMoi);
        }
        the quanLiThe = new the();
        quanLiThe.loadTableThe();
        jlbXeTrongBen.setText(String.valueOf(quanLiThe.xeTrongBen()));
        jLabel168.setText(String.valueOf(quanLiThe.xeDangDangKy()));
        jLabel169.setText(String.valueOf(quanLiThe.xeDangChoGiaHan()));
    }//GEN-LAST:event_jButton_XacNhanMaTheMoiActionPerformed

    private void jButton_DangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DangXuatActionPerformed
        // TODO add your handling code here:
        this.dispose();
        viewLogin login = new viewLogin();
        login.setVisible(true);
        String trangThai = "true";
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "update TAIKHOAN set TRANGTHAI=?";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ps.setString(1, trangThai);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Lỗi trangThaiThe");
        }
    }//GEN-LAST:event_jButton_DangXuatActionPerformed

    private void jButton_DatLaiCTRVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DatLaiCTRVActionPerformed
        // TODO add your handling code here:
        Xe qlx = new Xe();
        qlx.layDSGuiXe();
    }//GEN-LAST:event_jButton_DatLaiCTRVActionPerformed

    private void jButton_TimKiemTheoBSX2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemTheoBSX2ActionPerformed
        // TODO add your handling code here:
        if (jTextField_TimKiemTheoBSX2.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Chưa nhập Biển Số Xe cần tìm kiếm!");
        } else {
            Xe quanLiXe = new Xe();

            DefaultTableModel dtm789 = (DefaultTableModel) jTable_CTRV.getModel();
            dtm789.setNumRows(0);
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select BIENSOXE, TENHINHTHUC, TGVAO, TGRA,SOTIEN,IDCATRUC from DANGKY_HINHTHUCGUI, HINHTHUCGUI, GUIXE where GUIXE.IDDANGKY = DANGKY_HINHTHUCGUI.IDDANGKY and DANGKY_HINHTHUCGUI.IDHINHTHUC = HINHTHUCGUI.IDHINHTHUC and BIENSOXE=?";
            Vector vt;
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, jTextField_TimKiemTheoBSX2.getText());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    vt = new Vector();
                    vt.add(rs.getString(1));
                    vt.add(rs.getString(2));
                    vt.add(quanLiXe.chuyenDinhDang2(rs.getString(3)));
                    vt.add(quanLiXe.chuyenDinhDang2(rs.getString(4)));
                    vt.add(rs.getString(5));
                    vt.add(rs.getString(6));
                    dtm789.addRow(vt);
                }
                jTable_CTRV.setModel(dtm789);
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("Loi layDSGuiXe");
            }
        }
    }//GEN-LAST:event_jButton_TimKiemTheoBSX2ActionPerformed

    private void jButton_ThemTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemTKActionPerformed
        // TODO add your handling code here:
        String maNV = jComboBox_MaNV1.getSelectedItem().toString();
        String tenTK = jTenTK.getText();
        String matKhau = String.valueOf(jMatKhau.getPassword());
        String trangThai = "true";
        String tk = "^[a-z0-9._-]{3,15}$";

        String mk = "^[a-z0-9]{6,18}$";

        int ktTenTK = 0, ktMatKhau = 0;

        if (tenTK.equals("")) {
            jLabel_loiTenTK.setVisible(true);
            ktTenTK = 1;
        } else {
            jLabel_loiTenTK.setVisible(false);
        }
        if (matKhau.equals("")) {
            jLabel_loiMK.setVisible(true);
            ktMatKhau = 1;
        } else {
            jLabel_loiMK.setVisible(false);
        }
        if (!Pattern.compile(tk).matcher(tenTK).matches()) {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập không đúng định dạng! ", "THÊM THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            return;

        } else if (!Pattern.compile(mk).matcher(matKhau).matches()) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không đúng định dạng! ", "THÊM THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (ktTenTK == 0 && ktMatKhau == 0) {
            boolean checkMaNV = kiemTraMaNVTonTai(maNV);
            boolean checkTenTK = kiemTraTenTK(tenTK);
            if (checkMaNV == true) {
                JOptionPane.showMessageDialog(this, "Mã nhân viên này đã có tài khoản! ", "THÊM THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            }
            if (checkTenTK == true) {
                JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại! ", "THÊM THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            }
            if (checkMaNV == false && checkTenTK == false) {
                String maHoaMK = maHoaMatKhau(matKhau);
                DSTaiKhoan DSTK = new DSTaiKhoan(maNV, tenTK, maHoaMK, trangThai);
                DSTaiKhoanModify.insertTblTAIKHOAN(DSTK);
                showDSTaiKhoan();
                JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công!", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);

                jTenTK.setText("");
                jMatKhau.setText("");
                resetCombobox();
            }
        }
    }//GEN-LAST:event_jButton_ThemTKActionPerformed

    private void jButton_XoaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaTKActionPerformed
        // TODO add your handling code here:
        String tenTK = jTenTK.getText();
        String maNV = jComboBox_MaNV1.getSelectedItem().toString();
        the a = new the();
        String maNVLogin = a.layMANVLogin();
        if (maNV.equals(maNVLogin)) {
            JOptionPane.showMessageDialog(rootPane, "Không thể xóa tài khoản chính mình!");
            return;
        }
        int ktTenTk = 0;
        if (tenTK.equals("")) {
            jLabel_loiTenTK.setVisible(true);
            ktTenTk = 1;
        } else {
            jLabel_loiTenTK.setVisible(false);
        }
        if (ktTenTk == 0) {
            boolean checkTenTK = kiemTraTenTK(tenTK);
            if (checkTenTK == false) {
                JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại! ", "XÓA THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            } else {
                int selectedIndex = jTable_DSTK.getSelectedRow();
                if (selectedIndex >= 0) {
                    DSTaiKhoan DSTK = DSTaiKhoanList.get(selectedIndex);
                    int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?");

                    if (option == 0) {

                        DSTaiKhoanModify.deleteTblTAIKHOAN(DSTK);
                        JOptionPane.showMessageDialog(this, "Xóa tài khoản thành công!", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);
                        showDSTaiKhoan();
                        jTenTK.setText("");
                        jMatKhau.setText("");
                        resetCombobox();
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton_XoaTKActionPerformed

    private void jButton_CapNhatTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapNhatTKActionPerformed
        // TODO add your handling code here:
        jDialog8.setVisible(true);
        jDialog8.setLocationRelativeTo(null);

    }//GEN-LAST:event_jButton_CapNhatTKActionPerformed

    private void jButton_TimKiemTheoMaNV2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemTheoMaNV2ActionPerformed
        // TODO add your handling code here:
        if (jTimKiemTheoMaNV2.getText().length() > 0 && jTimKiemTheoMaNV2.getText() != null) {
            String find = jTimKiemTheoMaNV2.getText();
            DSTaiKhoanList = DSTaiKhoanModify.findByMANV(find);

            tableModel3.setRowCount(0);

            DSTaiKhoanList.forEach((dstaikhoan) -> {
                tableModel3.addRow(new Object[]{dstaikhoan.getMANV(), dstaikhoan.getTENDANGNHAP(), dstaikhoan.getHiddenMATKHAU()});
            });
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa nhập mã nhân viên!");
            showDSTaiKhoan();
        }
    }//GEN-LAST:event_jButton_TimKiemTheoMaNV2ActionPerformed

    private void jButton_DatLaiDSTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DatLaiDSTKActionPerformed
        // TODO add your handling code here:
        showDSTaiKhoan();
    }//GEN-LAST:event_jButton_DatLaiDSTKActionPerformed

    private void jButton_DatLaiDSDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DatLaiDSDKActionPerformed
        // TODO add your handling code here:
        Xe qlx = new Xe();
        qlx.layDSDKHinhThucGui();
    }//GEN-LAST:event_jButton_DatLaiDSDKActionPerformed

    private void jButton_TimKiemTheoHTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemTheoHTGActionPerformed
        // TODO add your handling code here:
        if (jComboBox_TimKiemTheoHTG.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn hình thức gửi cần tìm kiếm!");
        } else {
            Xe qlx = new Xe();
            DefaultTableModel dtm6 = (DefaultTableModel) jTable_DSDKHTG.getModel();
            dtm6.setNumRows(0);
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select IDTHE,BIENSOXE,TENHINHTHUC,NGAYDK,NGAYKT,TIENDATHU,TENTINHTRANG from DANGKY_HINHTHUCGUI, HINHTHUCGUI,TINHTRANG_HINHTHUCGUI "
                    + "where DANGKY_HINHTHUCGUI.IDHINHTHUC= HINHTHUCGUI.IDHINHTHUC and DANGKY_HINHTHUCGUI.IDTINHTRANG = TINHTRANG_HINHTHUCGUI.IDTINHTRANG and TENHINHTHUC=?";
            Vector vt;
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, jComboBox_TimKiemTheoHTG.getSelectedItem().toString());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    vt = new Vector();
                    vt.add(rs.getString(1));
                    vt.add(rs.getString(2));
                    vt.add(rs.getString(3));
                    vt.add(qlx.chuyenDinhDang(rs.getString(4)));
                    vt.add(qlx.chuyenDinhDang(rs.getString(5)));
                    vt.add(rs.getString(6));
                    vt.add(rs.getString(7));
                    dtm6.addRow(vt);
                }
                jTable_DSDKHTG.setModel(dtm6);
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("Loi layDSDKHinhThucGui");
            }
        }
    }//GEN-LAST:event_jButton_TimKiemTheoHTGActionPerformed

    private void jButton_TimKiemTheoNgayDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemTheoNgayDKActionPerformed
        // TODO add your handling code here:
        String ngayDK1 = dateChooserCombo3.getText() + " 00:00:00";
        String ngayDK2 = dateChooserCombo3.getText() + " 23:59:00";
        Xe qlx = new Xe();
        DefaultTableModel dtm656 = (DefaultTableModel) jTable_DSDKHTG.getModel();
        dtm656.setNumRows(0);
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "select IDTHE,BIENSOXE,TENHINHTHUC,NGAYDK,NGAYKT,TIENDATHU,TENTINHTRANG from DANGKY_HINHTHUCGUI, HINHTHUCGUI,TINHTRANG_HINHTHUCGUI "
                + "where DANGKY_HINHTHUCGUI.IDHINHTHUC= HINHTHUCGUI.IDHINHTHUC and DANGKY_HINHTHUCGUI.IDTINHTRANG = TINHTRANG_HINHTHUCGUI.IDTINHTRANG and NGAYDK>=? and NGAYDK<=?";
        Vector vt;
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ps.setString(1, ngayDK1);
            ps.setString(2, ngayDK2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(qlx.chuyenDinhDang(rs.getString(4)));
                vt.add(qlx.chuyenDinhDang(rs.getString(5)));
                vt.add(rs.getString(6));
                vt.add(rs.getString(7));
                dtm656.addRow(vt);
            }
            jTable_DSDKHTG.setModel(dtm656);
            rs.close();
            ps.close();
            ketNoi.close();
        } catch (SQLException e) {
            System.out.println("Loi layDSDKHinhThucGui");
        }
    }//GEN-LAST:event_jButton_TimKiemTheoNgayDKActionPerformed

    private void jButton_TimKiemTheoBSX1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemTheoBSX1ActionPerformed
        // TODO add your handling code here:
        if (jTextField_TimKiemTheoBSX1.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Chưa nhập Biển Số Xe cần tìm kiếm!");
        } else {
            Xe qlx = new Xe();
            DefaultTableModel dtm678 = (DefaultTableModel) jTable_DSDKHTG.getModel();
            dtm678.setNumRows(0);
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = "select IDTHE,BIENSOXE,TENHINHTHUC,NGAYDK,NGAYKT,TIENDATHU,TENTINHTRANG from DANGKY_HINHTHUCGUI, HINHTHUCGUI,TINHTRANG_HINHTHUCGUI "
                    + "where DANGKY_HINHTHUCGUI.IDHINHTHUC= HINHTHUCGUI.IDHINHTHUC and DANGKY_HINHTHUCGUI.IDTINHTRANG = TINHTRANG_HINHTHUCGUI.IDTINHTRANG and BIENSOXE=?";
            Vector vt;
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, jTextField_TimKiemTheoBSX1.getText());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    vt = new Vector();
                    vt.add(rs.getString(1));
                    vt.add(rs.getString(2));
                    vt.add(rs.getString(3));
                    vt.add(qlx.chuyenDinhDang(rs.getString(4)));
                    vt.add(qlx.chuyenDinhDang(rs.getString(5)));
                    vt.add(rs.getString(6));
                    vt.add(rs.getString(7));
                    dtm678.addRow(vt);
                }
                jTable_DSDKHTG.setModel(dtm678);
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException e) {
                System.out.println("Loi layDSDKHinhThucGui");
            }
        }
    }//GEN-LAST:event_jButton_TimKiemTheoBSX1ActionPerformed

    private void jButton_DSTDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DSTDDActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtmThe1 = (DefaultTableModel) jTable_DSThe.getModel();
        dtmThe1.setNumRows(0);
        Connection ketNoi = ketNoiSQL.layKetNoi();

        Vector vt;

        try {
            CallableStatement c = ketNoi.prepareCall("{call THONG_KE_THE_False}");
            ResultSet rs = c.executeQuery();
            while (rs.next()) {
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add("ĐANG SỬ DỤNG");
                vt.add(rs.getString(3));
                dtmThe1.addRow(vt);

            }
            jTable_DSThe.setModel(dtmThe1);
            rs.close();
            c.close();
            ketNoi.close();

        } catch (SQLException e) {
            System.out.println("Loi 6048");
        }

    }//GEN-LAST:event_jButton_DSTDDActionPerformed

    private void jButton_DSTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DSTTActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtmThe1 = (DefaultTableModel) jTable_DSThe.getModel();
        dtmThe1.setNumRows(0);
        Connection ketNoi = ketNoiSQL.layKetNoi();

        Vector vt;

        try {
            CallableStatement c = ketNoi.prepareCall("{call THONG_KE_THE_True}");
            ResultSet rs = c.executeQuery();
            while (rs.next()) {
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add("");
                vt.add("TRỐNG");
                vt.add("");
                dtmThe1.addRow(vt);

            }
            jTable_DSThe.setModel(dtmThe1);
            rs.close();
            c.close();
            ketNoi.close();

        } catch (SQLException e) {
            System.out.println("Loi 6071");
        }


    }//GEN-LAST:event_jButton_DSTTActionPerformed

    private void jButton_DatLaiTheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DatLaiTheActionPerformed
        // TODO add your handling code here:
        the qlt = new the();
        qlt.loadTableThe();
    }//GEN-LAST:event_jButton_DatLaiTheActionPerformed

    private void jButton_matTheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_matTheActionPerformed
        // TODO add your handling code here:
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        String tenLoaiXe = (String) jComboBox_LoaiXe.getSelectedItem();
        String tenHinhThucGui = (String) jComboBox_HinhThucGui.getSelectedItem();
        boolean check = a.kiemTraBienSoXe(bienSoXe);
        //    String mauXe = jTextField_MauXe.getText();
        String idThe = (String) jComboBox_MaThe.getSelectedItem();

        int ktBSX = 0, ktHTG = 0, ktTLX = 0, ktIDThe = 0;
        if (bienSoXe.equals("")) {
            jLabel_LoiBSX.setVisible(true);
            ktBSX = 1;
        } else {
            jLabel_LoiBSX.setVisible(false);
        }

        if (tenLoaiXe.equals("")) {
            jLabel_LoiLoaiXe.setVisible(true);
            ktTLX = 1;
        } else {
            jLabel_LoiLoaiXe.setVisible(false);
        }

        if (tenHinhThucGui.equals("")) {
            jLabel_LoiHTG.setVisible(true);
            ktHTG = 1;
        } else {
            jLabel_LoiHTG.setVisible(false);
        }
        if (idThe.equals("")) {
            jLabel_LoiThe.setVisible(true);
            ktIDThe = 1;
        } else {
            jLabel_LoiThe.setVisible(false);
        }
        if (ktBSX == 0 && ktHTG == 0 && ktTLX == 0 && ktIDThe == 0) {
            if (check == true) {
                //============================================
                String ngayHienTai = a.luuNgayDK();
                String ngayDK = a.layNgayDK(bienSoXe, ngayHienTai);
                String tenTinhTrangDV = a.layTenTinhTrangDV(bienSoXe, ngayDK);
                if (tenHinhThucGui.equals("NGÀY") && (tenTinhTrangDV.equals("ĐÃ HỦY") || tenTinhTrangDV.equals("-1"))) {
                    JOptionPane.showMessageDialog(this, "Thao Tác Thất Bại! ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else if (tenHinhThucGui.equals("THÁNG") && (tenTinhTrangDV.equals("ĐÃ HỦY") || tenTinhTrangDV.equals("-1"))) {
                    JOptionPane.showMessageDialog(this, "Thao Tác Thất Bại! ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else {
                    jLabel_MT1.setText(bienSoXe);
                    jLabel_MT2.setText(idThe);
                    String ngayMatThe = a.luuNgayDK();
                    jLabel_MT3.setText(a.chuyenDinhDang(ngayMatThe));
                    Long tienMatThe = a.layPhiMatThe(tenLoaiXe);
                    jLabel_MT4.setText(tienMatThe + " Đ");
                    jDialog1.setVisible(true);
                }
                //============================================
            } else {
                JOptionPane.showMessageDialog(this, "Thao Tác Thất Bại!", "LỖI", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton_matTheActionPerformed

    private void jTextFiel_BSXKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFiel_BSXKeyTyped
        // TODO add your handling code here:
        Xe a = new Xe();
        a.dtm4 = (DefaultTableModel) jTable_DSXDK.getModel();
        a.dtm4.setNumRows(0);
        String s = jTextFiel_BSX.getText();
        s = s + evt.getKeyChar();
        s = s.trim();
        jTextField_MauXe.setText("");
        jTextField_TenXe.setText("");
        a.loadMaThe();
        jComboBox_MaThe.setSelectedItem("");
        jComboBox_LoaiXe.setSelectedItem("");
        jComboBox_HinhThucGui.setSelectedItem("");
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "SELECT BIENSOXE, TENXE, MAUXE, TENLOAIXE from XE, LOAIXE where XE.IDLOAIXE = LOAIXE.IDLOAIXE and BIENSOXE like N'%" + s + "%'";
        Vector vt;
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getString(4));
                a.dtm4.addRow(vt);
            }
            jTable_DSXDK.setModel(a.dtm4);
            rs.close();
            ps.close();
            ketNoi.close();
        } catch (SQLException e) {
            System.out.println("Loi layTimKiemXe");
        }
    }//GEN-LAST:event_jTextFiel_BSXKeyTyped

    private void jButton_CapNhatXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapNhatXeActionPerformed
        // TODO add your handling code here:
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        int ktBSX = 0;
        boolean check = a.kiemTraBienSoXe(bienSoXe);
        if (bienSoXe.equals("")) {
            jLabel_LoiBSX.setVisible(true);
            ktBSX = 1;
        } else {
            jLabel_LoiBSX.setVisible(false);
        }
        if (check == false && ktBSX == 0) {
            JOptionPane.showMessageDialog(this, "Xe này chưa được đăng ký, bạn không thể cập nhập thông tin", "CẬP NHẬP THẤT BẠI", JOptionPane.ERROR_MESSAGE);
        }
        if (check == true && ktBSX == 0) {
            Connection ketNoi = ketNoiSQL.layKetNoi();
            String sql = " update XE set TENXE=?,MAUXE=? where BIENSOXE=? ";
            try {
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, jTextField_TenXe.getText().trim().toUpperCase());
                ps.setString(2, jTextField_MauXe.getText().trim().toUpperCase());
                ps.setString(3, bienSoXe);

                ps.executeUpdate();
                a.layDSXe();
                JOptionPane.showMessageDialog(this, "Cập nhật TÊN XE, MÀU XE thành công!");
            } catch (SQLException e) {
                System.out.println("Loi capNhapThongTinXe");
            }
        }
        the quanLiThe = new the();
        jlbXeTrongBen.setText(String.valueOf(quanLiThe.xeTrongBen()));
    }//GEN-LAST:event_jButton_CapNhatXeActionPerformed

    private void jButton_DangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DangKyActionPerformed
        // TODO add your handling code here:
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        String tenXe = jTextField_TenXe.getText();
        String mauXe = jTextField_MauXe.getText();
        String tenLoaiXe = (String) jComboBox_LoaiXe.getSelectedItem();
        String idThe = (String) jComboBox_MaThe.getSelectedItem();
        String tenHinhThucGui = (String) jComboBox_HinhThucGui.getSelectedItem();

        int ktBSX = 0, ktHTG = 0, ktTLX = 0, ktIDThe = 0;

        if (bienSoXe.equals("")) {
            jLabel_LoiBSX.setVisible(true);
            ktBSX = 1;
        } else {
            jLabel_LoiBSX.setVisible(false);
        }

        if (tenLoaiXe.equals("")) {
            jLabel_LoiLoaiXe.setVisible(true);
            ktTLX = 1;
        } else {
            jLabel_LoiLoaiXe.setVisible(false);
        }

        if (tenHinhThucGui.equals("")) {
            jLabel_LoiHTG.setVisible(true);
            ktHTG = 1;
        } else {
            jLabel_LoiHTG.setVisible(false);
        }

        if (idThe.equals("")) {
            jLabel_LoiThe.setVisible(true);
            ktIDThe = 1;
        } else {
            jLabel_LoiThe.setVisible(false);
        }
        if (ktBSX == 0 && ktHTG == 0 && ktTLX == 0 && ktIDThe == 0) {
            boolean check = a.kiemTraBienSoXe(bienSoXe);
            boolean checkDinhDang = a.ktBienSoXe(bienSoXe, tenLoaiXe);
            if (checkDinhDang == false) {
                JOptionPane.showMessageDialog(this, "BIỂN SỐ XE MÁY CÓ DẠNG: 29-H4-2306 HOẶC 36-G5-123.45, OTO: 30A-123.55", "BIỂN SỐ XE KHÔNG HỢP LỆ!", JOptionPane.WARNING_MESSAGE);
            } else {
                String ngayHienTai = a.luuNgayDK();
                if (check == false) {
                    if (tenHinhThucGui.equals("NGÀY")) {
                        a.luuXe(bienSoXe, tenXe, mauXe, tenLoaiXe);
                        JOptionPane.showMessageDialog(this, "Đăng Ký Thành Công! Mời vào bến", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);
                        a.layDSXe();
                        String ngayKT = null;
                        long tienThu = 0;
                        String trangThai = "false";
                        String tenTinhTrangDV = "KÍCH HOẠT";
                        a.luuDKHinhThucGui(bienSoXe, tenHinhThucGui, ngayHienTai, ngayKT, tienThu, idThe, tenTinhTrangDV);
                        a.layDSDKHinhThucGui();
                        a.trangThaiThe(idThe, trangThai);
                    } else {
                        jLabel_TT1.setText(bienSoXe);
                        jLabel_TT2.setText(tenHinhThucGui);
                        jLabel_TT3.setText(a.chuyenDinhDang(ngayHienTai));
                        String ngayKT = a.luuNgayKT(ngayHienTai);
                        jLabel_TT4.setText(a.chuyenDinhDang(ngayKT));
                        long tien = (long) (a.layGiaLoaiXe(tenLoaiXe) * a.layHeSoGui(tenHinhThucGui) * 30);
                        jLabel_TT5.setText(tien + " Đ");
                        jDialog3.setVisible(true);
                    }
                } else {
                    String ngayDK = a.layNgayDK(bienSoXe, ngayHienTai);
                    String ktNgayKT = a.layNgayKT(bienSoXe, tenHinhThucGui, ngayDK);
                    //    String ngayCuoiGiaHan = a.timNgayCuoiGiaHan(ktNgayKT);
                    String tenTinhTrangDV = a.layTenTinhTrangDV(bienSoXe, ngayDK);
                    if (tenHinhThucGui.equals("NGÀY") && tenTinhTrangDV.equals("ĐÃ HỦY")) {
                        JOptionPane.showMessageDialog(this, "Đăng Ký Thành Công! Mời vào bến", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);
                        a.layDSXe();
                        String ngayKT = null;
                        long tienThu = 0;
                        String trangThai = "false";
                        String tenTinhTrangDVMoi = "KÍCH HOẠT";
                        a.luuDKHinhThucGui(bienSoXe, tenHinhThucGui, ngayHienTai, ngayKT, tienThu, idThe, tenTinhTrangDVMoi);
                        a.layDSDKHinhThucGui();
                        a.trangThaiThe(idThe, trangThai);
                    } else if (tenHinhThucGui.equals("THÁNG") && tenTinhTrangDV.equals("CHỜ GIA HẠN")) {
                        JOptionPane.showMessageDialog(this, "Vui lòng chọn gia hạn hoặc hủy gia hạn trước khi đăng ký", "ĐĂNG KÝ THẤT BẠI", JOptionPane.ERROR_MESSAGE);
                    } else if (tenHinhThucGui.equals("THÁNG") && tenTinhTrangDV.equals("ĐÃ HỦY")) {
                        jLabel_TT1.setText(bienSoXe);
                        jLabel_TT2.setText(tenHinhThucGui);
                        jLabel_TT3.setText(a.chuyenDinhDang(ngayHienTai));
                        String ngayKT = a.luuNgayKT(ngayHienTai);
                        jLabel_TT4.setText(a.chuyenDinhDang(ngayKT));
                        long tien = (long) (a.layGiaLoaiXe(tenLoaiXe) * a.layHeSoGui(tenHinhThucGui) * 30);
                        jLabel_TT5.setText(tien + " Đ");
                        jDialog3.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Xe đã đăng ký hình thức gửi và vẫn còn hiệu lực", "ĐĂNG KÝ THẤT BẠI", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        the quanLiThe = new the();
        jlbXeTrongBen.setText(String.valueOf(quanLiThe.xeTrongBen()));
        jLabel168.setText(String.valueOf(quanLiThe.xeDangDangKy()));
        jLabel169.setText(String.valueOf(quanLiThe.xeDangChoGiaHan()));
    }//GEN-LAST:event_jButton_DangKyActionPerformed

    private void jButton_HuyGiaHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HuyGiaHanActionPerformed
        // TODO add your handling code here:
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        String tenLoaiXe = (String) jComboBox_LoaiXe.getSelectedItem();
        String tenHinhThucGui = (String) jComboBox_HinhThucGui.getSelectedItem();
        boolean check = a.kiemTraBienSoXe(bienSoXe);
        //    String mauXe = jTextField_MauXe.getText();
        String idThe = (String) jComboBox_MaThe.getSelectedItem();

        int ktBSX = 0, ktHTG = 0, ktTLX = 0, ktIDThe = 0;
        if (bienSoXe.equals("")) {
            jLabel_LoiBSX.setVisible(true);
            ktBSX = 1;
        } else {
            jLabel_LoiBSX.setVisible(false);
        }

        if (tenLoaiXe.equals("")) {
            jLabel_LoiLoaiXe.setVisible(true);
            ktTLX = 1;
        } else {
            jLabel_LoiLoaiXe.setVisible(false);
        }

        if (tenHinhThucGui.equals("")) {
            jLabel_LoiHTG.setVisible(true);
            ktHTG = 1;
        } else {
            jLabel_LoiHTG.setVisible(false);
        }
        if (idThe.equals("")) {
            jLabel_LoiThe.setVisible(true);
            ktIDThe = 1;
        } else {
            jLabel_LoiThe.setVisible(false);
        }
        if (ktBSX == 0 && ktHTG == 0 && ktTLX == 0 && ktIDThe == 0) {
            String ngayHienTai = a.luuNgayDK();
            String ngayTruc = a.chuyenDinhDang3(ngayHienTai);
            String gioHienTai = a.chuyenDinhDang4(ngayHienTai);
            String idLoaiCaTruc = a.layIDLoaiCaTruc(gioHienTai);
            String idCaTruc = a.layIDCaTruc(ngayTruc, idLoaiCaTruc);
            if (idCaTruc.equals("-1")) {
                JOptionPane.showMessageDialog(this, "QUẢN LÝ CHƯA PHÂN CÔNG CA TRỰC CHO HÔM NAY! ", "HỦY GIA HẠN THẤT BẠI", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (check == true) {
                // String ngayHienTai = a.luuNgayDK();
                String ngayDK = a.layNgayDK(bienSoXe, ngayHienTai);
                String ngayKT = a.layNgayKT(bienSoXe, tenHinhThucGui, ngayDK);
                String tenTinhTrangDV = a.layTenTinhTrangDV(bienSoXe, ngayDK);
                String idDangKy = a.layIDDangKy(bienSoXe, tenHinhThucGui, ngayDK); //idDangKy cu~ de kiem tra xem xe da vao ben hay ra ben
                String layTGVao = a.layTGVao(idDangKy);
                String tinhTrangMoi = "ĐÃ HỦY";
                if (tenHinhThucGui.equals("THÁNG") && tenTinhTrangDV.equals("CHỜ GIA HẠN")) {
                    if (layTGVao.equals("-1")) {
                        a.capNhatTinhTrangHTG(tinhTrangMoi, bienSoXe, tenHinhThucGui, ngayDK);
                        a.layDSDKHinhThucGui();
                        String trangThaiCu = a.layTrangThaiThe(idThe);
                        String trangThaiMoi = "";
                        if (trangThaiCu == null) {
                            trangThaiMoi = null;
                        } else {
                            trangThaiMoi = "true";
                        }
                        a.trangThaiThe(idThe, trangThaiMoi);
                        jTextFiel_BSX.setText("");
                        jTextField_MauXe.setText("");
                        jTextField_TenXe.setText("");
                        //    jComboBox_MaThe.removeAllItems();
                        a.loadMaThe();
                        jComboBox_MaThe.setSelectedIndex(-1);
                        jComboBox_LoaiXe.setSelectedIndex(-1);
                        jComboBox_HinhThucGui.setSelectedIndex(-1);
                    } else {
                        if (a.soSanhNgay(ngayHienTai, ngayKT) == 0) {
                            jDialog9.setVisible(true);
                            jDialog9.setLocationRelativeTo(null);
                        }
                        if (a.soSanhNgay(ngayHienTai, ngayKT) > 0) {
                            String ngayDKMoi = a.tinhNgayDKMoi(ngayKT); //sd 1 bien lam cho ngayDK lan~ tgVao
                            String tenHinhThucMoi = "NGÀY";
                            String ngayKTMoi = null;
                            String tinhTrangDKMoi = "KÍCH HOẠT";
                            long tien = 0;
                            a.luuDKHinhThucGui(bienSoXe, tenHinhThucMoi, ngayDKMoi, ngayKTMoi, tien, idThe, tinhTrangDKMoi);
                            //cap nhat lai cai the cu la "DA HUY"
                            a.capNhatTinhTrangHTG("ĐÃ HỦY", bienSoXe, tenHinhThucGui, ngayDK);
                            a.layDSDKHinhThucGui();
                            String idDangKyMoi = a.layIDDangKy(bienSoXe, tenHinhThucMoi, ngayDKMoi);
                            a.luuGuiXe(idDangKyMoi, ngayDKMoi, ngayKTMoi, tien, idCaTruc);
                            a.layDSGuiXe();
                        }
                    }
                    JOptionPane.showMessageDialog(this, "BẠN ĐÃ HỦY GIA HẠN THÀNH CÔNG!", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "KHÔNG THỂ HỦY GIA HẠN! ", "LỖI HỦY GIA HẠN", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "KHÔNG THỂ HỦY GIA HẠN! ", "LỖI HỦY GIA HẠN", JOptionPane.WARNING_MESSAGE);
            }
        }

        the quanLiThe = new the();
        jlbXeTrongBen.setText(String.valueOf(quanLiThe.xeTrongBen()));
        jLabel168.setText(String.valueOf(quanLiThe.xeDangDangKy()));
        jLabel169.setText(String.valueOf(quanLiThe.xeDangChoGiaHan()));
    }//GEN-LAST:event_jButton_HuyGiaHanActionPerformed

    private void jButton_GiaHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GiaHanActionPerformed
        // TODO add your handling code here:
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        String tenLoaiXe = (String) jComboBox_LoaiXe.getSelectedItem();
        String tenHinhThucGui = (String) jComboBox_HinhThucGui.getSelectedItem();
        boolean check = a.kiemTraBienSoXe(bienSoXe);
        //String mauXe = jTextField_MauXe.getText();
        String idThe = (String) jComboBox_MaThe.getSelectedItem();

        int ktBSX = 0, ktHTG = 0, ktTLX = 0, ktIDThe = 0;
        if (bienSoXe.equals("")) {
            jLabel_LoiBSX.setVisible(true);
            ktBSX = 1;
        } else {
            jLabel_LoiBSX.setVisible(false);
        }

        if (tenLoaiXe.equals("")) {
            jLabel_LoiLoaiXe.setVisible(true);
            ktTLX = 1;
        } else {
            jLabel_LoiLoaiXe.setVisible(false);
        }

        if (tenHinhThucGui.equals("")) {
            jLabel_LoiHTG.setVisible(true);
            ktHTG = 1;
        } else {
            jLabel_LoiHTG.setVisible(false);
        }
        if (idThe.equals("")) {
            jLabel_LoiThe.setVisible(true);
            ktIDThe = 1;
        } else {
            jLabel_LoiThe.setVisible(false);
        }
        if (ktBSX == 0 && ktHTG == 0 && ktTLX == 0 && ktIDThe == 0) {
            String ngayHienTai = a.luuNgayDK();
            String ngayTruc = a.chuyenDinhDang3(ngayHienTai);
            String gioHienTai = a.chuyenDinhDang4(ngayHienTai);
            String idLoaiCaTruc = a.layIDLoaiCaTruc(gioHienTai);
            String idCaTruc = a.layIDCaTruc(ngayTruc, idLoaiCaTruc);
            if (idCaTruc.equals("-1")) {
                JOptionPane.showMessageDialog(this, "QUẢN LÝ CHƯA PHÂN CÔNG CA TRỰC CHO HÔM NAY! ", "GIA HẠN THẤT BẠI", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (check == true) {
                //   String ngayHienTai = a.luuNgayDK();
                String ngayDK = a.layNgayDK(bienSoXe, ngayHienTai);
                String ngayKT = a.layNgayKT(bienSoXe, tenHinhThucGui, ngayDK);
                String tenTinhTrangDV = a.layTenTinhTrangDV(bienSoXe, ngayDK);

                if (tenHinhThucGui.equals("THÁNG") && tenTinhTrangDV.equals("CHỜ GIA HẠN")) {
                    String ngayDKMoi = a.tinhNgayDKMoi(ngayKT);
                    String ngayKTMoi = a.luuNgayKT(ngayDKMoi);
                    long tienThu = (long) (a.layGiaLoaiXe(tenLoaiXe) * a.layHeSoGui(tenHinhThucGui) * 30);
                    jLabel_TTGH1.setText(bienSoXe);
                    jLabel_TTGH2.setText(tenHinhThucGui);
                    jLabel_TTGH3.setText(a.chuyenDinhDang(ngayDKMoi));
                    jLabel_TTGH4.setText(a.chuyenDinhDang(ngayKTMoi));
                    jLabel_TTGH5.setText(tienThu + " Đ");
                    jDialog6.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "KHÔNG THỂ GIA HẠN! ", "LỖI GIA HẠN", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "KHÔNG THỂ GIA HẠN! ", "LỖI GIA HẠN", JOptionPane.WARNING_MESSAGE);
            }
        }
        the quanLiThe = new the();
        jlbXeTrongBen.setText(String.valueOf(quanLiThe.xeTrongBen()));
        jLabel168.setText(String.valueOf(quanLiThe.xeDangDangKy()));
        jLabel169.setText(String.valueOf(quanLiThe.xeDangChoGiaHan()));
    }//GEN-LAST:event_jButton_GiaHanActionPerformed

    private void jButton_XuatBenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XuatBenActionPerformed
        // TODO add your handling code here:
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        String tenLoaiXe = (String) jComboBox_LoaiXe.getSelectedItem();
        String tenHinhThucGui = (String) jComboBox_HinhThucGui.getSelectedItem();
        boolean check = a.kiemTraBienSoXe(bienSoXe);
        String mauXe = jTextField_MauXe.getText();
        String idThe = (String) jComboBox_MaThe.getSelectedItem();

        int ktBSX = 0, ktHTG = 0, ktTLX = 0, ktIDThe = 0;
        if (bienSoXe.equals("")) {
            jLabel_LoiBSX.setVisible(true);
            ktBSX = 1;
        } else {
            jLabel_LoiBSX.setVisible(false);
        }

        if (tenLoaiXe.equals("")) {
            jLabel_LoiLoaiXe.setVisible(true);
            ktTLX = 1;
        } else {
            jLabel_LoiLoaiXe.setVisible(false);
        }

        if (tenHinhThucGui.equals("")) {
            jLabel_LoiHTG.setVisible(true);
            ktHTG = 1;
        } else {
            jLabel_LoiHTG.setVisible(false);
        }

        if (idThe.equals("")) {
            jLabel_LoiThe.setVisible(true);
            ktIDThe = 1;
        } else {
            jLabel_LoiThe.setVisible(false);
        }
        if (ktBSX == 0 && ktHTG == 0 && ktTLX == 0 && ktIDThe == 0) {
            if (check == false) {
                JOptionPane.showMessageDialog(this, "Vui lòng đăng ký hình thức gửi trước! ", "VÀO BẾN THẤT BẠI", JOptionPane.ERROR_MESSAGE);
            } else {
                String ngayHienTai = a.luuNgayDK();
                String ngayDK = a.layNgayDK(bienSoXe, ngayHienTai);
                String ngayKT = a.layNgayKT(bienSoXe, tenHinhThucGui, ngayDK);
                String tenTinhTrangDV = a.layTenTinhTrangDV(bienSoXe, ngayDK);

                if (tenHinhThucGui.equals("NGÀY") && tenTinhTrangDV.equals("ĐÃ HỦY")) {
                    JOptionPane.showMessageDialog(this, "Vui lòng đăng ký hình thức gửi trước! ", "XUẤT BẾN THẤT BẠI", JOptionPane.ERROR_MESSAGE);

                } else if (tenHinhThucGui.equals("THÁNG") && tenTinhTrangDV.equals("CHỜ GIA HẠN")) {
                    jDialog5.setVisible(true);
                } else if (tenHinhThucGui.equals("THÁNG") && tenTinhTrangDV.equals("ĐÃ HỦY")) {
                    JOptionPane.showMessageDialog(this, "Vui lòng đăng ký hình thức gửi trước! ", "XUẤT BẾN THẤT BẠI", JOptionPane.ERROR_MESSAGE);
                } else {
                    String idDangKy = a.layIDDangKy(bienSoXe, tenHinhThucGui, ngayDK);
                    String layTGVao = a.layTGVao(idDangKy);
                    String tgVao = a.layTGVao(idDangKy);
                    String tgRa = a.luuTime();
                    long tien = 0;
                    if (layTGVao.equals("-1")) { //vi ca tgVao va tgRa deu co' --> nen bh phai vao ben
                        JOptionPane.showMessageDialog(this, "Xe chưa vào bến bạn không thể xuất bến! ", "XUẤT BẾN THẤT BẠI", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (tenHinhThucGui.equals("THÁNG")) {
                            String ngayTruc = a.chuyenDinhDang3(ngayHienTai);
                            String gioHienTai = a.chuyenDinhDang4(ngayHienTai);
                            String idLoaiCaTruc = a.layIDLoaiCaTruc(gioHienTai);
                            String idCaTruc = a.layIDCaTruc(ngayTruc, idLoaiCaTruc);
                            if (idCaTruc.equals("-1")) {
                                JOptionPane.showMessageDialog(this, "QUẢN LÝ CHƯA PHÂN CÔNG CA TRỰC CHO HÔM NAY! ", "XUẤT BẾN THẤT BẠI", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            a.capNhapGuiXe(idDangKy, tgVao, tgRa, tien, idCaTruc);
                            jTextFiel_BSX.setText("");
                            jTextField_MauXe.setText("");
                            jTextField_TenXe.setText("");
                            //    jComboBox_MaThe.removeAllItems();
                            a.loadMaThe();
                            jComboBox_MaThe.setSelectedIndex(-1);
                            jComboBox_LoaiXe.setSelectedIndex(-1);
                            jComboBox_HinhThucGui.setSelectedIndex(-1);
                            a.layDSGuiXe();
                            a.layDSXe();
                            JOptionPane.showMessageDialog(this, "ĐÃ XUẤT BẾN");
                        } else {

                            //-------------       
                            long gia = (long) (a.layGiaLoaiXe(tenLoaiXe));
                            float heSoGui = a.layHeSoGui(tenHinhThucGui);
                            long tienPhuPhi = (long) (a.layTienPhuPhi(tenLoaiXe));
                            long tienThanhToan, tienNgayTruoc, tienHomNay;
                            long soNgay = a.tinhSoNgayGui(tgVao, tgRa);
                            int gio = Integer.valueOf(a.chuyenDinhDang5(tgRa));
                            if (soNgay > 0) {
                                tienNgayTruoc = (long) (soNgay * (gia + tienPhuPhi));
                            } else {
                                tienNgayTruoc = 0;
                            }
                            if (gio >= 17) {
                                tienHomNay = gia + tienPhuPhi;
                            } else {
                                tienHomNay = gia;
                            }
                            tienThanhToan = (long) ((tienNgayTruoc + tienHomNay) * heSoGui);
                            //--------------                            

                            jLabel_TTN1.setText(bienSoXe);
                            jLabel_TTN2.setText(tenHinhThucGui);
                            jLabel_TTN3.setText(a.chuyenDinhDang2(tgVao));
                            jLabel_TTN4.setText(a.chuyenDinhDang2(tgRa));
                            jLabel_TTN5.setText(tienThanhToan + " Đ");
                            jDialog2.setVisible(true);
                            the quanLiThe = new the();
                            jlbXeTrongBen.setText(String.valueOf(quanLiThe.xeTrongBen()));
                        }
                    }
                }
            }
        }
        the quanLiThe = new the();
        jlbXeTrongBen.setText(String.valueOf(quanLiThe.xeTrongBen()));
        jLabel168.setText(String.valueOf(quanLiThe.xeDangDangKy()));
        jLabel169.setText(String.valueOf(quanLiThe.xeDangChoGiaHan()));
    }//GEN-LAST:event_jButton_XuatBenActionPerformed

    private void jButton_VaoBenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VaoBenActionPerformed
        // TODO add your handling code here:
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        String tenLoaiXe = (String) jComboBox_LoaiXe.getSelectedItem();
        String tenHinhThucGui = (String) jComboBox_HinhThucGui.getSelectedItem();
        boolean check = a.kiemTraBienSoXe(bienSoXe);
        String mauXe = jTextField_MauXe.getText();
        String idThe = (String) jComboBox_MaThe.getSelectedItem();

        int ktBSX = 0, ktHTG = 0, ktTLX = 0, ktIDThe = 0;
        if (bienSoXe.equals("")) {
            jLabel_LoiBSX.setVisible(true);
            ktBSX = 1;
        } else {
            jLabel_LoiBSX.setVisible(false);
        }

        if (tenLoaiXe.equals("")) {
            jLabel_LoiLoaiXe.setVisible(true);
            ktTLX = 1;
        } else {
            jLabel_LoiLoaiXe.setVisible(false);
        }

        if (tenHinhThucGui.equals("")) {
            jLabel_LoiHTG.setVisible(true);
            ktHTG = 1;
        } else {
            jLabel_LoiHTG.setVisible(false);
        }

        if (idThe.equals("")) { //tai saooo
            jLabel_LoiThe.setVisible(true);
            ktIDThe = 1;
        } else {
            jLabel_LoiThe.setVisible(false);
        }
        if (ktBSX == 0 && ktHTG == 0 && ktTLX == 0 && ktIDThe == 0) {
            if (check == false) {
                JOptionPane.showMessageDialog(this, "Vui lòng đăng ký hình thức gửi trước! ", "VÀO BẾN THẤT BẠI", JOptionPane.ERROR_MESSAGE);
            } else {
                String ngayHienTai = a.luuNgayDK();
                String ngayDK = a.layNgayDK(bienSoXe, ngayHienTai);
                String tenTinhTrangDV = a.layTenTinhTrangDV(bienSoXe, ngayDK);

                if (tenHinhThucGui.equals("NGÀY") && tenTinhTrangDV.equals("ĐÃ HỦY")) {
                    JOptionPane.showMessageDialog(this, "Vui lòng đăng ký hình thức gửi trước! ", "VÀO BẾN THẤT BẠI", JOptionPane.ERROR_MESSAGE);

                } else if (tenHinhThucGui.equals("THÁNG") && tenTinhTrangDV.equals("CHỜ GIA HẠN")) {
                    jDialog5.setVisible(true);
                } else if (tenHinhThucGui.equals("THÁNG") && tenTinhTrangDV.equals("ĐÃ HỦY")) {
                    JOptionPane.showMessageDialog(this, "Vui lòng đăng ký hình thức gửi trước! ", "VÀO BẾN THẤT BẠI", JOptionPane.ERROR_MESSAGE);
                } else {
                    String idDangKy = a.layIDDangKy(bienSoXe, tenHinhThucGui, ngayDK);
                    String layTGVao = a.layTGVao(idDangKy);
                    if (layTGVao.equals("-1")) { //vi ca tgVao va tgRa deu co' --> nen bh phai vao ben                       
                        String tgVao = a.luuTime();
                        String tgRa = null;
                        long soTien = 0;

                        String ngayTruc = a.chuyenDinhDang3(ngayHienTai);
                        String gioHienTai = a.chuyenDinhDang4(ngayHienTai);
                        String idLoaiCaTruc = a.layIDLoaiCaTruc(gioHienTai);
                        String idCaTruc = a.layIDCaTruc(ngayTruc, idLoaiCaTruc);
                        if (idCaTruc.equals("-1")) {
                            JOptionPane.showMessageDialog(this, "QUẢN LÝ CHƯA PHÂN CÔNG CA TRỰC CHO HÔM NAY! ", "VÀO BẾN THẤT BẠI", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        a.luuGuiXe(idDangKy, tgVao, tgRa, soTien, idCaTruc);
                        a.layDSGuiXe();
                        JOptionPane.showMessageDialog(this, "ĐÃ VÀO BẾN");
                        jTextFiel_BSX.setText("");
                        jTextField_MauXe.setText("");
                        jTextField_TenXe.setText("");
                        //    jComboBox_MaThe.removeAllItems();
                        a.loadMaThe();
                        jComboBox_MaThe.setSelectedIndex(-1);
                        jComboBox_LoaiXe.setSelectedIndex(-1);
                        jComboBox_HinhThucGui.setSelectedIndex(-1);
                        jComboBox_MaThe.setSelectedIndex(-1);
                    } else {
                        JOptionPane.showMessageDialog(this, "Xe chưa xuất bến bạn khong thể vào bến! ", "VÀO BẾN THẤT BẠI", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        the quanLiThe = new the();
        jlbXeTrongBen.setText(String.valueOf(quanLiThe.xeTrongBen()));
        jLabel168.setText(String.valueOf(quanLiThe.xeDangDangKy()));
        jLabel169.setText(String.valueOf(quanLiThe.xeDangChoGiaHan()));
    }//GEN-LAST:event_jButton_VaoBenActionPerformed

    private void jTable_DSXDKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_DSXDKMouseClicked
        // TODO add your handling code here:
        Xe a = new Xe();
        a.dtm4 = (DefaultTableModel) jTable_DSXDK.getModel();
        int j = jTable_DSXDK.getSelectedRow();
        int i = jTable_DSXDK.convertRowIndexToModel(j); //chú ý

        jTextFiel_BSX.setText((String) a.dtm4.getValueAt(i, 0));
        jTextField_TenXe.setText((String) a.dtm4.getValueAt(i, 1));
        jTextField_MauXe.setText((String) a.dtm4.getValueAt(i, 2));
        jComboBox_LoaiXe.setSelectedItem(a.dtm4.getValueAt(i, 3));
        String ngayHienTai = a.luuNgayDK();
        String bienSoXe = jTextFiel_BSX.getText();
        String ngayDK = a.layNgayDK(bienSoXe, ngayHienTai);
        String tenHinhThucGui = a.layTenHinhThuc(bienSoXe, ngayDK);
        String tenTinhTrangDV = a.layTenTinhTrangDV(bienSoXe, ngayDK);
        if (tenTinhTrangDV.equals("KÍCH HOẠT") || tenTinhTrangDV.equals("CHỜ GIA HẠN")) {
            String idThe = a.layIDThe(bienSoXe, ngayDK);
            jComboBox_HinhThucGui.setSelectedItem(tenHinhThucGui);
            jComboBox_MaThe.removeAllItems();
            jComboBox_MaThe.addItem(idThe); //chu y~~~~~~~~~~
            jComboBox_MaThe.setSelectedItem(idThe);
        } else {
            a.loadMaThe();
            jComboBox_HinhThucGui.setSelectedItem("");
            jComboBox_MaThe.setSelectedItem("");
            //   jButton_DangKy.setEnabled(true);
        }
    }//GEN-LAST:event_jTable_DSXDKMouseClicked

    private void jButton_ThemTheMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemTheMoiActionPerformed
        // TODO add your handling code here:
        String id = "";
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "select count(IDTHE) from the";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int temp = Integer.valueOf(rs.getString(1));
                temp++;
                id = "T" + String.valueOf(temp);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Loi lay count IDThe");
        }
        String sql1 = "INSERT INTO THE VALUES (?,'TRUE')";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql1);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Loi them the");
        }
        the t = new the();
        t.loadTableThe();
        t.countIDThe();
        JOptionPane.showMessageDialog(this, "Đã thêm thẻ!", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton_ThemTheMoiActionPerformed

    private void jButton_DatLaiThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DatLaiThongKeActionPerformed
        // TODO add your handling code here:

        jLabel130.setText("0");
        jLabelTongTien.setText("0");
        jLabel135.setText("0");
        jLabel129.setText("0");
        jLabel111.setText("0");
        jLabel112.setText("0");
        jLabel128.setText("0");
        jLabel115.setText("0");
        jLabel116.setText("0");
        jlabelfail.setText("0");
        jLabel136.setText("0");
        jLabel142.setText("0");
        jLabel143.setText("0");
        jLabel126.setText("0");
        jLabel127.setText("0");
        jLabel137.setText("0");
        jLabel138.setText("0");
        the a = new the();
        a.layDSTK();
    }//GEN-LAST:event_jButton_DatLaiThongKeActionPerformed

    private void jButton_ThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThongKeActionPerformed
        // TODO add your handling code here:
        the qlt = new the();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String tuNgay = sdf1.format(dateChooserTuNgay.getSelectedDate().getTime());
        String denNgay = sdf2.format(dateChooserDenNgay.getSelectedDate().getTime());
        Date bd = new Date();
        Date kt = new Date();
        try {
            bd = sdf1.parse(tuNgay);
            kt = sdf2.parse(denNgay);
            if (bd.compareTo(kt) > 0) {
                JOptionPane.showMessageDialog(this, "Thời gian không hợp lệ");
                return;
            }
        } catch (ParseException ex) {
        }
        //String convert to Int,Long

        String xeNgay = qlt.tk_Xe_Ngay(tuNgay, denNgay);
        String xeThang = qlt.tk_Xe_Thang(tuNgay, denNgay);
        String otoNgay = qlt.tk_Oto_Ngay(tuNgay, denNgay);
        String otoThang = qlt.tk_Oto_Thang(tuNgay, denNgay);
        String xeNgay1, xeThang1, otoNgay1, otoThang1;
        long xeNgay2, xeThang2, otoNgay2, otoThang2;

        if (!"0".equals(xeNgay)) {
            xeNgay1 = xeNgay.substring(0, xeNgay.indexOf("."));
            xeNgay2 = Long.valueOf(xeNgay1);
        } else {
            xeNgay1 = xeNgay;
            xeNgay2 = Long.valueOf(xeNgay);
        }
        if (!"0".equals(xeThang)) {
            xeThang1 = xeThang.substring(0, xeThang.indexOf("."));
            xeThang2 = Long.valueOf(xeThang1);
        } else {
            xeThang1 = xeThang;
            xeThang2 = Long.valueOf(xeThang);
        }
        if (!"0".equals(otoNgay)) {
            otoNgay1 = otoNgay.substring(0, otoNgay.indexOf("."));
            otoNgay2 = Long.valueOf(otoNgay1);
        } else {
            otoNgay1 = otoNgay;
            otoNgay2 = Long.valueOf(otoNgay);
        }
        if (!"0".equals(otoThang)) {
            otoThang1 = otoThang.substring(0, otoThang.indexOf("."));
            otoThang2 = Long.valueOf(otoThang1);
        } else {
            otoThang1 = otoThang;
            otoThang2 = Long.valueOf(otoThang);
        }
        String soTheMat = qlt.demTheMat(tuNgay, denNgay);
        String tienTheMat = qlt.tienTheMat(tuNgay, denNgay);

        String tienTheMat1;
        long tienTheMat2;
        if (!"0".equals(tienTheMat)) {

            tienTheMat1 = tienTheMat.substring(0, tienTheMat.indexOf("."));
            tienTheMat2 = Long.valueOf(tienTheMat1);
        } else {
            tienTheMat1 = tienTheMat;
            tienTheMat2 = Long.valueOf(tienTheMat1);
        }
        //String convert Int,Long
        JOptionPane.showMessageDialog(this, "THỐNG KÊ!");

        //THONG KE TIEN
        jLabel111.setText(xeNgay1);
        jLabel112.setText(otoNgay1);
        jLabel115.setText(xeThang1);
        jLabel116.setText(otoThang1);

        long tienXe = xeNgay2 + xeThang2;
        long tienOto = xeNgay2 + xeThang2;
        long tienNgay = xeNgay2 + otoNgay2;
        long tienThang = xeThang2 + otoThang2;
        long tongTien = tienNgay + tienThang + tienTheMat2;

        jLabelTongTien.setText(String.valueOf(tongTien));
        jLabel138.setText(tienTheMat1);
        jLabel137.setText(soTheMat);
        jLabel126.setText(String.valueOf(tienNgay));
        jLabel127.setText(String.valueOf(tienThang));
        String demXeNgayVao = qlt.tk_count_Xe_Ngay_Vao(tuNgay, denNgay);
        String demXeNgayRa = qlt.tk_count_Xe_Ngay_Ra(tuNgay, denNgay);
        String demXeThangVao = qlt.tk_count_Xe_Thang_Vao(tuNgay, denNgay);
        String demXeThangRa = qlt.tk_count_Xe_Thang_Ra(tuNgay, denNgay);
        String demOtoNgayVao = qlt.tk_count_Oto_Ngay_Vao(tuNgay, denNgay);
        String demOtoNgayRa = qlt.tk_count_Oto_Ngay_Ra(tuNgay, denNgay);
        String demOtoThangVao = qlt.tk_count_Oto_Thang_Vao(tuNgay, denNgay);
        String demOtoThangRa = qlt.tk_count_Oto_Thang_Ra(tuNgay, denNgay);
        int demXeNgayVao1 = Integer.valueOf(demXeNgayVao);
        int demXeNgayRa1 = Integer.valueOf(demXeNgayRa);
        int demXeThangVao1 = Integer.valueOf(demXeThangVao);
        int demXeThangRa1 = Integer.valueOf(demXeThangRa);
        int demOtoNgayVao1 = Integer.valueOf(demOtoNgayVao);
        int demOtoNgayRa1 = Integer.valueOf(demOtoNgayRa);
        int demOtoThangVao1 = Integer.valueOf(demOtoThangVao);
        int demOtoThangRa1 = Integer.valueOf(demOtoThangRa);
        int demOtoRa = demOtoNgayRa1 + demOtoThangRa1;
        int demOtoVao = demOtoNgayVao1 + demOtoThangVao1;
        int demXeRa = demXeNgayRa1 + demXeThangRa1;
        int demXeVao = demXeNgayVao1 + demXeThangVao1;
        int xeVao = demXeVao + demOtoVao;
        int xeRa = demOtoRa + demXeRa;
        jLabel130.setText(String.valueOf(demXeRa));
        jLabel135.setText(String.valueOf(demXeVao));
        jlabelfail.setText(String.valueOf(demOtoRa));
        jLabel136.setText(String.valueOf(demOtoVao));
        jLabel128.setText(String.valueOf(xeRa));
        jLabel129.setText(String.valueOf(xeVao));

        String txn = qlt.tk_count_Xe_Ngay(tuNgay, denNgay);
        String txt = qlt.tk_count_Xe_Thang(tuNgay, denNgay);
        String ton = qlt.tk_count_Oto_Ngay(tuNgay, denNgay);
        String tot = qlt.tk_count_Oto_Thang(tuNgay, denNgay);
        int txn1 = Integer.valueOf(txn);
        int txt1 = Integer.valueOf(txt);
        int ton1 = Integer.valueOf(ton);
        int tot1 = Integer.valueOf(tot);
        int tlx = txn1 + txt1;
        int tlo = ton1 + tot1;
        jLabel142.setText(String.valueOf(tlx));
        jLabel143.setText(String.valueOf(tlo));
        qlt.laySortDSTK(tuNgay, denNgay);
    }//GEN-LAST:event_jButton_ThongKeActionPerformed

    private void jButton_DatLaiDSCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DatLaiDSCTActionPerformed
        // TODO add your handling code here:
        showDSCaTruc();
    }//GEN-LAST:event_jButton_DatLaiDSCTActionPerformed

    private void jButton_TimKiemTheoIDCaTrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemTheoIDCaTrucActionPerformed
        // TODO add your handling code here:
        if (jTextField1.getText().length() > 0 && jTextField1.getText() != null) {
            String find = jTextField1.getText();
            DSCaTrucList = DSCaTrucModify.findByIDCATRUC(find);

            tableModel.setRowCount(0);

            DSCaTrucList.forEach((DSCT) -> {
                tableModel.addRow(new Object[]{DSCT.getIDCATRUC(), DSCT.getNGAYTRUC(), DSCaTrucModify.layTENCATRUCByIDLOAICATRUC(DSCT.getIDLOAICATRUC()), DSCT.getMANV(), DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU())});
            });
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa nhập ID ca trực cần tìm kiếm!");
            showDSCaTruc();
        }
    }//GEN-LAST:event_jButton_TimKiemTheoIDCaTrucActionPerformed

    private void jButton_CapNhatCaTrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapNhatCaTrucActionPerformed
        // TODO add your handling code here:
        int selectedIndex = jTable_DSCaTruc.getSelectedRow();
        String tenCaTruc = jComboBox_CaTruc.getSelectedItem().toString();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String ngayTruc = sdf2.format(jFormattedTextField_NgayTruc.getSelectedDate().getTime());
        boolean checkIDCaTruc = kiemTraIDCaTruc(ngayTruc, tenCaTruc);
        if (checkIDCaTruc == false) {
            JOptionPane.showMessageDialog(this, "Ca trực không tồn tại! ", "XÓA THẤT BẠI", JOptionPane.WARNING_MESSAGE);
        } else {
            if (selectedIndex >= 0) {
                DSCaTruc DSCT = DSCaTrucList.get(selectedIndex);

                int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn cập nhật?");

                if (option == 0) {
                    String IDCATRUC = DSCT.getIDCATRUC();
                    String NGAYTRUC = dateConverterRev(dateConverter2(jFormattedTextField_NgayTruc.getText()));
                    String CATRUC = DSCaTrucModify.layIDLOAICATRUCByTENCATRUC(jComboBox_CaTruc.getSelectedItem().toString());
                    String MANV = jComboBox6.getSelectedItem().toString();
                    String IDNHIEMVU = jComboBox_NhiemVu.getSelectedItem().toString();

                    DSCT = new DSCaTruc(IDCATRUC, NGAYTRUC, CATRUC, MANV, IDNHIEMVU);

                    DSCaTrucModify.updateTblCATRUC(DSCT);
                    DSCaTrucModify.updateIDCATRUC();
                    DSCaTrucModify.updateTblPHANCONG(DSCT);
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);
                    showDSCaTruc();
                    resetCombobox();

                }
            }
        }
    }//GEN-LAST:event_jButton_CapNhatCaTrucActionPerformed

    private void jButton_XoaCaTrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaCaTrucActionPerformed
        // TODO add your handling code here:

        int selectedIndex = jTable_DSCaTruc.getSelectedRow();
        String tenCaTruc = jComboBox_CaTruc.getSelectedItem().toString();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String ngayTruc = sdf2.format(jFormattedTextField_NgayTruc.getSelectedDate().getTime());
        boolean checkIDCaTruc = kiemTraIDCaTruc(ngayTruc, tenCaTruc);
        if (checkIDCaTruc == false) {
            JOptionPane.showMessageDialog(this, "Ca trực không tồn tại! ", "XÓA THẤT BẠI", JOptionPane.WARNING_MESSAGE);
        } else {
            if (selectedIndex >= 0) {
                DSCaTruc DSCT = DSCaTrucList.get(selectedIndex);
                LocalDate parsedDate = LocalDate.parse(dateConverter(DSCT.getNGAYTRUC()), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                if (parsedDate.isAfter(LocalDate.now())) {
                    int option = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn muốn xóa?");

                    if (option == 0) {

                        DSCaTrucModify.deleteTblPHANCONG(DSCT);
                        DSCaTrucModify.deleteTblCATRUC(DSCT);
                        showDSCaTruc();
                        JOptionPane.showMessageDialog(this, "Xóa thành công!", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Bạn không thể xóa ca trực này", "XÓA THẤT BẠI", JOptionPane.WARNING_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_jButton_XoaCaTrucActionPerformed

    private void jButton_ThemCaTrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemCaTrucActionPerformed
        // TODO add your handling code here:
        String caTruc = DSCaTrucModify.layIDLOAICATRUCByTENCATRUC(jComboBox_CaTruc.getSelectedItem().toString());
        String maNV = jComboBox6.getSelectedItem().toString();
        String nhiemVu = "";
        String tenCaTruc = jComboBox_CaTruc.getSelectedItem().toString();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String ktNgayTruc = sdf2.format(jFormattedTextField_NgayTruc.getSelectedDate().getTime());
        boolean checkIDCaTruc = kiemTraIDCaTruc(ktNgayTruc, tenCaTruc);
        the qlt = new the();
        String ktVaiTro = qlt.layIDVAITRO(maNV);

        if (jComboBox_NhiemVu.getSelectedItem() == null) {
            nhiemVu = "";
        } else {
            nhiemVu = jComboBox_NhiemVu.getSelectedItem().toString();
        }

        int ktNhiemVu = 0;

        if (nhiemVu.equals("")) {
            jLabel_loiNVu.setVisible(true);
            ktNhiemVu = 1;
        } else {
            jLabel_loiNVu.setVisible(false);
        }

        LocalDate parsedDate = LocalDate.parse(dateConverter2(jFormattedTextField_NgayTruc.getText()), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        if (!parsedDate.isBefore(LocalDate.now())) {
            if (ktNhiemVu == 0) {
                if (ktVaiTro.equals("0")) {
                    JOptionPane.showMessageDialog(this, "Không thể phân công cho quản lý !", "THẤT BẠI", JOptionPane.WARNING_MESSAGE);
                } else {
                    //cho phép thêm
                    String ngayTruc = dateConverterRev(dateConverter2(jFormattedTextField_NgayTruc.getText()));
                    DSCaTruc DSCT = new DSCaTruc(ngayTruc, caTruc, maNV, nhiemVu);
                    if (DSCaTrucModify.checkInputCaTruc(DSCT) == true) {
                        if (checkIDCaTruc == false) {
                            DSCaTrucModify.insertTblCATRUC(DSCT);
                        }
                        //  DSCaTrucModify.insertTblCATRUC(DSCT);

                        DSCaTrucModify.updateIDCATRUC();

                        String IDCATRUC = DSCaTrucModify.findIDCATRUC(ngayTruc, caTruc);

                        DSCT = new DSCaTruc(IDCATRUC, ngayTruc, caTruc, maNV, nhiemVu);

                        DSCaTrucModify.insertTblPHANCONG(DSCT);
                        showDSCaTruc();
                        JOptionPane.showMessageDialog(this, "Thêm ca trực thành công!", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);

                        resetCombobox();
                    } else {
                        JOptionPane.showMessageDialog(this, "Nhân viên đã đăng kí ca trực này!", "THẤT BẠI", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không thể thêm ca trực vào quá khứ", "THÊM THẤT BẠI", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton_ThemCaTrucActionPerformed

    private void jButton_TimKiemTheoMaNV3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemTheoMaNV3ActionPerformed
        // TODO add your handling code here:

        if (jTimKiemTheoMaNV3.getText().length() > 0 && jTimKiemTheoMaNV3.getText() != null) {
            String find = jTimKiemTheoMaNV3.getText();
            DSCaTrucList = DSCaTrucModify.findByMANV(find);

            tableModel.setRowCount(0);

            DSCaTrucList.forEach((DSCT) -> {
                tableModel.addRow(new Object[]{DSCT.getIDCATRUC(), DSCT.getNGAYTRUC(), DSCaTrucModify.layTENCATRUCByIDLOAICATRUC(DSCT.getIDLOAICATRUC()), DSCT.getMANV(), DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU())});
            });
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa nhập mã nhân viên cần tìm kiếm!");
            showDSCaTruc();
        }
    }//GEN-LAST:event_jButton_TimKiemTheoMaNV3ActionPerformed

    private void jComboBox_CaTrucItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_CaTrucItemStateChanged
        // TODO add your handling code here:
        String b = dateConverter2(jFormattedTextField_NgayTruc.getText());
        b = b.trim();
        String c = (String) jComboBox_CaTruc.getSelectedItem();
        c = c.trim();
        String d = (String) jComboBox6.getSelectedItem();
        d = d.trim();
        int row = chooseIndexByNGAYTRUC(jTable_DSCaTruc.getModel(), b, c, d);
        if (row >= 0) {
            jTable_DSCaTruc.setRowSelectionInterval(row, row);
            selectedRow = jTable_DSCaTruc.getSelectedRow();
            if (selectedRow >= 0) {
                DSCaTruc DSCT = DSCaTrucList.get(selectedRow);
                jComboBox_NhiemVu.setSelectedItem(DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU()));
            }
        } else {
            jTable_DSCaTruc.getSelectionModel().clearSelection();
        }
    }//GEN-LAST:event_jComboBox_CaTrucItemStateChanged

    private void jComboBox6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox6ItemStateChanged
        // TODO add your handling code here:
        String b = dateConverter2(jFormattedTextField_NgayTruc.getText());
        b = b.trim();
        String c = (String) jComboBox_CaTruc.getSelectedItem();
        c = c.trim();
        String d = (String) jComboBox6.getSelectedItem();
        d = d.trim();
        int row = chooseIndexByNGAYTRUC(jTable_DSCaTruc.getModel(), b, c, d);
        if (row >= 0) {
            jTable_DSCaTruc.setRowSelectionInterval(row, row);
            selectedRow = jTable_DSCaTruc.getSelectedRow();
            if (selectedRow >= 0) {
                DSCaTruc DSCT = DSCaTrucList.get(selectedRow);
                jComboBox_NhiemVu.setSelectedItem(DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU()));
            }
        } else {
            jTable_DSCaTruc.getSelectionModel().clearSelection();
        }
    }//GEN-LAST:event_jComboBox6ItemStateChanged

    private void jButton_DatLaiDSNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DatLaiDSNVActionPerformed
        // TODO add your handling code here:
        showDSNhanVien();
    }//GEN-LAST:event_jButton_DatLaiDSNVActionPerformed

    private void jButton_CapNhatNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapNhatNVActionPerformed
        // TODO add your handling code here:
        the a = new the();
        String maNV = jMaNV.getText();
        String maNVLogin = a.layMANVLogin();
        String hoTen = jTenNV.getText();
        String cmnd = jCMND.getText();
        String gioiTinh = jComboBox_GioiTinh.getSelectedItem().toString();
        String diaChi = jDiaChi.getText();
        String sdt = jSDT.getText();
        String vaiTro = jComboBox_VaiTro.getSelectedItem().toString();

        String idVaiTro = a.layIDVAITRO(maNV);
        boolean checkSDT = kiemTraPhone(sdt);
        String checkSDTTonTai = kiemTraSDTTonTai2(sdt);
        boolean checkCMND = kiemTraCMND(cmnd);
        String checkCMNDTonTai = kiemTraCMNDTonTai2(cmnd);

        if (checkSDT == false || checkCMND == false || !(checkSDTTonTai.equals(maNV)) || !(checkCMNDTonTai.equals(maNV))) {
            if (checkSDT == false) {
                JOptionPane.showMessageDialog(this, "SỐ ĐIỆN THOẠI CÓ 10 ĐẾN 11 SỐ BẮT ĐẦU BẰNG SỐ 0! ", "LỖI ĐỊNH DẠNG", JOptionPane.WARNING_MESSAGE);
            }
            if (checkCMND == false) {
                JOptionPane.showMessageDialog(this, "CMND CÓ 9 SỐ! ", "LỖI ĐỊNH DẠNG", JOptionPane.WARNING_MESSAGE);
            }
            if (!(checkSDTTonTai.equals(maNV))) {
                JOptionPane.showMessageDialog(this, "SDT đã bị trùng! ", "CẬP NHẬT THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            }
            if (!(checkCMNDTonTai.equals(maNV))) {
                JOptionPane.showMessageDialog(this, "CMND  đã bị trùng! ", "CẬP NHẬT THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            }
            return;
        }
        if (maNV.equals("") || hoTen.equals("") || cmnd.equals("")) {
            jLabel_loiMaNV.setVisible(true);
            jLabel_loiTenNV.setVisible(true);
            jLabel_loiCMND.setVisible(true);
            jLabel_loiSDT.setVisible(true);
            return;
        }

        if (idVaiTro.equals("1") && jComboBox_VaiTro.getSelectedIndex() == 0) {
            int input = JOptionPane.showConfirmDialog(null,
                    "Bạn có muốn cập nhật vai trò của nhân viên?", "Cảnh báo!", JOptionPane.YES_NO_CANCEL_OPTION);
            if (input == 1 || input == 2) {
                return;
            }
        }
        if (!maNV.equals(maNVLogin) && idVaiTro.equals("0") && jComboBox_VaiTro.getSelectedIndex() == 1) {
            int input = JOptionPane.showConfirmDialog(null,
                    "Bạn có muốn cập nhật vai trò của quản lý khác?", "Cảnh báo!", JOptionPane.YES_NO_CANCEL_OPTION);
            if (input == 1 || input == 2) {
                return;
            }
        }
        if (maNV.equals(maNVLogin)) {
            int ktMaNV = 0;
            if (maNV.equals("")) {
                jLabel_loiMaNV.setVisible(true);
                ktMaNV = 1;
            } else {
                jLabel_loiMaNV.setVisible(false);
            }
            if (ktMaNV == 0) {
                boolean checkMaNV = kiemTraMaNhanVien(maNV);
                if (checkMaNV == false) {
                    JOptionPane.showMessageDialog(this, "Mã nhân viên không tồn tại! ", "CẬP NHẬT THẤT BẠI", JOptionPane.WARNING_MESSAGE);
                } else {
                    //cho cập nhật
                    DSNhanVien DSNV = new DSNhanVien(maNV, chuanHoa(hoTen), cmnd, gioiTinh, "Quản lý", diaChi, sdt);
                    DSNhanVienModify.updateTblNHANVIEN(DSNV);
                    showDSNhanVien();
                    if (jComboBox_VaiTro.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công!");

                    }

                }
            }
            jMaNV.setText("");
            jTenNV.setText("");
            jCMND.setText("");
            jDiaChi.setText("");
            jSDT.setText("");

            if (jComboBox_VaiTro.getSelectedIndex() == 1) {
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công thông tin trừ vai trò quản lý!");
                jComboBox_VaiTro.setSelectedIndex(0);
            }

            return;
        }
        int ktMaNV = 0;
        if (maNV.equals("")) {
            jLabel_loiMaNV.setVisible(true);
            ktMaNV = 1;
        } else {
            jLabel_loiMaNV.setVisible(false);
        }
        if (ktMaNV == 0) {
            boolean checkMaNV = kiemTraMaNhanVien(maNV);
            if (checkMaNV == false) {
                JOptionPane.showMessageDialog(this, "Mã nhân viên không tồn tại! ", "CẬP NHẬT THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            } else {
                //cho cập nhật
                DSNhanVien DSNV = new DSNhanVien(maNV, chuanHoa(hoTen), cmnd, gioiTinh, vaiTro, diaChi, sdt);
                DSNhanVienModify.updateTblNHANVIEN(DSNV);
                showDSNhanVien();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);

                //jMaNV.setText("");
            }
        }
        jMaNV.setText("");
        jTenNV.setText("");
        jCMND.setText("");
        jDiaChi.setText("");
        jSDT.setText("");
        resetCombobox();

    }//GEN-LAST:event_jButton_CapNhatNVActionPerformed

    private void jButton_XoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaNVActionPerformed
        // TODO add your handling code here:

        String maNV = jMaNV.getText();

        String b = jMaNV.getText();
        b = b.trim();

        the a = new the();
        String maNVLogin = a.layMANVLogin();

        int row2 = chooseIndexByMANV(jTable_DSCaTruc.getModel(), b, 3);

        if (row2 >= 0) {
            JOptionPane.showMessageDialog(rootPane, "Không thể xóa nhân viên đã làm việc!");
            return;
//            DSCaTruc DSCT = DSCaTrucList.get(row2);
//            DSCaTrucModify.deleteTblPHANCONGByMANV(DSCT);
        }

        if (maNV.equals(maNVLogin)) {
            JOptionPane.showMessageDialog(rootPane, "Không thể xóa chính mình!");
            return;
        }
        int ktMaNV = 0;
        if (maNV.equals("")) {
            jLabel_loiMaNV.setVisible(true);
            ktMaNV = 1;
        } else {
            jLabel_loiMaNV.setVisible(false);
        }
        if (ktMaNV == 0) {
            boolean checkMaNV = kiemTraMaNhanVien(maNV);
            if (checkMaNV == false) {
                JOptionPane.showMessageDialog(this, "Mã nhân viên không tồn tại! ", "XÓA THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            } else {
                int selectedIndex = jTable_DSNV.getSelectedRow();
                if (selectedIndex >= 0) {
                    DSNhanVien DSNV = DSNhanVienList.get(selectedIndex);

                    int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?");

                    if (option == 0) {

                        int row = chooseIndexByMANV(jTable_DSTK.getModel(), b, 0);
                        if (row >= 0) {

                            DSTaiKhoan DSTK = DSTaiKhoanList.get(row);
                            DSTaiKhoanModify.deleteTblTAIKHOAN(DSTK);
                        }

                        DSNhanVienModify.deleteTblDSNhanVien(DSNV);
                        showDSNhanVien();
                        showDSCaTruc();
                        showDSTaiKhoan();
                        jMaNV.setText("");
                        jTenNV.setText("");
                        jCMND.setText("");
                        jDiaChi.setText("");
                        jSDT.setText("");
                        resetCombobox();
                        JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công!", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton_XoaNVActionPerformed

    private void jButton_ThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemNVActionPerformed
        // TODO add your handling code here:
        String maNV = "NV" + (timMaNhanVienLonNhat() + 1);
        String hoTen = jTenNV.getText();
        String cmnd = jCMND.getText();
        String gioiTinh = jComboBox_GioiTinh.getSelectedItem().toString();
        String tenVaiTro = jComboBox_VaiTro.getSelectedItem().toString();
        String diaChi = jDiaChi.getText();
        String sdt = jSDT.getText();

        int ktMaNV = 0, ktHoTen = 0, ktCMND = 0, ktSDT = 0;
        if (maNV.equals("")) {
            jLabel_loiMaNV.setVisible(true);
            ktMaNV = 1;
        } else {
            jLabel_loiMaNV.setVisible(false);
        }

        if (hoTen.equals("")) {
            jLabel_loiTenNV.setVisible(true);
            ktHoTen = 1;
        } else {
            jLabel_loiTenNV.setVisible(false);
        }
        if (cmnd.equals("")) {
            jLabel_loiCMND.setVisible(true);
            ktCMND = 1;
        } else {
            jLabel_loiCMND.setVisible(false);
        }
        if (sdt.equals("")) {
            jLabel_loiSDT.setVisible(true);
            ktSDT = 1;
        } else {
            jLabel_loiSDT.setVisible(false);
        }
        if (ktMaNV == 0 && ktHoTen == 0 && ktCMND == 0 && ktSDT == 0) {
            boolean checkSDT = kiemTraPhone(sdt);
            boolean checkSDTTonTai = kiemTraSDTTonTai(sdt);
            boolean checkCMND = kiemTraCMND(cmnd);
            boolean checkCMNDTonTai = kiemTraCMNDTonTai(cmnd);
            boolean checkMaNV = kiemTraMaNhanVien(maNV);

            if (checkSDT == false) {
                JOptionPane.showMessageDialog(this, "SỐ ĐIỆN THOẠI CÓ 10 ĐẾN 11 SỐ BẮT ĐẦU BẰNG SỐ 0! ", "LỖI ĐỊNH DẠNG", JOptionPane.WARNING_MESSAGE);
            }
            if (checkSDTTonTai == true) {
                JOptionPane.showMessageDialog(this, "Số điện thoại đã bị trùng! ", "THÊM THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            }
            if (checkCMND == false) {
                JOptionPane.showMessageDialog(this, "CMND CÓ 9 SỐ! ", "LỖI ĐỊNH DẠNG", JOptionPane.WARNING_MESSAGE);
            }
            if (checkCMNDTonTai == true) {
                JOptionPane.showMessageDialog(this, "CMND đã bị trùng! ", "THÊM THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            }
            if (checkMaNV == true) {
                JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại! ", "THÊM THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            }
            if (checkSDT == true && checkCMND == true && checkSDTTonTai == false && checkCMNDTonTai == false && checkMaNV == false) {
                DSNhanVien DSNV = new DSNhanVien(maNV, chuanHoa(hoTen), cmnd, gioiTinh, tenVaiTro, diaChi, sdt);
                DSNhanVienModify.insertTblNHANVIEN(DSNV);
                showDSNhanVien();
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);

                jMaNV.setText("");
                jTenNV.setText("");
                jCMND.setText("");
                jDiaChi.setText("");
                jSDT.setText("");
                resetCombobox();
            }
        }
    }//GEN-LAST:event_jButton_ThemNVActionPerformed

    private void jButton_TimKiemTheoMaNV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemTheoMaNV1ActionPerformed
        // TODO add your handling code here:
        if (jTimKiemTheoMaNV1.getText().length() > 0 && jTimKiemTheoMaNV1.getText() != null) {
            String find = jTimKiemTheoMaNV1.getText();
            DSNhanVienList = DSNhanVienModify.findByMANV(find);

            tableModel2.setRowCount(0);

            DSNhanVienList.forEach((dsnhanvien) -> {
                tableModel2.addRow(new Object[]{dsnhanvien.getMANV(), dsnhanvien.getHOTEN(), dsnhanvien.getCMND(), dsnhanvien.getGIOITINH(), dsnhanvien.getTENVAITRO(), dsnhanvien.getDIACHI(), dsnhanvien.getSDT()});
            });
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa nhập mã nhân viên!");
            showDSNhanVien();
        }
    }//GEN-LAST:event_jButton_TimKiemTheoMaNV1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtmThe1 = (DefaultTableModel) jTable_DSThe.getModel();
        dtmThe1.setNumRows(0);
        Connection ketNoi = ketNoiSQL.layKetNoi();
        String sql = "select THE.IDTHE,BIENSOXE,TRANGTHAI,TENHINHTHUC\n"
                + "from THE,CHITIET_MATTHE,DANGKY_HINHTHUCGUI,HINHTHUCGUI\n"
                + "where THE.IDTHE=DANGKY_HINHTHUCGUI.IDTHE and CHITIET_MATTHE.IDDANGKY=DANGKY_HINHTHUCGUI.IDDANGKY\n"
                + "    and HINHTHUCGUI.IDHINHTHUC=DANGKY_HINHTHUCGUI.IDHINHTHUC \n"
                + "	and THE.TRANGTHAI IS NULL";
        Vector vt;

        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add("ĐÃ KHÓA");
                vt.add(rs.getString(4));
                dtmThe1.addRow(vt);
            }
            jTable_DSThe.setModel(dtmThe1);
            rs.close();
            ps.close();
            ketNoi.close();
        } catch (SQLException e) {
            System.out.println("Loi layDSThe");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        the t = new the();
        String matKhauCu = String.valueOf(jPasswordField1.getPassword());
        String maHoaMKCu = maHoaMatKhau(matKhauCu);
        String matKhauMoi1 = String.valueOf(jPasswordField2.getPassword());
        String matKhauMoi2 = String.valueOf(jPasswordField3.getPassword());
        String maHoaMKMoi = maHoaMatKhau(matKhauMoi1);
        if (!maHoaMKCu.equals(t.layMatKhauLogin())) {

            JOptionPane.showMessageDialog(this, "Nhập sai mật khẩu hiện tại");
            return;
        } else {
            if (matKhauMoi1.equals("") || matKhauMoi2.equals("")) {
                JOptionPane.showMessageDialog(this, "Không được để trống mật khẩu mới");
            } else if (!matKhauMoi1.equals(matKhauMoi2)) {
                JOptionPane.showMessageDialog(this, "Nhập lại mật khẩu mới sai");
            } else {
                DSTaiKhoan DSTK = new DSTaiKhoan(t.layMANVLogin(), t.layTenDangNhapLogin(), maHoaMKMoi, "false");
                DSTaiKhoanModify.updateTblTAIKHOAN(DSTK);
                JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);
                showDSTaiKhoan();
                jTenTK.setText("");
                jMatKhau.setText("");
                resetCombobox();
            }
        }
        jDialog8.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jDialog8.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jFormattedTextField_NgayTrucOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_jFormattedTextField_NgayTrucOnCommit
        // TODO add your handling code here:
        String b = dateConverter2(jFormattedTextField_NgayTruc.getText());
        b = b.trim();
        String c = (String) jComboBox_CaTruc.getSelectedItem();
        c = c.trim();
        String d = (String) jComboBox6.getSelectedItem();
        d = d.trim();

        int row = chooseIndexByNGAYTRUC(jTable_DSCaTruc.getModel(), b, c, d);
        if (row >= 0) {
            jTable_DSCaTruc.setRowSelectionInterval(row, row);
            selectedRow = jTable_DSCaTruc.getSelectedRow();
            if (selectedRow >= 0) {
                DSCaTruc DSCT = DSCaTrucList.get(selectedRow);
                jComboBox_NhiemVu.setSelectedItem(DSCaTrucModify.layTENNHIEMVUByIDNHIEMVU(DSCT.getIDNHIEMVU()));
            }
        } else {
            jTable_DSCaTruc.getSelectionModel().clearSelection();
        }

    }//GEN-LAST:event_jFormattedTextField_NgayTrucOnCommit

    private void jButton_HuyThanhToanGiaHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HuyThanhToanGiaHanActionPerformed
        // TODO add your handling code here:
        jDialog6.setVisible(false);
    }//GEN-LAST:event_jButton_HuyThanhToanGiaHanActionPerformed

    private void jButton_CapNhatLaiGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapNhatLaiGiaActionPerformed
        // TODO add your handling code here:
        Xe a = new Xe();
        String tenLX1 = jLabel_loaiXe1.getText();
        String tenLX2 = jLabel_loaiXe2.getText();
        String giaTienLoaiXe1 = jTextField_giaLoaiXe1.getText();
        String giaTienLoaiXe2 = jTextField_giaLoaiXe2.getText();
        String giaPhuPhi1 = jTextField_tienPhuPhi1.getText();
        String giaPhuPhi2 = jTextField_tienPhuPhi2.getText();
        String phiMatThe1 = jTextField_phiMatThe1.getText();
        String phiMatThe2 = jTextField_phiMatThe2.getText();

        int ktGiaLX1 = 0, ktGiaLX2 = 0, ktGiaPP1 = 0, ktGiaPP2 = 0, ktPhiMT1 = 0, ktPhiMT2 = 0;
        if (giaTienLoaiXe1.equals("")) {
            jLabel_loiGiaTien1.setVisible(true);
            ktGiaLX1 = 1;
        } else {
            jLabel_loiGiaTien1.setVisible(false);
        }
        if (giaTienLoaiXe2.equals("")) {
            jLabel_loiGiaTien2.setVisible(true);
            ktGiaLX2 = 1;
        } else {
            jLabel_loiGiaTien2.setVisible(false);
        }
        if (giaPhuPhi1.equals("")) {
            jLabel_loiTienPhuPhi1.setVisible(true);
            ktGiaPP1 = 1;
        } else {
            jLabel_loiTienPhuPhi1.setVisible(false);
        }
        if (giaPhuPhi2.equals("")) {
            jLabel_loiTienPhuPhi2.setVisible(true);
            ktGiaPP2 = 1;
        } else {
            jLabel_loiTienPhuPhi2.setVisible(false);
        }
        //---
        if (phiMatThe1.equals("")) {
            jLabel_loiPhiMatThe1.setVisible(true);
            ktPhiMT1 = 1;
        } else {
            jLabel_loiPhiMatThe1.setVisible(false);
        }
        if (phiMatThe2.equals("")) {
            jLabel_loiPhiMatThe2.setVisible(true);
            ktPhiMT2 = 1;
        } else {
            jLabel_loiPhiMatThe2.setVisible(false);
        }
        if (ktGiaLX1 == 0 && ktGiaLX2 == 0 && ktGiaPP1 == 0 && ktGiaPP2 == 0 && ktPhiMT1 == 0 && ktPhiMT2 == 0) {
            a.capNhapGiaLoaiXe(tenLX1, giaTienLoaiXe1, giaPhuPhi1, phiMatThe1);
            a.capNhapGiaLoaiXe(tenLX2, giaTienLoaiXe2, giaPhuPhi2, phiMatThe2);
            JOptionPane.showMessageDialog(this, "Đã cập nhật lại!", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_jButton_CapNhatLaiGiaActionPerformed

    private void jTextFiel_BSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFiel_BSXMouseClicked
        // TODO add your handling code here:
        jLabel_LoiBSX.setVisible(false);
        jLabel_LoiLoaiXe.setVisible(false);
        jLabel_LoiHTG.setVisible(false);
        jLabel_LoiThe.setVisible(false);
    }//GEN-LAST:event_jTextFiel_BSXMouseClicked

    private void jButton_dkHinhThucNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dkHinhThucNgayActionPerformed
        // TODO add your handling code here
        jDialog9.setVisible(false);
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        String tenHinhThucGui = (String) jComboBox_HinhThucGui.getSelectedItem();

        String ngayHienTai = a.luuNgayDK();
        String ngayDK = a.layNgayDK(bienSoXe, ngayHienTai);
        String ngayKT = a.layNgayKT(bienSoXe, tenHinhThucGui, ngayDK);
        String idThe = (String) jComboBox_MaThe.getSelectedItem();

        String ngayDKMoi = a.chuyenDinhDang(ngayKT); //sd 1 bien lam cho ngayDK lan~ tgVao
        String tenHinhThucMoi = "NGÀY";
        String ngayKTMoi = null;
        String tinhTrangDKMoi = "KÍCH HOẠT";
        long tien = 0;
        a.luuDKHinhThucGui(bienSoXe, tenHinhThucMoi, ngayDKMoi, ngayKTMoi, tien, idThe, tinhTrangDKMoi);
        //cap nhat lai cai the cu la "DA HUY"
        a.capNhatTinhTrangHTG("ĐÃ HỦY", bienSoXe, tenHinhThucGui, ngayDK);
        a.layDSDKHinhThucGui();
        String ngayTruc = a.chuyenDinhDang3(ngayHienTai);
        String gioHienTai = a.chuyenDinhDang4(ngayHienTai);
        String idLoaiCaTruc = a.layIDLoaiCaTruc(gioHienTai);
        String idCaTruc = a.layIDCaTruc(ngayTruc, idLoaiCaTruc);
        if (idCaTruc.equals("-1")) {
            JOptionPane.showMessageDialog(this, "QUẢN LÝ CHƯA PHÂN CÔNG CA TRỰC CHO HÔM NAY! ", "THAO TÁC THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String idDangKyMoi = a.layIDDangKy(bienSoXe, tenHinhThucMoi, ngayDKMoi);
        a.luuGuiXe(idDangKyMoi, ngayDKMoi, ngayKTMoi, tien, idCaTruc);
        a.layDSGuiXe();
        JOptionPane.showMessageDialog(this, "Đã chuyễn sang hình thức đăng ký ngày!", "THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton_dkHinhThucNgayActionPerformed

    private void jButton_xuatBenKhiHuyGiaHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_xuatBenKhiHuyGiaHanActionPerformed
        // TODO add your handling code here:
        jDialog9.setVisible(false);
        Xe a = new Xe();
        String bienSoXe = jTextFiel_BSX.getText();
        String tenLoaiXe = (String) jComboBox_LoaiXe.getSelectedItem();
        String tenHinhThuc = (String) jComboBox_HinhThucGui.getSelectedItem();

        String ngayHienTai = a.luuNgayDK();
        String ngayDK = a.layNgayDK(bienSoXe, ngayHienTai);
        String idDangKy = a.layIDDangKy(bienSoXe, tenHinhThuc, ngayDK);
        String tgVao = a.layTGVao(idDangKy);
        String tgRa = a.luuTime();
        String ngayKT = a.luuNgayDK();
        String idThe = a.layIDThe(bienSoXe, ngayDK);

        String ngayTruc = a.chuyenDinhDang3(ngayHienTai);
        String gioHienTai = a.chuyenDinhDang4(ngayHienTai);
        String idLoaiCaTruc = a.layIDLoaiCaTruc(gioHienTai);
        String idCaTruc = a.layIDCaTruc(ngayTruc, idLoaiCaTruc);
        if (idCaTruc.equals("-1")) {
            JOptionPane.showMessageDialog(this, "QUẢN LÝ CHƯA PHÂN CÔNG CA TRỰC CHO HÔM NAY! ", "THAO TÁC THẤT BẠI", JOptionPane.WARNING_MESSAGE);
            return;
        }
        long tien = 0;
        a.capNhapGuiXe(idDangKy, tgVao, tgRa, tien, idCaTruc);
        a.capNhapHinhThucGui(bienSoXe, tenHinhThuc, ngayDK, ngayKT);
        a.layDSDKHinhThucGui();
        a.layDSGuiXe();
        a.layDSXe();
        String tinhTrangThe = "ĐÃ HỦY";
        a.capNhatTinhTrangHTG(tinhTrangThe, bienSoXe, tenHinhThuc, ngayDK);
        a.layDSDKHinhThucGui();
        jTextFiel_BSX.setText("");
        jTextField_MauXe.setText("");
        jTextField_TenXe.setText("");
        //    jComboBox_MaThe.removeAllItems();
        String trangThaiCu = a.layTrangThaiThe(idThe);
        String trangThaiMoi = "";
        if (trangThaiCu == null) {
            trangThaiMoi = null;
        } else {
            trangThaiMoi = "true";
        }
        a.trangThaiThe(idThe, trangThaiMoi);
        a.loadMaThe();
        jComboBox_MaThe.setSelectedIndex(-1);
        jComboBox_LoaiXe.setSelectedIndex(-1);
        jComboBox_HinhThucGui.setSelectedIndex(-1);

        JOptionPane.showMessageDialog(this, "ĐÃ XUẤT BẾN!");
        jButton_DangKy.setEnabled(true);
        the quanLiThe = new the();
        jlbXeTrongBen.setText(String.valueOf(quanLiThe.xeTrongBen()));
        jLabel168.setText(String.valueOf(quanLiThe.xeDangDangKy()));
        jLabel169.setText(String.valueOf(quanLiThe.xeDangChoGiaHan()));
    }//GEN-LAST:event_jButton_xuatBenKhiHuyGiaHanActionPerformed

    private void jTextField_TimKiemTheoBSX2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TimKiemTheoBSX2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TimKiemTheoBSX2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(view.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private datechooser.beans.DateChooserCombo dateChooserCombo3;
    private datechooser.beans.DateChooserCombo dateChooserDenNgay;
    private datechooser.beans.DateChooserCombo dateChooserTuNgay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_CapNhatCaTruc;
    private javax.swing.JButton jButton_CapNhatLaiGia;
    private javax.swing.JButton jButton_CapNhatNV;
    private javax.swing.JButton jButton_CapNhatTK;
    private javax.swing.JButton jButton_CapNhatXe;
    private javax.swing.JButton jButton_DSTDD;
    private javax.swing.JButton jButton_DSTT;
    private javax.swing.JButton jButton_DangKy;
    private javax.swing.JButton jButton_DangXuat;
    private javax.swing.JButton jButton_DatLaiCTRV;
    private javax.swing.JButton jButton_DatLaiDSCT;
    private javax.swing.JButton jButton_DatLaiDSDK;
    private javax.swing.JButton jButton_DatLaiDSNV;
    private javax.swing.JButton jButton_DatLaiDSTK;
    private javax.swing.JButton jButton_DatLaiThe;
    private javax.swing.JButton jButton_DatLaiThongKe;
    private javax.swing.JButton jButton_DongYTTN;
    private javax.swing.JButton jButton_DongYThanhToan;
    private javax.swing.JButton jButton_DongYThanhToanGiaHan;
    private javax.swing.JButton jButton_DongYXoaXe;
    private javax.swing.JButton jButton_GiaHan;
    private javax.swing.JButton jButton_HuyGiaHan;
    private javax.swing.JButton jButton_HuyTTN;
    private javax.swing.JButton jButton_HuyThanhToan;
    private javax.swing.JButton jButton_HuyThanhToanGiaHan;
    private javax.swing.JButton jButton_HuyXoaXe;
    private javax.swing.JButton jButton_ThemCaTruc;
    private javax.swing.JButton jButton_ThemNV;
    private javax.swing.JButton jButton_ThemTK;
    private javax.swing.JButton jButton_ThemTheMoi;
    private javax.swing.JButton jButton_ThongKe;
    private javax.swing.JButton jButton_TimKiemTheoBSX1;
    private javax.swing.JButton jButton_TimKiemTheoBSX2;
    private javax.swing.JButton jButton_TimKiemTheoHTG;
    private javax.swing.JButton jButton_TimKiemTheoIDCaTruc;
    private javax.swing.JButton jButton_TimKiemTheoMaNV1;
    private javax.swing.JButton jButton_TimKiemTheoMaNV2;
    private javax.swing.JButton jButton_TimKiemTheoMaNV3;
    private javax.swing.JButton jButton_TimKiemTheoNgayDK;
    private javax.swing.JButton jButton_VaoBen;
    private javax.swing.JButton jButton_XacNhanMaTheMoi;
    private javax.swing.JButton jButton_XacNhanMatThe;
    private javax.swing.JButton jButton_XoaCaTruc;
    private javax.swing.JButton jButton_XoaNV;
    private javax.swing.JButton jButton_XoaTK;
    private javax.swing.JButton jButton_XuatBen;
    private javax.swing.JButton jButton_dkHinhThucNgay;
    private javax.swing.JButton jButton_matThe;
    private javax.swing.JButton jButton_xuatBenKhiHuyGiaHan;
    private javax.swing.JTextField jCMND;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox_CaTruc;
    private javax.swing.JComboBox<String> jComboBox_GioiTinh;
    private javax.swing.JComboBox<String> jComboBox_HinhThucGui;
    private javax.swing.JComboBox<String> jComboBox_LoaiXe;
    private javax.swing.JComboBox<String> jComboBox_MaNV1;
    private javax.swing.JComboBox<String> jComboBox_MaThe;
    private javax.swing.JComboBox<String> jComboBox_NhiemVu;
    private javax.swing.JComboBox<String> jComboBox_TimKiemTheoHTG;
    private javax.swing.JComboBox<String> jComboBox_VaiTro;
    private javax.swing.JComboBox<String> jComboBox_maThe2;
    private javax.swing.JTextField jDiaChi;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JDialog jDialog5;
    private javax.swing.JDialog jDialog6;
    private javax.swing.JDialog jDialog7;
    private javax.swing.JDialog jDialog8;
    private javax.swing.JDialog jDialog9;
    private datechooser.beans.DateChooserCombo jFormattedTextField_NgayTruc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLabel jLabelTongTien;
    private javax.swing.JLabel jLabel_LoiBSX;
    private javax.swing.JLabel jLabel_LoiHTG;
    private javax.swing.JLabel jLabel_LoiLoaiXe;
    private javax.swing.JLabel jLabel_LoiThe;
    private javax.swing.JLabel jLabel_MT1;
    private javax.swing.JLabel jLabel_MT2;
    private javax.swing.JLabel jLabel_MT3;
    private javax.swing.JLabel jLabel_MT4;
    private javax.swing.JLabel jLabel_TT1;
    private javax.swing.JLabel jLabel_TT2;
    private javax.swing.JLabel jLabel_TT3;
    private javax.swing.JLabel jLabel_TT4;
    private javax.swing.JLabel jLabel_TT5;
    private javax.swing.JLabel jLabel_TTGH1;
    private javax.swing.JLabel jLabel_TTGH2;
    private javax.swing.JLabel jLabel_TTGH3;
    private javax.swing.JLabel jLabel_TTGH4;
    private javax.swing.JLabel jLabel_TTGH5;
    private javax.swing.JLabel jLabel_TTN1;
    private javax.swing.JLabel jLabel_TTN2;
    private javax.swing.JLabel jLabel_TTN3;
    private javax.swing.JLabel jLabel_TTN4;
    private javax.swing.JLabel jLabel_TTN5;
    private javax.swing.JLabel jLabel_loaiXe1;
    private javax.swing.JLabel jLabel_loaiXe2;
    private javax.swing.JLabel jLabel_loiCMND;
    private javax.swing.JLabel jLabel_loiGiaTien1;
    private javax.swing.JLabel jLabel_loiGiaTien2;
    private javax.swing.JLabel jLabel_loiMK;
    private javax.swing.JLabel jLabel_loiMaNV;
    private javax.swing.JLabel jLabel_loiNVu;
    private javax.swing.JLabel jLabel_loiNgayTruc;
    private javax.swing.JLabel jLabel_loiPhiMatThe1;
    private javax.swing.JLabel jLabel_loiPhiMatThe2;
    private javax.swing.JLabel jLabel_loiSDT;
    private javax.swing.JLabel jLabel_loiTenNV;
    private javax.swing.JLabel jLabel_loiTenTK;
    private javax.swing.JLabel jLabel_loiTienPhuPhi1;
    private javax.swing.JLabel jLabel_loiTienPhuPhi2;
    private javax.swing.JLabel jLabel_ngay;
    private javax.swing.JLabel jLabel_time;
    private javax.swing.JLabel jMaNV;
    private javax.swing.JPasswordField jMatKhau;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_new;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JTextField jSDT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable_CTRV;
    private javax.swing.JTable jTable_DSCaTruc;
    private javax.swing.JTable jTable_DSDKHTG;
    private javax.swing.JTable jTable_DSNV;
    private javax.swing.JTable jTable_DSTK;
    private javax.swing.JTable jTable_DSThe;
    private javax.swing.JTable jTable_DSXDK;
    private javax.swing.JTable jTable_TK;
    private javax.swing.JTextField jTenNV;
    private javax.swing.JTextField jTenTK;
    private javax.swing.JTextField jTextFiel_BSX;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField_MauXe;
    private javax.swing.JTextField jTextField_TenXe;
    private javax.swing.JTextField jTextField_TimKiemTheoBSX1;
    private javax.swing.JTextField jTextField_TimKiemTheoBSX2;
    private javax.swing.JTextField jTextField_giaLoaiXe1;
    private javax.swing.JTextField jTextField_giaLoaiXe2;
    private javax.swing.JTextField jTextField_phiMatThe1;
    private javax.swing.JTextField jTextField_phiMatThe2;
    private javax.swing.JTextField jTextField_tienPhuPhi1;
    private javax.swing.JTextField jTextField_tienPhuPhi2;
    private javax.swing.JTextField jTimKiemTheoMaNV1;
    private javax.swing.JTextField jTimKiemTheoMaNV2;
    private javax.swing.JTextField jTimKiemTheoMaNV3;
    private javax.swing.JLabel jlabelCountIDThe;
    private javax.swing.JLabel jlabelfail;
    private javax.swing.JLabel jlbXeTrongBen;
    private javax.swing.JLabel labelTenNhanVien;
    // End of variables declaration//GEN-END:variables
}
