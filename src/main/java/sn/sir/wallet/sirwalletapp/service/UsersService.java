package sn.sir.wallet.sirwalletapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sn.sir.wallet.sirwalletapp.model.Users;
import sn.sir.wallet.sirwalletapp.repository.UsersRepository;

import java.io.NotActiveException;
import java.util.List;

@Service
public class UsersService {
   private UsersRepository usersRepository;
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public int creer(Users users){
        final Users userss = new Users();
        mapToEntity(users, userss);
        return usersRepository.save(users).getId();
    }
    public List<Users> listeUsers(){
        final List<Users> userss = usersRepository.findAll(Sort.by("id"));
        return userss.stream()
                .map(users -> mapToDTO(users, new Users()))
                .toList();
    }
    public Users get(final int id) {
        try {
            return usersRepository.findById(id)
                    .map(users -> mapToDTO(users, new Users())).
                    orElseThrow(ChangeSetPersister.NotFoundException::new);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(final int id) {
        usersRepository.deleteById(id);
    }
    private Users mapToDTO(final Users users, final Users usersDTO) {
        usersDTO.setId(users.getId());
        usersDTO.setPrenom(users.getPrenom());
        usersDTO.setNom(users.getNom());
        usersDTO.setcNI(users.getcNI());
        usersDTO.setTelephone(users.getTelephone());
        //usersDTO.setComptes(users.getComptes() == null ? null : users.getComptes().getId());
        return usersDTO;
    }
    private Users mapToEntity(final Users usersDTO, final Users users) {
        users.setPrenom(usersDTO.getPrenom());
        users.setNom(usersDTO.getNom());
        users.setcNI(usersDTO.getcNI());
        users.setTelephone(usersDTO.getTelephone());
//        final Comptes comptes = usersDTO.getComptes() == null ? null : comptesRepository.findById(usersDTO.getComptes())
//                .orElseThrow(() -> new NotFoundException("comptes not found"));
//        users.setComptes(comptes);
        return users;
    }
}
