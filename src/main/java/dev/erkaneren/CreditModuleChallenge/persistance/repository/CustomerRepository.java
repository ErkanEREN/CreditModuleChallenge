package dev.erkaneren.CreditModuleChallenge.persistance.repository;

import org.springframework.stereotype.Repository;

import dev.erkaneren.CreditModuleChallenge.interfaces.RepositoryOf;
import dev.erkaneren.CreditModuleChallenge.persistance.model.Customer;

@Repository
public interface CustomerRepository extends RepositoryOf<Customer>{

}
