/**
 * Creates a UP Personnel object that has a name and an ID number associated with that object
 * @author Jason Yao
 * @version 08/04/14
 */
public class UPPersonnel
{
    // Instance Variables
    private String name;
    private int idNum;
    
    /**
     * [CONSTRUCTOR] Initializes a UPPersonnel object with their ID number and name
     * @param initName
     * @param initIDNum
     */
    public UPPersonnel (String initName, int initIDNum)
    {
        // Initializes name to initName
        this.name = initName;
        
        // Initializes idNum to initIDNum
        this.idNum = initIDNum; 
    }
    
    /**
     * [ACCESSOR] Gets the name of the personnel
     * @return name the name of the personnel
     */
    public String getName ()
    {
        return name;
    }
    
    /**
     * [ACCESSOR] Gets the ID number of the personnel
     * @return idNum the ID number of the personnel
     */
    public int getIDNum ()
    {
        return idNum;
    }
    
    /**
     * Overrides the toString method to represent the object based upon the person's name and ID number
     * @return The string representation of the object
     */
    public String toString ()
    {
        String representative = name + ", ID number: " + idNum;
        return representative;
    }
    
    /**
     * Overrides the equals method to equate a personnel if their names are the same
     * @param personnelComparedTo the other UP Personnel object
     * @return equalsboolean returns true if the objects names are equal
     */
    public boolean equals (UPPersonnel personnelComparedTo)
    {
        // Checks if null first
        if (personnelComparedTo != null)
        {
            if (this.name.equals(personnelComparedTo.getName()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}

