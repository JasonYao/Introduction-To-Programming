/**
 * Filter that flips the image vertically.
 * @author Tammy VanDeGrift
 * 
 * !!! DO NOT MODIFY THIS CLASS !!!
 */
public class FlipVerticalFilter implements Filter {
    // no instance variables -- no state of objects
  
    /** 
     * filter
     * flips pixel image horizontally around vertical
     * center line
     * @param pi The PixelImage object to modify
     */
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();  // get image data
    
        for (int row = 0; row < pi.getHeight() / 2; row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
                // swap values across center line
                Pixel temp = data[row][col];
                data[row][col] = data[pi.getHeight() - row - 1][col];
                data[pi.getHeight() - row - 1][col] = temp;
            }
        }  
        // reset data into the PixelImage object pi
        pi.setData(data);
    }
}
