package com.example.plaid_service.repository;

import com.example.plaid_service.model.entity.TransactionsDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionsDetailsDao extends JpaRepository<TransactionsDetailsModel,Long> {
   @Query("from TransactionsDetailsModel WHERE account_id=:id")
    public List<TransactionsDetailsModel> getTransactionsById(String id);
}
