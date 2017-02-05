package edu.usm.cos420.example1.domain;

import java.io.Serializable;


/**
 *
 *  Customer records holds three pieces
 *  of information. The class implements the interface 
 *  Serializable so that we can store and retrieve the 
 *  information in this class 
 * 
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 7526472295622776147L;
    private Long id;
    private static Long COUNTER = 0L;
    private String firstName, lastName, strAddress, cityTown, state, zipCode;

   /**
    * get the ID of the customer 
    * @return ID 
    */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the customer
     * @param id new id 
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /** 
     * Default Constructor : 
     * Creates new customer with an autogenenerated sequence ID 
     */
    public Customer() {
        firstName = lastName = strAddress = cityTown = state = zipCode = new String("");
        Long id = 0L; 
    }

    /** 
     * Customer constructor 
     */
    public Customer(Long id, String firstName, String lastName, String strAddress,
            String cityTown, String state, String zipCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.strAddress = strAddress;
        this.cityTown = cityTown;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public String getFirstName() {
    	return firstName;
    }
    
    public String getNameToString(Long id){
        String name = nameToString();
        return name;
    }

    /**
     * Returns the String representation of this User. Not required, it just pleases reading logs.
     * @see java.lang.Object#toString()
     */
    public String nameToString(){
        return firstName + " " + lastName;
    }
    
    public String mailAddressToString(){
        return strAddress + "\n" + cityTown + ", " + state + " " + zipCode;
    }
    
    public String customerWIdToString() {
        return "ID# " + id + " " + nameToString();
    }
    
    @Override
    public String toString() {
        return nameToString() + "\n" + mailAddressToString() + "\n";
    }

    // for returning autogeneration of ids
    public Long getNewId()
    {
        Long generatedId = generateId();
        return generatedId;
    }
    
    // for autogeneration of ids
    private Long generateId()
    {
        return COUNTER+=(int)(Math.random()*1000000);
    }

}

