package dev.erkaneren.CreditModuleChallenge.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.erkaneren.CreditModuleChallenge.persistance.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
