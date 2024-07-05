package com.example.NuedaProjSpring.model;


public interface Loan {


    void setID(String id);
    void setIntRate(double rate);
    void setAmount(double amt);
    void setTerm(double year);
    void setType(String type);
    void setStatus (String status);
    void setOriginationDate (String date);

    String getType();
    String getID();
    double getRate();
    double getAmount();
    double getTerm();
    String getStatus();
    String getOriginationDate();

    public String toString();
    

}

