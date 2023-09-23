package sn.sir.wallet.sirwalletapp.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sn.sir.wallet.sirwalletapp.model.Users;
import sn.sir.wallet.sirwalletapp.repository.UsersRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsersServiceTest {
   @Autowired
    private UsersRepository usersRepository;
   @Mock
   UsersRepository usersRepository1;
    @Autowired
    private UsersService usersService;

    @Autowired
    public UsersServiceTest(UsersRepository usersRepository, UsersService usersService) {
        this.usersRepository = usersRepository;
        this.usersService = usersService;
    }
    @Test
    public void testCreer() {
        //Users users=new Users();
        Users users = new Users("Papa Saliou","LY",12883663728L,773524422L);
        int id = usersService.creer(users);
        // Vérification du résultat
        assertEquals(id, usersRepository.save(users).getId());
    }
    @Test
    void findAll() {
        int nomberOfUsers=usersService.listeUsers().size();
        //Given
        List<Users> initUsers = List.of(
                new Users(1, "Papa saliou", "LY", 1256355366L, 778889988L),
                new Users(2, "Papa Saliou", "Ly", 2535366262L, 778889911L));

        // simulate the behavior of the customerRepository to call Database and return the initCustomers
        when(usersRepository1.findAll()).thenReturn(initUsers);

        //when
        List<Users> customers = usersService.listeUsers();

        //Then
        assertEquals(nomberOfUsers, customers.size());
    }

}