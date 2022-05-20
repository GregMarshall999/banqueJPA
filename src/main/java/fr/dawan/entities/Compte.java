package fr.dawan.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CPTE_TYPE",
        discriminatorType= DiscriminatorType.STRING,length=15)
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
    @ManyToOne
    @JoinColumn(name = "CODE_CLI")
    private Client client;
    @OneToMany(mappedBy = "compte", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Collection<Operation> operations;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
