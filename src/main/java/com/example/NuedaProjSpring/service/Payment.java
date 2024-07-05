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
        this.add(new StudentLoan("Student Loan","sgd2309", 4.5, 20000, 10, "Active", "2020-01-15"));
        this.add(new StudentLoan("Student Loan","tds123", 4.0, 30000, 15, "Paid Off", "2019-06-10"));
        this.add(new StudentLoan("Student Loan","das345", 4.75, 15000, 5, "Active", "2021-08-05"));
        this.add(new StudentLoan("Student Loan","abc123", 5.0, 25000, 8, "Active", "2021-09-12"));
        this.add(new StudentLoan("Student Loan","xyz789", 4.25, 10000, 6, "Defaulted", "2022-01-20"));
        this.add(new StudentLoan("Student Loan","stu678", 4.6, 22000, 12, "Active", "2020-10-10"));
        this.add(new StudentLoan("Student Loan","lmn345", 4.3, 18000, 9, "Paid Off", "2019-05-30"));
        this.add(new StudentLoan("Student Loan","qrs678", 4.55, 27000, 11, "Defaulted", "2021-02-14"));

        // Adjusted mortgage loans with more realistic amounts and rates
        this.add(new Mortgage("Mortgage Loan","rb1478", 3.75, 300000, 20, "Active", "2018-03-12"));
        this.add(new Mortgage("Mortgage Loan","ab9102", 3.5, 250000, 15, "Active", "2017-11-20"));
        this.add(new Mortgage("Mortgage Loan","xyz123", 4.0, 400000, 30, "Active", "2015-07-25"));
        this.add(new Mortgage("Mortgage Loan","lm4567", 4.25, 350000, 25, "Active", "2016-05-17"));
        this.add(new Mortgage("Mortgage Loan","op8901", 3.8, 200000, 10, "Paid Off", "2014-12-10"));
        this.add(new Mortgage("Mortgage Loan","klm234", 3.9, 450000, 35, "Active", "2018-08-19"));
        this.add(new Mortgage("Mortgage Loan","pqr456", 3.6, 275000, 22, "Paid Off", "2017-04-10"));

        // Adjusted personal loans with more realistic amounts and rates
        this.add(new PersonalLoan("Personal Loan","kn388", 8.5, 10000, 3, "Active", "2022-02-14"));
        this.add(new PersonalLoan("Personal Loan","bm387", 9.0, 15000, 5, "Paid Off", "2020-09-30"));
        this.add(new PersonalLoan("Personal Loan","yb18044", 8.0, 5000, 3, "Defaulted", "2021-01-18"));
        this.add(new PersonalLoan("Personal Loan","uv1234", 7.5, 20000, 7, "Active", "2023-03-22"));
        this.add(new PersonalLoan("Personal Loan","wx5678", 8.25, 12000, 4, "Active", "2022-04-25"));
        this.add(new PersonalLoan("Personal Loan","efg123", 7.9, 8000, 2, "Active", "2023-06-15"));
        this.add(new PersonalLoan("Personal Loan","hij456", 8.3, 17000, 6, "Active", "2022-07-12"));
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
