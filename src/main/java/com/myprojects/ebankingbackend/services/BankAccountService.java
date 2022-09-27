package com.myprojects.ebankingbackend.services;

import com.myprojects.ebankingbackend.dtos.*;
import com.myprojects.ebankingbackend.exceptions.BalanceNotSufficientException;
import com.myprojects.ebankingbackend.exceptions.BankAccountNotFoundException;
import com.myprojects.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomerDto saveCustomer(CustomerDto customerDto);
    CurrentBankAccountDto saveCurrentBankAccount(double initialBalance, double overDraft, Long CostumerId ) throws CustomerNotFoundException;
    SavingBankAccountDto saveSavingBankAccount(double initialBalance, double interestRate, Long CostumerId ) throws  CustomerNotFoundException;
    List<CustomerDto> listCostumers();
    BankAccountDto getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount,String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount,String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination,double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDto> bankAccountList();

    List<CustomerDto> listCustomers();

    CustomerDto getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDto updateCustomer(CustomerDto customerDto);

    void deleteCustomer(Long customerId);

    List<AccountOperationDto> accountHistory(String accountId);

    AccountHistoryDto getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
    List<CustomerDto> searchCustomers(String keyword);
}
