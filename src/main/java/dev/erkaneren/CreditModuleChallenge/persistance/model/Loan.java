package dev.erkaneren.CreditModuleChallenge.persistance.model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Loan")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Loan {
	// id, customerId, loanAmount, numberOfInstallment, createDate, isPaid
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "customerId", referencedColumnName = "id")
	private Customer customer;

	@Column(name = "loanAmount")
	private long loanAmount;

	@Transient // do not persist/serialize the enum
	private transient InstallmentOptions spanOf;

	@Column(name = "numberOfInstallment")
	@Builder.ObtainVia(method = "this.getNumberOfInstallments()")
	private int numberOfInstallment; // instead enum code gets stored in db
    
    @PrePersist
    public void populateDBFields(){
        numberOfInstallment = spanOf.getOrdinal();
		Calendar cal = Optional.ofNullable(createDate).orElseGet(Calendar::getInstance);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		this.installments = Arrays.asList(new LoanInstallment[spanOf.getOrdinal()]).stream()
			.map(i -> {
				cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
				Calendar dueDate = Calendar.getInstance();
				dueDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1,0,0,0);
				return LoanInstallment.builder()
				.loan(this)
				.dueDate(dueDate)
				.amount(Math.round(loanAmount*(1+interestRate)/spanOf.getOrdinal()))
				.build();}).toList();
    }
    @PostLoad
    public void populateTransientFields(){
        spanOf = InstallmentOptions.valueOf(numberOfInstallment);
    }

	public int getNumberOfInstallments() {
		return numberOfInstallment = spanOf.getOrdinal();
	}

	public enum InstallmentOptions { // enums are already final on #java
		month_6(6), month_9(9), month_12(12), month_24(24);

		private int ordinal;

		private InstallmentOptions(int ordinal) {
			this.ordinal = ordinal;
		}

		public int getOrdinal() {
			return ordinal;
		}

		public static InstallmentOptions valueOf(int value){
			return Arrays.asList(values()).stream().filter(e->{return e.getOrdinal() == value;}).findAny().get();
		}
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createDate")
	private Calendar createDate;

	@Column(name = "isPaid")
	private boolean isPaid;

	@Column(name = "interestRate")
	private double interestRate;

	@OneToMany(mappedBy = "loan", cascade = CascadeType.ALL)
	private List<LoanInstallment> installments;

}
