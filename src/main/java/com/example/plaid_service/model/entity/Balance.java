package com.example.plaid_service.model.entity;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "balance")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long balance_id;
    private double available;
    private  double current;
    private  String iso_currency_code;
    @Column(name = "Total_Limit")
    private  double limit;
    @Column(name = "Main_Unofficial_Currency_Code")
    private  double unofficial_currency_code;
}
