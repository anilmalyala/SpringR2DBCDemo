package com.example.springr2dbcsample.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {
    Integer id;
    String firstName;
    String lastName;
    String email;
    String country;
    Boolean isActive;
}
