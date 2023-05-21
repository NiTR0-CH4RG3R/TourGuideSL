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
public class BookingEntry {
    private int id = 0;
    private final int clientId;
    private final LocalDateTime checkInTime;
    private final LocalDateTime checkOutTime;
    
    public BookingEntry( final int id, final int clientId, final LocalDateTime checkInTime, final LocalDateTime checkOutTime ) {
        this.id = id;
        this.clientId = clientId;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    public BookingEntry( final int clientId, final LocalDateTime checkInTime, final LocalDateTime checkOutTime ) {
        this( 0, clientId, checkInTime, checkOutTime );
    }
    
    public int GetId() { return id; }

    public int GetClientId() { return clientId; }

    public LocalDateTime GetCheckInTime() { return checkInTime; }

    public LocalDateTime GetCheckOutTime() { return checkOutTime; }

    public void SetId( final int id ) { this.id = id; }
    
}
