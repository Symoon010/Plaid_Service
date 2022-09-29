package com.example.plaid_service.dto;

import java.util.List;

public class AccountsDetailsDto {
    private List<AccountResponseDto> accounts;

    public AccountsDetailsDto(List<AccountResponseDto> accounts) {
        this.accounts = accounts;
    }

    public AccountsDetailsDto() {
    }

    public List<AccountResponseDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountResponseDto> accounts) {
        this.accounts = accounts;
    }
}
