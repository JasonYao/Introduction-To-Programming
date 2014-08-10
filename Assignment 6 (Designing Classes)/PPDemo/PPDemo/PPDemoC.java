/**
 * Demonstrate public, private, static
 * 
 * @author kw
 * @version 24 Feb 2014
 */
public class PPDemoC
{

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main(String[] arg)
    {
        CreditCardC.INTEREST_RATE = 0.08;
        // create several objects
        CreditCardC mine;
        CreditCardC yours;
        mine = new CreditCardC(123456,"mine",123);
        yours = new CreditCardC(123456, "yours",987);

       
        // if (mine.equals(yours)) { }

        // try to access their methods and instance variables
        
        // show the results

        //         System.out.println("mine: " + mine);
        //         System.out.println("yours: " + yours);
        //         if (mine.equals(yours)) 
        //             System.out.println("true!");
        //         else
        //             System.out.println("false!");
        System.out.println("My code is " + mine.securityCode + 
            " " + mine.name + " " + 
            mine.getCardNumber() + " " +
            mine.INTEREST_RATE);
        System.out.println("Your code is " + yours.securityCode +
            " " + yours.name + " " + 
            yours.getCardNumber() + " " +
            yours.INTEREST_RATE);
        mine.INTEREST_RATE = 0.1;
        System.out.println("My code is " + mine.securityCode + 
            " " + mine.name + " " + 
            mine.getCardNumber() + " " +
            mine.INTEREST_RATE);
        System.out.println("Your code is " + yours.securityCode +
            " " + yours.name + " " + 
            yours.getCardNumber() + " " +
            yours.INTEREST_RATE);

    }
}