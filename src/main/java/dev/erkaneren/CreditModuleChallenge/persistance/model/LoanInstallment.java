package dev.erkaneren.CreditModuleChallenge.persistance.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "LoanInstallment")
public class LoanInstallment{
	// id, loanId, amount,  paidAmount, dueDate, paymentDate, isPaid
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "loan_installment_generator")
	private long id;

	@ManyToOne
	@Column(name = "loan_id")
	private Loan loan;

	@Column(name = "amount")
	private long amount;

	@Column(name = "paid")
	private long paid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dueDate")
	private Date dueDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "paymentDate")
	private Date paymentDate;

	@Column(name = "isPaid")
	private boolean isPaid;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Loan getLoan() {
        return this.loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public long getAmount() {
        return this.amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getPaid() {
        return this.paid;
    }

    public void setPaid(long paid) {
        this.paid = paid;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isPaid() {
        return this.isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public LoanInstallment(long id, Loan loan, long amount, long paid, Date dueDate, Date paymentDate, boolean isPaid) {
        this.id = id;
        this.loan = loan;
        this.amount = amount;
        this.paid = paid;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.isPaid = isPaid;
    }
}