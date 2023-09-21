package com.foodies.controller;


import com.foodies.dto.request.CustomerRequest;
import com.foodies.dto.response.CustomerResponse;
import com.foodies.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    CustomerService customerService;


    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse customerResponse = customerService.addCustomer(customerRequest);

        return new ResponseEntity(customerResponse, HttpStatus.CREATED);
    }


    public ResponseEntity findCustomerByMobileNo(@PathVariable ("mobile") String mobileNo){

        try {
            CustomerResponse customerResponce = customerService.findCustomerByMobileNo(mobileNo);
            return new ResponseEntity(customerResponce,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
