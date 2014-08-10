// needed for doing graphics
import java.awt.*;
import javax.swing.*;
import java.awt.Font.*;

/**
 * Class Art - Creates a Java program that displays a customizable poster for Ender's Game using the Graphics class.
 * @author Jason Yao
 * @version 04/02/14
 * --------------------------
 * CS203
 * Starter Code Last Updated:  Spring 2014
 * --------------------------
 */
public class Art extends JPanel
{

    // instance variables
    // 
    // Define your variables here if you want to assign them in the init()
    // method and use them in paint() method
    // 
    int numCubes;  //number of floating cubes in the poster
    String helmetColourLower; // Colour of Ender's helmet in the poster
    
    // Potential Helmet Colours to equate to via .equals()
    String helmetColourSet1 = "black";
    String helmetColourSet2 = "maroon";
    String helmetColourSet3 = "teal";
    
    // Colour Variables
    Color maroon = new Color(205,22,22);
    Color teal = new Color(26,220,201);
    Color orange = new Color(255, 204, 153);
    Color steel = new Color(160, 160, 160);
    
     /**
      * This method is called exactly once when your program is first started.
      * It asks the user for information used to customize the final drawing.
      */
    public void init() 
    {
        // Example of message window:
        JOptionPane.showMessageDialog(null, 
            "Welcome to the Customized Java Movie Poster Maker! To make your personal poster, please answer the following questions.");

        /* Example of dialog window:  prompt user for number of floating cubes and then
         * convert the users input string into an integer
         */
        String question1 = 
            "How many floating cubes do you want in the picture? (Enter 1, 2, 3 or 4)";
        String numCubesString = JOptionPane.showInputDialog(question1);
        numCubes = Integer.parseInt(numCubesString);
        
        // Asks for which colour the main character's helmet should be.
        String question2 =
            "What colour would you like Ender's helmet to be? (Enter black, maroon, or teal, capitalization does not matter)";
        String helmetColourString = JOptionPane.showInputDialog(question2);
        String helmetColourTrimmed = helmetColourString.trim();
        helmetColourLower = helmetColourTrimmed.toLowerCase();
        if ((numCubes > 4) || (numCubes < 0))
        {
            JOptionPane.showMessageDialog(null,
                "Please note that the number of cubes you have entered is invalid- a default value of 2 cubes will be drawn.");
            numCubes = 2;
        }
        if (!(helmetColourLower.equals(helmetColourSet1)) && !(helmetColourLower.equals(helmetColourSet2)) && !(helmetColourLower.equals(helmetColourSet3)))
        {
             JOptionPane.showMessageDialog(null,
                "Please note that the colour you have entered is invalid- a default colour of black will be used.");
            helmetColourLower = "black";
        }
        else 
        {
            JOptionPane.showMessageDialog(null,
                "Thank you for your input, we will now draw " + numCubes + " floating cube(s), and paint Ender's helmet " + helmetColourLower + ".");
        }
    }//init
    /**
     * This is a helper method that draws a crude floating cube, and ender's body.
     * It is called from the paint() method below.
     */
    public void drawCubes(Graphics g, int x, int y)
    {
        // create a trianglular cube polygon
        Polygon cube = new Polygon();
        cube.addPoint(50, 50);
        cube.addPoint(100, 50);
        cube.addPoint(75, 80);
        cube.addPoint(50, 100);
        cube.addPoint(100, 100);
        cube.addPoint(75, 80);
        cube.addPoint(50, 50);
        cube.addPoint(50, 100);
        cube.addPoint(100, 100);
        cube.addPoint(100, 50);

        //Translates the polygon to a different set of cartesian coordinates
        cube.translate(x,y);

        // Paint the cube on the canvas
        g.setColor(Color.white); 
        g.fillPolygon(cube);
        g.setColor(Color.black);
        g.drawPolygon(cube);
        
        // Sets the background color
        setBackground(orange);
    }//drawTree
    /**
     * This program uses the data that the init() method placed in the program's
     * instance variables to draw artwork on the window.  
     * 
     * This method will be called many times.  Each time the window is moved,
     * resized, covered or uncovered, the painting must be redrawn.
     * 
     * @param  g   the Graphics object for this applet
     */
    public void paint(Graphics g)
    {
        //leave this mysterious line of code here.  Otherwise your
        //background color won't be painted
        super.paint(g);
        
        // Draws the surrounding background images
        g.setColor(Color.black);
        g.drawOval(0, 350, 600, 900);
        
        // draws a cube
        drawCubes(g, 20, 300);
        
        // Checks to see if we need to draw a second cube
        if(numCubes > 1)
        {
            drawCubes(g, 50, 175);
        }

        // Checks to see if we need to draw a third cube
        if(numCubes > 2)
        {
            drawCubes(g, 300, 225);
        }
        
        // Checks to see if we need to draw a fourth cube
        if (numCubes == 4)
        {
            drawCubes(g, 475, 350);
        }
        
        /*
         * The following lines of code create's Ender's body on screen
         */
        // Creates Ender's left leg
        Polygon enderLeftLeg = new Polygon();
        enderLeftLeg.addPoint(200, 1200);
        enderLeftLeg.addPoint(225, 1150);
        enderLeftLeg.addPoint(250, 850);
        enderLeftLeg.addPoint(225, 850);
        
        // Creates Ender's right leg
        Polygon enderRightLeg = new Polygon();
        enderRightLeg.addPoint(400, 1150);
        enderRightLeg.addPoint(425, 1200);
        enderRightLeg.addPoint(400, 850);
        enderRightLeg.addPoint(375, 850);
        
        // Creates Ender's body
        Polygon enderBody = new Polygon();
        enderBody.addPoint(200, 850); //bottom of body
        enderBody.addPoint(400, 850); //bottom of body
        enderBody.addPoint(375, 750); //hips
        enderBody.addPoint(400, 650); //shoulders
        enderBody.addPoint(225, 650); //shoulders
        enderBody.addPoint(250, 750); //hips
        enderBody.addPoint(225, 850); //bottom of body
        
        // Creates Ender's arms
        g.drawLine(225, 650, 150, 765); //Draws the left upper arm
        g.drawLine(150, 765, 235, 865); //Draws the left upper arm
        
        g.drawLine(400, 650, 385, 765); // Draws the right upper arm
        g.drawLine(385, 765, 410, 865); // Draws the right lower arm   
        
        // Draws Ender's helmet
        Polygon enderHelmet = new Polygon();
        enderHelmet.addPoint(275, 650); //bottom left of helmet
        enderHelmet.addPoint(325, 650); //bottom right
        enderHelmet.addPoint(340, 600); //middle right of helmet
        enderHelmet.addPoint(330, 570); //top right of helmet
        enderHelmet.addPoint(280, 570); //top left of helmet
        enderHelmet.addPoint(260, 600); //middle left of helmet
        enderHelmet.addPoint(275, 650); //bottom left of helmet
        
        if (helmetColourLower.equals(helmetColourSet1))
        {
            g.setColor(Color.black);
        }
        else if (helmetColourLower.equals(helmetColourSet2))
        {
            g.setColor(maroon); 
        }
        else
        {
            g.setColor(teal); 
        } 
        g.fillPolygon(enderHelmet);
        
        // Draws the helmet visor thingy
        Polygon enderVisor = new Polygon();
        enderVisor.addPoint(280, 570); //top left of visor
        enderVisor.addPoint(295, 630); //bottom left of visor
        enderVisor.addPoint(315, 630); //bottom right of visor
        enderVisor.addPoint(330, 570); //top right of visor
        enderVisor.addPoint(315, 585); //middle right of visor
        enderVisor.addPoint(295, 585); //middle left of visor
        
        g.setColor(steel);
        g.fillPolygon(enderVisor);
        g.setColor(Color.white);
        g.drawPolygon(enderVisor);

        // Paint Ender on the canvas
        g.setColor(Color.black);
        g.fillPolygon(enderLeftLeg);
        g.fillPolygon(enderRightLeg);
        g.fillPolygon(enderBody);
        
        // Sets the font for the drawString() Method
        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.BOLD, 90)); 
        
        // Draws the title of the movie via the drawString() method
        g.drawString("ENDER'S", 120, 950);
        g.drawString("GAME", 180, 1040);
        
        // Draws the movie quote at the top
        g.setFont(new Font("TimesRoman", Font.CENTER_BASELINE, 40)); 
        g.drawString("THIS", 270, 680);
        g.drawString("IS", 295, 720);
        g.drawString("NOT", 270, 760);
        g.drawString("A", 298, 800);
        g.drawString("GAME", 260, 840);

    }//paint
    /**
     * The program begins by creating a window frame and putting a drawing canvas
     * into it.  CS203 Students can safely ignore this method though you may wish
     * to change the size of the window from the 500x500 specified below.
     */
    public static void main(String[] args)
    {
        //Create a window frame
        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600, 1200);

        // put the picture in the frame
        Art studentArt = new Art();
        studentArt.init();
        myFrame.add(studentArt);

        //show the user
        myFrame.setVisible(true);
    }    
}//class Art
