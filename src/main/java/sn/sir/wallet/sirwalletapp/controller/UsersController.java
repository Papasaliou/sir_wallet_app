package sn.sir.wallet.sirwalletapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sn.sir.wallet.sirwalletapp.model.Users;
import sn.sir.wallet.sirwalletapp.service.UsersService;

import java.util.List;

@RestController
@RequestMapping(path = "Users")
public class UsersController {
    private UsersService usersService;
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Users users){
        this.usersService.creer(users);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> listeClient() {
        return this.usersService.listeUsers();
    }
    @GetMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Users userById(@PathVariable int id) {
        return this.usersService.get(id);
    }

//
}
