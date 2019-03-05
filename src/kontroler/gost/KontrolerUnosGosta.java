/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.gost;

import domain.Drzava;
import domain.Gost;
import forme.gost.FrmUnosGosta;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.util.Operacija;
import transfer.util.StatusOdgovora;

/**
 *
 * @author marij
 */
public class KontrolerUnosGosta {

    private Gost gost;

    public KontrolerUnosGosta() {
       gost = new Gost();
    }

    public void setGost(Gost g) {
gost=g;
    }

    public void srediFormu(FrmUnosGosta frmU) {
        try {
            popuniComboBoxDrzave(frmU.getCmbDrzave());
            if(gost==null){
                 frmU.getTxtJMBG().setText(null);
                frmU.getTxtImePrezime().setText(null);
                frmU.getTxtKontakt().setText(null);
                frmU.getTxtJMBG().setText(null);
                frmU.getCmbDrzave().setSelectedItem(null);
                frmU.getTxtJMBG().setEditable(true);
            }else{
                frmU.getTxtJMBG().setText(gost.getJmbg());
                frmU.getTxtImePrezime().setText(gost.getImePrezime());
                frmU.getTxtKontakt().setText(gost.getKontakt());
                frmU.getTxtJMBG().setText(gost.getJmbg());
                frmU.getCmbDrzave().setSelectedItem(gost.getDrzava());
                frmU.getTxtJMBG().setEditable(false);
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frmU, ex.getMessage()); 
        ex.printStackTrace();}
    
    }

    private void popuniComboBoxDrzave(JComboBox<Object> cmbDrzave) throws Exception {
        Zahtev zahtev= new Zahtev();
        zahtev.setOperation(Operacija.UCITAJ_SVE_DRZAVE);
        Komunikacija.getInstance().posaljiZahtev(zahtev);
        Odgovor odg=Komunikacija.getInstance().primiOdgovor();
        if(odg.getStatus()==StatusOdgovora.ERROR){
            throw new Exception(odg.getPoruka());
        }
        cmbDrzave.setModel(new DefaultComboBoxModel(((List<Drzava>)odg.getData()).toArray()));
    }

    
   

    public void dodajGosta(FrmUnosGosta aThis) {
        try {
            kreirajGosta(aThis);
            Zahtev zahtev= new Zahtev();
            zahtev.setOperation(Operacija.SACUVAJ_NOVOG_GOSTA);
            zahtev.setData(gost);
            Komunikacija.getInstance().posaljiZahtev(zahtev);
            Odgovor odg= Komunikacija.getInstance().primiOdgovor();
            if(odg.getStatus()==StatusOdgovora.ERROR){
                JOptionPane.showMessageDialog(aThis, odg.getPoruka());
            } else{
                 JOptionPane.showMessageDialog(aThis, odg.getPoruka());
            }
                gost=null;
                
            } catch (Exception ex) {
          JOptionPane.showMessageDialog(aThis, ex.getMessage());
            ex.printStackTrace(); }
    }

    private void kreirajGosta(FrmUnosGosta aThis) throws Exception {
        proveriPodatke(aThis);
    if(gost== null){
        gost= new Gost();
    }
    
    gost.setJmbg(aThis.getTxtJMBG().getText());
    gost.setImePrezime(aThis.getTxtImePrezime().getText());
    gost.setKontakt(aThis.getTxtKontakt().getText());
    gost.setDrzava((Drzava) aThis.getCmbDrzave().getSelectedItem());
    gost.setGostID(gost.getGostID());
    }

    public void sacuvajIzmene(FrmUnosGosta aThis) {
      try {
            kreirajGosta(aThis);
            Zahtev zahtev= new Zahtev();
            zahtev.setOperation(Operacija.SACUVAJ_IZMENE_GOSTA);
            zahtev.setData(gost);
            Komunikacija.getInstance().posaljiZahtev(zahtev);
            Odgovor odg= Komunikacija.getInstance().primiOdgovor();
            if(odg.getStatus()==StatusOdgovora.ERROR){
                JOptionPane.showMessageDialog(aThis, odg.getPoruka());
            } else{
                 JOptionPane.showMessageDialog(aThis, odg.getPoruka());
            }
                gost=null;
                srediFormu(aThis);
                
            } catch (Exception ex) {
             JOptionPane.showMessageDialog(aThis, ex.getMessage());
            ex.printStackTrace(); }
    }

   

    private void proveriPodatke(FrmUnosGosta fm) throws Exception {
        proveriDaLiJePrazno(fm);
        proveriTelefon(fm);
      
    
    }

    private void proveriDaLiJePrazno(FrmUnosGosta fm) throws Exception {
    if( fm.getTxtJMBG().getText().isEmpty())
        throw new Exception("Sva polja moraju biti popunjena");
    if( fm.getTxtImePrezime().getText().isEmpty())
        throw new Exception("Sva polja moraju biti popunjena");
    if( fm.getTxtJMBG().getText().isEmpty())
        throw new Exception("Sva polja moraju biti popunjena");
    if( fm.getTxtKontakt().getText().isEmpty() )
        throw new Exception("Sva polja moraju biti popunjena");
    if( fm.getTxtJMBG().getText().isEmpty())
        throw new Exception("Sva polja moraju biti popunjena");
   
    }

    private void proveriTelefon(FrmUnosGosta fm) throws Exception {
       String broj= fm.getTxtKontakt().getText();
    try{
        int cifre=Integer.parseInt(broj);
    }catch(Exception e){
        throw new Exception("Kontakt broj mora sadrzati samo cifre!");
        
    }

}
}
