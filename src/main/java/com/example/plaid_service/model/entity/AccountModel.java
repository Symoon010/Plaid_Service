package com.example.plaid_service.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="account_details")
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
public class AccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String account_id;
    @OneToOne
    @JoinColumn(name = "balance_id")
    private  Balance balances;
    private String mask;
    private String name;
    private String official_name;
    private String subtype;
    private String type;
}
