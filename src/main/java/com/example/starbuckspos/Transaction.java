package com.example.starbuckspos;

import java.util.ArrayList;

public class Transaction {
    private String customerName;
    private ArrayList<Drink> drinks;
    private String paymentMethod;
    private double total;
    private double totalPaid;

    public Transaction(String customerName, ArrayList<Drink> drinks, String paymentMethod, double total, double totalPaid) {
        this.customerName = customerName;
        this.drinks = drinks;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.totalPaid = totalPaid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }
}
