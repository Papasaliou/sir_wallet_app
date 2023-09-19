package sn.sir.wallet.sirwalletapp.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.sir.wallet.sirwalletapp.model.Comptes;
import sn.sir.wallet.sirwalletapp.model.Users;
import sn.sir.wallet.sirwalletapp.service.ComptesService;

import java.util.List;
@RestController
@RequestMapping(path = "Comptes")
public class ComptesController {
    public ComptesService comptesService;

    public ComptesController(ComptesService comptesService) {
        this.comptesService = comptesService;
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Comptes comptes){
        this.comptesService.creerCompte(comptes);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comptes> listCompte() {
        return this.comptesService.listeCompte();
    }
    @GetMapping (path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Comptes CompteById(@PathVariable int id) {
        return this.comptesService.getCompteById(id);
    }
    @PostMapping(path = "{id}/depot/{montant}")
    public void depot(@PathVariable int id, @PathVariable Double montant)
    {
        Comptes comptes=comptesService.getCompteById(id);
        this.comptesService.depot(comptes, montant);
    }
    @PostMapping(path = "{id}/retrait/{montant}")
    public void retrait(@PathVariable int id, @PathVariable Double montant)
    {
        Comptes comptes=comptesService.getCompteById(id);
        this.comptesService.retrait(comptes, montant);
    }
    @PostMapping(path = "{idE}/transfert/{montant}/{idR}")
    public void transfert(@PathVariable int idE,@PathVariable int idR, @PathVariable Double montant)
    {
        Comptes comptes1=comptesService.getCompteById(idE);
        Comptes comptes2=comptesService.getCompteById(idR);
        this.comptesService.transfert(comptes1,comptes2, montant);
    }

}
