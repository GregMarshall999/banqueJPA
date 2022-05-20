package fr.dawan.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("COMPTECOURANT")
public class CompteCourant extends Compte {
    private static final long serialVersionUID = -1414357314344154487L;

    @Column(name = "c_decouvert")
    private double decouvert;

    public CompteCourant() {
        super();
    }

    //region getter/setter
    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
    //endregion

    @Override
    public String toString() {
        return super.toString() +
                ", decouvert=" + decouvert +
                '}';
    }
}
