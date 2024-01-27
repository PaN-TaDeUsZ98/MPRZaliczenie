package org.example;

public class TransactionResponse {
    private TransactionStatus status;
    private double newBalance;

    public TransactionResponse(TransactionStatus status, double newBalance) {
        this.status = status;
        this.newBalance = newBalance;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }
}
