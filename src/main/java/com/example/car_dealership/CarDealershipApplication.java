package com.example.car_dealership;

import com.example.car_dealership.models.Vehicles;
import com.example.car_dealership.repos.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CarDealershipApplication implements CommandLineRunner {

	@Autowired
	private VehicleRepo vehicleRepo;

	public static void main(String[] args) {
		SpringApplication.run(CarDealershipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Vehicles> vehiclesList = vehicleRepo.getAllVehicles();
		System.out.print("Available Vehicles: ");
		for (Vehicles vehicle : vehiclesList) {
			System.out.println("Vehicle ID: " + vehicle.getVehicle_id() + ", Make/Model/Year: " + vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear());
		}
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter make: ");
		String make = scanner.next();

		List<Vehicles> vehiclesList1 = vehicleRepo.getVehiclesByMake(make);

		System.out.println("Vehicles with make " + make + ":");
		for (Vehicles vehicle : vehiclesList1) {
			System.out.println("Vehicle ID: " + vehicle.getVehicle_id() + " Make/Model/Year: " + vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear());
		}

	}
}
