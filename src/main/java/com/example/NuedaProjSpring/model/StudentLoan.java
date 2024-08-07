package com.example.NuedaProjSpring.model;

public class StudentLoan implements Loan {

    private String type;
    private String id;
    private double rate;
    private double amount;
    private double term;
    private String status;
    private String originationDate;

    public StudentLoan(String type, String id, double rate, double amount, double term,String status, String originationDate){
        this.type = type;
        this.id = id;
        this.rate = rate;
        this.amount = amount;
        this.term = term;
        this.status = status;
        this.originationDate = originationDate;
    }

    @Override
    public void setID(String id) {
        // TODO Auto-generated method stub
        this.id = id;
    }

    @Override
    public void setIntRate(double rate) {
        // TODO Auto-generated method stub
       this.rate = rate;
    }

    @Override
    public void setAmount(double amt) {
        // TODO Auto-generated method stub
        this.amount = amt;
    }

    @Override
    public void setTerm(double year) {
        // TODO Auto-generated method stub
        this.term = year;
    }

    @Override
    public String getID() {
        // TODO Auto-generated method stub
        return id;
    }

    @Override
    public double getRate() {
        // TODO Auto-generated method stub
        return rate;
    }

    @Override
    public double getAmount() {
        // TODO Auto-generated method stub
        return amount;
    }

    @Override
    public double getTerm() {
        // TODO Auto-generated method stub
       return term;
    }
    
    @Override
    public String toString(){
        return "Loan type: " + type + "; Loan id: " + id + "; term: " + term + "; interest rate: " + rate + "; amount: " + amount;
    }

    @Override
    public void setType(String type) {
        // TODO Auto-generated method stub
        this.type = type;
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return type;
    }
    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setOriginationDate(String date) {
        this.originationDate = date;
    }

    @Override
    public String getOriginationDate() {
        return originationDate;
    }
}
