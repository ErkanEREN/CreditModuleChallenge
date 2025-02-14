package dev.erkaneren.CreditModuleChallenge.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.erkaneren.CreditModuleChallenge.interfaces.ApiController;
import dev.erkaneren.CreditModuleChallenge.persistance.model.Loan;

@RestController
@RequestMapping("/api/loan")
public class LoanController extends ApiController<Loan> {
}
