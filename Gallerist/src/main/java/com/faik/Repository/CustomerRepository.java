package com.faik.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faik.Model.Account;
import com.faik.Model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Account, Long>{

	Customer save(Customer customer);

}
