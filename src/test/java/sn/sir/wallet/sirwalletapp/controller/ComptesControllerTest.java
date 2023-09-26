package sn.sir.wallet.sirwalletapp.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sn.sir.wallet.sirwalletapp.model.Comptes;
import sn.sir.wallet.sirwalletapp.model.Transactions;
import sn.sir.wallet.sirwalletapp.repository.ComptesRepository;
import sn.sir.wallet.sirwalletapp.service.ComptesService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
class ComptesControllerTest {
    @Autowired
    private ComptesController comptesController;
    @Autowired
    private ComptesService comptesService;
    @Autowired
    private ComptesRepository comptesRepository;
    @Autowired

    public ComptesControllerTest(ComptesController comptesController, ComptesService comptesService, ComptesRepository comptesRepository) {
        this.comptesController = comptesController;
        this.comptesService = comptesService;
        this.comptesRepository = comptesRepository;
    }
    @Test
    public void testGetCompteById() {
        int id = 9;
        Comptes comptes   = comptesRepository.findById(id).orElse(null);
        assertNotNull(comptes);
        assertEquals(id, comptes.getId());
    }
    @Test
    public void testGetById() {
        int id = 9;
        Comptes comptes   = comptesController.CompteById(id);
        assertNotNull(comptes);
        assertEquals(id, comptes.getId());
    }

    @Test
    public void testCreer() {
        // Création d'un compte
        Comptes comptes = new Comptes(19,100.0,new Date(),"Compte1",7);
//
        // Appel de la méthode à tester
        comptesService.creerCompte(comptes);

        // Récupération du compte créé
        Comptes compteTrouve = comptesService.getCompteById(19);

        // Vérification du résultat
        Assertions.assertEquals(compteTrouve.getMotDePasse(), "Compte1");
        Assertions.assertEquals(compteTrouve.getSolde(), 100.0);
    }
    @Test
    public void creerCompte()
    {
        Comptes comptes=new Comptes(29,1934.2,new Date(),"uyte354",9);
        comptesController.creer(comptes);
    }

}
