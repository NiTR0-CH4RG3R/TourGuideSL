/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourguidesl;

enum VehicleType {
    MOTORCYLCLE, THREEWHEEL, CAR, VAN, BUS, UNKNOWN
}

/**
 *
 * @author Buddhima Zoysa
 */
public class Vehicle {
    private int id;
    private VehicleType type;
    private String license_plate;
    private int passenger_count;

    
    public Vehicle( 
            final int id,
            final VehicleType type,
            final String license_plate,
            final int passenger_count
            ) throws Exception 
    {
        if ( type == VehicleType.UNKNOWN ) {
            throw new Exception( "Vehicle type cannot be UNKNOWN!" );
        }
        if ( license_plate.equals( "" ) ) {
            throw new Exception( "License plate number cannot be empty!" );
        }
        
        this.id = id;
        this.type = type;
        this.license_plate = license_plate;
        this.passenger_count = passenger_count;
    }
    
    public Vehicle(             
            final VehicleType type,
            final String license_plate,
            final int passenger_count
    ) throws Exception {
        this( 0, type, license_plate, passenger_count );
    }
    
    
    public int GetId() { return id; }

    public VehicleType GetType() { return type; }

    public String GetLicensePlate() { return license_plate; }

    public int GetPassengerCount() { return passenger_count; }
    
     @Override
    public String toString() {
        return String.format("%s - %s", this.type.toString(), this.license_plate);
    }
}
