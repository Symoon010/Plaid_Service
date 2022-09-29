package com.example.plaid_service.model;

public class PublicTokenModel {


    private  String client_id;
    private  String  secret;
    private  String  institution_id;
    private  String []initial_products;

    public PublicTokenModel() {
    }

    public PublicTokenModel(String client_id, String secret, String institution_id, String[] initial_products) {
        this.client_id = client_id;
        this.secret = secret;
        this.institution_id = institution_id;
        this.initial_products = initial_products;
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

    public String getInstitution_id() {
        return institution_id;
    }

    public void setInstitution_id(String institution_id) {
        this.institution_id = institution_id;
    }

    public String[] getInitial_products() {
        return initial_products;
    }

    public void setInitial_products(String[] initial_products) {
        this.initial_products = initial_products;
    }
}
