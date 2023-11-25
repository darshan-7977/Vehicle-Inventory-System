package com.vehicleInventoryProject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Vehicle {
	String brand;
	String model;
	Integer year;

	Vehicle(String brand, String model, Integer year) {
		this.brand = brand;
		this.model = model;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Brand: " + brand + "	 Model: " + model + " 	Year: " + year;
	}

	public static void displayVehicles(LinkedList<Vehicle> vehicles) {
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle); // This will invoke the toString() method of the Vehicle class
		}

		System.out.println("");
	}

	public static void addVehicle(LinkedList<Vehicle> vehicle, Scanner sc) {
		System.out.println("Enter Vehicle details as Brand, Model, Year");
		vehicle.add(new Vehicle(sc.next(), sc.next(), sc.nextInt()));
		System.out.println("Vehicle added successfully..\n");
	}

	public static void removeVehicle(LinkedList<Vehicle> vehicle, Scanner sc) {
		System.out.print("Enter Model: ");
		String name = sc.next();
		boolean removed = false;
		for (int i = 0; i < vehicle.size(); i++) {
			if (vehicle.get(i).model.equalsIgnoreCase(name)) {
				vehicle.remove(i);
				removed = true;
				break;
			}
		}
		if (removed) {
			System.out.println(name + " model vehicle removed successfully..\n");
		} else {
			System.out.println(name + " model vehicle not found inside the Inventory OR Invalid Entry\n");
		}
	}

	public static void searchVehicle(LinkedList<Vehicle> vehicle, Scanner sc) {
		System.out.print("Enter Model: ");
		String name = sc.next();
		boolean present = false;
		for (int i = 0; i < vehicle.size(); i++) {
			if (vehicle.get(i).model.equalsIgnoreCase(name)) {
				present = true;
				break;
			}
		}
		if (present) {
			System.out.println("Yes, the vehicle is present in the Inventory\n");
		} else {
			System.out.println(
					"Sorry, " + name + " model vehicle is not present in the Inventory, you should add one..\n");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		LinkedList<Vehicle> a = new LinkedList<>();

		Vehicle v1 = new Vehicle("Toyota", "Camry", 2023);
		Vehicle v2 = new Vehicle("Ford", "F-150", 2023);
		Vehicle v3 = new Vehicle("Honda", "Civic", 2023);
		Vehicle v4 = new Vehicle("BMW", "3-Series", 2023);
		Vehicle v5 = new Vehicle("Volkswagen", "Golf", 2023);
		a.addAll(Arrays.asList(v1, v2, v3, v4, v5));

		while (true) {
			System.out.println("Vehicle Inventory Manager");
			System.out.println("1. Display the vehicles present in the Inventory.");
			System.out.println("2. Add vehicles..");
			System.out.println("3. Remove a vehicle..");
			System.out.println("4. Search for a particular vehicle..");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			Integer choice = sc.nextInt();

			switch (choice) {
			case 1:
				displayVehicles(a);
				break;

			case 2:
				addVehicle(a, sc);
				break;

			case 3:
				removeVehicle(a, sc);
				break;

			case 4:
				searchVehicle(a, sc);
				break;

			case 5:
				System.out.println("Exiting the Vehicle Inventory Manager...");
				sc.close();
				System.exit(0);

			default:
				System.out.println("Invalid choice, Please try again..");
			}
		}
	}
}
