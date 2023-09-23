package sn.sir.wallet.sirwalletapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.sir.wallet.sirwalletapp.model.Transactions;
@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Integer> {

}
