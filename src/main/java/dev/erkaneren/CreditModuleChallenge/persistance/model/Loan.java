package dev.erkaneren.CreditModuleChallenge.persistance.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Loan")
public class Loan {
	// id, customerId, loanAmount, numberOfInstallment, createDate, isPaid
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "loan_generator")
	private long id;

	@ManyToOne
	@Column(name = "customer_id")
	private Customer customer;

	@Column(name = "loanAmount")
	private long loanAmount;

	@Enumerated(EnumType.ORDINAL) // persist enums as integer
	@Column(name = "numberOfInstallment")
	private InstallmentOptions spanOf; // would argue why not spanOfInstallment?

	public enum InstallmentOptions { // enums are already final on #java
		month_6(6), month_9(9), month_12(12), month_24(24);
		private int numVal;
		private InstallmentOptions(int numVal) { this.numVal = numVal; }
		public int getNumVal() { return numVal; }
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate")
	private Date createDate;

	@Column(name = "isPaid")
	private boolean isPaid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public InstallmentOptions getSpanOf() {
		return spanOf;
	}

	public void setSpanOf(InstallmentOptions spanOf) {
		this.spanOf = spanOf;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Loan(long id, Customer customer, long loanAmount, InstallmentOptions spanOf, Date createDate,
			boolean isPaid) {
		super();
		this.id = id;
		this.customer = customer;
		this.loanAmount = loanAmount;
		this.spanOf = spanOf;
		this.createDate = createDate;
		this.isPaid = isPaid;
	}

	public Loan() {
		super();
	}

}
