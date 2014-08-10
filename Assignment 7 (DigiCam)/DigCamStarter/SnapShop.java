import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import javax.swing.JFileChooser;

/**
 * A PhotoShop like application for filtering images
 * 
 * @author Richard Dunn, modified by Parag, 
 * modified by Tammy VanDeGrift
 * 
 * !!! DO NOT MODIFY THIS CLASS !!!
 * !!! CS 203 Students: You do not need to understand the 
 * code in this class !!!
 * !!! IGNORE THIS FILE !!!
 */
public class SnapShop extends JFrame {
    FileLoader fl;
    FilterButtons fb;
    ImagePanel ip;
    RenderingDialog rd;
    BufferedImage originalImage;
    Filter digicam;
    PixelImage pixelImage;  //pixel image corresponding to this image
  
    /**
     * Constructor for objects of class SnapShop
     */
    public SnapShop() {
        super("CS 203 - SnapShop");
    
        this.addWindowListener(new WindowAdapter () {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    
        ip = new ImagePanel(this);
        this.getContentPane().add(ip, BorderLayout.CENTER);
    
        fl = new FileLoader(this);
        this.getContentPane().add(fl, BorderLayout.NORTH);
    
        fb = new FilterButtons(this);
        this.getContentPane().add(fb, BorderLayout.WEST);
    
        rd = new RenderingDialog(this);
    
        SnapShopConfiguration.configure(this);
    
        // add the digital camera filter as part of
        // the standard SnapShop
        digicam=new DigitalCameraFilter();
        addFilter(digicam, "Digital Camera Filter");
    
        this.pack();
        this.setVisible(true);
    }
  
    /** 
     * FileLoader
     * class used to load image files
     * inner class of SnapShop
     */
    private class FileLoader extends JPanel implements ActionListener {
        private String filePath;
        private ImagePanel ip;
        private SnapShop s;
    
        /** 
         * construct a new FileLoader object
         * @param s  SnapShop object
         */
        public FileLoader(SnapShop s) {
            super(new FlowLayout());
            filePath = "";
            this.s = s;
            this.ip = s.getImagePanel();
      
            JButton loadButton = new JButton("      Load New File      ");
            loadButton.addActionListener(this);
            add(loadButton);
        }
    
        /** 
         * actionPerformed
         * get action performed by user in choose file
         * to open
         * @param e ActionEvent performed
         */
        public void actionPerformed(ActionEvent e) {
      
            JFileChooser chooser = new JFileChooser(filePath); 
            int resultOfShow = chooser.showDialog(null, "Choose a .jpg image file");
            try{
                if (resultOfShow == JFileChooser.APPROVE_OPTION) {
                    String fileName = chooser.getSelectedFile().getAbsolutePath();
                    ip.loadImage(fileName);
                } 
                else {
                    // user must have canceled
                    throw new IOException("");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(s, "Could not load a file",
                                      "Error",
                                      JOptionPane.ERROR_MESSAGE);
            }
        }
    
        /** 
         * setDefaultDirectory
         * sets default directory to filePath
         * @param filePath  path for default directory
         */
        public void setDefaultDirectory(String filePath) {
            this.filePath = filePath;
        }
    }
  
    /** 
     * FilterButtons
     * inner class that represent the buttons tied to filter
     * operations
     */
    private class FilterButtons extends JPanel {
        private SnapShop s;
        private ImagePanel ip;
    
        /** 
         * constructs new FilterButtons object
         * @param s  SnapShop object
         */
        public FilterButtons(SnapShop s) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.s = s;
            this.ip = s.getImagePanel();;
        }
    
    /** 
     * addFilter
     * adds a new filter to the set of filters
     * @param f the Filter object
     * @param description string description of the filter
     */
    public void addFilter(Filter f, String description) {
        JButton filterButton = new JButton(description);
        filterButton.addActionListener(new FilterButtonListener(this, f));
        add(filterButton);
        s.pack();
    }
    
    /**
     * applyFileter
     * executes the filter associated with button
     * @Filter f filter to run
     */ 
    public void applyFilter(Filter f) {
        try {
            ip.applyFilter(f);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    /** 
     * FilterButtonListener
     * inner class to represent the act of listening for
     * button presses
     */
    private class FilterButtonListener implements ActionListener {
        private FilterButtons fb;
        private Filter f;
      
        /** 
         * constructor
         * creates new FilterButtonListener given filter buttons
         * and filter object
         * @param fb  set of FilterButtons
         * @param f   filter object
         */
        public FilterButtonListener(FilterButtons fb, Filter f) {
            this.fb = fb;
            this.f = f;
        }
      
        /** 
         * actionPerformed
         * apply filter when button is pressed
         * @param e ActionEvent that triggers the 
         * application of the filter
         */
        public void actionPerformed(ActionEvent e) {
            fb.applyFilter(f);
        }
    }                
}
  
/** Class representing the ImagePanel */
private class ImagePanel extends JPanel {
    // instance variables
    private BufferedImage bi;
    private SnapShop s;
    private int margin;
    
    /** 
     * constructor
     * creates new ImagePanel object with the SnapShop
     * object passed to constructor
     * @param s the SnapShop object
     */
    public ImagePanel(SnapShop s) {
        margin = 10;
        bi = null;
        this.s = s;
    }
    
    /** 
     * loadImage
     * performs action of loading the image
     * @param filename  the image file to load
     */
    public void loadImage(String filename) {             
        Image img = Toolkit.getDefaultToolkit().getImage(filename);
        try {
            MediaTracker tracker = new MediaTracker(this);
            tracker.addImage(img, 0);
            tracker.waitForID(0);
        } catch (Exception e) {}
        int width = img.getWidth(this);
        int height = img.getHeight(this);
        bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D biContext = bi.createGraphics();
        biContext.drawImage(img, 0, 0, null);
        setPreferredSize(new Dimension(2*bi.getWidth()+ margin, bi.getHeight()));
        revalidate();
        s.pack();
        s.repaint();
      
        //set the original image to this image
        // and apply the digital camera filter
        originalImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = originalImage.createGraphics();
        g.drawImage(img, 0, 0, null);
        pixelImage = new PixelImage(bi);
        fb.applyFilter(digicam);
    }
    
    /** 
     * paint
     * renders images in window
     * @param g The Graphics object on which to draw images
     */
    public void paint(Graphics g) {
        super.paint(g);
        if (bi != null) {
            g.drawImage(bi, 0, 0, this);
            g.drawImage(originalImage, bi.getWidth()+ margin, 0 , this);
        }
    }
    
    /** 
     * applyFilter
     * applies filter to image and redraws image
     * @param f the filter to apply
     */
    public void applyFilter(Filter f) {
        if (bi == null) {
            return;
        }
        s.showWaitDialog();
        f.filter(pixelImage);
        s.hideWaitDialog();
        bi = pixelImage.getImage();
        repaint();
    }   
}
  
/** 
 * RenderingDialog
 * represents dialog box that is displayed while action
 * is performed
 */
private class RenderingDialog extends JFrame {
    /** constructor
     * creates new RenderingDialog with parent JFrame object
     * @param parent parent frame for the dialog box
     */
    public RenderingDialog(JFrame parent) {
        super("Please Wait");
        Point p = parent.getLocation();
        setLocation((int)p.getX() + 100, (int)p.getY() + 100);
        this.getContentPane().add(new JLabel("Applying filter, please wait..."), 
            BorderLayout.CENTER);
        }
    }
  
    /**
     * addFilter
     * Adds a filter to the SnapShop interface.  Creates a button and
     * links it to the filter.
     * @param f The filter to apply
     * @param description English description of the filter
     */
    public void addFilter(Filter f, String description) {
        fb.addFilter(f, description);
    }
  
    /**
     * showWaitDialog
     * makes wait dialog visible
     */
    protected void showWaitDialog() {
        rd.pack();
        rd.setVisible(true);
    }
  
    /**
     * hideWaitDialog
     * makes wait dialog invisible
     */
    protected void hideWaitDialog() {
        rd.setVisible(false);
    }
  
    /**
     * getImagePanel
     * returns ImagePanel
     * @return ImagePanel associated with
     * RenderingDialog
     */
    protected ImagePanel getImagePanel() {
        return ip;
    }
  
    /**
     * setDefaultDirectory
     * Set the default directory to appear in the box
     * @param filepath the default directory filepath
     */
    public void setDefaultDirectory(String filepath) {
        fl.setDefaultDirectory(filepath);
    }
}
