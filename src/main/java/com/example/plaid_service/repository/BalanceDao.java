package com.example.plaid_service.repository;

import com.example.plaid_service.model.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceDao extends JpaRepository<Balance,Long> {
}
