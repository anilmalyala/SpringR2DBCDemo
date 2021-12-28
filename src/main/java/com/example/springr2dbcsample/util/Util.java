package com.example.springr2dbcsample.util;

import com.example.springr2dbcsample.data.Customer;
import com.example.springr2dbcsample.data.CustomerDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class Util {
    public CustomerDTO toDto(Customer customer){
        CustomerDTO customerDTO=new CustomerDTO ();
        BeanUtils.copyProperties (customer,customerDTO);
        return customerDTO;
    }

    public Customer toEntity(CustomerDTO customerDTO){
        Customer customer=new Customer ();
        BeanUtils.copyProperties (customerDTO,customer);
        return customer;
    }

}
