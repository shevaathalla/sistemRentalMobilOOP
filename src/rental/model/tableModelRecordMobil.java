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
public class tableModelRecordMobil extends AbstractTableModel{
    
    List<Rekap> rek;
    String[] kolom= {"Nama Customer","Tipe Mobil","Tanggal Pinjam","Biaya"};

    public tableModelRecordMobil(List<Rekap> rek) {
        this.rek = rek;        
    }
    
    
    @Override
    public int getRowCount() {
        return rek.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rek.get(rowIndex).getNamaCustomer();
            case 1:
                return rek.get(rowIndex).getMobil().getTipe();
            case 2:
                return rek.get(rowIndex).getTanggal();
            case 3:
                return rek.get(rowIndex).getBiaya();            
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){        
        return kolom[column];
    }
    
}
