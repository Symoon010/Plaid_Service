package com.example.plaid_service.repository;

import com.example.plaid_service.model.entity.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDetailsDao extends JpaRepository<AccountModel,Long> {
//    @Query("FROM Balance  WHERE   = :name")
//    public List<Balance> getBalanceById(String id);


}
