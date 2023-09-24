package sn.sir.wallet.sirwalletapp.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;
import sn.sir.wallet.sirwalletapp.model.Users;
import sn.sir.wallet.sirwalletapp.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
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
    @Test
    public void testGetUserById_Success() {
        Users mockUser = new Users(1, "Abdou","Mbaye",2536638209L,76255432L);
        when(usersRepository1.findById(1)).thenReturn(Optional.of(mockUser));
        Users user = usersService.get(1);
        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.getPrenom()).isEqualTo("Abdou");
    }
    @Test
    public void testGetUserNotFound() {
        when(usersRepository1.findById(2)).thenReturn(Optional.empty());
        try {
            usersService.get(2);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            // Assertions
            assertThat(e.getCause()).isInstanceOf(ChangeSetPersister.NotFoundException.class);
        }
    }
}