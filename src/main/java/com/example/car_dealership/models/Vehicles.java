package com.example.car_dealership.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicles {
    private int vehicle_id;
    private String vin;
    private String make;
    private String model;
    private int year;
    private String color;
    private float price;
    private int mileage;
    private boolean sold;
}
