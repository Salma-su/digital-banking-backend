package com.myprojects.ebankingbackend.web;

import com.myprojects.ebankingbackend.dtos.CustomerDto;
import com.myprojects.ebankingbackend.entities.Customer;
import com.myprojects.ebankingbackend.exceptions.CustomerNotFoundException;
import com.myprojects.ebankingbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CustomerRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/customers")
    public List<CustomerDto> costumers(){
        return bankAccountService.listCostumers();
    }
    @GetMapping("/customers/{id}")
    public CustomerDto costumer(@PathVariable(name= "id") Long costumerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(costumerId);
    }
    @PostMapping("customers")
    public CustomerDto saveCustomer(@RequestBody CustomerDto customerDto){
       return bankAccountService.saveCustomer(customerDto);
    }
    @PutMapping("/customers/{customerId}")
    public CustomerDto updateDto(@PathVariable Long customerId  , CustomerDto customerDto){
        customerDto.setId(customerId);
       return bankAccountService.updateCustomer(customerDto);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteDto(@PathVariable Long id){
          bankAccountService.deleteCustomer(id);
    }
    @GetMapping("/customers/search")
    public List<CustomerDto> searchCustomers(@RequestParam(name = "keyword", defaultValue = "")  String keyword){
        return bankAccountService.searchCustomers("%"+keyword+"%");
    }
}
