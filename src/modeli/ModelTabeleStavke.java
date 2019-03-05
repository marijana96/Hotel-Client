/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domain.SmestajnaJedinica;
import domain.StavkaRacuna;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marij
 */
public class ModelTabeleStavke extends AbstractTableModel{
      List<StavkaRacuna> list;
    String[] kolone = new String[]{"Broj racuna ","Smestajna jedinica", "Dolazak", "Odlazak", "Suma"};
  
    
    

    public ModelTabeleStavke(List<StavkaRacuna> list) {
        this.list = list;
    }

    public ModelTabeleStavke() {
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
        StavkaRacuna sj = list.get(rowIndex);
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yy");
        switch (columnIndex) {
            case 0:
                return sj.getBrojRacuna();
               
            case 1:
                return sj.getSmestajnaJedinica().getNaziv()+" "+sj.getSmestajnaJedinica().getBrojSobe();
               
            case 2:
                 
                 String dolazak= sdf.format(sj.getDolazak());
                return dolazak;
            case 3:
                 String odlazak= sdf.format(sj.getOdlazak());
                return odlazak;
            case 4:
                return sj.getSuma();
    
            default:
                return "";

        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      StavkaRacuna sj=list.get(rowIndex);
      switch (columnIndex) {
          case 0:
               sj.setBrojRacuna(Integer.parseInt((String) aValue));
              
               break;
            case 1:
          sj.setSmestajnaJedinica((SmestajnaJedinica) aValue);
               break;
            case 2:
            sj.setDolazak((aValue.toString()));
               break;
            case 3:
                 sj.setOdlazak((aValue.toString()));
               break;
            case 4:
               sj.setSuma(Double.parseDouble((aValue.toString())));
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
