package com.example.plaid_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AccountBalanceDto {
    private double available;
     private  double current;
     private  String iso_currency_code;
     private  double limit;
     private  double unofficial_currency_code;

}
