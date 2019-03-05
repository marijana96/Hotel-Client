/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.racun;

import domain.Drzava;
import domain.Gost;
import domain.Hotel;
import domain.Racun;
import domain.SmestajnaJedinica;
import domain.StavkaRacuna;
import forme.gost.FrmPretragaGosta;
import forme.gost.FrmUnosGosta;
import forme.racun.FrmRacun;
import forme.sjedinica.model.ModelTabeleSJedinice;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import komunikacija.Komunikacija;
import modeli.ModelTabeleStavke;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.util.Operacija;
import transfer.util.StatusOdgovora;

/**
 *
 * @author marij
 */
public class KontrolerRacuna {
List<StavkaRacuna> list;
int brojStavke=1;
double ukupanIznos=0;
    Gost gost;
    Racun racun;
  
    public KontrolerRacuna() {
list=new LinkedList<>();
    }

    public void srediFormu(FrmRacun fm) {
       srediTabelu(fm.getTblStavke());
       fm.getLblIznos().setVisible(false);
       fm.getLblDin().setVisible(false);
       fm.getLblUkupanIznos().setText(ukupanIznos+"");
     
    }

    public void azuriraj(FrmRacun fm) {
     Date datum = fm.getJdpDatum().getDate();
        if (datum != null) {
            DateFormat df = new SimpleDateFormat("dd-MM-yy");
           // profakturaID += "-" + df.format(datum);
        }}

   
         

    private void srediTabelu(JTable tblStavke) {
          ModelTabeleStavke mts=new ModelTabeleStavke(list);
        tblStavke.setModel(mts);
        mts.fireTableDataChanged(); }

    public void azurirajIznos(FrmRacun fm) {
    double iznos=0;
    int brNoci;
        SmestajnaJedinica sj= (SmestajnaJedinica) fm.getCmbSmestajneJedinice().getSelectedItem();
        iznos+=sj.getCena();
        
        if(fm.getJdpOdlazak().getDate()!=null){
        SimpleDateFormat sdf= new SimpleDateFormat("dd.MM.yy");
          Date dolazak=fm.getJdpDolazak().getDate();
         // String d=sdf.format(dolazak);
            Date odlazak=fm.getJdpOdlazak().getDate();
    // (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
           brNoci=(int) ((odlazak.getTime()-dolazak.getTime()) / (1000 * 60 * 60 * 24));
           iznos= (iznos*brNoci);
           
        }
       
        fm.getLblIznos().setVisible(true);
        fm.getLblDin().setVisible(true);
        fm.getLblDin().setText("din");
        fm.getLblIznos().setText(iznos+"");
       
     }

    public void dodajStavku(FrmRacun fm) {
    StavkaRacuna sr= new StavkaRacuna();
     SimpleDateFormat sdf= new SimpleDateFormat("dd.MM.yy");
          Date dolazak=fm.getJdpDolazak().getDate();
         
            Date odlazak=fm.getJdpOdlazak().getDate();
      Gost g1= (Gost) fm.getCmbGosti().getSelectedItem();
      int br=g1.getGostID();
      String nalepi=brojStavke+""+br;
    sr.setBrojRacuna(Integer.parseInt(nalepi));
    sr.setDolazak(dolazak);
    sr.setOdlazak(odlazak);
    sr.setSmestajnaJedinica((SmestajnaJedinica) fm.getCmbSmestajneJedinice().getSelectedItem());
    sr.setSuma(Double.parseDouble(fm.getLblIznos().getText()));
    sr.setRacun(null);
    brojStavke++;
    list.add(sr);
    srediPoljaUnosStavke(fm);
        srediTabelu(fm.getTblStavke());
        
    }

    private void srediPoljaUnosStavke(FrmRacun fm) {
  
  ukupanIznos+=Double.parseDouble(fm.getLblIznos().getText());
         fm.getLblUkupanIznos().setText(ukupanIznos+"");
  
       fm.getJdpDolazak().setDate(null);
         fm.getJdpOdlazak().setDate(null);
         fm.getCmbSmestajneJedinice().setSelectedItem(null);
          fm.getLblIznos().setVisible(false);
       fm.getLblDin().setVisible(false);
       
    }

    public void azurirajUkupanIznos(FrmRacun aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void azurirajRacunId(FrmRacun fm) {
        String racunId="ID-";
        Date datum= fm.getJdpDatum().getDate();
        if(datum!=null && gost!=null){
            racunId+=gost.getGostID();
            SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yy");
        racunId+="-" +sdf.format(datum);
        }
        if(racun!=null){
            racun.setRacunId(racunId);
        }
        fm.getTxtRacunId().setText(racunId);
    }

    
    

   

    public void podesiPodatkeGost(FrmRacun frm) {
        gost=(Gost) frm.getCmbGosti().getSelectedItem();
        azurirajRacunId(frm);
       frm.getLblJMBG().setText(gost.getJmbg());
    frm.getLblDrzava().setText(gost.getDrzava().getNaziv());
    frm.getLblPozivnBroj().setText(gost.getDrzava().getPozivniBroj()+"");
    frm.getLblKontakt().setText(gost.getKontakt()); 
    frm.getLblID().setText(gost.getGostID()+"");}

    public void izbrisiIzTabele(FrmRacun fm) throws Exception {
     int red = fm.getTblStavke().getSelectedRow();
        if (red == -1) {
            throw new Exception("Morate izabrati stavku iz tabele");
        }
        
        else{
            ukupanIznos-=list.get(red).getSuma();
            brojStavke--;
            list.remove(red);
        }
    
        srediFormu(fm);
    }

    public boolean validirajDatum(FrmRacun fm) {
      if((fm.getJdpDolazak().getDate())==null)
             return false;
         if((fm.getJdpOdlazak().getDate())==null)
             return false;
           if((fm.getJdpOdlazak().getDate()).before(fm.getJdpDolazak().getDate()))

         return false;
           
     
    return true;}

    public void sacuvajRacun(FrmRacun fm) {
    try {  
        kreirajRacun(fm);
        Zahtev zahtev= new Zahtev();
        zahtev.setOperation(Operacija.SACUVAJ_RACUN);
        zahtev.setData(racun);
        Komunikacija.getInstance().posaljiZahtev(zahtev);
        Odgovor odg= Komunikacija.getInstance().primiOdgovor();
        if(odg.getStatus()==StatusOdgovora.ERROR){
            JOptionPane.showMessageDialog(fm, odg.getPoruka());
        }
        else{
            JOptionPane.showMessageDialog(fm, odg.getPoruka());
        }
        racun=new Racun();
        racun.setStavkeRacuna(new LinkedList<StavkaRacuna>());
       srediFormuNaPocetno(fm);
    } catch (Exception ex) {
       JOptionPane.showMessageDialog(fm, ex.getMessage());
            ex.printStackTrace();}
    }

    private void kreirajRacun(FrmRacun fm) throws Exception {
       validirajRacun(fm);
       //dodajStavke(fm);
       try{
           racun=new Racun();
       racun.setRacunId(fm.getTxtRacunId().getText());
       racun.setDatum(fm.getJdpDatum().getDate());
           Hotel h= new Hotel(123, "Hotel 123", 1000);
      racun.setHotel(h);
         racun.setGost((Gost) fm.getCmbGosti().getSelectedItem());
         racun.setZiroRacun(Integer.parseInt(fm.getTxtZiroRacun().getText()));
         racun.setStavkeRacuna(list);
        
         List<StavkaRacuna> sr= racun.getStavkeRacuna();
           for (StavkaRacuna stavkaRacuna : sr) {
               stavkaRacuna.setRacun(racun);
           }
         
       
    } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            throw new Exception("Broj ziro racuna mora biti ispisan ciframa");
        }
    }

    private void validirajRacun(FrmRacun fm) throws Exception {
     if(fm.getTblStavke().getRowCount()==0){
         throw new Exception("Racun mora imati bar jednu stavku.");
                 }
     }

    private void srediFormuNaPocetno(FrmRacun fm) {
       list=new LinkedList<>();
        srediTabelu(fm.getTblStavke());
       fm.getLblIznos().setVisible(false);
       fm.getLblDin().setVisible(false);
       ukupanIznos=0;
       fm.getTxtZiroRacun().setText(null);
       fm.getTxtRacunId().setText(null);
       fm.getLblID().setText(null);
        fm.getLblDrzava().setText(null);
         fm.getLblJMBG().setText(null);
          fm.getLblKontakt().setText(null);
         fm.getLblPozivnBroj().setText(null);
       fm.getCmbGosti().setSelectedItem(null);
       fm.getCmbSmestajneJedinice().setSelectedItem(null);
       fm.getJdpDatum().setDate(null);
         fm.getLblID().setText(null);
       fm.getLblUkupanIznos().setText(ukupanIznos+""); }

    
}


    

    

