/**
 * Creates a filter to identify the edges in a photo, and then to change the composition so that the photo
 * becomes similar to a colouring book page
 * 
 * @author Jason Yao
 * @version 30/03/14
 */
public class EdgeFilter implements Filter
{
    // Constants
    public static final int diffConstant = 22;

    /**
     * Filter
     * Identifies the edges inside the photo, changes the composition of the photo based upon the edges
     * 
     * @param image The PixelImage object that is being modified
     */
    public void filter(PixelImage image)
    {
        // Grabs the image data
        Pixel[][] data = image.getData();

        // Iterates through the pixel array
        int[][] brightness = new int[image.getHeight()][image.getWidth()];
        boolean[][] edged = new boolean[image.getHeight()][image.getWidth()];

        // Iterates through the rows in the image
        for (int i = 0; i < image.getHeight(); ++i)
        {
            // Iterates through the columns in the image
            for (int j = 0; j < image.getWidth(); ++ j)
            {
                // Calculates the brightness of the pixel, saves it inside a brightness array
                brightness[i][j] = (data[i][j].getGreen() +
                    data[i][j].getRed() + data[i][j].getBlue())/3;
            }// Ends column iteration
        } // Ends row iteration

        // Iterates through the rows in the edged array
        for (int i = 0; i < image.getHeight(); ++i)
        {
            // Iterates through the columns in the edged array
            for (int j = 0; j < image.getWidth(); ++j)
            {
                // Logic to change the brightness from the original to an "edgified" brightness level

                // Checks if the surrounding piece is valid, then comparing to see if it is an edge
                edged[i][j] = checkSurrounding(brightness, i, j);
                
                // If the brightness is set to black, sets the data array values to black
                if (edged[i][j] == true)
                {
                    // Sets all values to black (0)
                    data[i][j].setGreen(0);
                    data[i][j].setRed(0);
                    data[i][j].setBlue(0);
                }
                // If the brightness is set to white, sets the data array values to white
                else if (edged[i][j] == false)
                {
                    // Sets all values to white (255)
                    data[i][j].setGreen(255);
                    data[i][j].setBlue(255);
                    data[i][j].setRed(255);
                }
            } // End edged array column iteration
        } // End edged array row iteration

        // Resets the data in the PixelImage object image
        image.setData(data);
    }

    /**
     * Helper Method: Helps check for validity, and that it doesn't go out of bounds in the array
     * @param i           Input row to be checked
     * @param j           Input column to be checked
     * @param brightness  Brightness array in order to check the bounds
     * @return boolean    True if it is inside the bounds, false if outside of bounds
     */
    private boolean checkValid(int i, int j, int[][] brightness)
    {
        if ((i < 0) || (i >= brightness.length) || (j < 0) || (j >= brightness[i].length))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * Helper Method: Checks the brightness of the pixel, and marks it as an edge
     * @param i          Input row to be compared to
     * @param j          Input column to be compared to
     * @param brightness Brightness array to see which 
     * @param originalX  Original row compared to
     * @param originalY  Original column compared to
     * @return boolean   True if the difference is larger than the stated constant, false if it is less than the constant
     */
    private boolean checkBrightness(int i, int j, int[][] brightness, int originalX, int originalY)
    {
        // If the brightness is different from the original by more than a constant, it is counted as an edge
        // Checks to make sure that nothing passed in is out of bounds
        if ((checkValid(i, j, brightness) == false) || (checkValid(originalX, originalY, brightness) == false))
        {
            return false;
        }
        else
        {
            // If it is an edge, then returns true
            if (Math.abs(brightness[originalX][originalY] - brightness[i][j]) >= diffConstant)
            {
                return true;
            }
            // Else it is not an edge, in which case returns false
            else
            {
                return false;
            }
        }
    }

    /**
     * Helper method: [CHECK SURROUNDING] Keeps the count of valid surrounding brightnesses
     * @param brightness
     * @param row
     * @param col
     * @return boolean Returns true if the value is an edge
     */
    private boolean checkSurrounding(int[][] brightness, int row, int col)
    {
        // If top-left is valid, then checks to see if it is an edge
        if (checkValid(row - 1, col - 1, brightness) == true)
        {
            if (checkBrightness(row - 1, col - 1, brightness, row, col) == true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        // If top-right is valid, then increments the count by 1, and grabs the colour attribute
        if (checkValid(row - 1, col + 1, brightness) == true)
        {
            if (checkBrightness(row - 1, col + 1, brightness, row, col) == true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        // If bottom-left is valid, then increments the count by 1, and grabs the colour attribute
        if (checkValid(row + 1, col - 1, brightness) == true)
        {
            if (checkBrightness(row + 1, col - 1, brightness, row, col) == true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        // If bottom-right is valid, then increments the count by 1, and grabs the colour attribute
        if (checkValid(row + 1, col + 1, brightness) == true)
        {
            if (checkBrightness(row + 1, col + 1, brightness, row, col) == true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        // If left is valid, then increments the count by 1
        if (checkValid(row, col - 1, brightness) == true)
        {
            if (checkBrightness(row, col - 1, brightness, row, col) == true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        // If right is valid
        if (checkValid(row, col + 1, brightness) == true)
        {
            if (checkBrightness(row, col + 1, brightness, row, col) == true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        // If top is valid, then increments the count by 1
        if (checkValid(row - 1, col, brightness) == true)
        {
            if (checkBrightness(row - 1, col, brightness, row, col) == true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        // If bot is valid
        if (checkValid(row + 1, col, brightness) == true)
        {
            if (checkBrightness(row + 1, col, brightness, row, col) == true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
}
