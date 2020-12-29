/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rental.model;

/**
 *
 * @author HP ProBook
 */
public class Rekap extends Rental{
    private Rental rent = new Rental();    
    private int kmAwal;
    private int kmAkhir;    
    private String tglPengembalian;
    private int biaya;
    
    
    @Override
    public String getNamaCustomer(){
        return namaCustomer;
    }
    @Override
    public void setNamaCustomer(String namaCustomer){
        this.namaCustomer = namaCustomer;
    }
    public int getKmAwal() {
        return kmAwal;
    }

    public int getKmAkhir() {
        return kmAkhir;
    }    

    public String getTglPengembalian() {
        return tglPengembalian;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setKmAwal(int kmAwal) {
        this.kmAwal = kmAwal;
    }

    public void setKmAkhir(int kmAkhir) {
        this.kmAkhir = kmAkhir;
    }    

    public void setTglPengembalian(String tglPengembalian) {
        this.tglPengembalian = tglPengembalian;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }    

    public Rental getRent() {
        return rent;
    }

    public void setRent(Rental rent) {
        this.rent = rent;
    }
}
