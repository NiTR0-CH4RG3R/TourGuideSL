/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourguidesl;

/**
 *
 * @author Buddhima Zoysa
 */
public class Location {
    private int id;
    private String name;
    private String address;
    private String description;
    
    public Location( 
            final int id,
            final String name,
            final String address,
            final String description
    ) throws Exception
    {
        if ( name.isEmpty() || name.isBlank() ) throw new Exception( "`Location.name` cannot be empty!" );
        if ( address.isEmpty() || address.isBlank() ) throw new Exception( "`Location.address` cannot be empty!" );
        if ( description.isEmpty() || description.isBlank() ) throw new Exception( "`Location.description` cannot be empty!" );
        
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
    }
    
    public Location(
            final String name,
            final String address,
            final String description
    ) throws Exception
    {
        this( 0, name, address, description );
    }

    public int GetId() {
        return id;
    }

    public String GetName() {
        return name;
    }

    public String GetAddress() {
        return address;
    }

    public String GetDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return String.format("%s", this.name);
    }
}
