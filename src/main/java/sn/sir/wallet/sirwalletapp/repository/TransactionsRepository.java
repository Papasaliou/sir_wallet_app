package sn.sir.wallet.sirwalletapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.sir.wallet.sirwalletapp.model.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions,Integer> {
}
