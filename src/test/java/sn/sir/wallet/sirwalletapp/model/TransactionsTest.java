package sn.sir.wallet.sirwalletapp.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsTest {

    @Test
    public void testTransactionsConstructorAndGetter() {
        int id = 1;
        Double montant = 100.0;
        Date date = new Date();
        int etat = 0;
        int idE = 2;
        int idR = 3;

        Transactions transaction = new Transactions(id, montant, date, etat, idE, idR);

        assertEquals(id, transaction.getId());
        assertEquals(montant, transaction.getMontant());
        assertEquals(date, transaction.getDate());
        assertEquals(etat, transaction.getEtat());
        assertEquals(idE, transaction.getIdE());
        assertEquals(idR, transaction.getIdR());
    }

    @Test
    public void testTransactionSetters()
    {
        Users user = new Users();
        user.setId(1);
        user.setPrenom("Khalima");
        user.setNom("Sambe");
        user.setcNI(1234567890L);
        user.setTelephone(772345522L);

        assertEquals(1, user.getId());
        assertEquals("Khalima", user.getPrenom());
        assertEquals("Sambe", user.getNom());
        assertEquals(1234567890L, user.getcNI());
        assertEquals(772345522L, user.getTelephone());
    }

}