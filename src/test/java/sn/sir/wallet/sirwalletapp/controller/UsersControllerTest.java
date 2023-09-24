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

//    @Test
//    public void testListeClient() throws Exception {
//        // Mock la méthode listeUsers() du service
//        List<Users> mockUsers = new ArrayList<>();
//        mockUsers.add(new Users(1, "Abdou","Mbaye",2536638209L,76255432L));
//        mockUsers.add(new Users(2, "Serigne","Mbaye",2536638209L,76255432L));
//        when(usersService1.listeUsers()).thenReturn(mockUsers);
//
//        // Appel de la méthode listeClient() du contrôleur
//        mockMvc.perform(get("/users"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(1L))
//                .andExpect(jsonPath("$[0].prenom").value("Abdou"))
//                .andExpect(jsonPath("$[1].id").value(2L))
//                .andExpect(jsonPath("$[1].prenom").value("Serigne"));
//    }
}