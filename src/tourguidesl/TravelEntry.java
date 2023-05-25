/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourguidesl;

import java.time.LocalDateTime;

/**
 *
 * @author Buddhima Zoysa
 */
public class TravelEntry {
    private int id;
    private int customer_id;
    private int location_id;
    private int vehicle_id;
    private int driver_id;
    private int passanger_count;
    private LocalDateTime departure_time;
    
    public TravelEntry( 
            final int id,
            final int customer_id,
            final int location_id,
            final int vehicle_id,
            final int driver_id,
            final int passanger_count,
            final LocalDateTime departure_time
    )
    {
        this.id                 = id                 ;
        this.customer_id        = customer_id        ;
        this.location_id        = location_id        ;
        this.vehicle_id         = vehicle_id         ;
        this.driver_id          = driver_id          ;
        this.passanger_count    = passanger_count    ;
        this.departure_time     = departure_time     ;
    }
    
    public TravelEntry(
            final int customer_id,
            final int location_id,
            final int vehicle_id,
            final int driver_id,
            final int passanger_count,
            final LocalDateTime departure_time
    ) {
        this ( 
                0, 
                customer_id, 
                location_id, 
                vehicle_id, 
                driver_id, 
                passanger_count, 
                departure_time );
    }

    public int GetId() {
        return id;
    }

    public int GetCustomerId() {
        return customer_id;
    }

    public int GetLocationId() {
        return location_id;
    }

    public int GetVehicleId() {
        return vehicle_id;
    }

    public int GetDriverId() {
        return driver_id;
    }

    public int GetPassangerCount() {
        return passanger_count;
    }

    public LocalDateTime GetDepartureTime() {
        return departure_time;
    }
}
