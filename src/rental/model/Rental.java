/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental.model;

import java.util.Date;

/**
 *
 * @author HP ProBook
 */
public class Rental {

    private int id;
    private String kode_rental;
    String namaCustomer, noSim, alamat, telepon, tanggal;
    private Mobil mobil;    

  // Setter Getter
    public String getNamaCustomer() {
        return namaCustomer;
    }
    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }
    public String getNoSim() {
        return noSim;
    }
    public void setNoSim(String noSim) {
        this.noSim = noSim;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getTelepon() {
        return telepon;
    }
    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public Mobil getMobil() {
        return mobil;
    }

    public void setMobil(Mobil mobil) {
        this.mobil = mobil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKode_rental() {
        return kode_rental;
    }

    public void setKode_rental(String kode_rental) {
        this.kode_rental = kode_rental;
    }
    
    
}
