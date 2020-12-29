/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rental.dao;
import java.util.List;
import rental.model.Rental;
/**
 *
 * @author HP ProBook
 */
public interface implementRental {
    public void insert(Rental rent);
    public void delete(int id);
    
    public List<Rental> getAll();
    public Rental cariKode(String kode);
    public Rental cariId(int id);
    public void updateStatus(int id,boolean status);
}
