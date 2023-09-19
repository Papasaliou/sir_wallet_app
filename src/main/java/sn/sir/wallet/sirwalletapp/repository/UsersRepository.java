package sn.sir.wallet.sirwalletapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.sir.wallet.sirwalletapp.model.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {

}
