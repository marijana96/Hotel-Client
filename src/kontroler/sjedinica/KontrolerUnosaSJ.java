/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.sjedinica;

import domain.SmestajnaJedinica;
import forme.sjedinica.FrmUnosNoveSJedinice;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import kontroler.gost.KontrolerUnosGosta;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.util.Operacija;
import transfer.util.StatusOdgovora;

/**
 *
 * @author marij
 */
public class KontrolerUnosaSJ {

    public KontrolerUnosaSJ() {
    }

    public void dodajSJedinicu(FrmUnosNoveSJedinice aThis) {
             try {
                 SmestajnaJedinica sj=kreirajSJedinicu(aThis);
            Zahtev zahtev= new Zahtev();
            zahtev.setOperation(Operacija.SACUVAJ_NOVU_SJEDINICU);
            zahtev.setData(sj);
            Komunikacija.getInstance().posaljiZahtev(zahtev);
            Odgovor odg= Komunikacija.getInstance().primiOdgovor();
            if(odg.getStatus()==StatusOdgovora.ERROR){
                JOptionPane.showMessageDialog(aThis, odg.getPoruka());
            } else{
                 JOptionPane.showMessageDialog(aThis, odg.getPoruka());
            }
            srediFormu(aThis);
                
            } catch (Exception ex) {
           JOptionPane.showMessageDialog(aThis, ex.getMessage());
            ex.printStackTrace(); }
    }

    private SmestajnaJedinica kreirajSJedinicu(FrmUnosNoveSJedinice aThis) throws Exception {
        proveriPodatjeSJ(aThis);
     SmestajnaJedinica sj=new SmestajnaJedinica();
   sj.setBrojSobe(aThis.getTxtBrojSobe().getText());
   sj.setNaziv(aThis.getTxtNaziv().getText());
    sj.setStavkeRacuna(null);
    if(aThis.getButtonGroup1().getSelection()==aThis.getBtnSlobodno().getModel()){
        sj.setStatus("slobodno");
    }else{
        sj.setStatus("zauzeto");}
    sj.setCena(Double.parseDouble(aThis.getTxtCena().getText()));
    sj.setTip((String) aThis.getCmbTip().getSelectedItem());
    return sj;
    
    }

    private void srediFormu(FrmUnosNoveSJedinice aThis) {
    aThis.getTxtNaziv().setText(null);
     aThis.getTxtBrojSobe().setText(null);
      aThis.getTxtCena().setText(null);
      aThis.getButtonGroup1().clearSelection();
    }

    private void proveriPodatjeSJ(FrmUnosNoveSJedinice fm) throws Exception {
         proveriDaLiJePrazno(fm); }

    private void proveriDaLiJePrazno(FrmUnosNoveSJedinice fm) throws Exception {
      if( fm.getTxtBrojSobe().getText().isEmpty())
        throw new Exception("Sva polja moraju biti popunjena");
    if( fm.getTxtCena().getText().isEmpty())
        throw new Exception("Sva polja moraju biti popunjena");
    if( fm.getTxtNaziv().getText().isEmpty())
        throw new Exception("Sva polja moraju biti popunjena");
   
    } }

    

