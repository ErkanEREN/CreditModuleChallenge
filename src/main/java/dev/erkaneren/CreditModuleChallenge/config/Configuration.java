package dev.erkaneren.CreditModuleChallenge.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import dev.erkaneren.CreditModuleChallenge.interfaces.ServiceFor;
import dev.erkaneren.CreditModuleChallenge.persistance.model.Customer;
import dev.erkaneren.CreditModuleChallenge.persistance.model.Loan;
import dev.erkaneren.CreditModuleChallenge.service.CustomerService;
import dev.erkaneren.CreditModuleChallenge.service.LoanService;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    @ConditionalOnMissingBean(CustomerService.class)
    ServiceFor<Customer> customerService(){
        return new CustomerService();
    }
    
    @Bean
    @ConditionalOnMissingBean(LoanService.class)
    ServiceFor<Loan> loanService(){
        return new LoanService();
    }


}
