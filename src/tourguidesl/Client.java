/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourguidesl;

enum Gender {
    MALE, FEMALE, UNKNOWN
}

/**
 *
 * @author Buddhima Zoysa
 */
public class Client {
    private int id = 0;
    private String name = "";
    private String email = "";
    private String country = "";
    private String contact = "";
    private int age = 0;
    private Gender gender = Gender.UNKNOWN;

    public Client(
            final int id,
            final String name,
            final String email,
            final String country,
            final String contact,
            final int age,
            final Gender gender
            ) throws Exception 
    {
        if ( name.equals("") ) throw new Exception( "'name' field cannot be empty!" );
        if ( email.equals("") ) throw new Exception( "'email' field cannot be empty!" );
        if ( contact.equals("") ) throw new Exception( "'contact' field cannot be empty!" );
        if ( !( age > 18 ) ) throw new Exception( "'age' field has to be over 18!" );
        
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.contact = contact;
        this.age = age;
        this.gender = gender;
    }
    
    public Client(
            final String name,
            final String email,
            final String country,
            final String contact,
            final int age,
            final Gender gender
            ) throws Exception 
    {
        this(0, name, email, country, contact, age, gender);
    }
    
    
    public void SetId( final int id ) { this.id = id; }
    
    public int GetId() {  return id; }
    public String GetName() { return name; }
    public String GetEmail() { return email; }
    public String GetCountry() { return country; }
    public String GetContact() { return contact; }
    public int GetAge() { return age; }
    public Gender GetGender() { return gender; }
    
}
