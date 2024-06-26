package com.example.NuedaProjSpring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.NuedaProjSpring.model.Loan;
import com.example.NuedaProjSpring.model.Mortgage;
import com.example.NuedaProjSpring.model.PersonalLoan;
import com.example.NuedaProjSpring.model.StudentLoan;

@Service
public class Payment {

    List<Loan> loans = new ArrayList<>(); // can also have list of type Item where checkIn adds and checkOut removes
    //  private List<Item> accounts = new ArrayList<>();

    public Payment(){
        this.add(new StudentLoan("sg2309", 4.24, 100000, 10));
        this.add(new StudentLoan("temp123", 4.24, 50000, 15));
        this.add(new StudentLoan("ID345", 4.24, 10000, 5));

        this.add(new Mortgage("rb1478", 7.90, 300000, 10));
        this.add(new Mortgage("ab9102", 7.90, 250000, 15));
        this.add(new Mortgage("xyz123", 7.90, 400000, 20));

        this.add(new PersonalLoan("loanID", 36, 10000, 3));
        this.add(new PersonalLoan("bm387", 36, 10000, 5));
        this.add(new PersonalLoan("yb18044", 36, 5000, 3));

    }

    public void add(Loan x){
        loans.add(x);
        System.out.println("Loan taken: " + x.getID());
    }

    public void paidOff(String id){
        Loan x = findLoan(id);
        if(x != null){
            loans.remove(x);
            System.out.println("Loan paid: " + x.getID());
        }
        else{
            System.out.println("Loan not found!");
        }
    }

    public double getMonthlyPayment(String id) {
        Loan x = findLoan(id);
        if(x != null){
            double monthlyInterestRate = x.getRate() / 1200;
            double monthlyPayment = x.getAmount() * monthlyInterestRate / (1 - 
                (1 / Math.pow(1 + monthlyInterestRate, x.getTerm() * 12)));
            return monthlyPayment;    
        }
        else{
            System.out.println("Loan not found!");
            return 0;
        }
    }
    
    public double getTotalPayment(String id) {
        Loan x = findLoan(id);
        if(x != null){
            double totalPayment = getMonthlyPayment(id) * x.getTerm() * 12;
            System.out.println("Total payment is " + totalPayment);
            return totalPayment;    
        }
        else {
            System.out.println("Loan not found!");
            return 0;
        }
    }

    public Loan findLoan(String id){
        for (Loan x : loans){
            if(x.getID().equals(id)){
                return x;
            }
        }
        return null;
    }

    public List<Loan> returnList(){
        List<Loan> where = new ArrayList<Loan>();
        for (Loan x : loans){
            where.add(x);
        }
        return where;
    }
}
