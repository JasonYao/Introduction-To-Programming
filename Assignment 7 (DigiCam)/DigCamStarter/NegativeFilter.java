
/**
 * Creates a filter that turns the photo into a negative
 * 
 * @author Jason Yao
 * @version 30/03/14
 */
public class NegativeFilter implements Filter
{
    /**
     * Filter
     * Makes the image into a negative
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
                // Gets the current blue value
                int pixelBlue = 0;
                int pixelBlueFinal = 0;
                pixelBlue = data[i][j].getBlue();
                pixelBlueFinal = 255 - pixelBlue;

                // Sets the new blue value
                data[i][j].setBlue(pixelBlueFinal);

                // Gets the current green value
                int pixelGreen = 0;
                int pixelGreenFinal = 0;
                pixelGreen = data[i][j].getGreen();
                pixelGreenFinal = 255 - pixelGreen;

                // Sets the new green value
                data[i][j].setGreen(pixelGreenFinal);

                // Gets the new red value
                int pixelRed = 0;
                int pixelRedFinal = 0;
                pixelRed = data[i][j].getRed();
                pixelRedFinal = 255 - pixelRed;

                // Sets the new red value
                data[i][j].setRed(pixelRedFinal);
            }// Ends column iteration
        } // Ends row iteration
        
        // Resets the data in the PixelImage object image
        image.setData(data);
    }
}
