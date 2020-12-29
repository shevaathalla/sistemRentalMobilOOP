/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP ProBook
 */
public class tableModelMobil extends AbstractTableModel {

    List<Mobil> mobil;
    String kolom []= {"NOPOL","Tipe","Kilometer","Status"};

    public tableModelMobil(List<Mobil> mobil) {
        this.mobil = mobil;
    }    

    @Override
    public int getRowCount() {
        return mobil.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return mobil.get(rowIndex).getNopol();
            case 1:
                return mobil.get(rowIndex).getTipe();
            case 2:
                return mobil.get(rowIndex).getKilometer();
            case 3:
                if (mobil.get(rowIndex).isStatus()) {
                    return "Ada";
                } else {
                    return "Tidak ada";
                }
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return kolom[columnIndex];
    }

}
