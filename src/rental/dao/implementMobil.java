/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rental.dao;
import java.util.List;
import rental.model.Mobil;
/**
 *
 * @author HP ProBook
 */
public interface implementMobil {
    public void insert(Mobil m);
    public void update(Mobil m, int id);
    public void delete(String nopol);
    
    public List<Mobil> getAll();
    public Mobil getCariNopol(String nopol);
    public Mobil getCariId(int id);
    public void updateStatus(int id,boolean status);
    public void updateKilometer(int id,int kilometer);
}
