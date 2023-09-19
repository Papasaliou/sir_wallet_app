package sn.sir.wallet.sirwalletapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.sir.wallet.sirwalletapp.model.Comptes;

public interface ComptesRepository extends JpaRepository<Comptes,Integer> {
}
