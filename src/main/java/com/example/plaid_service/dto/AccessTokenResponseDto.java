package com.example.plaid_service.dto;

public class AccessTokenResponseDto {

    private  String access_token;
    private  String item_id;
    private  String request_id;

    public AccessTokenResponseDto() {
    }

    public AccessTokenResponseDto(String access_token, String item_id, String request_id) {
        this.access_token = access_token;
        this.item_id = item_id;
        this.request_id = request_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }
}
