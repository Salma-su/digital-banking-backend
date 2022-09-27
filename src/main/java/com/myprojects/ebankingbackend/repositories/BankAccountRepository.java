package com.myprojects.ebankingbackend.repositories;

import com.myprojects.ebankingbackend.entities.AccountOperation;
import com.myprojects.ebankingbackend.entities.BankAccount;
import com.myprojects.ebankingbackend.enums.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository  extends JpaRepository<BankAccount, String> {
}
