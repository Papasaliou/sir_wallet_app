package sn.sir.wallet.sirwalletapp.model;
import org.antlr.v4.runtime.misc.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Configuration;
import sn.sir.wallet.sirwalletapp.repository.UsersRepository;
import sn.sir.wallet.sirwalletapp.service.UsersService;

import static org.junit.jupiter.api.Assertions.*;

@Configuration
class UsersTest {


    @Test
    public void testUsersConstructorAndGetter()
    {
        int id = 1;
        String prenom = "Khadim";
        String nom = "Mbaye";
        Long cni = 1996347890L;
        Long telephone = 772345899L;

        Users user = new Users(id, prenom, nom, cni, telephone);

        assertEquals(id, user.getId());
        assertEquals(prenom, user.getPrenom());
        assertEquals(nom, user.getNom());
        assertEquals(cni, user.getcNI());
        assertEquals(telephone, user.getTelephone());

    }
    @Test
    public  void testUserSetters()
    {
        Users user = new Users();
        user.setId(1);
        user.setPrenom("Arame");
        user.setNom("Faye");
        user.setcNI(000000000001L);
        user.setTelephone(776349900L);

        assertEquals(1, user.getId());
        assertEquals("Arame", user.getPrenom());
        assertEquals("Faye", user.getNom());
        assertEquals(000000000001L, user.getcNI());
        assertEquals(776349900, user.getTelephone());
    }
}