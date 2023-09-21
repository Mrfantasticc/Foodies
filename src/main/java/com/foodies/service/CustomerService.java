package com.foodies.service;

import com.foodies.dto.request.CustomerRequest;
import com.foodies.dto.response.CustomerResponse;
import com.foodies.exception.CustomerNotFoundException;
import com.foodies.model.Cart;
import com.foodies.model.Customer;
import com.foodies.repository.CustomerRepository;
import com.foodies.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest){

//        dto  --> customer model

        Customer customer = CustomerTransformer.CustomerRequestToCustomer(customerRequest);

//        allot cart

        Cart cart= Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();

        customer.setCart(cart);
        
//        save in db

        Customer save = customerRepository.save(customer);

        return CustomerTransformer.CustomerToCustomerResponse(save);

    }





    public CustomerResponse findCustomerByMobileNo(String mobileNo){
        Customer customer = customerRepository.findByMobileNo(mobileNo);

        if (customer==null){
            throw new CustomerNotFoundException("Invalid Mobile No..");
        }

        return CustomerTransformer.CustomerToCustomerResponse(customer);

    }
}
