package com.example.plaid_service.model;

public class AccountsRequestModel {


     private  String client_id;
     private  String secret;
     private  String access_token;

     public AccountsRequestModel() {
    }

    public AccountsRequestModel(String client_id, String secret, String access_token) {
        this.client_id = client_id;
        this.secret = secret;
        this.access_token = access_token;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
