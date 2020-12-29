/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import rental.database.koneksi;
import rental.model.Mobil;

/**
 *
 * @author HP ProBook
 */
public class MobilDao implements implementMobil {

    Connection con;
    final String insert = "INSERT INTO mobil (nopol,tipe,kilometer,status,harga) VALUES (?,?,?,1,?);";
    final String update = "UPDATE mobil set nopol=?, tipe=?, kilometer=? where id=?";
    final String delete = "DELETE FROM mobil WHERE nopol =?;";
    final String select = "SELECT * FROM mobil;";
    final String selectNopol = "SELECT * FROM mobil where nopol=?";
    final String selectId = "SELECT * FROM mobil where id=?";
    final String updateStatus = "UPDATE mobil set status =? where id=?";
    final String updateKilometer = "UPDATE mobil set kilometer =? where id=?";

    public MobilDao() {
        this.con = koneksi.koneksiDB();
    }

    @Override
    public void insert(Mobil m) {
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, m.getNopol());
            pst.setString(2, m.getTipe());
            pst.setInt(3, m.getKilometer());
            pst.setInt(4, m.getHarga());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            while (rs.next()) {
                m.setId(rs.getInt(1));
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
    public void update(Mobil m, int id) {
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(update);
            pst.setString(1, m.getNopol());
            pst.setString(2, m.getTipe());
            pst.setInt(3, m.getKilometer());
            pst.setInt(4, id);
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

    @Override
    public void delete(String nopol) {
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(delete);
            pst.setString(1, nopol);
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

    @Override
    public List<Mobil> getAll() {
        List<Mobil> mob = null;
        Statement st;
        try {
            mob = new ArrayList<>();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Mobil m = new Mobil();
                m.setId(rs.getInt("id"));
                m.setNopol(rs.getString("nopol"));
                m.setTipe(rs.getString("tipe"));
                m.setKilometer(rs.getInt("kilometer"));
                m.setStatus(rs.getBoolean("status"));
                m.setHarga(rs.getInt("harga"));
                mob.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mob;
    }

    @Override
    public Mobil getCariNopol(String nopol) {
        PreparedStatement pst = null;
        Mobil m = new Mobil();
        try {
            pst = con.prepareStatement(selectNopol);
            pst.setString(1, nopol);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                m.setId(rs.getInt("id"));
                m.setNopol(rs.getString("nopol"));
                m.setTipe(rs.getString("tipe"));
                m.setKilometer(rs.getInt("kilometer"));
                m.setHarga(rs.getInt("harga"));
                m.setStatus(rs.getBoolean("status"));
            }else{
                JOptionPane.showMessageDialog(null, "Data tidak ada");
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
        return m;

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

    @Override
    public Mobil getCariId(int id) {
        PreparedStatement pst = null;
        Mobil m = new Mobil();
        try {
            pst = con.prepareStatement(selectId);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                m.setId(rs.getInt("id"));
                m.setNopol(rs.getString("nopol"));
                m.setTipe(rs.getString("tipe"));
                m.setKilometer(rs.getInt("kilometer"));
                m.setHarga(rs.getInt("harga"));
                m.setStatus(rs.getBoolean("status"));
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
        return m;

    }

    @Override
    public void updateKilometer(int id, int kilometer) {
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(updateKilometer);
            pst.setInt(1, kilometer);
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
