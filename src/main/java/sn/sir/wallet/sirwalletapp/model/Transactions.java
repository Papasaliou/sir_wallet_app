package sn.sir.wallet.sirwalletapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Transactions {
    @Id
    private Long id;
    @Column
    private Double montant;
    @Column
    private Date date;
    @Column
    private int etat;
    @Column
    private int idE;
    @Column
    private int idR;

    public Transactions(Long id, Double montant, Date date, int etat, int idE, int idR) {
        this.id = id;
        this.montant = montant;
        this.date = date;
        this.etat = etat;
        this.idE = idE;
        this.idR = idR;
    }
    public Transactions(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }
}
