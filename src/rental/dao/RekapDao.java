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
import java.util.ArrayList;
import java.util.List;
import rental.model.Rekap;
import rental.database.koneksi;

/**
 *
 * @author HP ProBook
 */
public class RekapDao implements implementRekap{
    Connection con;    
    final String insert = "INSERT INTO rekap (kilometer_awal,kilometer_akhir,biaya,rental_id) VALUES (?,?,?,?)";  
    final String delete = "DELETE FROM rekap WHERE id=?";
    final String select = "SELECT * FROM rekap";

    public RekapDao() {
        this.con = koneksi.koneksiDB();
    }
    
    @Override
    public void insert(Rekap r) {
        PreparedStatement pst = null;        
        try {
            pst = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);                       
            pst.setInt(1,r.getKmAwal() );
            pst.setInt(2, r.getKmAkhir());
            pst.setInt(3, r.getBiaya());
            pst.setInt(4,r.getId());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();            
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
    public void update(Rekap r, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rekap> getAll() {
        List<Rekap> rek = null;
        Statement st;
        implementRental ren = new RentalDao();
        try {
            rek = new ArrayList<>();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                Rekap r = new Rekap();                
                r.setId(rs.getInt("rental_id"));
                System.out.println(r.getId());
                r.setKmAwal(rs.getInt("kilometer_awal"));
                r.setKmAkhir(rs.getInt("kilometer_akhir"));
                r.setTanggal(ren.cariId(r.getId()).getTanggal());
                System.out.println(r.getTanggal());
                r.setTglPengembalian(rs.getString("tgl_kembali"));
                r.setBiaya(rs.getInt("biaya"));
                r.setNamaCustomer(ren.cariId(r.getId()).getNamaCustomer());
                r.setMobil(ren.cariId(r.getId()).getMobil());
                rek.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rek;
    }
    
}
