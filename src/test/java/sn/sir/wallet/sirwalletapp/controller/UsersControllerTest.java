package sn.sir.wallet.sirwalletapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import sn.sir.wallet.sirwalletapp.SirWalletAppApplication;
import sn.sir.wallet.sirwalletapp.model.Users;
import sn.sir.wallet.sirwalletapp.repository.UsersRepository;
import sn.sir.wallet.sirwalletapp.service.UsersService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
//@DataJpaTest
//@ContextConfiguration (classes = Users.class)
@SpringBootTest
class UsersControllerTest {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersService usersService;
    @Autowired
    private UsersController usersController;
    @Autowired
    public UsersControllerTest(UsersRepository usersRepository, UsersService usersService, UsersController usersController) {

        this.usersRepository = usersRepository;
        this.usersService = usersService;
        this.usersController = usersController;
    }

    @Test
    public void testGetUserById() {
        int id = 10;
        Users users = usersRepository.findById(id).orElse(null);
        assertNotNull(users);
        assertEquals(id, users.getId());
    }
}