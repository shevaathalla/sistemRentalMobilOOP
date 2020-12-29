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
public class tableModelRental extends AbstractTableModel {

    List<Rental> ren;
    String[] name = {"Kode Rental","Nama Customer","Telepon","Mobil","Tanggal"};
    public tableModelRental(List<Rental> ren) {
        this.ren = ren;
    }

    @Override
    public int getRowCount() {
        return ren.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return ren.get(rowIndex).getKode_rental();
            case 1:
                return ren.get(rowIndex).getNamaCustomer();
            case 2:
                return ren.get(rowIndex).getTelepon();
            case 3:
                return ren.get(rowIndex).getMobil().getTipe();
            case 4:
                return ren.get(rowIndex).getTanggal();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){        
        return name[column];
    }
}
