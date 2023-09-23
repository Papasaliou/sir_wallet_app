package sn.sir.wallet.sirwalletapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.sir.wallet.sirwalletapp.model.Comptes;
@Repository
public interface ComptesRepository extends JpaRepository<Comptes,Integer> {

}
