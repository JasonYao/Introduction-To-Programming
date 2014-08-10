import java.awt.image.*;
/**
 * PixelImage - 
 * Provides a picture as an array of Pixels
 * 
 * @author Richard Dunn, modified by Donald Chinn, 
 * modified by Parag, modified by Tammy VanDeGrift
 * 
 * !!! DO NOT MODIFY THIS CLASS !!!
 */
public class PixelImage {
    private BufferedImage myImage; //image corresponding to this pixel image
    private int width;             // width of the image
    private int height;            // height of the image
    private Pixel pixels[][];      // the pixels
  
    /**
     * PixelImage
     * maps a real image to a PixelImage object
     * @param bi The buffered image object used to
     * create the PixelImageObject
     */
    public PixelImage(BufferedImage bi) {
        // initialise instance variables
        myImage = bi;
        width = bi.getWidth();
        height = bi.getHeight();
        pixels = new Pixel[height][width];
        initializePixels();
    }
  
    /**
     * getWidth
     * Returns the width of the image
     * @return image width
     */
     public int getWidth() {
         return this.width;
     }
  
    /**
     * getHeight
     * Returns the height of the image
     * @return image height
     */
    public int getHeight() {
        return this.height;
    }
  
    /**
     * getImage
     * Returns the buffered image
     * @return buffered image
     */
    public BufferedImage getImage() {
        return this.myImage;
    }
  
    /** 
     * initializePixels
     * initializes pixels based on information
     * in the buffered image
     */
    private void initializePixels() {
    
        Raster r = this.myImage.getRaster();
        int[] samples = new int[3];
    
        for (int row = 0; row < r.getHeight(); row++) {
            for (int col = 0; col < r.getWidth(); col++) {
                samples = r.getPixel(col, row, samples);
                Pixel newPixel = new Pixel(samples[0], samples[1], samples[2]);
                pixels[row][col] = newPixel;
            }
        }
    }
  
    /**
     * getData
     * Return the image's pixel data as an array of Pixels.  The
     * first coordinate is the x-coordinate, so the size of the 
     * array is [width][height], where width and height are the 
     * dimensions of the array
     * @return The array of pixels
     */
    public Pixel[][] getData() {
        return pixels;
    }
  
    /**
     * setData
     * Sets the image's pixel data from an array.  This array matches
     * that returned by getData().  It is an error to pass in an
     * array that does not match the image's dimensions or that
     * has pixels with invalid values (not 0-255)
     * @param data   A 2-dimensional array of Pixels
     */
    public void setData(Pixel[][] data) throws IllegalArgumentException {
        pixels=data;
        int[] pixelValues = new int[3];     // a temporary array to hold r,g,b values
        WritableRaster wr = this.myImage.getRaster();
    
        if (data.length != wr.getHeight()) {
            throw new IllegalArgumentException("Array size does not match");
        } else {
            if (data[0].length != wr.getWidth()) {
                throw new IllegalArgumentException("Array size does not match");
            }
        }
        for (int row = 0; row < wr.getHeight(); row++) {
            for (int col = 0; col < wr.getWidth(); col++) {
                pixelValues[0] = data[row][col].getRed();
                pixelValues[1] = data[row][col].getGreen();
                pixelValues[2] = data[row][col].getBlue();
                wr.setPixel(col, row, pixelValues);
            }
        }
    }
}
