package com.foodies.repository;

import com.foodies.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Customer findByMobileNo(String mobileNo);
}
