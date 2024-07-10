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

@Repository
public class DealershipRepo {
    @Autowired
    private DataSource dataSource;

    // Get all vehicles for a specific dealership
    public List<Vehicles> getAllVehicles(int dealershipId) {
        String query = "SELECT v.* FROM vehicles v " +
                "JOIN inventory i ON v.vehicle_id = i.vehicle_id " +
                "WHERE i.dealership_id = ?";
        List<Vehicles> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, dealershipId);

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

    // Get vehicles by make for a specific dealership
    public List<Vehicles> getVehiclesByMake(int dealershipId, String make) {
        String query = "SELECT v.* FROM vehicles v " +
                "JOIN inventory i ON v.vehicle_id = i.vehicle_id " +
                "WHERE i.dealership_id = ? AND v.make = ?";
        List<Vehicles> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, dealershipId);
            ps.setString(2, make);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int vehicleId = rs.getInt("vehicle_id");
                    String vin = rs.getString("vin");
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