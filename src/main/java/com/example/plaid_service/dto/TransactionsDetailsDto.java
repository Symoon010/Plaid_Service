package com.example.plaid_service.dto;

import java.util.List;

public class TransactionsDetailsDto {
    private List<TransactionsDto> transactions;

    public List<TransactionsDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionsDto> transactions) {
        this.transactions = transactions;
    }
}
