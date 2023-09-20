package sn.sir.wallet.sirwalletapp.service;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sn.sir.wallet.sirwalletapp.model.Comptes;
import sn.sir.wallet.sirwalletapp.model.Transactions;
import sn.sir.wallet.sirwalletapp.repository.ComptesRepository;
import sn.sir.wallet.sirwalletapp.repository.TransactionsRepository;
import sn.sir.wallet.sirwalletapp.repository.UsersRepository;

import java.util.Date;
import java.util.List;

@Service
public class TransactionsService {
    private ComptesRepository comptesRepository;
    private UsersRepository usersRepository;
    private TransactionsRepository transactionsRepository;

    public TransactionsService(ComptesRepository comptesRepository, UsersRepository usersRepository, TransactionsRepository transactionsRepository) {
        this.comptesRepository = comptesRepository;
        this.usersRepository = usersRepository;
        this.transactionsRepository = transactionsRepository;
    }

    public void annullerTransaction(int id)
    {
        Transactions transactions= transactionsRepository.getReferenceById(id);
        if(transactions.getEtat()==1)
        {
            Comptes comptes1=comptesRepository.getReferenceById(transactions.getIdE());
            Comptes comptes2=comptesRepository.getReferenceById(transactions.getIdR());
            Double soldeActuelCmp1= comptes1.getSolde();
            Double soldeActuelCmp2= comptes2.getSolde();
            comptes2.setSolde(soldeActuelCmp2-transactions.getMontant());
            comptes1.setSolde(soldeActuelCmp1+transactions.getMontant());
            transactions.setEtat(0);
            transactionsRepository.save(transactions);
            comptesRepository.save(comptes1);
            comptesRepository.save(comptes2);
        }

    }

    public void depot(final Comptes comptes,Double montantTransaction)
    {
        Double soldeActuel=comptes.getSolde();
        Double NouveauSolde  =soldeActuel+montantTransaction;
        comptes.setSolde(NouveauSolde);
        comptesRepository.save(comptes);
        insertIntoTransaction(montantTransaction,comptes.getId(),comptes.getId());
    }

    public void retrait(final Comptes comptes,Double montantTransaction)
    {
        if(comptes.getSolde()>=montantTransaction)
        {
            Double soldeActuel=comptes.getSolde();
            Double nouveauSolde  =soldeActuel-montantTransaction;
            comptes.setSolde(nouveauSolde);
            comptesRepository.save(comptes);
            insertIntoTransaction(montantTransaction,comptes.getId(),comptes.getId());
        }
    }

    public void transfert(final Comptes comptes1, final Comptes comptes2, Double montantTransaction)
    {
        if(comptes1.getSolde()>=montantTransaction)
        {
            comptes1.setSolde(comptes1.getSolde()-montantTransaction);
            comptesRepository.save(comptes1);
            comptes2.setSolde(comptes2.getSolde()+montantTransaction);
            comptesRepository.save(comptes2);
            insertIntoTransaction(montantTransaction,comptes1.getId(),comptes2.getId());
        }
    }

    public void insertIntoTransaction(Double montant,int idE,int idR)
    {
        Transactions transactions =new Transactions();
        transactions.setMontant(montant);
        transactions.setEtat(1);
        transactions.setIdE(idE);
        transactions.setIdR(idR);
        this.transactionsRepository.save(transactions);
    }

    public int createTransaction(final Transactions transactionsDTO) {
        final Transactions transactions = new Transactions();
        mapToEntity(transactionsDTO, transactions);
        return transactionsRepository.save(transactions).getId();
    }

    public List<Transactions> findAllTransaction() {
        final List<Transactions> transactionss = transactionsRepository.findAll(Sort.by("id"));
        return transactionss.stream()
                .map(transactions -> mapToDTO(transactions, new Transactions()))
                .toList();
    }

    public Transactions getTransaction(final int id) {
        try {
            return transactionsRepository.findById(id)
                    .map(transactions -> mapToDTO(transactions, new Transactions()))
                    .orElseThrow(ChangeSetPersister.NotFoundException::new);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Transactions mapToDTO(final Transactions transactions,
                                     final Transactions transactionsDTO) {
        transactionsDTO.setId(transactions.getId());
        transactionsDTO.setMontant(transactions.getMontant());
        transactionsDTO.setDate(transactions.getDate());
        transactionsDTO.setEtat(transactions.getEtat());
        transactionsDTO.setIdE(transactions.getIdE());
        transactionsDTO.setIdR(transactions.getIdR());
//        transactionsDTO.setComptes(transactions.getComptes() == null ? null : transactions.getComptes().getId());
//        transactionsDTO.setComptess(transactions.getComptess() == null ? null : transactions.getComptess().getId());
        return transactionsDTO;
    }

    private Transactions mapToEntity(final Transactions transactionsDTO,
                                     final Transactions transactions) {
        transactionsDTO.setMontant(transactions.getMontant());
        transactionsDTO.setDate(transactions.getDate());
        transactionsDTO.setEtat(transactions.getEtat());
        transactionsDTO.setIdE(transactions.getIdE());
        transactionsDTO.setIdR(transactions.getIdR());
//        final Comptes comptes = transactionsDTO.getComptes() == null ? null : comptesRepository.findById(transactionsDTO.getComptes())
//                .orElseThrow(() -> new NotFoundException("comptes not found"));
//        transactions.setComptes(comptes);
//        final Comptes comptess = transactionsDTO.getComptess() == null ? null : comptesRepository.findById(transactionsDTO.getComptess())
//                .orElseThrow(() -> new NotFoundException("comptess not found"));
//        transactions.setComptess(comptess);
        return transactions;
    }




}
