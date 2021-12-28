package com.example.springr2dbcsample.controller;

import com.example.springr2dbcsample.data.CustomerDTO;
import com.example.springr2dbcsample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @GetMapping("customers")
    public Mono<ResponseEntity> getAllCustomers(){
        return customerService.getAllCustomers ().delayElements (Duration.ofSeconds (1))
                .collectList ()
                .map (customerDTOList -> ResponseEntity.ok (customerDTOList))
                .cast(ResponseEntity.class)
                .defaultIfEmpty (ResponseEntity.status (HttpStatus.NO_CONTENT).build ());
    }

    @GetMapping(value = "customers-flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<CustomerDTO> getAllCustomersFlux(){
        return customerService.getAllCustomers ().delayElements (Duration.ofSeconds (1));
    }

    @GetMapping("customer/{id}")
    public Mono<ResponseEntity> getCustomerById(@PathVariable Integer id) {
        final ResponseEntity<CustomerDTO> customerDTOResponseEntity=new ResponseEntity<> (HttpStatus.NO_CONTENT);

        return customerService.getCustomerById (id)
                .map (customerDTO -> new ResponseEntity(customerDTO, HttpStatus.OK))
                .defaultIfEmpty ((customerDTOResponseEntity));
    }
}
