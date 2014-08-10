/**
 * Creates a filter that shifts all the pixels in the photo to the left by 1 pixel, left-most pixel is
 * then transfered to the right-most side
 * 
 * @author Jason Yao
 * @version 30/03/14
 */
public class ShiftLeftFilter implements Filter
{
    /**
     * filter
     * Shifts an image to the left by 1 pixel
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
            for (int j = 0; j < image.getWidth() - 1; ++j)
            {
                // Creates a temporary pixel object to hold the first column
                Pixel temp = data[i][0];
                
                // Sets the pixel to the pixel in the next column
                data[i][j] = data[i][j + 1];
                
                // Adds back the temporary Pixel object to the end of the image
                data[i][image.getWidth() - 1] = temp;
            }
        }

        // Resets the data in the PixelImage object image
        image.setData(data);
    }
}
