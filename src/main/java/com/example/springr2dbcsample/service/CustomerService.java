package com.example.springr2dbcsample.service;

import com.example.springr2dbcsample.data.CustomerDTO;
import com.example.springr2dbcsample.repository.CustomerReactiveRepo;
import com.example.springr2dbcsample.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {
    @Autowired
    private Util util;

    @Autowired
    private CustomerReactiveRepo customerReactiveRepo;

    public Flux<CustomerDTO> getAllCustomers(){
        return customerReactiveRepo.findAll ().map (util::toDto);
    }

    public Mono<CustomerDTO> getCustomerById(Integer id) {
        return customerReactiveRepo.findById (id).map (util::toDto);
    }


}
