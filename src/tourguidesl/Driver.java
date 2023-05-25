/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourguidesl;

/**
 *
 * @author Buddhima Zoysa
 */
public class Driver {
    private int id;
    private String name;
    private String driving_license;
    private String national_id;
    private String contact;
    
    public Driver( 
        final int id,
        final String name,
        final String driving_license,
        final String national_id,
        final String contact
    ) throws Exception
    {
        if ( name.isBlank() || name.isEmpty() ) throw new Exception( "`name` cannot be empty!" );
        if ( driving_license.isBlank() || driving_license.isEmpty() ) throw new Exception( "`driving_license` cannot be empty!" );
        if ( national_id.isBlank() || national_id.isEmpty() ) throw new Exception( "`national_id` cannot be empty!" );
        if ( contact.isBlank() || contact.isEmpty() ) throw new Exception( "`contact` cannot be empty!" );
        
        this.id = id;
        this.name = name;
        this.driving_license = driving_license;
        this.national_id = national_id;
        this.contact = contact;
    }
    
    public Driver( 
        final String name,
        final String driving_license,
        final String national_id,
        final String contact
    ) throws Exception {
        this( 
            0, 
            name, 
            driving_license, 
            national_id, 
            contact 
        );
    }

    public int GetId() {
        return id;
    }

    public String GetName() {
        return name;
    }

    public String GetDrivingLicense() {
        return driving_license;
    }

    public String GetNIC() {
        return national_id;
    }

    public String GetContact() {
        return contact;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s", this.name, this.driving_license);
    }
}
