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

}
