package fr.dawan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Client implements Serializable
{
    private static final long serialVersionUID = 4378677906962590543L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;
    @Column(name = "cl_name")
    private String nom;
    @Column(name = "cl_mail", unique = true)
    private String email;
    @OneToMany(mappedBy = "client")
    private Collection<Compte> comptes;

    public Client()
    {
        super();
    }

    //region getters/setters
    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }

    //endregion
}
