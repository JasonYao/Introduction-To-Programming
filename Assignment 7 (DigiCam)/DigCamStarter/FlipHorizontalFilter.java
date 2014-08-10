/**
 * Creates a filter that flips a photo horizontally by rearranging pixel values in the array
 * 
 * @author Jason Yao 
 * @version 30/03/14
 */
public class FlipHorizontalFilter implements Filter
{
    /**
     * filter
     * flips an image horizontally
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
            for (int j = 0; j < image.getWidth()/2; ++ j)
            {
                // Swaps values across the central line running vertically
                Pixel temp = data[i][j];
                data[i][j] = data[i][image.getWidth() - j - 1];
                data[i][image.getWidth() - j - 1] = temp;
            }// Ends column iteration
        } // Ends row iteration
        
        // Resets the data in the PixelImage object image
        image.setData(data);
    }
}
