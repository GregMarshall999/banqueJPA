package fr.dawan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Operation implements Serializable
{
    private static final long serialVersionUID = 7427664112736413612L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long operationNumber;
    @Column(name="o_date")
    private LocalDate operationDate;
    @Column(name = "o_amount")
    private double amount;
    @ManyToOne
    @JoinColumn(name = "NUM_CPTE")
    private Compte compte;

    private Operation() {
        super();
    }

    //region getters/setters
    public long getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(long operationNumber) {
        this.operationNumber = operationNumber;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    //endregion
}
