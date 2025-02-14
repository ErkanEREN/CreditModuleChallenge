package dev.erkaneren.CreditModuleChallenge.persistance.model;

import java.util.Calendar;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "LoanInstallment")
public class LoanInstallment {
    // id, loanId, amount, paidAmount, dueDate, paymentDate, isPaid
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false )
    @JoinColumn(name = "loanId", referencedColumnName = "id")
    private Loan loan;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "paidAmount")
    private Long paid;

    @Temporal(TemporalType.DATE)
    @Column(name = "dueDate")
    private Calendar dueDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "paymentDate")
    private Calendar paymentDate;

    @Column(name = "isPaid")
    private boolean isPaid;
}