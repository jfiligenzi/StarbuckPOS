package com.example.starbuckspos;

import java.util.ArrayList;

public class Transaction implements Comparable<Transaction>{
    public String customerName;
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

    public Transaction() {

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

    @Override
    public String toString() {
        return "\nTransaction{" +
                "customerName='" + customerName + '\'' +
                ", drinks=" + drinks +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", total=" + total +
                ", totalPaid=" + totalPaid +
                '}';
    }

    @Override
    public int compareTo(Transaction anotherTransaction) {
        Hash trans1 = new Hash(this.getCustomerName());
        Hash trans2 = new Hash(anotherTransaction.getCustomerName());

        return trans1.hashValue - trans2.hashValue;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        return false;
    }
}

//Creates a hash value for comparison
class Hash {
    final int p = 31;
    final int m = 1000000007;
    int hashValue;
    Hash(String string) {
        int currentHash = 0;
        final char[] s = string.toCharArray();
        long power = 1;
        final int n = string.length();
        for(int i = 0; i < n; i++) {
            currentHash = (int)((currentHash + (s[i] - 'a' + 1) * power) % m);
            power = (power * p) % m;
        }
        hashValue = currentHash;
    }
}


