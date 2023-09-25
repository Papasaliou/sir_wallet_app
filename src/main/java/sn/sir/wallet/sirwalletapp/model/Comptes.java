package sn.sir.wallet.sirwalletapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
@Entity
public class Comptes {
    @Id
   // @Column(nullable = false, updatable = false)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Double solde;
    @Column
    private Date dateOuverture;
    @Column
    private String motDePasse;
    @Column
    //@JoinColumn(name = "idUser", unique = true)
    private int idUser;

    public Comptes(int id, Double solde, Date dateOuverture, String motDePasse, int idUser) {
        this.id = id;
        this.solde = solde;
        this.dateOuverture = dateOuverture;
        this.motDePasse = motDePasse;
        this.idUser = idUser;
    }

    public Comptes() {
    }

    public Comptes(int  l, double v) {
        this.id=l;
        this.solde=solde;
    }
    public Comptes( double v,Date dateOuverture,String mdp,int iduser) {
        this.solde=solde;
        this.dateOuverture=dateOuverture;
        this.motDePasse=mdp;
        this.idUser=iduser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
