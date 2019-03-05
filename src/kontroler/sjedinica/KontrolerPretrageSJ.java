/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.sjedinica;

import domain.Gost;
import domain.SmestajnaJedinica;
import forme.sjedinica.FrmPretragaSJedinica;
import forme.sjedinica.model.ModelTabeleSJedinice;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import komunikacija.Komunikacija;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.util.Operacija;
import transfer.util.StatusOdgovora;

/**
 *
 * @author marij
 */
public class KontrolerPretrageSJ {
List<SmestajnaJedinica> list;
    public KontrolerPretrageSJ() {
        list=new LinkedList<>();
    }

    public void srediFormu(FrmPretragaSJedinica aThis) {
        popuniTabelu(aThis.getTblSJedinice()); }

    private void popuniTabelu(JTable tblSJedinice) {
        ModelTabeleSJedinice mts=new ModelTabeleSJedinice(list);
        tblSJedinice.setModel(mts);
        mts.fireTableDataChanged();
    }

    public void prikaziSveSJ(FrmPretragaSJedinica aThis) {
     try{
        Zahtev zahtev = new Zahtev();
            zahtev.setOperation(Operacija.UCITAJ_SVE_SJEDINICE);

            Komunikacija.getInstance().posaljiZahtev(zahtev);
            Odgovor odg = Komunikacija.getInstance().primiOdgovor();
            if (odg.getStatus() == StatusOdgovora.ERROR) {
                throw new Exception(odg.getPoruka());
            }
            list = (List<SmestajnaJedinica>) odg.getData();
            if (list.isEmpty()) {
                srediFormu(aThis);
                throw new Exception("Ne postoji nijedna smestajn jedinica u bazi");
            }
            srediFormu(aThis);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(aThis, ex.getMessage());
            ex.printStackTrace();

        }
    }

    public void nadjiSJedinicePoBroju(FrmPretragaSJedinica aThis) {
    try {
            String kriterijum = aThis.getTxtKriterujum().getText();
            if (kriterijum.isEmpty()) {
                throw new Exception("Morate uneti kriterijum pretrage");
            }

            Zahtev zahtev = new Zahtev();
            zahtev.setOperation(Operacija.PRETRAZI_SJEDINICEBROJ);
            zahtev.setData(kriterijum);
            Komunikacija.getInstance().posaljiZahtev(zahtev);
            Odgovor odg = Komunikacija.getInstance().primiOdgovor();
            if (odg.getStatus() == StatusOdgovora.ERROR) {
                throw new Exception(odg.getPoruka());
            }
           list = (List<SmestajnaJedinica>) odg.getData();
            if (list.isEmpty()) {
                srediFormu(aThis);
                throw new Exception("Nijedna smestajna jedinica nije nadjena.");
            }
            srediFormu(aThis);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(aThis, e.getMessage());
            e.printStackTrace();
        }
    }

    public void nadjiSJedinicePoTipu(FrmPretragaSJedinica aThis) {
        srediFormu(aThis);
        try {
            String kriterijum = aThis.getTxtKriterujum().getText();
            if (kriterijum.isEmpty()) {
                throw new Exception("Morate uneti kriterijum pretrage");
            }

            Zahtev zahtev = new Zahtev();
            zahtev.setOperation(Operacija.PRETRAZI_SJEDINICETIP);
            zahtev.setData(kriterijum);
            Komunikacija.getInstance().posaljiZahtev(zahtev);
            Odgovor odg = Komunikacija.getInstance().primiOdgovor();
            if (odg.getStatus() == StatusOdgovora.ERROR) {
                throw new Exception(odg.getPoruka());
            }
           list = (List<SmestajnaJedinica>) odg.getData();
            if (list.isEmpty()) {
                srediFormu(aThis);
                throw new Exception("Nijedna smestajna jedinica nije nadjena.");
            }
            srediFormu(aThis);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(aThis, e.getMessage());
            e.printStackTrace();
        }
    }
    }
    
