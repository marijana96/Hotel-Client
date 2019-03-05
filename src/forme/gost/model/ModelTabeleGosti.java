/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.gost.model;

import domain.Gost;
import java.util.List;
import javax.swing.CellEditor;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marij
 */
public class ModelTabeleGosti extends AbstractTableModel {

    List<Gost> list;
    String[] kolone = new String[]{"ID","JMBG", "Ime i prezime", "Pozivni broj", "Kontakt", "Drzava"};

    public ModelTabeleGosti(List<Gost> list) {
        this.list = list;
    }

    public ModelTabeleGosti() {
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
        Gost g = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return g.getGostID();
               
            case 1:
                return g.getJmbg();
               
            case 2:
                return g.getImePrezime();
            case 3:
                return g.getDrzava().getPozivniBroj();
            case 4:
                return g.getKontakt();
           case 5:
               return g.getDrzava().getNaziv();
            default:
                return "";

        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      Gost g=list.get(rowIndex);
      switch (columnIndex) {
          case 0:
               g.setGostID((Integer) aValue);
              
               break;
            case 1:
               g.setJmbg((String) aValue);
               break;
            case 2:
               g.setImePrezime(aValue.toString());
               break;
            case 3:
                g.getDrzava().setPozivniBroj(Integer.parseInt(aValue.toString()));
               break;
            case 4:
                 g.setKontakt(aValue.toString());
               break;
            case 5:
              g.getDrzava().setNaziv(aValue.toString());
               break;
         

        }
    }

    @Override
    public String getColumnName(int column) {
     return kolone[column];}

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    if(columnIndex==0) 
        return false;
    else 
        return true;
    }
   
    
    

}
