package dev.erkaneren.CreditModuleChallenge.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.erkaneren.CreditModuleChallenge.persistance.model.LoanInstallment;

@Repository
public interface LoanInstallmentRepository extends JpaRepository<LoanInstallment, Long> {

}
