package com.example.car_dealership.repos;

import com.example.car_dealership.models.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepo {
    @Autowired
    private DataSource dataSource;

    //get all categories
    public List<Vehicles> getAllVehicles() {
        //write your sql query
        //open a connection to the database
        //we are going to prepare the query to be sent to SQL
        //we will execute the query and get back a result set
        //loop through each row in the result set
        //grab data column by column and put it into a new Java Object
        //put it in a list
        //at the end of the loop, return the list
        String query = "SELECT * FROM vehicles";
        List<Vehicles> vehicles = new ArrayList<>();

        //try-with
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                //grab the data from the columns
                int vehicleId = rs.getInt("vehicle_id");
                String vin = rs.getString("vin");
                String make = rs.getString("make");
                String model = rs.getString("model");
                int year = rs.getInt("year");
                String color = rs.getString("color");
                float price = rs.getFloat("price");
                int mileage = rs.getInt("mileage");
                boolean sold = rs.getBoolean("sold");

                // Create a Vehicles object
                Vehicles vehicle = new Vehicles(vehicleId, vin, make, model, year, color, price, mileage, sold);
                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicles> getVehiclesByMake(String x) {
        String query = "SELECT * FROM vehicles WHERE make = ?";
        List<Vehicles> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, x);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int vehicleId = rs.getInt("vehicle_id");
                    String vin = rs.getString("vin");
                    String make = rs.getString("make");
                    String model = rs.getString("model");
                    int year = rs.getInt("year");
                    String color = rs.getString("color");
                    float price = rs.getFloat("price");
                    int mileage = rs.getInt("mileage");
                    boolean sold = rs.getBoolean("sold");
                    Vehicles vehicle = new Vehicles(vehicleId, vin, make, model, year, color, price, mileage, sold);
                    vehicles.add(vehicle);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }
}
