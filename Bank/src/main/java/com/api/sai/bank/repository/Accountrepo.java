package com.api.sai.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sai.bank.model.Account;
@Repository
public interface Accountrepo extends JpaRepository<Account, Integer> {
Account findByaccountno(String accountno);
}
