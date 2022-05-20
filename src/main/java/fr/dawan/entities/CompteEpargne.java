package fr.dawan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CompteEpargne")
public class CompteEpargne extends Compte
{
    private static final long serialVersionUID = -1465644998715595702L;

    @Column(name = "c_interet")
    private double interet;

    public CompteEpargne()
    {
        super();
    }

    //region getters/setters
    public double getInteret() {
        return interet;
    }

    public void setInteret(double interet) {
        this.interet = interet;
    }
    //endregion

    @Override
    public String toString() {
        return super.toString() +
                ", interet=" + interet +
                '}';
    }
}
