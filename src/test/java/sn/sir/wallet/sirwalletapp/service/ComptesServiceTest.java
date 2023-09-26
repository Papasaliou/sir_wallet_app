package sn.sir.wallet.sirwalletapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sn.sir.wallet.sirwalletapp.model.Comptes;
import sn.sir.wallet.sirwalletapp.model.Users;
import sn.sir.wallet.sirwalletapp.repository.ComptesRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ComptesServiceTest {
    @Autowired
    private ComptesService comptesService;
    @Autowired
    private ComptesRepository comptesRepository;
    @Mock
    private ComptesRepository comptesRepository1;
    @Test
    void findAll() {
        int nomberOfComptes = comptesService.listeCompte().size();
        //Given
        List<Comptes> initComptes = List.of(
                new Comptes(1, 2366.3, new Date(1), "1256355366", 1),
                new Comptes(2, 2342.1, new Date(1), "2535366262L", 2));

        // simulate the behavior of the customerRepository to call Database and return the initCustomers
        when(comptesRepository1.findAll()).thenReturn(initComptes);
        //when
        List<Comptes> comptes = comptesService.listeCompte();
        //Then
        assertEquals(nomberOfComptes, comptes.size());
    }
    @Test
    public void testGetCompteById() {
        Comptes mockCompte = new Comptes(9, 20094.0,new Date(),"2536638209L",1);
        when(comptesRepository1.findById(9)).thenReturn(Optional.of(mockCompte));
        Comptes comptes = comptesService.getCompteById(9);
        assertThat(comptes).isNotNull();
        assertThat(comptes.getId()).isEqualTo(9);
        assertThat(comptes.getSolde()).isEqualTo(20094.0);
    }
    @Test
    public void testCreerCompte() {
        // Création d'un compte DTO
        Comptes comptes = new Comptes(28, 20094.0,new Date(),"2536638209L",8);

        // Appel de la méthode à tester
        int idCompte = comptesService.creerCompte(comptes);

        Optional<Comptes> comptesOptional = comptesRepository.findById(idCompte);
        if (comptesOptional.isPresent()) {
            Comptes comptesRetrouve = comptesOptional.get();
            // Vérification des propriétés du compte
            Assertions.assertEquals(comptes.getId(), comptesRetrouve.getId());
            Assertions.assertEquals(comptes.getSolde(), comptesRetrouve.getSolde());
            Assertions.assertEquals(comptes.getIdUser(), comptesRetrouve.getIdUser());
        } else {
            // Le compte n'existe pas
        }

    }
}