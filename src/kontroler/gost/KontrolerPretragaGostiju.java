/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.gost;

import domain.Gost;
import forme.glavna.FrmMode;
import forme.gost.FrmPretragaGosta;
import forme.gost.FrmUnosGosta;
import forme.gost.model.ModelTabeleGosti;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import komunikacija.Komunikacija;
import kontroler.racun.KontrolerRacuna;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.util.Operacija;
import transfer.util.StatusOdgovora;

/**
 *
 * @author marij
 */
public class KontrolerPretragaGostiju {

    List<Gost> gosti;

    public KontrolerPretragaGostiju() {
        gosti = new LinkedList<>();
    }

    public void srediFormu(FrmPretragaGosta aThis) {
        popuniTabelu(aThis.getTblGosti());
    }

    private void popuniTabelu(JTable tblGosti) {
        ModelTabeleGosti mtg = new ModelTabeleGosti(gosti);
        
        tblGosti.setModel(mtg);
        tblGosti.removeColumn(tblGosti.getColumnModel().getColumn(0));
        mtg.fireTableDataChanged();
    }

    public void nadjiGostePoKriterijumu(FrmPretragaGosta aThis) {
        try {
            String kriterijum = aThis.getTxtKriterujum().getText();
            if (kriterijum.isEmpty()) {
                throw new Exception("Morate uneti kriterijum pretrage");
            }

            Zahtev zahtev = new Zahtev();
            zahtev.setOperation(Operacija.PRETRAZI_GOSTE);
            zahtev.setData(kriterijum);
            Komunikacija.getInstance().posaljiZahtev(zahtev);
            Odgovor odg = Komunikacija.getInstance().primiOdgovor();
            if (odg.getStatus() == StatusOdgovora.ERROR) {
                throw new Exception(odg.getPoruka());
            }
            gosti = (List<Gost>) odg.getData();
            if (gosti.isEmpty()) {
                srediFormu(aThis);
                throw new Exception("Nijedan gost nije nadjen");
            }
            srediFormu(aThis);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(aThis, e.getMessage());
            e.printStackTrace();
        }
    }
        public void izmeniGosta(FrmPretragaGosta aThis) {
      try{
            Gost g = izabraniGost(aThis);
            
            FrmUnosGosta frmUnos=new FrmUnosGosta(null, true, FrmMode.EDIT,g);
            frmUnos.setVisible(true);
            srediFormu(aThis);
      }catch(Exception ex){
          JOptionPane.showMessageDialog(aThis, ex.getMessage());
      }
    }
    public Gost izabraniGost(FrmPretragaGosta aThis) throws Exception {
        int red = aThis.getTblGosti().getSelectedRow();
        if (red == -1) {
            throw new Exception("Morate izabrati gosta iz tabele");
        }
        return gosti.get(red);
    }



    public void nadjiGostePoKriterijumuJMBG(FrmPretragaGosta aThis) {
        try {
            String kriterijum = aThis.getTxtKriterujum().getText();
            if (kriterijum.isEmpty()) {
                throw new Exception("Morate uneti kriterijum pretrage");
            }

            Zahtev zahtev = new Zahtev();
            zahtev.setOperation(Operacija.PRETRAZI_GOSTEJMBG);
            zahtev.setData(kriterijum);
            Komunikacija.getInstance().posaljiZahtev(zahtev);
            Odgovor odg = Komunikacija.getInstance().primiOdgovor();
            if (odg.getStatus() == StatusOdgovora.ERROR) {
                throw new Exception(odg.getPoruka());
            }
            gosti = (List<Gost>) odg.getData();
            if (gosti.isEmpty()) {
                srediFormu(aThis);
                throw new Exception("Nijedan gost nije nadjen");
            }
            srediFormu(aThis);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(aThis, e.getMessage());
            e.printStackTrace();
        }
    }

    public void prikaziSveGoste(FrmPretragaGosta aThis)  {
        try {
            Zahtev zahtev = new Zahtev();
            zahtev.setOperation(Operacija.UCITAJ_SVE_GOSTE);

            Komunikacija.getInstance().posaljiZahtev(zahtev);
            Odgovor odg = Komunikacija.getInstance().primiOdgovor();
            if (odg.getStatus() == StatusOdgovora.ERROR) {
                throw new Exception(odg.getPoruka());
            }
            gosti = (List<Gost>) odg.getData();
            if (gosti.isEmpty()) {
                srediFormu(aThis);
                throw new Exception("Ne postoji nijedan gost u bazi");
            }
            srediFormu(aThis);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(aThis, ex.getMessage());
            ex.printStackTrace();

        }
    }

//    private Gost izabraniGost(FrmPretragaGosta aThis) throws Exception {
//        int red = aThis.getTblGosti().getSelectedRow();
//        if (red == -1) {
//            throw new Exception("Morate izabrati gosta iz tabele");
//        }
//        return gosti.get(red);
//    }
//
//    public void izmeniGosta(FrmPretragaGosta aThis) {
//        Gost g = izabraniGost(aThis);
//
//    }

    public void izbrisiGosta(FrmPretragaGosta aThis)  {
        try {
            Gost g = izabraniGost(aThis);
            Zahtev zahtev= new Zahtev();
            zahtev.setOperation(Operacija.IZBRISI_GOSTA);
            zahtev.setData(g);
            Komunikacija.getInstance().posaljiZahtev(zahtev);
            Odgovor odg= Komunikacija.getInstance().primiOdgovor();
             if (odg.getStatus() == StatusOdgovora.ERROR) {
                throw new Exception(odg.getPoruka());
            }
            JOptionPane.showMessageDialog(aThis, odg.getPoruka());
            srediFormu(aThis);
        } catch (Exception ex) {
              JOptionPane.showMessageDialog(aThis, ex.getMessage());
            ex.printStackTrace(); }
            
        }

   
          
    }
    

