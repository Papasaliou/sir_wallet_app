package sn.sir.wallet.sirwalletapp.service;

import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sn.sir.wallet.sirwalletapp.model.Comptes;
import sn.sir.wallet.sirwalletapp.model.Transactions;
import sn.sir.wallet.sirwalletapp.repository.ComptesRepository;
import sn.sir.wallet.sirwalletapp.repository.TransactionsRepository;
import sn.sir.wallet.sirwalletapp.repository.UsersRepository;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TransactionsServiceTest {
    private TransactionsRepository transactionsRepository;
    @Autowired
    private ComptesRepository comptesRepository;
    @Autowired
    private final TransactionsService transactionsService;
    @Autowired
    private ComptesService comptesService;
    @Autowired
    public TransactionsServiceTest( TransactionsService transactionsService,TransactionsRepository transactionsRepository,ComptesRepository comptesRepository,ComptesService comptesService) {
        this.transactionsService = transactionsService;
        this.transactionsRepository=transactionsRepository;
        this.comptesRepository=comptesRepository;
        this.comptesService=comptesService;
    }
//    @Test
//    public void testCreer() {
//        // Création d'un compte
//        Transactions transactions = new Transactions(20,100.0,new Date(),1,1,3);
////
//        // Appel de la méthode à tester
//        transactionsService.createTransaction(transactions);
//
//        // Récupération du compte créé
//        Transactions transactionTrouvee = transactionsService.getTransaction(12);
//
//        // Vérification du résultat
//        Assertions.assertEquals(transactionTrouvee.getMontant(), transactions.getMontant());
//        Assertions.assertEquals(transactionTrouvee.getEtat(), 1);
//    }

    @Test
    public void testTransfert() {
        int ide=11;
        int idr=10;

        // Création de deux objets Comptes
        Comptes comptes1 =comptesRepository.findById(ide).get();
        Comptes comptes2 = comptesRepository.findById(idr).get();

        // Initialisation des solde et montantTransaction
        double solde1 = comptes1.getSolde();
        double solde2 = comptes2.getSolde();
        double montantTransaction = 50.0;
        transactionsService.transfert(comptes1, comptes2, montantTransaction);

        // Vérification des résultats
        assertEquals(solde1 - montantTransaction, comptes1.getSolde());
        assertEquals(solde2 + montantTransaction, comptes2.getSolde());
    }
    @Test
    public void testDepopt() {
        int id=11;

        // Création de deux objets Comptes
        Comptes comptes =comptesRepository.findById(id).get();
        // Initialisation des solde et montantTransaction
        double solde = comptes.getSolde();
        double montantTransaction = 50.0;
        transactionsService.depot(comptes, montantTransaction);

        // Vérification des résultats

        assertEquals(solde + montantTransaction, comptes.getSolde());
    }
    @Test
    public void testRetrait() {
        int id=11;
        // Création de deux objets Comptes
        Comptes comptes =comptesRepository.findById(id).get();
        // Initialisation des solde et montantTransaction
        double solde = comptes.getSolde();
        double montantTransaction = 50.0;
        transactionsService.retrait(comptes, montantTransaction);

        // Vérification des résultats

        assertEquals(solde - montantTransaction, comptes.getSolde());
    }

//    @Test
//    public void testAnnulerTransaction() {
//        // Création de deux comptes
//        Comptes comptes1 =comptesRepository.findById(10).get();
//        Comptes comptes2 = comptesRepository.findById(11).get();
//        // Création d'une transaction
//        Transactions transactions = new Transactions(28,500.0,new Date(),1,comptes1.getId(),comptes2.getId());
//        // Enregistrement de la transaction dans la base de données
//        int id=transactionsRepository.save(transactions).getId();
//        // Appel de la méthode à tester
//        Optional<Transactions> transactionsOptional = transactionsRepository.findById(transactions.getId());
//        if (transactionsOptional.isPresent()) {
//           Transactions  transactionTrouvee = transactionsOptional.get();
//            transactionsService.annullerTransaction(transactionTrouvee.getId());
//            Assertions.assertEquals(comptes1.getSolde(), 1500.0);
//            Assertions.assertEquals(comptes2.getSolde(), 1500.0);
//            // Vérification de l'état de la transaction
//            Transactions transactionAnnulee = transactionsRepository.findById(transactions.getId()).get();
//            Assertions.assertEquals(transactionAnnulee.getEtat(), 0);
//        } else {
//            // Le compte n'existe pas
//        }


    }
