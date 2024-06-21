
package com.example.NuedaProjSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.NuedaProjSpring.model.Loan;
import com.example.NuedaProjSpring.service.Payment;

@RestController
@RequestMapping("api/loans") // https:localhost:8080/api/accounts
@CrossOrigin
public class LoanController {
    // handles REST API endpoints; Spring boot has web servers, as soon as we run it listens for HTTP connections
    @Autowired // grabs from factory and sticks it in here
    private Payment service;

    @GetMapping("/{loanID}") // declares that this method handles get request at endpoint (http://localhost:8080/api/loans/123456)
    public Loan getLoan(@PathVariable("loanID") String loanID){
        return service.findLoan(loanID); // Spring converts/serializes into json and send it back as http request
    }

    @GetMapping("/monthly/{loanID}")  // Example additional method
    public String testMonthlyMethod(@PathVariable("loanID") String loanID) {
        // Perform some test operations with the Payment service
        double monthlyPayment = service.getMonthlyPayment(loanID);
        return "Monthly payment for loan " + loanID + " is " + monthlyPayment;
    }

    @GetMapping("/total/{loanID}")  // Example additional method
    public String testTotalMethod(@PathVariable("loanID") String loanID) {
        // Perform some test operations with the Payment service
        double totalPayment = service.getTotalPayment(loanID);
        return "Total payment for loan " + loanID + " is " + totalPayment;
    }
}