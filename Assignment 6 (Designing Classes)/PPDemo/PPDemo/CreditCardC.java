
/**
 * Represents a credit card
 * 
 * @author CS203C
 * @version 24 Feb 2014
 */
public class CreditCardC
{
    // instance variables
    private int cardNbr;
    public String name;
    public int securityCode;
    public static double INTEREST_RATE = 0.012; 

    /**
     * Constructor for objects of class CreditCardC
     */
    public CreditCardC(int cardNbr, String newName, int newSecurityCode)
    {
        // initialise instance variables
        this.cardNbr = cardNbr;
        this.name = newName;
        this.securityCode = newSecurityCode;
      
    }

    /**
     * Gets the number of this credit card
     *
     * @return     card number 
     */
    public int getCardNumber( )
    {
        // put your code here
        return cardNbr;
    }
    
    /**
     * @returns true when other is equivalent to this CreditCardC
     */
    public boolean equals(CreditCardC other)
    {
        if (this.cardNbr == other.cardNbr)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Returns a String representation of this CreditCardC
     */
    public String toString()
    {
        return this.cardNbr + " " + this.name;
    }
}
