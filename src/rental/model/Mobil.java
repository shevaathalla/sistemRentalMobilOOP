/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rental.model;

import java.util.ArrayList;

/**
 *
 * @author HP ProBook
 */
public class Mobil {
    private int id;
    private String tipe;
    private String nopol;
    private int kilometer;
    private boolean status; 
    private int harga;

    public String getTipe() {
        return tipe;
    }

    public String getNopol() {
        return nopol;
    }

    public int getKilometer() {
        return kilometer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
