package com.example.plaid_service.model;

public class AccessTokenRequestModel {

    private  String client_id;
    private  String secret;
    private  String public_token;

    public AccessTokenRequestModel() {
    }

    public AccessTokenRequestModel(String client_id, String secret, String public_token) {
        this.client_id = client_id;
        this.secret = secret;
        this.public_token = public_token;
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

    public String getPublic_token() {
        return public_token;
    }

    public void setPublic_token(String public_token) {
        this.public_token = public_token;
    }
}
