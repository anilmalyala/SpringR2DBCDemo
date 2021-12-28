package com.example.springr2dbcsample.repository;

import com.example.springr2dbcsample.data.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReactiveRepo extends ReactiveCrudRepository<Customer,Integer> {
}
