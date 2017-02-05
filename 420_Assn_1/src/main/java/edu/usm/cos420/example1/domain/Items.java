package edu.usm.cos420.example1.domain;

import java.io.Serializable;
import java.util.Random;


/**
 *
 *  Item records holds three pieces
 *  of information. The class implements the interface 
 *  Serializable so that we can store and retrieve the 
 *  information in this class 
 * 
 */
public class Items implements Serializable {

    private static final long serialVersionUID = 7526472295622776147L;
    private Long id;
    private static Long COUNTER = 100000L;
    private String plantType, description;
    private int onHand;

   /**
    * get the ID of the plant 
    * @return ID 
    */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the plant
     * @param id new id 
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    public int getOnHand() {
    	return onHand;
    }
    
   
    /** 
     * Default Constructor : 
     * Creates new item with an autogenenerated sequence ID 
     */
    public Items() {
        plantType = description = new String("");
    }

    /** 
     * Item constructor 
     */
    public Items(Long id, String plantType, String description, int onHand) {
        this.id = id;
        this.plantType = plantType;
        this.description = description;
        this.onHand = onHand;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getplantType() {
        return plantType;
    }

    /**
     * Returns the String representation of this User. Not required, it just pleases reading logs.
     * @see java.lang.Object#toString()
     */
    
    public String plantWIdToString() {
        return "ID# " + id + " " + plantType;
    }
    
    @Override
    public String toString() {
        return "ID# " + id + " - " + plantType + "   -   Qty " + onHand + "\n             " + description;
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
        Random rnd = new Random();
        Long number = COUNTER + rnd.nextInt(900000);
        if (number > 999999 || number < 100000) generateId();
        return number;
    }

	public void setInv(int available) {
		this.onHand = available;		
	}
}


