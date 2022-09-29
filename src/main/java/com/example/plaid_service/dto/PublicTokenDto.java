package com.example.plaid_service.dto;

public class PublicTokenDto {

    public  String public_token;
     public  String request_id;

    public PublicTokenDto() {
    }

    public PublicTokenDto(String public_token, String request_id) {
        this.public_token = public_token;
        this.request_id = request_id;
    }

    public String getPublic_token() {
        return public_token;
    }

    public void setPublic_token(String public_token) {
        this.public_token = public_token;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }
}
