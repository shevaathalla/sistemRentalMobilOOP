/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental.controller;

import java.util.List;
import javax.swing.JOptionPane;
import rental.dao.MobilDao;
import rental.dao.RekapDao;
import rental.dao.RentalDao;
import rental.dao.implementMobil;
import rental.dao.implementRekap;
import rental.dao.implementRental;
import rental.model.Mobil;
import rental.model.Rekap;
import rental.model.Rental;
import rental.model.tableModelRekap;
import rental.model.tableModelRental;
import rental.view.FrameMain;

/**
 *
 * @author HP ProBook
 */
public class ControllerRekap {

    FrameMain frame;
    implementRekap implRek = new RekapDao();
    implementMobil implMob = new MobilDao();
    implementRental implRen = new RentalDao();
    List<Rekap> rek;

    public ControllerRekap(FrameMain frame) {
        this.frame = frame;
        this.rek = implRek.getAll();
    }

    public void tampilTable() {
        rek = implRek.getAll();
        tableModelRekap tmr = new tableModelRekap(rek);
        frame.getTblPendapatan().setModel(tmr);
        frame.getLblPendapatan_hariIni().setText(String.valueOf(totalPendapatan()));
    }

    public void insertRekap() {
        Rekap r = new Rekap();
        Rental ren = implRen.cariKode(frame.getTxtPengembalian_koderental().getText());
        Mobil m = ren.getMobil();
        r.setRent(ren);
        r.setMobil(m);
        System.out.println(m.getHarga());
        int kilometer_awal = m.getKilometer();
        int kilometer_akhir = (Integer) frame.getSpnPengembalian_kilometer().getValue();
        int durasi = (Integer) frame.getSpnPengembalian_durasi().getValue();
        int biaya = (m.getHarga()) * durasi;
        r.setKmAwal(kilometer_awal);
        r.setKmAkhir(kilometer_akhir);
        r.setBiaya(biaya);
        r.setId(ren.getId());
        implRek.insert(r);        
        implMob.updateStatus(m.getId(), true);
        implMob.updateKilometer(m.getId(), kilometer_akhir);
        implRen.updateStatus(ren.getId(), false);
    }
    public void completeOrder(){
        try {
            insertRekap();
            JOptionPane.showMessageDialog(null, "Order Completed terima kasih!");
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    public void reset(){
        frame.getTxtPengembalian_koderental().setText("");
        frame.getSpnPengembalian_durasi().setValue(0);
        frame.getSpnPengembalian_kilometer().setValue(0);
    }
    
    public int totalPendapatan(){
        int total = 0;
        int jumlahRow = frame.getTblPendapatan().getRowCount();                        
        for (int i = 0; i < jumlahRow; i++) {
            total = total +((Integer) frame.getTblPendapatan().getModel().getValueAt(i, 3));
        }
        return total;
                
    }

}
