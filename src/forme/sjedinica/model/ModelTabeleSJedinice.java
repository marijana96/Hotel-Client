/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.sjedinica.model;

import domain.Gost;
import domain.SmestajnaJedinica;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marij
 */
public class ModelTabeleSJedinice extends AbstractTableModel{
      List<SmestajnaJedinica> list;
    String[] kolone = new String[]{"Broj sobe ","Naziv", "Cena", "Tip", "Status"};

    public ModelTabeleSJedinice(List<SmestajnaJedinica> list) {
        this.list = list;
    }

    public ModelTabeleSJedinice() {
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       SmestajnaJedinica sj = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sj.getBrojSobe();
               
            case 1:
                return sj.getNaziv();
               
            case 2:
                return sj.getCena();
            case 3:
                return sj.getTip();
            case 4:
                return sj.getStatus();
    
            default:
                return "";

        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      SmestajnaJedinica sj=list.get(rowIndex);
      switch (columnIndex) {
          case 0:
               sj.setBrojSobe((String) aValue);
              
               break;
            case 1:
          sj.setNaziv(aValue.toString());
               break;
            case 2:
            sj.setCena(Double.parseDouble(aValue.toString()));
               break;
            case 3:
                 sj.setTip(aValue.toString());
               break;
            case 4:
               sj.setStatus(aValue.toString());
               break;
           
         

        }
    }

    @Override
    public String getColumnName(int column) {
     return kolone[column];}

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    if(columnIndex==0 || columnIndex==1) 
        return false;
    else 
        return true;
    } 
}
