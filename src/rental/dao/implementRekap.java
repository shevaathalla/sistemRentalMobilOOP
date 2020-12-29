/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rental.dao;

import java.util.List;
import rental.model.Rekap;

/**
 *
 * @author HP ProBook
 */
public interface implementRekap {    
    public void insert(Rekap r);
    public void update(Rekap r, int id);
    public void delete(int id);
    
    public List<Rekap> getAll();
}
