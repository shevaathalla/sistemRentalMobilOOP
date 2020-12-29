/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import rental.database.koneksi;
import rental.model.Rental;
import rental.dao.implementMobil;

/**
 *
 * @author HP ProBook
 */
public class RentalDao implements implementRental {

    Connection con;
    final String insert = "INSERT INTO rental (kode_rental,nama_customer,no_sim,alamat,telepon,mobil_id) VALUES(?,?,?,?,?,?)";
    final String select = "SELECT * FROM rental WHERE status=1";
    final String selectKode = "SELECT * FROM rental WHERE kode_rental =?";
    final String selectId = "SELECT * FROM rental WHERE id =?";
    final String updateStatus = "UPDATE rental set status =? where id=?";

    public RentalDao() {
        this.con = koneksi.koneksiDB();
    }

    @Override
    public void insert(Rental rent) {
        PreparedStatement pst = null;
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        String kode_rental = rent.getMobil().getTipe().substring(0, 3) + rent.getNamaCustomer() + formattedDate;
        try {
            pst = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, kode_rental);
            pst.setString(2, rent.getNamaCustomer());
            pst.setString(3, rent.getNoSim());
            pst.setString(4, rent.getAlamat());
            pst.setString(5, rent.getTelepon());
            pst.setInt(6, rent.getMobil().getId());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            while (rs.next()) {
                rent.setId(rs.getInt(1));
                rent.setTanggal("waktu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rental> getAll() {
        List<Rental> ren = null;
        MobilDao md = new MobilDao();
        Statement st;
        try {
            ren = new ArrayList<>();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Rental r = new Rental();
                r.setId(rs.getInt("id"));
                r.setKode_rental(rs.getString("kode_rental"));
                r.setNamaCustomer(rs.getString("nama_customer"));
                r.setNoSim(rs.getString("no_sim"));
                r.setAlamat(rs.getString("alamat"));
                r.setTelepon(rs.getString("telepon"));
                r.setMobil(md.getCariId(rs.getInt("mobil_id")));
                r.setTanggal(rs.getString("waktu"));
                ren.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ren;
    }

    @Override
    public Rental cariKode(String kode) {
        implementMobil implMob = new MobilDao();
        PreparedStatement pst = null;
        Rental re = new Rental();
        try {
            pst = con.prepareStatement(selectKode);
            pst.setString(1, kode);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                re.setId(rs.getInt("id"));
                re.setKode_rental(rs.getString("kode_rental"));
                re.setNamaCustomer(rs.getString("nama_customer"));
                re.setNoSim(rs.getString("no_sim"));
                re.setAlamat(rs.getString("alamat"));
                re.setTelepon(rs.getString("telepon"));
                re.setMobil(implMob.getCariId(rs.getInt("mobil_id")));
                re.setTanggal(rs.getString("waktu"));
            } else {
                JOptionPane.showMessageDialog(null, "Kode rental tidak ada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return re;
    }

    @Override
    public Rental cariId(int id) {
        implementMobil implMob = new MobilDao();
        PreparedStatement pst = null;
        Rental re = new Rental();
        try {
            pst = con.prepareStatement(selectId);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                re.setId(rs.getInt("id"));
                re.setKode_rental(rs.getString("kode_rental"));
                re.setNamaCustomer(rs.getString("nama_customer"));
                re.setNoSim(rs.getString("no_sim"));
                re.setAlamat(rs.getString("alamat"));
                re.setTelepon(rs.getString("telepon"));
                re.setMobil(implMob.getCariId(rs.getInt("mobil_id")));
                re.setTanggal(rs.getString("waktu"));
            } else {
                JOptionPane.showMessageDialog(null, "Id rental tidak ada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return re;
    }

    @Override
    public void updateStatus(int id, boolean status) {
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(updateStatus);
            pst.setBoolean(1, status);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
