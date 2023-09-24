package sn.sir.wallet.sirwalletapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sn.sir.wallet.sirwalletapp.model.Transactions;
import sn.sir.wallet.sirwalletapp.model.Users;
import sn.sir.wallet.sirwalletapp.repository.TransactionsRepository;
import sn.sir.wallet.sirwalletapp.service.TransactionsService;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TransactionsControllerTest {
    @Autowired
    private  TransactionsController transactionsController;
    @Autowired
    private TransactionsService transactionsService;
    @Autowired
    private TransactionsRepository transactionsRepository;
    @Autowired
    public TransactionsControllerTest(TransactionsController transactionsController, TransactionsService transactionsService, TransactionsRepository transactionsRepository) {
        this.transactionsController = transactionsController;
        this.transactionsService = transactionsService;
        this.transactionsRepository = transactionsRepository;
    }
    @Test
    public void testGetTransactionById() {
        int id = 10;
        Transactions transactionss  = transactionsRepository.findById(id).orElse(null);
        assertNotNull(transactionss);
        assertEquals(id, transactionss.getId());
    }
}