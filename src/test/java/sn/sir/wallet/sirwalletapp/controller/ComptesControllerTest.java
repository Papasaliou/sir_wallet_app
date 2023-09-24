package sn.sir.wallet.sirwalletapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sn.sir.wallet.sirwalletapp.model.Comptes;
import sn.sir.wallet.sirwalletapp.model.Transactions;
import sn.sir.wallet.sirwalletapp.repository.ComptesRepository;
import sn.sir.wallet.sirwalletapp.service.ComptesService;

import static org.junit.jupiter.api.Assertions.*;
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
}