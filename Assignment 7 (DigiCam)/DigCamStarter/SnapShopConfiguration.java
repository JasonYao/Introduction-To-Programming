/**
 * SnapShopConfiguration
 * A class to configure the SnapShop application
 * 
 * @author Jason Yao
 * @version  22/03/14
 * 
 */
public class SnapShopConfiguration {
    /**
     * configure
     * Method to configure the SnapShop.  
     * Call methods like addFilter
     * and setDefaultFilename in this method.
     * @param theShop   The SnapShop application
     */
    public static void configure(SnapShop theShop) {
        // set default directory
        theShop.setDefaultDirectory("./Images/");
        
        // Adds a filter that flips the image vertically
        theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
        
        // Adds a filter that flips the image horizontally
        theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
        
        // Adds a filter to Demosaic a photo
        theShop.addFilter(new DemosaicFilter(), "Demosaic Photo");
        
        // Adds a filter to darken the photo
        theShop.addFilter(new DarkenFilter(), "Darken Photo");
        
        // Adds a filter to shift the photo by 1 pixel
        theShop.addFilter(new ShiftLeftFilter(), "Shift Photo Left");
        
        // Adds a filter to identify edges in the photo
        theShop.addFilter(new EdgeFilter(), "Find Edges");
        
        // Adds a filter to turn the photo into a negative
        theShop.addFilter(new NegativeFilter(), "Turn Negative");
    }
    
    /** 
     * main
     * creates a new SnapShop object
     */
    public static void main(String args[]) {
      SnapShop theShop = new SnapShop();
    }  
}
