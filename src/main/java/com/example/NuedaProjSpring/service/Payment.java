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
        // Adjusted student loans with more realistic amounts and rates
        this.add(new StudentLoan("Student Loan","sgd2309", 4.5, 20000, 10));
        this.add(new StudentLoan("Student Loan","tds123", 4.0, 30000, 15));
        this.add(new StudentLoan("Student Loan","das345", 4.75, 15000, 5));

        // Adjusted mortgage loans with more realistic amounts and rates
        this.add(new Mortgage("Mortgage Loan","rb1478", 3.75, 300000, 20));
        this.add(new Mortgage("Mortgage Loan","ab9102", 3.5, 250000, 15));
        this.add(new Mortgage("Mortgage Loan","xyz123", 4.0, 400000, 30));

        // Adjusted personal loans with more realistic amounts and rates
        this.add(new PersonalLoan("Personal Loan","kn388", 8.5, 10000, 3));
        this.add(new PersonalLoan("Personal Loan","bm387", 9.0, 15000, 5));
        this.add(new PersonalLoan("Personal Loan","yb18044", 8.0, 5000, 3));
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

    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public double getMonthlyPayment(String id) {
        Loan x = findLoan(id);
        if(x != null){
            double monthlyInterestRate = x.getRate() / 1200;
            double monthlyPayment = x.getAmount() * monthlyInterestRate / (1 - 
                (1 / Math.pow(1 + monthlyInterestRate, x.getTerm() * 12)));
            return roundToTwoDecimalPlaces(monthlyPayment);
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
            return roundToTwoDecimalPlaces(totalPayment);
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
