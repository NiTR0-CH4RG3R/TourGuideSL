/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourguidesl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Buddhima Zoysa
 * 
 * This class contains many of widely used utility functions 
 */
public class Utility {
    static String LocalDateTimeToString( final LocalDateTime dateTime ) {
        return dateTime.format( DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") );
    }
    
    static LocalDateTime StringToLocalDateTime( final String str ) {
        return LocalDateTime.parse( str, DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm:ss" ) );
    }
    
    static VehicleType StringToVehicleType( final String str ) {
        for ( var e : VehicleType.values() ) {
            if ( str.equals( e.toString() ) ) return e;
        }
        return VehicleType.UNKNOWN;
    }
}
