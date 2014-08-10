import java.awt.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

/**
 * This program is a simple game of catch the box!  The user moves a rectangular
 * box around the screen in attempt to place it inside a larger box which is
 * moving independently.
 *
 * @author Andrew Nuxoll
 * @author Jason Yao
 *
 * @version 11/02/14
 * ------------------------------
 * last updated:  Spring 2014
 * ------------------------------
 */
public class BoxCatcher implements MouseMotionListener
{

    /**
     * Variables!
     *
     * This program uses several variables to track the state of the game.
     *
     */

    //This constant defines how big the window is.
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 600;

    //These variables define the initial position and size of the big box
    private int bigBoxX = WINDOW_WIDTH / 2;
    private int bigBoxY = WINDOW_HEIGHT / 2;
    private int bigBoxSize = 30;

    //These variables define the initial position and size of the little box
    private int lilBoxX = 10;
    private int lilBoxY = 10;
    private int lilBoxSize = 20;

    //If the big box is moving (part B of the assignment) these variables
    //specify its trajectory.
    private int bigBoxDeltaX = 0;
    private int bigBoxDeltaY = 0;

    //This variable is used to track the user's current score.  
    private int score = 0;

    //This variable should be set to true when the little square first enters
    //the big square.  It should be set to false as soon as it leaves.
    private boolean insideLastTime = false;

    //This variable stores how many seconds have elapsed since the program
    //started.  Prof Nux's code will update this value for you.  Your only
    //responsibility is display it for the user with the paint method.
    private int seconds = 0;

    /*======================================================================
     * Methods
     *----------------------------------------------------------------------
     */

    /**
     * This method is called exactly once when your program is first started.
     * You'll eventually use it to allow the user to set the game difficulty.
     */
    public void init() 
    {
        // Displays an initial welcome message to the user
        JOptionPane.showMessageDialog(null,
        "Welcome to the Java BoxCatcher Game!");
        
        // Asks which difficulty setting the user would like
        int difficulty;
        String question = "Please enter a level of difficulty with a value between 1 (easiest) and 5 (hardest)";
        String answer = JOptionPane.showInputDialog(question);
        
        //String array that holds the valid values for the difficulty setting; needs to be a string, in order to check without tossing an error.
        String [] numbers = {"1","2","3","4","5"};
        
        // Checks to see that the value entered is valid, please note that non integer values (like strings) will be caught with no problems!
        while (!((answer.equals(numbers[0]))  || (answer.equals(numbers[1]))  || (answer.equals(numbers[2]))  || (answer.equals(numbers[3]))  || (answer.equals(numbers[4]))))
        {
            JOptionPane.showMessageDialog(null,
            "Please note that the value you have entered is invalid, please choose a valid difficulty setting between 1 and 5.");
            answer = JOptionPane.showInputDialog(question);
        }
        difficulty = Integer.parseInt(answer);
        
        // Sets the size of the big box depending on the difficulty selected, with 5 being the most difficult
        if (difficulty == 1)
        {
            bigBoxSize = 40;
        }
        else if (difficulty == 2)
        {
            bigBoxSize = 36;
        }
        else if (difficulty == 3)
        {
            bigBoxSize = 32;
        }
        else if (difficulty == 4)
        {
            bigBoxSize = 28;
        }
        else
        {
            bigBoxSize = 24;
        }
    }

    /**
     * @return true if the little box is currently entirely within the big box
     * and false otherwise
     */
    public boolean isInside()
    {
        //if statement to check if all four corners of the box are inside the big box.
        if ((lilBoxX >= bigBoxX) && (lilBoxX + 20 <= bigBoxX + bigBoxSize) && (lilBoxY >= bigBoxY) && (lilBoxY + 20 <= bigBoxY + bigBoxSize))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * @return true if the little box is overlapping with the big box and false
     * otherwise
     */
    public boolean isOverlapping()
    {
        //checks to see if the little box is in the top sector of the big box
        if (((lilBoxX + 20 >= bigBoxX) && (lilBoxX <= bigBoxX + bigBoxSize)) && ((lilBoxY + 20 >= bigBoxY) && (lilBoxY <= bigBoxY + bigBoxSize/2)))
        {
            return true;
        }
        //checks to see if the little box is in the bottom sector of the big box
        else if (((lilBoxX + 20 >= bigBoxX) && (lilBoxX <= bigBoxX + bigBoxSize)) && (lilBoxY <= bigBoxY + bigBoxSize) && (lilBoxY + 20 >= bigBoxY + bigBoxSize))
        {
            return true;
        }
        else
        {
            return false;
        }
    }//isOverlapping

    /**
     * When called, this method will draw the big and little boxes at their
     * current positions based on the class variables above.  The color of the
     * boxes vary depending upon whether their relative positions:
     *   
     *   small box is fully - the big box is white with a black
     *   inside the big box   border.  The small box is green.
     *
     *   small box overlaps - the big box is gray with a black
     *   the big box          border.  The small box is yellow.
     *
     *   otherwise          - the big box is black and the
     *                        small box is red
     *
     *  This method also updates and displays the user's score and the number of
     *  elapsed seconds since the program started.  The user gets +1 to score
     *  each time the small box is moved inside the big box.
     *  
     */
    public void paint(Graphics canvas)
    {
        /*
         * Sets the initial colours for the boxes, along with any borders.
         */
        // Fills the big box to be black
        canvas.setColor(Color.black);
        canvas.fillRect(bigBoxX, bigBoxY, bigBoxSize, bigBoxSize);

        //Sets up a black border around the big box.
        canvas.drawRect(bigBoxX, bigBoxY, bigBoxSize, bigBoxSize);

        // Fills the little box to be red
        canvas.setColor(Color.red);
        canvas.fillRect(lilBoxX, lilBoxY, lilBoxSize, lilBoxSize);

        //Sets up a black border around the little box.
        canvas.setColor(Color.black);
        canvas.drawRect(lilBoxX, lilBoxY, lilBoxSize, lilBoxSize);
        
        //Uses an If statement to see if the box is completely inside the box, then turns the colours of both boxes.
        if (isInside() == true)
        {
            // Fills the big box to be white
            canvas.setColor(Color.white);
            canvas.fillRect(bigBoxX, bigBoxY, bigBoxSize, bigBoxSize);

            //Sets up a black border around the big box.
            canvas.setColor(Color.black);
            canvas.drawRect(bigBoxX, bigBoxY, bigBoxSize, bigBoxSize);

            // Fills the little box to be green
            canvas.setColor(Color.green);
            canvas.fillRect(lilBoxX, lilBoxY, lilBoxSize, lilBoxSize);

            //Sets up a black border around the little box.
            canvas.setColor(Color.black);
            canvas.drawRect(lilBoxX, lilBoxY, lilBoxSize, lilBoxSize);
        }
        // Uses an If statement to check if the box is overlapping with the box
        else if (isOverlapping() == true)
        {
            // Fills the big box to be gray
            canvas.setColor(Color.gray);
            canvas.fillRect(bigBoxX, bigBoxY, bigBoxSize, bigBoxSize);

            //Sets up a black border around the big box.
            canvas.setColor(Color.black);
            canvas.drawRect(bigBoxX, bigBoxY, bigBoxSize, bigBoxSize);

            // Fills the little box to be yellow
            canvas.setColor(Color.yellow);
            canvas.fillRect(lilBoxX, lilBoxY, lilBoxSize, lilBoxSize);

            //Sets up a black border around the little box.
            canvas.setColor(Color.black);
            canvas.drawRect(lilBoxX, lilBoxY, lilBoxSize, lilBoxSize);
        }
        
        // Draws the current elapsed time (in seconds)
        canvas.setFont(new Font("TimesRoman", Font.BOLD, 40)); 
        canvas.drawString ("Current Time: " + seconds + " seconds", WINDOW_WIDTH - 454 , WINDOW_HEIGHT - 30);
        
        // Sets the boolean insideLastTime to the value of whether it is completely inside or not
        if (isInside() == false)
        {
            insideLastTime = false;
        }
        else if ((isInside() == true) && (insideLastTime == false))
        {
            insideLastTime = true;
            ++score;
        }
        
        // Draws the user's current score
        canvas.drawString ("Current Score: " + score + " points", WINDOW_WIDTH - 430 , WINDOW_HEIGHT - 60);
    }//paint
    //======================================================================
    //                        Homework 4b
    //
    // The code below this point is for homework 4b.  You can safely
    // ignore it while you work on homework 4a.
    // ======================================================================

    //This variable specifies whether the big box should move or not
    //Set this to true when you start on HW#4B.)
    private boolean movement = true;

    /**
     * This method repeatedly changes the x,y position of the box using its
     * trajectory as specified by bigBoxDeltaX and bigBoxDeltaY.  If the big box
     * would hit a wall it "bounces" by multiplying one or both of its
     * trajectory values by -1.  Each time box is moved, the repaint method
     * is called to update its position and then the pause() method is called
     * so the user has time to react.
     *
     * This method returns when the user catches the box (i.e., the user's
     * score changes).
     */
    void moveTheBox()
    {
        // Sets the big box to move while the little box is not inside
        while (isInside() == false)
        {
            // Changes the big box's position with the velocity
            bigBoxX = bigBoxX + bigBoxDeltaX;
            bigBoxY = bigBoxY + bigBoxDeltaY;
            repaint();
            pause();
            
            // Sets an if statement to catch if the object is moving past the edge of the screen, and will "bounce" the object away
            if ((bigBoxX + bigBoxDeltaX < 0) || (bigBoxX + bigBoxSize + bigBoxDeltaX > WINDOW_WIDTH))
            {
                bigBoxDeltaX = -bigBoxDeltaX;
                bigBoxDeltaY = bigBoxDeltaY;
            }
            
            // checks if the y is outside of bounds
            if ((bigBoxY + bigBoxDeltaY < 0) || (bigBoxY + bigBoxSize + bigBoxDeltaY > WINDOW_HEIGHT))
            {
                bigBoxDeltaX = bigBoxDeltaX;
                bigBoxDeltaY = -bigBoxDeltaY;
            }
            
            // Repaints the box as it is moving, and adds a time delay so we can react to the box's movement
            repaint();
            pause();
        } // while
    }//moveTheBox

    //======================================================================
    //                        ATTENTION STUDENTS!
    //
    // Do not modify the code below this point.  However you are welcome
    // to review it.  Most of this code is pretty straightforward but some
    // concepts (especially threads) will be new to you.
    // ======================================================================

    //This variable stores the time when the program started
    private long startTime = 0;
    //A random number generator is used to select starting position and velocity
    //for the big box
    private Random randGen = new Random();

    /**
     * Whenever an instance of BoxCatcher is created, it registers
     * itself to be notified whenever the mouse cursor moves and also
     * saves the canvas in an instance variable
     */
    public BoxCatcher(Canvas initCanvas)
    {
        //save a pointer to the graphics canvas
        myCanvas = initCanvas;

        //listen for mouse movement
        myCanvas.addMouseMotionListener(this);

    }//BoxCatcher ctor

    /*
     * These variables are used for double buffering and are initialized in
     * the main() method at the bottom of this file.
     */
    Canvas myCanvas = null;
    BufferStrategy strategy = null;

    /**
     * this method gets called whenever the user moves the mouse
     */
    public void mouseMoved(MouseEvent event)
    {
        lilBoxX = event.getX();
        lilBoxY = event.getY();
        repaint();
    }

    /**
     * this method is called whenever the user drags the mouse cursor.
     * This event is currently ignored
     */
    public void mouseDragged(MouseEvent event)
    {
        //Do nothing when the mouse is dragged
    }

    /**
     * this method causes the computer to wait a split second before
     * continuing.  The more you play, the faster it goes!
     */
    public void pause()
    {
        try
        {
            //gradually decrease the delay time from 100ms to 20ms
            int duration = 100 - score*2;
            if (duration < 20)
            {
                duration = 20;
            }

            Thread.sleep(duration);
        }
        catch(InterruptedException ie)
        {
            //it's safe to ignore this
        }
    }//pause
    /**
     * this method manages the creation and display of the next frame in the
     * game animation
     */
    public void repaint()
    {
        //Retrieve the canvas used for double buffering 
        Graphics hiddenCanvas = strategy.getDrawGraphics();

        //Start with a black pen on a white background
        hiddenCanvas.setColor(Color.white);
        hiddenCanvas.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        hiddenCanvas.setColor(Color.black);

        //Update the elapsed time
        seconds = (int)((System.currentTimeMillis() - startTime) / 1000);

        //Draw the next frame in the game animation
        paint(hiddenCanvas);

        //Display the new canvas to the user
        strategy.show();
        try
        {
            Thread.sleep(1);
        }
        catch(InterruptedException ie)
        {
            //it's safe to ignore this
        }

    }//repaint

    /**
     * this method contains the main run loop for the game
     *
     */
    public void run()
    {
        //Init the starting time
        startTime = System.currentTimeMillis();

        //Setup double-buffering
        myCanvas.createBufferStrategy(2);
        strategy = myCanvas.getBufferStrategy();

        //Keep running until the user presses the "Close" button
        while(true)
        {
            //Update the elapsed time
            seconds = (int)((System.currentTimeMillis() - startTime) / 1000);

            //draw the next frame
            repaint();

            //If the big box isn't supposed to move then do nothing else
            if (!movement)
            {
                continue;
            }

            //Select a random starting location for the box at least border from the edge
            int border = bigBoxSize + 20;
            bigBoxX = randGen.nextInt(WINDOW_WIDTH - 2 * border) + border;
            bigBoxY = randGen.nextInt(WINDOW_HEIGHT - 2 * border) + border;

            //Select a random trajectory for the box that has a magnitude of at
            //least 5 in each direction
            double magnitude = 0.0;
            do
            {
                bigBoxDeltaX = randGen.nextInt(40) - 20;
                bigBoxDeltaY = randGen.nextInt(40) - 20;

                magnitude = Math.sqrt(bigBoxDeltaX*bigBoxDeltaX + bigBoxDeltaY*bigBoxDeltaY);
            }
            while(magnitude < 8.0);

            //Move the box until the user catches it
            moveTheBox();

        }//while
    }//run

    /**
     * This method creates a window frame and displays the BoxCatcher
     * game inside of it.  
     */
    public static void main(String[] args)
    {
        //Create a properly sized window for this program
        final JFrame myFrame = new JFrame();
        myFrame.setSize(WINDOW_WIDTH+10, WINDOW_HEIGHT+30);

        //Tell this window to close when someone presses the close button
        myFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                };
            });

        //Display a canvas in the window
        Canvas myCanvas = new Canvas();
        myFrame.getContentPane().add(myCanvas);

        //Hide the regular mouse cursor
        BufferedImage emptyImage = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor noCursor = Toolkit.getDefaultToolkit().createCustomCursor(emptyImage, new Point(0, 0), "no cursor");
        myFrame.getContentPane().setCursor(noCursor);

        //Run the game!
        BoxCatcher myBoxCatcherGame = new BoxCatcher(myCanvas);
        myBoxCatcherGame.init();
        myFrame.setVisible(true);
        myBoxCatcherGame.run();

    }//main

}//class BoxCatcher
