package sn.sir.wallet.sirwalletapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.sir.wallet.sirwalletapp.model.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {


}
