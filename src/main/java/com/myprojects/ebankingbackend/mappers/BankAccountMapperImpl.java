package com.myprojects.ebankingbackend.mappers;

import com.myprojects.ebankingbackend.dtos.AccountOperationDto;
import com.myprojects.ebankingbackend.dtos.CurrentBankAccountDto;
import com.myprojects.ebankingbackend.dtos.CustomerDto;
import com.myprojects.ebankingbackend.dtos.SavingBankAccountDto;
import com.myprojects.ebankingbackend.entities.AccountOperation;
import com.myprojects.ebankingbackend.entities.CurrentAccount;
import com.myprojects.ebankingbackend.entities.Customer;
import com.myprojects.ebankingbackend.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl {
    public CustomerDto fromCustomer(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    public Customer fromCustomerDto(CustomerDto customerDto){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }

    public SavingBankAccountDto fromSavingBankAccount(SavingAccount savingAccount){
        SavingBankAccountDto savingBankAccountDto = new SavingBankAccountDto();
        BeanUtils.copyProperties(savingAccount, savingBankAccountDto);
        savingBankAccountDto.setCustomerDto(fromCustomer(savingAccount.getCustomer()));
        savingBankAccountDto.setType(savingAccount.getClass().getSimpleName());
        return savingBankAccountDto;
    }

    public SavingAccount fromSavingBankAccountDto(SavingBankAccountDto savingBankAccountDto){
        SavingAccount savingAccount = new SavingAccount();
        BeanUtils.copyProperties(savingBankAccountDto, savingAccount);
        savingAccount.setCustomer(fromCustomerDto(savingBankAccountDto.getCustomerDto()));
        return savingAccount;
    }

    public CurrentBankAccountDto fromCurrentBankAccount(CurrentAccount currentAccount){
        CurrentBankAccountDto currentBankAccountDto = new CurrentBankAccountDto();
        BeanUtils.copyProperties(currentAccount, currentBankAccountDto);
        currentBankAccountDto.setCustomerDto(fromCustomer(currentAccount.getCustomer()));
        currentBankAccountDto.setType(currentAccount.getClass().getSimpleName());
        return currentBankAccountDto;
    }

    public CurrentAccount fromCurrentBankAccountDto(CurrentBankAccountDto currentBankAccountDto){
        CurrentAccount currentAccount = new CurrentAccount();
        BeanUtils.copyProperties(currentAccount, currentBankAccountDto);
        currentAccount.setCustomer(fromCustomerDto(currentBankAccountDto.getCustomerDto()));
        return currentAccount;
    }
    public AccountOperationDto fromAccountOperation(AccountOperation accountOperation){
        AccountOperationDto accountOperationDTO=new AccountOperationDto();
        BeanUtils.copyProperties(accountOperation,accountOperationDTO);
        return accountOperationDTO;
    }


}
