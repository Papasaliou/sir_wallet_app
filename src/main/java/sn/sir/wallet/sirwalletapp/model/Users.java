package sn.sir.wallet.sirwalletapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String prenom;
    @Column
    private String nom;
    @Column
    private Long cni;
    @Column
    private Long telephone;

    public Users(int id, String prenom, String nom, Long cni, Long telephone) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.cni = cni;
        this.telephone = telephone;
    }

    public Users() {
    }

    public Users(String papaSaliou, String ly, long l, long l1) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getcNI() {
        return cni;
    }

    public void setcNI(Long cni) {
        this.cni = cni;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }
}
