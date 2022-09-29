package com.example.plaid_service.dto;

import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

public class AccountResponseDto {

    private String account_id;
    private AccountBalanceDto balances;
    private String mask;
    private String name;
    private String official_name;
    private String subtype;
    private String type;


    public AccountResponseDto() {
    }

    public AccountResponseDto(String account_id, AccountBalanceDto balances, String mask, String name, String official_name, String subtype, String type) {
        this.account_id = account_id;
        this.balances = balances;
        this.mask = mask;
        this.name = name;
        this.official_name = official_name;
        this.subtype = subtype;
        this.type = type;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public AccountBalanceDto getBalances() {
        return balances;
    }

    public void setBalances(AccountBalanceDto balances) {
        this.balances = balances;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficial_name() {
        return official_name;
    }

    public void setOfficial_name(String official_name) {
        this.official_name = official_name;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
