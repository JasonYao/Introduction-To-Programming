
/**
 * Write a description of class CreditCard here.
 * 
 * @author CS203A 
 * @version 24 Feb 2014
 */
public class CreditCard
{
    // instance variables - replace the example below with your own
    public static String size; 
    public int cardNumber;
    public String name;
    public int securityCode;
    private int nbrUses;

    /**
     * Constructor for objects of class CreditCard
     */
    public CreditCard(String newName, int newCardNumber, int newSecurityCode)
    {
        // initialise instance variables
        //         if (name == NULL ||
        //             name.trim().equals(""))
        //             {
        //                 // ???
        //             }
        this.name = newName;
        this.cardNumber = newCardNumber;
        this.size = "8";

    }

    /**
     * compares two CreditCard objects, returns true when the card numbers are the same
     */
    public boolean equals(CreditCard other)
    {
         return (this.cardNumber == other.cardNumber);
    }
    
    
    /**
     * Produces a String representation of this credit card 
     */
    public String toString()
    {
        
         return (this.cardNumber + " (" + this.name + ")" ) ;
    }


    /**
     * getSecurityCode
     * 
     * @return     security code for this card
     */
    public int getSecurityCode( )
    {
        // put your code here
        return securityCode;
    }

}
