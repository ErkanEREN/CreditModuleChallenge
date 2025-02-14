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

	@Column(name = "numberOfInstallment")
	private InstallmentOptions numberOfInstallment;
	public enum InstallmentOptions { Inst_6, Inst_9, Inst_12, Inst_24 }

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate")
    private Date createDate;

	@Column(name = "isPaid")
	private boolean isPaid;
}

