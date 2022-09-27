package com.myprojects.ebankingbackend.dtos;


import com.myprojects.ebankingbackend.entities.AccountOperation;
import com.myprojects.ebankingbackend.entities.Customer;
import lombok.Data;
import com.myprojects.ebankingbackend.enums.AccountStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
public  class SavingBankAccountDto extends BankAccountDto{
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDto customerDto;
    private double interestRate;
}