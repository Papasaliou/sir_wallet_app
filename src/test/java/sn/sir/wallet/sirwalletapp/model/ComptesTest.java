package sn.sir.wallet.sirwalletapp.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ComptesTest {
    @Test
    public void testCompteConstructorAndGetters()
    {
        int id = 1;
        Double solde = 2000.2;
        Date dateOuverture = new Date(2);
        String motDePasse = "motDePasse";
        int idUser = 2;

        Comptes comptes=new  Comptes(id,  solde,  dateOuverture,  motDePasse,  idUser) ;

        assertEquals(id,comptes.getId());
        assertEquals(solde,comptes.getSolde());
        assertEquals(dateOuverture,comptes.getDateOuverture());
        assertEquals(motDePasse,comptes.getMotDePasse());
        assertEquals(idUser,comptes.getIdUser());
    }

    @Test
    public void testCompteSetters()
    {
        Comptes compte = new Comptes();
        compte.setId(1);
        compte.setSolde(2000.2);
        compte.setDateOuverture(new Date(2));
        compte.setMotDePasse("motDePasse");
        compte.setIdUser(2);

        assertEquals(1, compte.getId());
        assertEquals(2000.2, compte.getSolde());
        assertEquals(new Date(2), compte.getDateOuverture());
        assertEquals("motDePasse", compte.getMotDePasse());
        assertEquals(2, compte.getIdUser());
    }


}