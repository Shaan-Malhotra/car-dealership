SELECT * FROM dealerships;

SELECT * FROM vehicles
WHERE vehicle_id IN (SELECT vehicle_id FROM inventory WHERE dealership_id = 7);

SELECT * FROM vehicles
WHERE vin = '1HGCM82633A123456';

SELECT * FROM dealerships
WHERE dealership_id IN (SELECT dealership_id FROM inventory
WHERE vehicle_id IN (SELECT vehicle_id FROM vehicles WHERE vin ='1HGCM82633A123456'));

SELECT * FROM dealerships
WHERE dealership_id IN (SELECT dealership_id FROM inventory
WHERE vehicle_id IN (SELECT vehicle_id FROM vehicles
WHERE color = 'Blue' AND make = 'Honda' AND model = 'Accord'));

INSERT INTO sales_contracts (vehicle_id, customer_id, price)
VALUES (4, 1, 25000);
