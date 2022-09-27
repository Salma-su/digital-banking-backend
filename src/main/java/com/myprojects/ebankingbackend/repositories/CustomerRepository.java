package com.myprojects.ebankingbackend.repositories;

import com.myprojects.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.name like :kw")
    List<Customer> searchCustomer(@Param("kw") String keyword);

    List<Customer> findByNameContains(String keyword);
    @Query("SELECT c FROM Customer c JOIN FETCH c.bankAccounts WHERE c.id = (:id)")
    Customer findByIdAndFetchBankAccountsEagerly(@Param("id") Long id);


    @EntityGraph(attributePaths = { "bankAccounts" })
    Customer getById(Long id);
}
