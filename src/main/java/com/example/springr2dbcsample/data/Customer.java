package com.example.springr2dbcsample.data;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Customer {
    @Id
    Integer id;
    String firstName;
    String lastName;
    String email;
    String country;
    Boolean isActive;

}
