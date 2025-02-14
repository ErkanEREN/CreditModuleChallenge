package dev.erkaneren.CreditModuleChallenge.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.erkaneren.CreditModuleChallenge.interfaces.ApiController;
import dev.erkaneren.CreditModuleChallenge.interfaces.ServiceFor;
import dev.erkaneren.CreditModuleChallenge.persistance.model.Customer;
import dev.erkaneren.CreditModuleChallenge.persistance.model.Loan;

@RestController
@RequestMapping("/aDi")
public class DeveloperController extends ApiController<Loan> {
    @Autowired
    private ServiceFor<Customer> customerService;

    @Autowired
    private ServiceFor<Loan> loanService;

    @GetMapping("/populate")
    public List<?> populate() {
    List<Object> ll = new ArrayList<>();

    List<Customer> customers = new ArrayList<Customer>();
    customers.add(
        Customer.builder()
            .name("name")
            .surname("surname")
            .build());
    customers.add(
        Customer.builder()
            .name("name")
            .surname("surname")
            .build());
    ll.addAll(customerService.saveAll(customers));

    List<Loan> loans = new ArrayList<Loan>();
    loans.add(
        Loan.builder()
            .createDate(Calendar.getInstance())
            .interestRate(0.24)
            .loanAmount(5842306)
            .customer(customers.get(0))
            .spanOf(Loan.InstallmentOptions.month_6)
        .build());
    loans.add(
        Loan.builder()
            .createDate(Calendar.getInstance())
            .interestRate(0.24)
            .customer(customers.get(0))
            .loanAmount(4895636)
            .spanOf(Loan.InstallmentOptions.month_12)
        .build());
            
    ll.addAll(loanService.saveAll(loans));
    return  ll;
    }
}
