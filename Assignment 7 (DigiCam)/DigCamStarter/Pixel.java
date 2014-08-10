/**
 * Pixel - represents a pixel, which has a 
 * red, green, and blue value
 * 
 * @author Richard Dunn, modified by Parag, 
 * modified by Tammy VanDeGrift
 * modified by Andrew Nuxoll
 * 
 * !!! DO NOT MODIFY THIS CLASS !!!
 */
public class Pixel {
    
    // instance variables
    // RGB color values for this pixel (0 - 255)
    private int red;
    private int green;
    private int blue;
    private int digCamColor;  // ALL, RED, GREEN, or BLUE
 
    // static variables for digital camera filter -
    // specifies which color was recorded by digital
    // camera
    public static final int ALL = 0;
    public static final int RED = 1;       
    public static final int GREEN = 2;
    public static final int BLUE = 3;

    /**
     * constructor for objects of class pixel
     * initializes the pixel values
     * @param red   red component value
     * @param green  green component value
     * @param blue  blue component value
     */
    public Pixel(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.digCamColor = Pixel.ALL; // set to all colors
    }
  
    /** getComponentById
     * returns the red, green or blue component based upon a given constant id
     * @param id the id of the color to get (Pixel.RED, Pixel.GREEN, or Pixel.BLUE)
     * @return the color component (or -1 for an invalid id)
     */
    public int getComponentById(int id) {
        switch(id) {
            case RED:
                return red;
            case BLUE:
                return blue;
            case GREEN:
                return green;
        }
        return -1;              // error value
    }
  
    /**
     * getRed
     * returns the red component
     * @return red component
     */
    public int getRed() {
        return red;
    }
  
    /**
     * getGreen
     * returns the green component
     * @return green component
     */
    public int getGreen() {
        return green;
    }
  
    /** getBlue
     * returns the blue component
     * @return blue component
     */
    public int getBlue() {
        return blue;
    }
  
    /** getDigCamColor
     * returns the color recorded by digital camera
     * @return color recorded by camera
     */
    public int getDigCamColor() {
        return digCamColor;
    }
  
    /** setRed
     * sets the red component
     * @param intensity red intensity value
     */
    public void setRed(int intensity){
        red = intensity;
    }
  
    /** setGreen
     * sets the green component
     * @param intensity green intensity value
     */
    public void setGreen(int intensity){
        green = intensity;
    }
  
    /** setBlue
     * sets the blue component
     * @param intensity blue intensity value
     */
    public void setBlue(int intensity){
        blue = intensity;
    }
  
    /** setDigCamColor
     * sets the digital camera color
     * @param color digital camera color
     */
    public void setDigCamColor(int color){
        digCamColor = color;
    }
  
    /** setComponentById
     * sets the red, green or blue component based upon a given constant id.
     * An invalid id is ignored.
     *
     * @param id the id of the color to set
     * @param val intensity the value to set it to
     */
    public void setComponentById(int id, int intensity) {
        switch(id) {
            case RED:
                red = intensity;
                break;
            case BLUE:
                blue = intensity;
                break;
            case GREEN:
                green = intensity;
                break;
        }
    }
  
    /** setAllColors
     * resets all components
     * @param rIntensity red intensity
     * @param gIntensity green intensity
     * @param bIntensity blue intensity
     */
    public void setAllColors(int rIntensity,
                             int gIntensity,
                             int bIntensity) {
        red = rIntensity;
        green = gIntensity;
        blue = bIntensity;
    }
  
    /** keepSingleColor
     * keeps the color indicated by parameter and sets
     * other two colors to 0
     * @param color  color for keeping
     */
    public void keepSingleColor(int color){
      
        if(color == RED) {
            green = 0;
            blue = 0;
            digCamColor = Pixel.RED;
        }   
        if(color == GREEN) {
            red = 0;
            blue = 0;
            digCamColor = Pixel.GREEN;
        }  
        if(color == BLUE) {
            red = 0;
            green = 0;
            digCamColor = Pixel.BLUE;
        } 
    }
  
    /** 
     * toString
     * returns a String representation of this Pixel object
     * @return string description of object
     */
    public String toString() {
        return "Pixel(red=" + red + ", green=" + green + ", blue=" + blue + ")";
    }
}
