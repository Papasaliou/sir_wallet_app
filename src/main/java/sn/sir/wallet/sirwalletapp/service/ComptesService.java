package sn.sir.wallet.sirwalletapp.service;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sn.sir.wallet.sirwalletapp.model.Comptes;
import sn.sir.wallet.sirwalletapp.model.Users;
import sn.sir.wallet.sirwalletapp.repository.ComptesRepository;
import sn.sir.wallet.sirwalletapp.repository.UsersRepository;

import java.util.List;

@Service
public class ComptesService {
    private  final ComptesRepository comptesRepository;
    private final UsersRepository usersRepository;

    public ComptesService(UsersRepository usersRepository,ComptesRepository comptesRepository) {
        this.usersRepository = usersRepository;
        this.comptesRepository= comptesRepository;
    }
    public List<Comptes> listeCompte() {
        final List<Comptes> comptess = comptesRepository.findAll(Sort.by("id"));
        return comptess.stream()
                .map(comptes -> mapToDTO(comptes, new Comptes()))
                .toList();
    }
    public int creerCompte(final Comptes comptesDTO) {
        final Comptes comptes = new Comptes();
        mapToEntity(comptesDTO, comptes);
        return comptesRepository.save(comptes).getId();
    }

    public Comptes getCompteById(final int id) {
        try {
            return comptesRepository.findById(id)
                    .map(comptes -> mapToDTO(comptes, new Comptes()))
                    .orElseThrow(ChangeSetPersister.NotFoundException::new);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private Comptes mapToDTO(final Comptes comptes, final Comptes comptesDTO) {
        comptesDTO.setId(comptes.getId());
        comptesDTO.setSolde(comptes.getSolde());
        comptesDTO.setDateOuverture(comptes.getDateOuverture());
        comptesDTO.setMotDePasse(comptes.getMotDePasse());
        comptesDTO.setIdUser(comptes.getIdUser());
        return comptesDTO;
    }

    private Comptes mapToEntity(final Comptes comptesDTO, final Comptes comptes) {
        comptes.setSolde(comptesDTO.getSolde());
        comptes.setDateOuverture(comptesDTO.getDateOuverture());
        comptes.setMotDePasse(comptesDTO.getMotDePasse());
        comptes.setIdUser(comptesDTO.getIdUser());
        return comptes;
    }
}
