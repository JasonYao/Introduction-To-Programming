/**
 * Creates a filter that utilizes the Bayer filter to demosaic a photo
 * 
 * @author Jason Yao
 * @version 23/03/14
 */
public class DemosaicFilter implements Filter
{
    /**
     * filter
     * Demosaic's an image
     * 
     * @param  image   The PixelImage object that is being modified
     */
    public void filter(PixelImage image)
    {
        Pixel[][] data = image.getData(); // grabs the image data

        // Iterates through the image, changing each pixel's RGB balance
        // Iterates through the rows
        for (int i = 0; i < image.getHeight(); ++i)
        {
            // Iterates through the columns
            for (int j = 0; j < image.getWidth(); ++j)
            {
                // Logic to change the image from the original to a demosaic'd image

                // If the correct value is blue, then calls
                if (data[i][j].getDigCamColor() == Pixel.BLUE)
                {
                    // Sets the red colour for the pixel (diagonal values)
                    int pixelRed = calculateDiagonal(data, i, j, Pixel.RED);
                    data[i][j].setRed(pixelRed);

                    // Sets the green colour for the pixel (horizontal + vertical values)
                    int pixelGreen = ((calculateHorizontal(data, i, j, Pixel.GREEN) + calculateVertical(data, i, j, Pixel.GREEN))/2);
                    data[i][j].setGreen(pixelGreen);
                }// ends the setting if original was blue
                else if (data[i][j].getDigCamColor() == Pixel.RED)
                {
                    // Sets the blue colour for the pixel (diagonal values)
                    int pixelBlue = calculateDiagonal(data, i, j, Pixel.BLUE);
                    data[i][j].setBlue(pixelBlue);

                    // Sets the green colour for the pixel (horizontal + vertical values)
                    int pixelGreen = ((calculateHorizontal(data, i, j, Pixel.GREEN) + calculateVertical(data, i, j, Pixel.GREEN))/2);
                    data[i][j].setGreen(pixelGreen);
                } // ends the setting if original was red
                else if (data[i][j].getDigCamColor() == Pixel.GREEN)
                {
                    // Checks to make sure not out of bounds when identifying which green value it is
                    // Checks the left if valid, if so, identifies the left DigCamColor as either red or blue
                    if ((checkValid(data, i, j - 1) == true))
                    {   
                        // If the left value is red, then it calculates the red value of the pixel (horizontal), and the blue value of the pixel (vertical)
                        if (data[i][j - 1].getDigCamColor() == Pixel.RED)
                        {
                            // Sets the red colour for the pixel (horizontal values)
                            int pixelRed = calculateHorizontal(data, i, j, Pixel.RED);
                            data[i][j].setRed(pixelRed);

                            // Sets the blue colour for the pixel (vertical values)
                            int pixelBlue = calculateVertical(data, i, j, Pixel.BLUE);
                            data[i][j].setBlue(pixelBlue);
                        }
                        // If the left value is blue, then it calculates the blue value of the pixel (horizontal), and the red value of the pixel (vertical)
                        else if (data[i][j - 1].getDigCamColor() == Pixel.BLUE)
                        {
                            // Sets the blue colour for the pixel (horizontal values)
                            int pixelBlue = calculateHorizontal(data, i, j, Pixel.BLUE);
                            data[i][j].setBlue(pixelBlue);

                            // Sets the red colour for the pixel (vertical values)
                            int pixelRed = calculateVertical(data, i, j, Pixel.RED);
                            data[i][j].setRed(pixelRed);
                        }
                    }
                    // Checks the right if valid, if so, identifies the right DigCamColor as either red or blue
                    else if ((checkValid(data, i, j + 1) == true))
                    {
                        // If the right value is red, then it calculates the red value of the pixel (horizontal), and the blue value of the pixel (vertical)
                        if (data[i][j + 1].getDigCamColor() == Pixel.RED)
                        {
                            // Sets the red colour for the pixel (horizontal values)
                            int pixelRed = calculateHorizontal(data, i, j, Pixel.RED);
                            data[i][j].setRed(pixelRed);

                            // Sets the blue colour for the pixel (vertical values)
                            int pixelBlue = calculateVertical(data, i, j, Pixel.BLUE);
                            data[i][j].setBlue(pixelBlue);
                        }
                        // If the right value is blue, then it calculates the blue value of the pixel (horizontal), and the red value of the pixel (vertical)
                        else if (data[i][j + 1].getDigCamColor() == Pixel.BLUE)
                        {
                            // Sets the blue colour for the pixel (horizontal values)
                            int pixelBlue = calculateHorizontal(data, i, j, Pixel.BLUE);
                            data[i][j].setBlue(pixelBlue);

                            // Sets the red colour for the pixel (vertical values)
                            int pixelRed = calculateVertical(data, i, j, Pixel.RED);
                            data[i][j].setRed(pixelRed);
                        }
                    } // ends checkvalid left and right 
                } // ends the setting if original was green
            } // ends column iteration
        } // ends row iteration

        // Resets the data in the PixelImage object image
        image.setData(data);
    }

    /**
     * Helper method: Checks the validity of the row and column, making sure that nothing goes out of bounds
     */
    private boolean checkValid(Pixel[][] data, int row, int col)
    {
        // Checks to make sure it's inside the bounds
        if ((row < 0) || (row > data.length - 1) || (col < 0) || (col > data[row].length - 1))
        {
            return false; // Default return value
        }
        // Otherwise, cry a little bit
        else
        {
            return true;
        }
    }

    /**
     * Helper method: [DIAGONAL] Keeps the count of valid surrounding colours, in order to identify the number that in the end is divided by.
     * Checks top-left and top-right, bottom-left and bottom-right only.
     * Returns the colour value based 
     */
    private int calculateDiagonal (Pixel[][] image, int row, int col, int inputColour)
    {
        int count = 0;
        int colour = 0;
        // If top-left is valid, then increments the count by 1, and grabs the colour attribute
        if (checkValid(image, row - 1, col - 1) == true)
        {
            colour = colour + image[row - 1][col - 1].getComponentById(inputColour);
            ++count;
        }

        // If top-right is valid, then increments the count by 1, and grabs the colour attribute
        if (checkValid(image, row - 1, col + 1) == true)
        {
            colour = colour + image[row - 1][col + 1].getComponentById(inputColour);
            ++count;
        }

        // If bottom-left is valid, then increments the count by 1, and grabs the colour attribute
        if (checkValid(image, row + 1, col - 1) == true)
        {
            colour = colour + image[row + 1][col - 1].getComponentById(inputColour);
            ++count;
        }

        // If bottom-right is valid, then increments the count by 1, and grabs the colour attribute
        if (checkValid(image, row + 1, col + 1) == true)
        {
            colour = colour + image[row + 1][col + 1].getComponentById(inputColour);
            ++count;
        }

        // Logic to calculate the red value of the pixel
        int colourFinal = 0;
        colourFinal = colour/count;

        return colourFinal;
    }

    /**
     * Helper method: [HORIZONTAL] Keeps the count of valid surrounding colours, in order to identify the number that in the end is divided by. Checks left and right only
     */
    private int calculateHorizontal (Pixel[][] image, int row, int col, int inputColour)
    {
        int count = 0;
        int colour = 0;
        // If left is valid, then increments the count by 1
        if (checkValid(image, row, col - 1) == true)
        {
            colour = colour + image[row][col - 1].getComponentById(inputColour);
            ++count;
        }

        // If right is valid
        if (checkValid(image, row, col + 1) == true)
        {
            colour = colour + image[row][col + 1].getComponentById(inputColour);
            ++count;
        }

        // Logic to calculate the colour value of the pixel
        int colourFinal = 0;
        colourFinal = colour/count;

        return colourFinal;
    }

    /**
     * Helper method: [VERTICAL] Keeps the count of valid surrounding colours, in order to identify the number that in the end is divided by. Checks top and bottom only
     */
    private int calculateVertical (Pixel[][] image, int row, int col, int inputColour)
    {
        int count = 0;
        int colour = 0;
        // If top is valid, then increments the count by 1
        if (checkValid(image, row - 1, col) == true)
        {
            colour = colour + image[row - 1][col].getComponentById(inputColour);
            ++count;
        }

        // If bot is valid
        if (checkValid(image, row + 1, col) == true)
        {
            colour = colour + image[row + 1][col].getComponentById(inputColour);
            ++count;
        }

        // Logic to calculate the colour value of the pixel
        int colourFinal = 0;
        colourFinal = colour/count;

        return colourFinal;
    }
}
