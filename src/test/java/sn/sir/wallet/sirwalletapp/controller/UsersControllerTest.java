package sn.sir.wallet.sirwalletapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sn.sir.wallet.sirwalletapp.SirWalletAppApplication;
import sn.sir.wallet.sirwalletapp.model.Comptes;
import sn.sir.wallet.sirwalletapp.model.Users;
import sn.sir.wallet.sirwalletapp.repository.UsersRepository;
import sn.sir.wallet.sirwalletapp.service.UsersService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@DataJpaTest
//@ContextConfiguration (classes = Users.class)

@SpringBootTest
//@TestConfiguration
class UsersControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersService usersService;
//    @MockBean
//    private UsersService usersService1;
    @Autowired
    private UsersController usersController;
    @Autowired
    public UsersControllerTest(UsersRepository usersRepository, UsersService usersService, UsersController usersController,UsersService usersService1) {

        this.usersRepository = usersRepository;
        this.usersService = usersService;
        this.usersController = usersController;
        //this.usersService1=usersService1;
    }
    @Test
    public void testGetUserById() {
        int id = 10;
        Users users = usersRepository.findById(id).orElse(null);
        assertNotNull(users);
        assertEquals(id, users.getId());
    }
    @Test
    public void listUser(){
        int nbUsers=usersRepository.findAll().size();
        int nb=usersController.listeClient().size();
        assertEquals(nbUsers,nb);
    }
    @Test
    public void creatUsers()
    {
        Users users=new Users(10,"Khady","Kandji",2736637209L,772534422L);
        usersController.creer(users);
    }
    @Test
    public void testGetById() {
        int id = 10;
        Users user   = usersController.userById(id);
        assertNotNull(user);
        assertEquals(id, user.getId());
    }

}