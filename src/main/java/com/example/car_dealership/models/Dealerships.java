package com.example.car_dealership.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dealerships {
    private int dealership_id;
    private String name;
    private String address;
    private String phone;
}

