
/**
 * Demonstrate public, private, static
 * 
 * @author kw
 * @version 24 Feb 2014
 */
public class PPDemo
{
  
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main(String[] arg)
    {
        // create several objects
        CreditCard mine;
        CreditCard yours;
        mine = new CreditCard("mine",123456, 123);
        yours = new CreditCard("yours",987654, 987);
       
      
       
       //mine  = new CreditCard(123456, "Karen", 123);
       // yours = new CreditCard(9876, "CS203C", 321);
       
      // if (mine.equals(yours)) { }
        
        
        // try to access their methods and instance variables
        
        
        // show the results
        
        System.out.println("mine: " + mine);
        System.out.println("yours: " + yours);
//         System.out.println("My code is " + mine.securityCode + " " + mine.name + " " + 
//                            mine.cardNumber  + " size: " + mine.size);
//         System.out.println("Your code is " + yours.securityCode + " " + yours.name + " " + 
//                            yours.cardNumber + " size: " + yours.size);
//                            
//         mine.size = "9";
//         
//         System.out.println("My code is " + mine.securityCode + " " + mine.name + " " + 
//                            mine.cardNumber + " size: " + mine.size);
//         System.out.println("Your code is " + yours.securityCode + " " + yours.name + " " + 
//                            yours.cardNumber + " size: " + yours.size);
       
        
    }
}
