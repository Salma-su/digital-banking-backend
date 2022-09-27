package com.myprojects.ebankingbackend;

import com.myprojects.ebankingbackend.dtos.BankAccountDto;
import com.myprojects.ebankingbackend.dtos.CurrentBankAccountDto;
import com.myprojects.ebankingbackend.dtos.CustomerDto;
import com.myprojects.ebankingbackend.dtos.SavingBankAccountDto;
import com.myprojects.ebankingbackend.entities.Customer;
import com.myprojects.ebankingbackend.exceptions.CustomerNotFoundException;
import com.myprojects.ebankingbackend.services.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingBackendApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService){
        return args -> {
            Stream.of("Hassan","Imane","Mohamed").forEach(name->{
                CustomerDto customer=new CustomerDto();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                bankAccountService.saveCustomer(customer);
            });
            bankAccountService.listCustomers().forEach(customer->{
                try {
                    bankAccountService.saveCurrentBankAccount(Math.random()*90000,9000,customer.getId());
                    bankAccountService.saveSavingBankAccount(Math.random()*120000,5.5,customer.getId());

                } catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                }
            });
            List<BankAccountDto> bankAccounts = bankAccountService.bankAccountList();
            for (BankAccountDto bankAccount:bankAccounts){
                for (int i = 0; i <10 ; i++) {
                    String accountId;
                    if(bankAccount instanceof SavingBankAccountDto){
                        accountId=((SavingBankAccountDto) bankAccount).getId();
                    } else{
                        accountId=((CurrentBankAccountDto) bankAccount).getId();
                    }
                    bankAccountService.credit(accountId,10000+Math.random()*120000,"Credit");
                    bankAccountService.debit(accountId,1000+Math.random()*9000,"Debit");
                }
            }
        };
    }
}
