package fr.dawan.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Compte implements Serializable
{
    private static final long serialVersionUID = -2200899635676776204L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numeroCompte;
    @Column(name="c_solde")
    private double solde;
    @Column(name="c_dateCreation")
    private LocalDate dateCreation;

    public Compte()
    {
        super();
    }

    //region getters/setters
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(long numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }
    //endregion

    protected String getCompteType()
    {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString()
    {
        return getCompteType()+"{" +
                "numeroCompte=" + numeroCompte +
                ", solde=" + solde +
                ", dateCreation=" + dateCreation;
    }
}
