package com.myprojects.ebankingbackend.web;

import com.myprojects.ebankingbackend.dtos.*;
import com.myprojects.ebankingbackend.entities.BankAccount;
import com.myprojects.ebankingbackend.exceptions.BalanceNotSufficientException;
import com.myprojects.ebankingbackend.exceptions.BankAccountNotFoundException;
import com.myprojects.ebankingbackend.mappers.BankAccountMapperImpl;
import com.myprojects.ebankingbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class BankAccountRestController {
    private BankAccountService bankAccountService ;

    @GetMapping("/accounts/{accountId}")
    public BankAccountDto getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
       return bankAccountService.getBankAccount(accountId);
    }
    @GetMapping("/accounts")
    public List<BankAccountDto> getBankAccountList(){
        return bankAccountService.bankAccountList();
    }
    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDto> getHistory(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);
    }
    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDto getAccountHistory(
            @PathVariable String accountId,
            @RequestParam(name = "page" , defaultValue= "0") int page,
            @RequestParam(name = "size" , defaultValue = "5") int size) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(accountId, page, size);
    }
    @PostMapping("/accounts/debit")
    public DebitDto debit(@RequestBody DebitDto debitDTO) throws BankAccountNotFoundException, BalanceNotSufficientException {
        this.bankAccountService.debit(debitDTO.getAccountId(),debitDTO.getAmount(),debitDTO.getDescription());
        return debitDTO;
    }
    @PostMapping("/accounts/credit")
    public CreditDto credit(@RequestBody CreditDto creditDto) throws BankAccountNotFoundException {
         bankAccountService.credit(creditDto.getAccountId(), creditDto.getAmount(),creditDto.getDescription());
         return creditDto;
    }
    @PostMapping("/accounts/transfer")
    public void transfer(@RequestBody TransferRequestDto transferRequestDto ) throws BankAccountNotFoundException, BalanceNotSufficientException {
        bankAccountService.transfer(transferRequestDto.getAccountSource(),transferRequestDto.getAccountDestination(),transferRequestDto.getAmount());

    }

}

