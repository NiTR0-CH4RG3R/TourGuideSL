/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourguidesl;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Buddhima Zoysa
 */
public class Database {
    // Database configurations
    private final String db_server_hostname = "localhost";
    private final String db_server_port = "3306";
    private final String db_name = "tourguide";
    private final String db_username = "tourguideapp";
    private final String db_password = "pwd";
    
    private Connection db_connection = null;
    private Statement db_statement = null;
    
    public Database() {
        // Create the connection url
        String connection_string = String.format( "jdbc:mysql://%s:%s/%s", db_server_hostname, db_server_port, db_name );
        
        // Try to connect to the database
        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            db_connection = DriverManager.getConnection( connection_string, db_username, db_password );
            db_statement = db_connection.createStatement();
        }
        catch ( ClassNotFoundException | SQLException e ) {
            System.out.println("[ERROR] : " + e.getMessage() );
        }
    }
    
// [UPDATE] : It seems that it is not neccassory to explicitly call the close() functions because the GC already do that for us
    
//    @Override
//    public void finalize() {
//        // Just a sanity thing to suppress my OCD :)
//        // Not sure if the Garbage Collector automatically close the statement and the connection when the object goes out of scope
//        try {
//            db_statement.close();
//            db_connection.close();
//        } catch ( SQLException | NullPointerException e ) {
//            System.out.println( "[ERROR] : " + e.getMessage() );
//        }
//    }
    
    public boolean Authenticate( final String username, final String password ) {
        boolean is_successful = false;
        
        String query = String.format( "SELECT COUNT(*) FROM users WHERE u_username='%s' AND u_password='%s'", username, password );
        ResultSet result = ExecuteReadQuery( query );
        
        try {
            result.next();
            is_successful = ( result.getInt( 1 ) == 1 );
        }
        catch ( SQLException e ) {
            System.out.println( "[ERROR] : " + e.getMessage() );
        }
        
        return is_successful;
    }
    
    public Client[] GetClients() {
        ArrayList<Client> clients = new ArrayList<>();
        
        ResultSet result = ExecuteReadQuery( "SELECT * FROM clients" );
        
        try {
            while( result.next() ) {
                int id = result.getInt( "c_id" );
                String name = result.getString( "c_name" );
                String email = result.getString( "c_email" );
                String country = result.getString( "c_country" );
                String contact = result.getString( "c_contact" );
                int age = result.getInt( "c_age" );
                
                String gender_str = result.getString( "c_gender" );
                Gender gender = Gender.UNKNOWN;
                if ( gender_str.equals( "MALE" ) ) gender = Gender.MALE;
                else if ( gender_str.equals( "FEMALE" ) ) gender = Gender.FEMALE;

                clients.add(  new Client( id, name, email, country, contact, age, gender ) );
            }
        }
        catch ( SQLException | NullPointerException e ) {
            System.out.println( "[ERROR] : " + e.getMessage() );
        } catch ( Exception e ) {
            System.out.println( "[ERROR] : " + e );
        }
        
        return clients.toArray(Client[]::new);
    }
    
    public Client GetClient( final int c_id ) {
        ResultSet result = ExecuteReadQuery( String.format( "SELECT * FROM clients WHERE c_id=%d", c_id ) );
        Client client = null;
        try {
            result.next();
            
            int id = result.getInt( "c_id" );
            String name = result.getString( "c_name" );
            String email = result.getString( "c_email" );
            String country = result.getString( "c_country" );
            String contact = result.getString( "c_contact" );
            int age = result.getInt( "c_age" );

            String gender_str = result.getString( "c_gender" );
            Gender gender = Gender.UNKNOWN;
            if ( gender_str.equals( "MALE" ) ) gender = Gender.MALE;
            else if ( gender_str.equals( "FEMALE" ) ) gender = Gender.FEMALE;

            client = new Client( id, name, email, country, contact, age, gender );
        }
        catch ( Exception e ) {
            System.out.println( "[ERROR] : " + e.getMessage() );
        }
        return client;
    }
    
    public Client GetClientByEmail( final String c_email ) {
        ResultSet result = ExecuteReadQuery( String.format( "SELECT * FROM clients WHERE c_email='%s'", c_email ) );
        Client client = null;
        try {
            result.next();
            
            int id = result.getInt( "c_id" );
            String name = result.getString( "c_name" );
            String email = result.getString( "c_email" );
            String country = result.getString( "c_country" );
            String contact = result.getString( "c_contact" );
            int age = result.getInt( "c_age" );

            String gender_str = result.getString( "c_gender" );
            Gender gender = Gender.UNKNOWN;
            if ( gender_str.equals( "MALE" ) ) gender = Gender.MALE;
            else if ( gender_str.equals( "FEMALE" ) ) gender = Gender.FEMALE;

            client = new Client( id, name, email, country, contact, age, gender );
        }
        catch ( Exception e ) {
            System.out.println( "[ERROR] : " + e.getMessage() );
        }
        return client;
    }

    public void AddClient( final Client client ) {
        String gender = "NULL";
        if ( client.GetGender() == Gender.MALE ) gender = "'MALE'";
        else if ( client.GetGender() == Gender.FEMALE ) gender = "'FEMALE'";
        String query = String.format( 
                "INSERT INTO clients( c_name, c_email, c_country, c_contact, c_age, c_gender ) VALUES( '%s', '%s', '%s', '%s', %d, %s )", 
                client.GetName(),
                client.GetEmail(),
                client.GetCountry(),
                client.GetContact(),
                client.GetAge(),
                gender
                );
        ExecuteWriteQuery( query );
    }
    
    public void RemoveClient( final Client client ) {
        String gender = "NULL";
        if ( client.GetGender() == Gender.MALE ) gender = "'MALE'";
        else if ( client.GetGender() == Gender.FEMALE ) gender = "'FEMALE'";
        String query = String.format( 
                "DELETE FROM clients WHERE c_name='%s' AND c_email='%s' AND c_country='%s' AND c_contact='%s' AND c_age=%d AND c_gender=%s", 
                client.GetName(),
                client.GetEmail(),
                client.GetCountry(),
                client.GetContact(),
                client.GetAge(),
                gender
                );
        ExecuteWriteQuery( query );
    }
    
    public void UpdateClient( final Client client ) {
        String gender = "NULL";
        if ( client.GetGender() == Gender.MALE ) gender = "'MALE'";
        else if ( client.GetGender() == Gender.FEMALE ) gender = "'FEMALE'";
        String query = String.format( "UPDATE clients SET c_name='%s', c_email='%s', c_country='%s', c_contact='%s', c_age=%d, c_gender=%s WHERE c_id=%d", 
                client.GetName(),
                client.GetEmail(),
                client.GetCountry(),
                client.GetContact(),
                client.GetAge(),
                gender,
                client.GetId()
        );
        System.out.println("Update Query =\"" + query + "\"");
        ExecuteWriteQuery( query );      
    }
    
    public BookingEntry[] GetBookingEntries() {
        ArrayList<BookingEntry> entries = new ArrayList<>();
        
        try {
            ResultSet result = ExecuteReadQuery( "SELECT * FROM accomodations" );
            
            while( result.next() ) {
                int id = result.getInt( "a_id" );
                int clientId = result.getInt( "a_client_id" );
                LocalDateTime checkIn = result.getTimestamp( "a_check_in" ).toLocalDateTime();
                LocalDateTime checkOut = result.getTimestamp( "a_check_out" ).toLocalDateTime();
                
                entries.add( new BookingEntry( id, clientId, checkIn, checkOut ) );
            }
        }
        catch ( Exception e ) {
            System.out.println( "[ERROR] : " + e.getMessage() );
        }
        
        return entries.toArray( BookingEntry[]::new );
    }
    
    public BookingEntry GetBookingEntry( final int a_id ) {
        BookingEntry entry = null;
        
        try {
            ResultSet result = ExecuteReadQuery( String.format( "SELECT * FROM accomodations WHERE a_id=%d", a_id ) );
            
            result.next();
            int id = result.getInt( "a_id" );
            int clientId = result.getInt( "a_client_id" );
            LocalDateTime checkIn = result.getTimestamp( "a_check_in" ).toLocalDateTime();
            LocalDateTime checkOut = result.getTimestamp( "a_check_out" ).toLocalDateTime();

            entry = new BookingEntry( id, clientId, checkIn, checkOut );
        }
        catch ( Exception e ) {
            System.out.println( "[ERROR] : " + e.getMessage() );
        }
        
        return entry;
    }
    
    public void AddBookingEntry( final BookingEntry entry ) {
        try {
            String query = String.format( "INSERT INTO accomodations( a_client_id, a_check_in, a_check_out ) VALUES( %d, '%s', '%s' )", 
                    entry.GetClientId(),
                    Utility.LocalDateTimeToString( entry.GetCheckInTime() ),
                    Utility.LocalDateTimeToString( entry.GetCheckOutTime() )
                    );
            ExecuteWriteQuery( query );
        }
        catch ( Exception e ) {
            System.out.println( "[ERROR] : " + e.getMessage() );
        }
    }
    
    public void RemoveBookingEntry( final BookingEntry entry ) {
        String query = String.format( "DELETE FROM accomodations WHERE a_id=%d", entry.GetId() );
        ExecuteWriteQuery( query );
    }
    
    public void UpdateBookingEntry( final BookingEntry entry ) {
        String query = String.format( "UPDATE accomodations SET a_client_id=%d, a_check_in='%s', a_check_out='%s' WHERE a_id=%d", 
                entry.GetClientId(), 
                Utility.LocalDateTimeToString( entry.GetCheckInTime() ),
                Utility.LocalDateTimeToString( entry.GetCheckOutTime() ), 
                entry.GetId() );
        ExecuteWriteQuery( query );
    }
    
    private void ExecuteWriteQuery( final String query ) {
        try {
            PreparedStatement db_prepared_statement = db_connection.prepareCall( query );
            db_prepared_statement.execute();
        } catch ( SQLException e ) {
            System.out.println( "[ERROR] : " + e.getMessage() );
        }
    }
    
    private ResultSet ExecuteReadQuery( final String query ) {
        ResultSet result = null;
        
        try {
            result = db_statement.executeQuery( query );
        }
        catch ( SQLException | NullPointerException e ) {
            System.out.println( "[ERROR] : " + e.getMessage() );
        }
        
        return result;
    }
    
}
