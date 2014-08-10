/**
 * DigitalCameraFilter - implements the
 * filter that stores the intensity for one RGB value for
 * each Pixel. The alternating patterns of R,G and G,B rows 
 * are stored. Green appears more often because human eye is 
 * sensitive to green and needs more accuracy. This filter
 * produces the mosaic pattern first recorded by a digital
 * camera.
 * @author Parag, modified by Tammy VanDeGrift
 * @version Oct. 31, 2007
 * 
 * !!! DO NOT MODIFY THIS CLASS !!!
 */
public class DigitalCameraFilter implements Filter {
  
    /** filter 
     * performs the filter that mimics the data capture
     * of a digital camera
     * @param pi The PixelImage object to provide the filter
     */
  public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        int pixelColor;
    
        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
        
                // get the color for this pixel - we want a 
                // pattern of the form R,G,R,G
                // alternating with rows of the form G,B,G,B...   
                if(row%2 == 0 && col%2 == 0) {
                    pixelColor = Pixel.RED;
                } else {
                    if (row%2 != 0 && col%2 != 0) {
                        pixelColor = Pixel.BLUE;
                    } else {
                        pixelColor = Pixel.GREEN;   
                    }
                }     
                Pixel pixel = data[row][col];
                data[row][col].keepSingleColor(pixelColor);
            }
        }
        pi.setData(data);
    }
}
