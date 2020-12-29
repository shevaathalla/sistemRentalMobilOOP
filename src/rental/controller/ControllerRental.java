/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental.controller;

import java.util.List;
import javax.swing.JOptionPane;
import rental.dao.MobilDao;
import rental.dao.RentalDao;
import rental.dao.implementRental;
import rental.dao.implementMobil;
import rental.model.Rental;
import rental.model.Mobil;
import rental.model.tableModelRental;
import rental.view.FrameMain;
import rental.view.FrameDetailRental;

/**
 *
 * @author HP ProBook
 */
public class ControllerRental {

    FrameMain frame;    
    implementRental implRen = new RentalDao();
    implementMobil implMob = new MobilDao();
    List<Rental> ren;

    public ControllerRental(FrameMain frame) {
        this.frame = frame;        
        this.ren = implRen.getAll();
    }

    public void reset() {
        frame.getTxtPeminjaman_namaCustomer().setText("");
        frame.getTxtPeminjaman_noSim().setText("");
        frame.getTxtPeminjaman_alamat().setText("");
        frame.getTxtPeminjaman_telepon().setText("");
        frame.getTxtPeminjaman_mobil().setText("");
    }

    public void tampilTable() {
        ren = implRen.getAll();
        tableModelRental trr = new tableModelRental(ren);
        frame.getTblRental().setModel(trr);
    }

    public void insertRental() {
        Rental r = new Rental();
        String nama_customer = frame.getTxtPeminjaman_namaCustomer().getText();
        String no_sim = frame.getTxtPeminjaman_noSim().getText();
        String alamat = frame.getTxtPeminjaman_alamat().getText();
        String no_telp = frame.getTxtPeminjaman_telepon().getText();
        Mobil m = implMob.getCariNopol(frame.getTxtPeminjaman_mobil().getText());
        if (m.isStatus() != false) {
            r.setNamaCustomer(nama_customer);
            r.setNoSim(no_sim);
            r.setAlamat(alamat);
            r.setTelepon(no_telp);
            r.setMobil(m);
            m.setStatus(false);
            implRen.insert(r);
            implMob.updateStatus(m.getId(), false);
            reset();
            JOptionPane.showMessageDialog(null, "Data mobil berhasil masuk");
        } else {
            JOptionPane.showMessageDialog(null, "Mobil sedang tidak tersedia");
        }
    }
}
