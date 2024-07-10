package com.example.car_dealership;

import com.example.car_dealership.models.Vehicles;
import com.example.car_dealership.repos.DealershipRepo;
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
	@Autowired
	private DealershipRepo dealershipRepo;


	public static void main(String[] args) {
		SpringApplication.run(CarDealershipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		menuItems();
		List<Vehicles> vehiclesList = dealershipRepo.getAllVehicles(7);
		System.out.print("Available Vehicles for Dealership 7: ");
		for (Vehicles vehicle : vehiclesList) {
			System.out.println("Vehicle ID: " + vehicle.getVehicle_id() + "\nMake/Model/Year: " + vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear());
		}
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter make: ");
		String make = scanner.next();

		List<Vehicles> vehiclesList1 = dealershipRepo.getVehiclesByMake(7, make);

		System.out.println("Vehicles in Dealership 7 with make " + make + ":");
		for (Vehicles vehicle : vehiclesList1) {
			System.out.println("Vehicle ID: " + vehicle.getVehicle_id() + "\nMake/Model/Year: " + vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear());
		}

	}
	private void menuItems() {
		System.out.println("Welcome to Shaan's Dealerships, select an action:");
		System.out.println("1. Find vehicles within a price range");
		System.out.println("2. Find vehicles by make/model");
		System.out.println("3. Find vehicles by year range");
		System.out.println("4. Find vehicles by color");
		System.out.println("5. Find vehicles by mileage range");
		System.out.println("6. Find vehicles by type");
		System.out.println("7. List all vehicles");
		System.out.println("8. Add a vehicle");
		System.out.println("9. Remove a vehicle");
		System.out.println("99. Quit");
    }


}

