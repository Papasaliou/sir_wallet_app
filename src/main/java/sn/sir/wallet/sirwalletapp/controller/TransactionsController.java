package sn.sir.wallet.sirwalletapp.controller;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.sir.wallet.sirwalletapp.model.Comptes;
import sn.sir.wallet.sirwalletapp.model.Transactions;
import sn.sir.wallet.sirwalletapp.model.Users;
import sn.sir.wallet.sirwalletapp.service.ComptesService;
import sn.sir.wallet.sirwalletapp.service.TransactionsService;
import sn.sir.wallet.sirwalletapp.service.UsersService;

import java.util.List;

@RestController
@RequestMapping(path = "Transactions")
public class TransactionsController {
    private UsersService usersService;
    private ComptesService comptesService;
    private TransactionsService transactionsService;

    public TransactionsController(UsersService usersService, ComptesService comptesService, TransactionsService transactionsService) {
        this.usersService = usersService;
        this.comptesService = comptesService;
        this.transactionsService = transactionsService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transactions> listTransaction() {
        return this.transactionsService.findAllTransaction();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void creatTransaction(@RequestBody Transactions transactions){
        this.transactionsService.createTransaction(transactions);
    }

    @GetMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Transactions transactionsById(@PathVariable int id) {
        return this.transactionsService.getTransaction(id);
    }

    @PostMapping(path = "{id}/depot/{montant}")
    public void depot(@PathVariable int id, @PathVariable Double montant)
    {
        Comptes comptes=comptesService.getCompteById(id);
        this.transactionsService.depot(comptes, montant);
    }

    @PostMapping(path = "{id}/retrait/{montant}")
    public void retrait(@PathVariable int id, @PathVariable Double montant)
    {
        Comptes comptes=comptesService.getCompteById(id);
        this.transactionsService.retrait(comptes, montant);
    }

    @PostMapping(path = "{idE}/transfert/{montant}/{idR}")
    public void transfert(@PathVariable int idE,@PathVariable int idR, @PathVariable Double montant)
    {
        Comptes comptes1=comptesService.getCompteById(idE);
        Comptes comptes2=comptesService.getCompteById(idR);
        this.transactionsService.transfert(comptes1,comptes2, montant);
    }
    @PostMapping(path = "annuler/{id}")
    public void annulerT(@PathVariable int id)
    {
        this.transactionsService.annullerTransaction(id);
    }

}
