
/**
 * Creates a filter that darkens the image by lowering all RGB intensities
 * 
 * @author Jason Yao
 * @version 30/03/14
 */
public class DarkenFilter implements Filter
{
    /**
     * filter
     * darkens an image
     * 
     * @param image The PixelImage object that is being modified
     */
    public void filter(PixelImage image)
    {
        Pixel[][] data = image.getData(); // grabs the image data
        
        // Iterates through the pixel array
        // Iterates through the rows
        for (int i = 0; i < image.getHeight(); ++i)
        {
            // Iterates through the columns
            for (int j = 0; j < image.getWidth(); ++ j)
            {
                // Subtracts from the red value of the pixel
                int pixelRed = data[i][j].getRed();
                // Checks that the red value does not go negative
                if (pixelRed - 10 >= 0)
                {
                    data[i][j].setRed(pixelRed - 10);
                }
                // If it does, it sets the blue value to 0.
                else
                {
                    data[i][j].setRed(0);
                }
                
                // Subtracts from the blue value of the pixel
                int pixelBlue = data[i][j].getBlue();
                // Checks that the blue value does not go negative
                if (pixelBlue - 10 >= 0)
                {
                    data[i][j].setBlue(pixelBlue - 10);
                }
                else
                {
                    data[i][j].setBlue(0);
                }
                
                // Subtracts from the green value of the pixel
                int pixelGreen = data[i][j].getGreen();
                // Checks that the green value does not go negative
                if (pixelBlue - 10 >= 0)
                {
                    data[i][j].setGreen(pixelGreen - 10);
                }
                else
                {
                    data[i][j].setGreen(0);
                }
            }// Ends column iteration
        } // Ends row iteration
        
        // Resets the data in the PixelImage object image
        image.setData(data);
    }
}
