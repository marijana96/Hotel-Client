/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domain.Drzava;
import domain.Gost;
import komunikacija.Komunikacija;
import domain.User;
import forme.gost.FrmPretragaGosta;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import transfer.Zahtev;
import transfer.Odgovor;
import transfer.util.StatusOdgovora;
import transfer.util.Operacija;

/**
 *
 * @author marij
 */
public class Kontroler {
    private static Kontroler instance;
     List<Gost> listGosti;
    private Kontroler(){
        listGosti=null;
}
       
    public static Kontroler getInstance() {
    if(instance==null){
        instance=new Kontroler();
    }
        return instance;
    }
    
    public User logIn(String username,String password) throws Exception{
        User user= new User();
        user.setUsername(username);
        user.setPassword(password);
        Zahtev zahtev= new Zahtev(Operacija.OPERATION_LOGIN, user);
        Komunikacija.getInstance().posaljiZahtev(zahtev);
        Odgovor odgovor=Komunikacija.getInstance().primiOdgovor();
        if(odgovor.getStatus()==StatusOdgovora.OK){
            return (User) odgovor.getData();
        }
        Exception ex= (Exception) odgovor.getError();
        throw ex;
    }

    public List<Drzava> ucitajSveDrzave() throws IOException, ClassNotFoundException {
    Zahtev zahtev= new Zahtev();
    zahtev.setOperation(Operacija.UCITAJ_SVE_DRZAVE);
    Komunikacija.getInstance().posaljiZahtev(zahtev);
    Odgovor odg= Komunikacija.getInstance().primiOdgovor();
    List<Drzava> lista= new LinkedList<>();
    lista=(List<Drzava>) odg.getData();
    return lista;
    }

   

    public List<Gost> pretraziGoste(FrmPretragaGosta aThis, String kriterijum) {
 
        try {
            Zahtev z= new Zahtev();
            z.setOperation(Operacija.PRETRAZI_GOSTE);
            z.setData(kriterijum);
            Komunikacija.getInstance().posaljiZahtev(z);
            Odgovor odg= Komunikacija.getInstance().primiOdgovor();
            if(odg.getStatus()==StatusOdgovora.ERROR){
              JOptionPane.showMessageDialog(aThis, odg.getPoruka(),"Greska", JOptionPane.ERROR_MESSAGE);
        }
        
      listGosti=(List<Gost>)odg.getData();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(aThis, ex.getMessage(),"Greska", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
        }
         return listGosti;
    } 

   
}
