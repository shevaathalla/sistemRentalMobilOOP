/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental.controller;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import rental.dao.MobilDao;
import rental.dao.RekapDao;
import rental.dao.implementMobil;
import rental.dao.implementRekap;
import rental.model.Mobil;
import rental.model.Rekap;
import rental.model.tableModelMobil;
import rental.model.tableModelRecordMobil;
import rental.view.FrameDetailMobil;
import rental.view.FrameMain;

/**
 *
 * @author HP ProBook
 */
public class ControllerMobil {

    FrameMain frame;
    FrameDetailMobil frameDtl;
    implementMobil implMobil = new MobilDao();
    implementRekap implRek = new RekapDao();
    List<Mobil> mob;

    public ControllerMobil(FrameMain frame, FrameDetailMobil frmDtl) {
        this.frame = frame;
        this.frameDtl = frmDtl;
        mob = implMobil.getAll();
    }

    public void tampilTable() {
        mob = implMobil.getAll();
        tableModelMobil tmm = new tableModelMobil(mob);
        frame.getTblMobil().setModel(tmm);
    }
    public void tampilTableRecordMobil(){
        String nopol = frameDtl.getTxtDetailMobil_nopol().getText();
        List<Rekap> rek = implRek.getRecordMobil(nopol);
        tableModelRecordMobil tmrm = new tableModelRecordMobil(rek);
        frameDtl.getTblDetailMobil().setModel(tmrm);
    }

    public void reset() {
        frame.getTxtMobil_nopol().setText("");
        frame.getTxtMobil_tipe().setText("");
        frame.getSpnMobil_kilometer().setValue(0);
    }

    public void resetDetail() {
        frameDtl.getTxtDetailMobil_nopol().setText("");
        frameDtl.getTxtDetailMobil_tipe().setText("");
        frameDtl.getSpnDetailMobil_kilometer().setValue(0);
    }

    public void insertMobil() {
        Mobil m = new Mobil();
        String nopol = frame.getTxtMobil_nopol().getText();
        String tipe = frame.getTxtMobil_tipe().getText();
        int kilometer = ((Integer) frame.getSpnMobil_kilometer().getValue()).intValue();
        int harga = ((Integer) frame.getSpnMobil_harga().getValue()).intValue();
        m.setNopol(nopol);
        m.setTipe(tipe);
        m.setKilometer(kilometer);
        m.setHarga(harga);
        m.setStatus(true);
        implMobil.insert(m);
        JOptionPane.showMessageDialog(null, "Data Mobil berhasil ditambahkan");
    }

    public void deleteMobil() {
        String nopol = frameDtl.getTxtDetailMobil_nopol().getText();
        implMobil.delete(nopol);
        JOptionPane.showMessageDialog(null, "Data Mobil berhasil dihapus");
    }
    public void updateMobil(int id){
        Mobil m = new Mobil();
        String nopol = frameDtl.getTxtDetailMobil_nopol().getText();
        String tipe = frameDtl.getTxtDetailMobil_tipe().getText();
        int kilometer = ((Integer) frameDtl.getSpnDetailMobil_kilometer().getValue()).intValue();
        m.setNopol(nopol);
        m.setTipe(tipe);
        m.setKilometer(kilometer);
        
        implMobil.update(m, id);
        JOptionPane.showMessageDialog(null, "Data Mobil berhasil diganti"); 
    }

    public Mobil cariNopol(String nopol) {
        Mobil m = implMobil.getCariNopol(nopol);
        return m;
    }    

}
