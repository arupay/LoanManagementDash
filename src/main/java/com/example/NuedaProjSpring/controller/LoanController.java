
package com.example.NuedaProjSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.NuedaProjSpring.model.Loan;
import com.example.NuedaProjSpring.service.Payment;

@RestController
@RequestMapping("api/loans") // https:localhost:8080/api/loans
@CrossOrigin
public class LoanController {
    // handles REST API endpoints; Spring boot has web servers, as soon as we run it listens for HTTP connections
    @Autowired // grabs from factory and sticks it in here
    private Payment service;

    @GetMapping() // declares that this method handles get request at endpoint (http://localhost:8080/api/loans)
    public List<Loan> getAllLoans(){
        return service.returnList();
    }

    @GetMapping("/{loanID}") // declares that this method handles get request at endpoint (http://localhost:8080/api/loans/123456)
    public Loan getLoan(@PathVariable("loanID") String loanID){
        return service.findLoan(loanID); // Spring converts/serializes into json and send it back as http request
    }

    @GetMapping("/monthly/{loanID}")
    public double getMonthlyPayment(@PathVariable("loanID") String loanID) {
        return service.getMonthlyPayment(loanID);
    }

    @GetMapping("/total/{loanID}")
    public double getTotalPayment(@PathVariable("loanID") String loanID) {
        return service.getTotalPayment(loanID);
    }
}